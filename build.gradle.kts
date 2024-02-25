plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.10"
    application
}

group = "com.sho.kana.assistant"
version = "1.0-SNAPSHOT"

repositories {
    // 使用阿里云 maven 源镜像仓库
    maven("https://maven.aliyun.com/repository/public/")
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("KanaMainKt")
}

tasks.withType<JavaExec> {
    systemProperty("file.encoding", "utf-8")
}