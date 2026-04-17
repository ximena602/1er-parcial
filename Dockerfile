FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /App
COPY . .
FROM ubuntu:latest
LABEL authors="PERSONAL"

RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar -x test

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/app.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]