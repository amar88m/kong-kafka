  # Use an official Eclipse Temurin JDK image with Alpine as the base
  FROM maven:3.9.9-eclipse-temurin-17 AS build

  # Set the working directory inside the container
  WORKDIR /app

  # Copy the pre-built jar file into the Docker image
  COPY target/*.jar /app/app.jar

  # Switch to the non-root user
  USER 1001

  # Expose the port the application uses
  EXPOSE 8080

  # Define the command to run the application
  #ENTRYPOINT ["java", "-jar", "app.jar"]
  ENTRYPOINT ["java","-Xms512m", "-Xmx1536m", "-jar", "app.jar"]