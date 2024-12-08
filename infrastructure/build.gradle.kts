dependencies {
    implementation(project(":domain"))

    // DB & JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.mysql:mysql-connector-j")
    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.10.0")


    // Elasticsearch
    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")

    // Security & JWT
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt-api:0.12.6")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.6")


    // Cache
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("org.ehcache:ehcache:3.10.8")

    // External APIs
    implementation("com.deepl.api:deepl-java:1.7.0")
    implementation("com.google.cloud:google-cloud-speech:4.49.0")
    implementation("com.google.cloud:google-cloud-texttospeech:2.55.0")
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}