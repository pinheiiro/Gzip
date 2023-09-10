# Use uma imagem base do Maven para compilar o projeto
FROM maven:3.8.4-jdk-17 AS build

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo pom.xml e o código-fonte do projeto para o contêiner
COPY pom.xml .
COPY src ./src

# Execute o comando Maven para compilar o projeto e criar o arquivo JAR
RUN mvn clean package -DskipTests

# Use uma imagem base do OpenJDK para Java 17 para executar o aplicativo
FROM adoptopenjdk:17-jre-hotspot

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR gerado pelo Maven para o contêiner
COPY --from=build /app/target/seu-app.jar ./app.jar

# Exponha a porta 8080 para o aplicativo Spring Boot
EXPOSE 8080

# Especifique o comando que será executado quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]