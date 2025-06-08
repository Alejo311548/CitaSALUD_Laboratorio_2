# Usa una imagen base con JDK 17
FROM eclipse-temurin:17-jdk AS build

# Establece el directorio de trabajo para la construcción
WORKDIR /app

# Copia los archivos necesarios para compilar el proyecto
COPY .mvn .mvn
COPY mvnw mvnw
COPY pom.xml pom.xml
COPY src src

# Da permisos de ejecución al wrapper
RUN chmod +x mvnw

# Construye el proyecto (sin tests)
RUN ./mvnw clean package -DskipTests

# Etapa final: solo contiene el .jar
FROM eclipse-temurin:17-jdk

# Establece el directorio de trabajo para ejecución
WORKDIR /app

# Copia el jar desde la etapa anterior
COPY --from=build /app/target/CITASalud_Backend.jar .

# Expone el puerto
EXPOSE 8080

# Comando para ejecutar el JAR
CMD ["java", "-jar", "CITASalud_Backend.jar"]
