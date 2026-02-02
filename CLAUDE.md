# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Spring Boot 3.2.0 REST API example written in Kotlin 2.0.0-Beta2. Uses Jetty as the servlet container (not Tomcat). Exposes HTTP on port 8080 and HTTPS on port 8443.

## Build Commands

```bash
# Build JAR
./mvnw clean package

# Run locally
java -jar target/spring-boot-kotlin-example.jar

# Build Docker image
make image

# Build and run everything
make up
```

## Test Endpoints

```bash
curl http://localhost:8080/              # Root endpoint
curl http://localhost:8080/probe/live    # Liveness probe
curl http://localhost:8080/probe/ready   # Readiness probe
curl http://localhost:8080/actuator/health
```

## Architecture

Simple stateless REST API with no database layer:

- **Entry point**: `ExampleApp.kt` - Spring Boot main class
- **Controllers**: `controller/RootController.kt` and `controller/ProbeController.kt`
- **Config**: `ObjectMapperBuilderCustomizer.kt` - Jackson JSON configuration with JavaTimeModule

All controller endpoints are annotated with `@Timed` for Micrometer metrics collection.

## Deployment

- **Docker**: Multi-stage build using Ubuntu 22.04 + OpenJDK 21 JRE
- **Kubernetes**: Helm chart in `deployment/k8s/helm/chart/`
- **CI/CD**: GitHub Actions workflow builds, tests, and pushes Docker images on main branch

## Key Configuration

- `src/main/resources/application.yml` - Spring Boot configuration
- `pom.xml` - Maven build with Kotlin and Spring Boot plugins
- `Makefile` - Shortcuts for build/image/run commands
