
buildscript {
    val kotlin_version by extra("1.5.0-release-764")
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("com.google.gms:google-services:4.3.10")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.41")

    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://devrepo.kakao.com/nexus/content/groups/public/")
    }
}


tasks.register("clean",Delete::class) {
    delete(rootProject.buildDir)
}