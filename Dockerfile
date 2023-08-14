FROM amazoncorretto:17.0.7-alpine

WORKDIR /app

COPY build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
