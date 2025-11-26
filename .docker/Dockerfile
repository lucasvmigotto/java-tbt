# syntax=docker/dockerfile:1.7-labs

FROM eclipse-temurin:25-jdk-ubi10-minimal AS build

WORKDIR /app

RUN \
    --mount=type=bind,source=pom.xml,target=pom.xml \
    --mount=type=bind,source=mvnw,target=mvnw \
    --mount=type=bind,source=.mvn/,target=.mvn/ \
    --mount=type=bind,source=src/,target=src/ \
    /app/mvnw package -DskipTests

FROM eclipse-temurin:25-jre-ubi10-minimal AS final

WORKDIR /app

COPY \
    --from=build \
    --chown=app:app \
    "/app/target/api*.jar" \
    "/app/api.jar"

CMD ["java", "-jar", "/app/api.jar"]


