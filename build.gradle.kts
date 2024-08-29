plugins {
	java
	id("org.springframework.boot") version "3.3.3"
	id("jakarta.persistence") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "1"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("jakarta.persistence:jakarta.persistence-api")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
