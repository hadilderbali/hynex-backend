
FROM eclipse-temurin:21-jre

WORKDIR /app

RUN useradd --system --uid 10001 appuser

COPY --chown=appuser:appuser target/*.jar app.jar

USER appuser

EXPOSE 8087

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
