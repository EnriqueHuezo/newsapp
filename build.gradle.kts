// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false

    // Compose compiler
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" apply false

    // Serialization
    kotlin("plugin.serialization") version "1.9.10" apply false
}