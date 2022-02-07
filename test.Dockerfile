FROM openjdk:11.0.13-slim
VOLUME /tmp
EXPOSE 8080
COPY build/libs/*.jar app.jar
COPY data/output.json data/output.json

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]