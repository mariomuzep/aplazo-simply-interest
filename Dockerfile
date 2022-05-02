FROM openjdk:8-alpine
ADD target/simple-interest-service-0.0.1-SNAPSHOT.jar /usr/share/services.jar
EXPOSE 8080
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/services.jar"]
