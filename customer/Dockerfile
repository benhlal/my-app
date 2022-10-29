# AS <NAME> to name this stage as maven
FROM maven:3.6.3 AS mavenStage
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package

# For Java 11,
FROM adoptopenjdk/openjdk16

ARG JAR_FILE=customer-0.0.1.jar

WORKDIR /opt/app

# Copy packaged jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=mavenStage /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","${JAR_FILE}"]