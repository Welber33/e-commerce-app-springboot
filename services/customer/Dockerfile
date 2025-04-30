FROM maven
COPY . /data
WORKDIR /data
RUN mvn clean install
CMD ["mvn", "spring-boot:run"]