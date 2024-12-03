dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

tasks.bootJar {
    enabled = true
    mainClass.set("com.tangtang.polingo.PolingoApplication")
}


tasks.jar {
    enabled = false
}