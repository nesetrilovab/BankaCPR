plugins {
    java

}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.13.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.20.0")
    implementation("com.fasterxml.jackson.core:jackson-core:2.20.0")
    implementation("com.google.inject:guice:7.0.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

