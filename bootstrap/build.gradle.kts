dependencies {
    implementation(project(":infrastructure"))
    implementation(project(":domain"))

    implementation("org.springframework.boot:spring-boot-starter")
}

tasks.bootJar {
    enabled = true
    mainClass.set("com.tangtang.polingo.PolingoApplication")
}


tasks.jar {
    enabled = false
}