# Usa una imagen con JDK 17
FROM eclipse-temurin:17-jdk

# Crea un directorio de trabajo
WORKDIR /app

# Copia todo el código fuente
COPY . .

# Da permisos de ejecución al wrapper
RUN chmod +x mvnw

# Compila la app sin tests
RUN ./mvnw clean package -DskipTests

# Expone el puerto 
EXPOSE 8080

# Comando para ejecutar el JAR
CMD ["java", "-jar", "target/CITASalud.jar"]
