  # Use an official Eclipse Temurin JDK image with Alpine as the base
  FROM innersource-artefacts-docker.lloydsbanking.cloud/ingested/eclipse-temurin:21.0.6_7-jdk-noble

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






    #FROM maven:3.9.9-eclipse-temurin-17 AS build
    #WORKDIR /app
    #COPY pom.xml .
    #COPY src ./src
    #RUN mvn clean package -DskipTests

    #FROM eclipse-temurin:17-jre
    #WORKDIR /app
    #COPY --from=build /app/target/kafka-service-1.0.0.jar app.jar
    #EXPOSE 8080
    #ENTRYPOINT ["java", "-jar", "app.jar"]