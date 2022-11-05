FROM openjdk:16-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} anomaly.jar
ENTRYPOINT ["java","-jar","/anomaly.jar"]