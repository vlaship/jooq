plugins {
    java
    alias(libs.plugins.springBoot)
    alias(libs.plugins.springDependencyManagement)
    alias(libs.plugins.git.properties)
    alias(libs.plugins.jooq)
}

group = "dev.vlaship.jooq"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = sourceCompatibility
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // web
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // mapper
    annotationProcessor(libs.mapstruct.processor)
    implementation(libs.mapstruct)

    // db
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation(libs.jooq)
    implementation(libs.preLiquibase)
    implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")
}

buildscript {
    dependencies {
        classpath(libs.jooqMetaExtensionsLiquibase)
    }
}

jooq {
    configuration {
        generator {
            database {
                name = "org.jooq.meta.extensions.liquibase.LiquibaseDatabase"
                properties {
                    property {
                        key = "rootPath"
                        value = "${projectDir}/src/main/resources"
                    }
                    property {
                        key = "scripts"
                        value = "db/changelog/db.changelog.yml"
                    }

                    property {
                        key = "database.liquibaseSchemaName"
                        value = "books"
                    }

                    property {
                        key = "includeLiquibaseTables"
                        value = false.toString()
                    }
                }
            }
            target {
                packageName = project.group.toString()
            }
        }
    }
}
