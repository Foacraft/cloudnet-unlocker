plugins {
    `java-library`
    kotlin("jvm") version "1.9.20"
    id("io.izzel.taboolib") version "1.56"
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
    relocate("@project_version@", project.version.toString())
    classifier = null
    version = "6.0.12-35"
}

repositories {
    mavenCentral()
    maven("https://repository.derklaro.dev/snapshots/")
    maven("https://repository.derklaro.dev/releases/")
}

dependencies {
    compileOnly("ink.ptms:nms-all:1.0.0")
    compileOnly("ink.ptms.core:v11902:11902-minimize:mapped")
    compileOnly("ink.ptms.core:v11902:11902-minimize:universal")
    compileOnly("net.md_5.bungee:BungeeCord:1")

    compileOnly("dev.derklaro.aerogel:aerogel:2.1.0")

    taboo(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
