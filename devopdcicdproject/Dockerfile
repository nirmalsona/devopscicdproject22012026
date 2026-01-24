FROM eclipse-temurin:11-jre-jammy

WORKDIR /app

COPY target/*.jar app.jar


EXPOSE 8000


CMD ["java", "-jar", "app.jar"]
