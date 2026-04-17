# 1. Etapa de construcción
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY . .
# Damos permiso al ejecutable de gradle y construimos
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar -x test

# 2. Etapa de ejecución
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copiamos el archivo generado desde la etapa de construcción
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
