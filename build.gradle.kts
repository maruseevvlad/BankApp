
plugins {
    id("java")
    id ("application")
}

group = "main"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "main.Main"
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.38")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("org.mindrot:jbcrypt:0.4")
}

tasks.test {
    useJUnitPlatform()
}