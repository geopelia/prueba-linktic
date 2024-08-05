FROM eclipse-temurin:17-jdk-jammy
WORKDIR /opt/app
RUN chmod 777 /opt/app
COPY . ./
RUN ./gradlew --version
CMD ["./gradlew", "bootRun"]
