# author:
# Sai Vivek Vangaveti - G01413358
# Venkata Sree Divya Kasturi - G01411963
# Mary Ashwitha Gopu - G01408743
# Gangadhara Sai Kutukuppala - G01444780
# functionality: Dockerfile for the Spring Boot application
FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp
# The application's jar file
ARG JAR_FILE=target/*.jar

# Add the application's jar to the container
COPY ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]