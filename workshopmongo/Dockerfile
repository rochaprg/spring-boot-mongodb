FROM openjdk:11
VOLUME /tmp
ADD ./target/workshopmongo-0.0.1-SNAPSHOT.jar workshopmongo.jar
ENTRYPOINT ["java","-jar","/workshopmongo.jar"]