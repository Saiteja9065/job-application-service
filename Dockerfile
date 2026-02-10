FROM amazoncorretto:21

WORKDIR /app

COPY target/job-application-service-0.0.1-SNAPSHOT.jar job-app.jar

EXPOSE 8085

ENTRYPOINT ["java","-jar","job-app.jar"]