FROM openjdk:11

EXPOSE 8080

ARG JAR_FILE=target/monthlyPayslip-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} monthlyPayslip.jar

ENTRYPOINT ["java", "-jar", "monthlyPayslip.jar"]

HEALTHCHECK --interval=30s --timeout=3s \
CMD curl -f http://localhost:8080/health | grep UP || exit 1
