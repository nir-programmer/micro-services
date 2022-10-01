
#Install the jdk 11 in the docker conatiner which will be created from this image
FROM openjdk:11-slim as build

# Add the application's jar to the container
COPY target/loans-service-0.0.1-SNAPSHOT.jar loans-service-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/loans-service-0.0.1-SNAPSHOT.jar"]