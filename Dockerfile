# Imagen base con una distribucion de java que funciona en linux
FROM openjdk:11-oracle

# Crear directorio de trabajo para la aplicacion
COPY build/libs/parcial-arquitectura-*.jar /app/parcial-arquitectura.jar

# Comando para ejecutar la aplicacion
CMD ["java", "-jar", "/app/parcial-arquitectura.jar"]