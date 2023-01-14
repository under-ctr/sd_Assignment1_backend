FROM openjdk:17-alpine
COPY target/assignment1-0.0.1-SNAPSHOT.jar assignment1.jar
ENTRYPOINT ["java", "-jar", "assignment1.jar"]