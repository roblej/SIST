FROM openjdk:17

ARG JAR_FILE=build/libs/ex0930_emp-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} doc_boot2.jar

ENTRYPOINT ["java", "-jar", "doc_boot2.jar"]