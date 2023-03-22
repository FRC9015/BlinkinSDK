plugins {
    id("java")
    id("maven-publish").apply(true)
    id("edu.wpi.first.wpilib.repositories.WPILibRepositoriesPlugin").version("2020.2")
}


group = "com.github.frc9015"
version = "0.1.0"

allprojects {
    repositories {
        mavenCentral()
        mavenLocal()
    }

    wpilibRepositories.addAllReleaseRepositories(project)
    wpilibRepositories.addAllDevelopmentRepositories(project)
}

dependencies {
    implementation("edu.wpi.first.wpilibj:wpilibj-java:2023.4.2")
    implementation("edu.wpi.first.wpiutil:wpiutil-java:2023.4.2")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}