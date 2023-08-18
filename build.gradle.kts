import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "org.zhangwenqing"
version = "1.0-SNAPSHOT"

repositories {
//    maven("https://maven.aliyun.com/repository/central")
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
//    maven("https://maven.aliyun.com/repository/google")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)

    implementation("br.com.devsrsouza.compose.icons.jetbrains:font-awesome:1.0.0")
    implementation("org.apache.poi:poi:5.2.3")
    implementation("org.apache.poi:poi-ooxml:5.2.3")
}

kotlin {
    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    sourceSets {
        val main by getting {
            dependencies {
                implementation("br.com.devsrsouza.compose.icons.jetbrains:font-awesome:1.0.0")
                implementation("org.apache.poi:poi:5.2.3")
                implementation("org.apache.poi:poi-ooxml:5.2.3")
            }
        }
        val test by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("org.junit.jupiter:junit-jupiter:5.9.1")
            }
            tasks.withType<Test>().configureEach {
                useJUnitPlatform()
                testLogging {
                    events("passed", "skipped", "failed")
                }
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "openxml-explorer"
            packageVersion = "1.0.20231"
            copyright = "© 2022 Zhang Wenqing. All rights reserved."
            vendor = "Zhang Wenqing"
            macOS {
                bundleID = "org.zhangwenqing.openxml-explorer"
                iconFile.set(project.file("artworks/icon.icns"))
            }
            windows {
                iconFile.set(project.file("artworks/icon.ico"))
                perUserInstall = true
                menu = true
                menuGroup = "Zhang Wenqing"
                // see https://wixtoolset.org/documentation/manual/v3/howtos/general/generate_guids.html
                upgradeUuid = "AA31C032-B1E7-4170-BBF7-1A0514776241"
            }
            linux {
                iconFile.set(project.file("artworks/icon.png"))
            }
        }
    }
}
