FROM openjdk:11-jre-slim
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-Xmx100m", "-jar", "/app.jar"]