dependencies {
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}