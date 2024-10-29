plugins {
    id("java")
}

sourceSets {
    main {
        java {
            srcDirs = ['src/main']
        }
    }
    test {
        java {
            srcDirs = ['src/test']
        }
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

