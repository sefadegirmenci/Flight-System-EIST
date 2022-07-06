FROM openjdk:18-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} flightsystem.jar
ENTRYPOINT ["java","-jar","/flightsystem.jar"]