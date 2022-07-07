FROM openjdk:18-jdk-alpine
EXPOSE 8080
WORKDIR app/
COPY . .
RUN sh build.sh
COPY build/libs/flightsystem-1.0.jar flightsystem.jar
ENTRYPOINT ["java","-jar","/flightsystem.jar"]