FROM eclipse-temurin:17

WORKDIR  /app

COPY ./target/*.jar /app/emi.jar

EXPOSE 8082

CMD ["java", "-jar", "emi.jar"]