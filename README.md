# Proyecto de Microservicios en Java

Este proyecto se basa en la arquitectura de microservicios y se ha desarrollado utilizando Java. Este enfoque permite descomponer una aplicación en partes más pequeñas y manejables, cada una de las cuales puede ser desplegada y escalada de manera independiente.

## Características Principales

- **Desarrollo en Java**: Basado en el lenguaje de programación Java, asegurando robustez y facilidad de mantenimiento.
- **Basado en Microservicios**: Cada servicio es independiente y se comunica a través de APIs, lo que mejora la escalabilidad y la flexibilidad.
- **API RESTful**: Los microservicios exponen sus funcionalidades a través de servicios RESTful, lo que permite la integración con otras plataformas.
- **Persistencia de Datos**: Integración con bases de datos para una gestión eficaz de los datos.
- **Despliegue en la Nube**: Posibilidad de despliegue en plataformas de nube, lo que mejora la disponibilidad y la capacidad de escalabilidad.

## Requisitos Previos

Para ejecutar este proyecto, asegúrate de tener instalado:
- Java 11 o superior
- Maven 3.6 o superior
- Docker (opcional, para despliegue en contenedores) 

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/KennyRoDi/entertainflix-microservice-java.git
   ```
2. Navega al directorio del proyecto:
   ```bash
   cd entertainflix-microservice-java
   ```
3. Ejecuta el siguiente comando para compilar el proyecto:
   ```bash
   mvn clean install
   ```
4. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

## Contribución

Las contribuciones son bienvenidas. Por favor, sigue este formato:
1. Haz un fork del repositorio.
2. Crea una nueva rama para tu característica:
   ```bash
   git checkout -b feature/mi-nueva-caracteristica
   ```
3. Realiza tus cambios y confirma:
   ```bash
   git commit -m "Añadida mi nueva característica"
   ```
4. Envía tus cambios:
   ```bash
   git push origin feature/mi-nueva-caracteristica
   ```
5. Abre un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.