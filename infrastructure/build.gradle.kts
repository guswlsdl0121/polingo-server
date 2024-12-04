dependencies {
    // DB & JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.mysql:mysql-connector-j")
    implementation("com.p6spy:p6spy")

    // Elasticsearch
    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")

    // Security
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")

    // Cache
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("org.ehcache:ehcache")

    // External APIs
    implementation("com.deepl.api:deepl-java:1.3.0")
    implementation("com.google.cloud:google-cloud-speech")
    implementation("com.google.cloud:google-cloud-texttospeech")
}