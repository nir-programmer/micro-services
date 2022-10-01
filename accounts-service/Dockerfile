
#Install the jdk 11 in the docker conatiner which will be created from this image
FROM openjdk:11-slim as build

# Add the application's jar to the container
COPY target/accounts-service-0.0.1-SNAPSHOT.jar accounts-service-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/accounts-service-0.0.1-SNAPSHOT.jar"]