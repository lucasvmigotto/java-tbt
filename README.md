# java-tbt

## Development

### Requirements

* [Docker CE](https://docs.docker.com/engine/install/)
* [DevContainers](https://code.visualstudio.com/docs/devcontainers/containers)
  * [Tutorial](https://code.visualstudio.com/docs/devcontainers/tutorial)
* [Dev Cotainers Extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)

### Environment setup

1. Clone

    * _https_

        ```bash
        git clone https://github.com/lucasvmigotto/java-tbt.git
        ```

    * _ssh_

        ```bash
        git clone git@github.com:lucasvmigotto/java-tbt.git
        ```

### Useful commands

#### PostgrSQL Docker Compose Service

```bash
# Start the service
docker compose up [-d | --detach] postgres
```

```bash
# Use the PSQL CLI
docker compose exec -it postgres psql -U postgres -d java_tbt
```

#### Application

```bash
# Start the server
./mvnw spring-boot:run
```

```bash
# Build the package
./mvnw package -DskipTests
```

## References

### Documentation

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.0/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.0/maven-plugin/build-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/4.0.0/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/reference/web/spring-security.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.0/reference/web/servlet.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/4.0.0/reference/using/devtools.html)
* [Flyway Migration](https://docs.spring.io/spring-boot/4.0.0/how-to/data-initialization.html#howto.data-initialization.migration-tool.flyway)

### Guides

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
