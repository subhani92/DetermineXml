# Use a base image with Java 17
FROM openjdk:11-jre-slim

# Copy the jar file to the image
COPY target/XmlValidator-1.0-SNAPSHOT.jar /app/XmlValidatorApp.jar

# Set the working directory
WORKDIR /app

# Define the entrypoint command to run the app
ENTRYPOINT ["java", "-jar", "XmlValidatorApp.jar"]
