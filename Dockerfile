FROM maven:3.9.0-amazoncorretto-19

WORKDIR /da-app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run