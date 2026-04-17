
# 1. Etapa de construcción (Build)
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY . .
# Damos permiso y ejecutamos la compilación
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar -x test

# 2. Etapa de ejecución
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copiamos el archivo .jar generado
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

