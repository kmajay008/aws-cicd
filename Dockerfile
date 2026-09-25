FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/course-service.jar /app/course-service.jar

EXPOSE 8080

CMD ["java", "-jar", "course-service.jar"]