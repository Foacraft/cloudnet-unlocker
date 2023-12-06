import java.io.FileOutputStream
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream

plugins {
    `java-library`
    kotlin("jvm") version "1.9.20"
    id("io.izzel.taboolib") version "1.56"
    id("eu.cloudnetservice.juppiter") version "0.4.0"
}

taboolib {
    install("common")
    install("common-5")
    install("module-chat")
    install("module-configuration")
    install("module-lang")
    install("platform-bukkit")
    install("platform-bungee")
    install("expansion-command-helper")
    description {
        contributors {
            name("Score2")
        }
        dependencies {
            name("CloudNet-Bridge")
        }
    }
    relocate("@project_name@", project.name.toString())
    relocate("@project_version@", project.version.toString())
    classifier = null
    version = "6.0.12-35"
}

repositories {
    mavenCentral()
    maven("https://repository.derklaro.dev/snapshots/")
    maven("https://repository.derklaro.dev/releases/")
    maven("https://repo.cloudnetservice.eu/repository/snapshots/")
    maven("https://s01.oss.sonatype.org/content/repositories/releases/")
}

dependencies {
    compileOnly("ink.ptms:nms-all:1.0.0")
    compileOnly("ink.ptms.core:v11902:11902-minimize:mapped")
    compileOnly("ink.ptms.core:v11902:11902-minimize:universal")
    compileOnly("net.md_5.bungee:BungeeCord:1")

    compileOnly("dev.derklaro.aerogel:aerogel:2.1.0")
    compileOnly("eu.cloudnetservice.cloudnet:node:4.0.0-RC9")
    compileOnly("eu.cloudnetservice.cloudnet:bridge:4.0.0-RC9")
    compileOnly("eu.cloudnetservice.cloudnet:platform-inject-api:4.0.0-RC9")

    taboo(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
}

moduleJson {
    author = "Score2"
    name = project.name
    group = project.group.toString()
    main = "${rootProject.group}.node.CUnlockerNode"
}

gradle.buildFinished {
    val jarTask = tasks.withType<Jar>().named("jar").get()
    val jarPath = jarTask.archiveFile.get().asFile.absolutePath

    try {
        val file = JarFile(jarPath)
        val tempFile = File(jarPath + ".tmp")
        val jarOutputStream = JarOutputStream(FileOutputStream(tempFile))

        file.entries().asSequence().forEach { entry ->
            file.getInputStream(entry).use { inputStream ->
                val jarEntry = when (entry.name) {
                    "plugin.yml" -> JarEntry("plugin.minecraft_server.yml")
                    "bungee.yml" -> JarEntry("plugin.bungeecord.yml")
                    else -> JarEntry(entry.name)
                }
                jarOutputStream.putNextEntry(jarEntry)
                inputStream.copyTo(jarOutputStream)
                jarOutputStream.closeEntry()
            }
        }

        jarOutputStream.close()
        file.close()

        File(jarPath).delete()
        tempFile.renameTo(File(jarPath))
    } catch (e: Exception) {
        println("在重命名文件时出错: ${e.message}")
    }
}