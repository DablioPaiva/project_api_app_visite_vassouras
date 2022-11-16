
FROM openjdk:11
RUN mkdir app
ARG JAR_FILE
ADD /target/visite-vassouras-app-api-0.0.1-SNAPSHOT.jar /app/spring-docker-app-vassouras.jar
WORKDIR /app
ENTRYPOINT java -jar spring-docker-app-vassouras.jar