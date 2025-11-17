# Arquitectura del Microservicio  
La arquitectura de este microservicio está diseñada para ser escalable, eficiente y de fácil mantenimiento. Se compone de varias capas que interactúan entre sí para cumplir con los requerimientos del sistema.

## Capas de la Arquitectura  
1. **Capa de Presentación**: Esta capa es responsable de gestionar las interacciones con los usuarios y presentar la información de manera amigable. Utiliza API REST para la comunicación con otras capas.
2. **Capa de Negocio**: Aquí se encuentran las reglas y la lógica del negocio. Esta capa procesa los datos recibidos, realiza las operaciones necesarias y se comunica con la capa de persistencia para almacenar o recuperar información.
3. **Capa de Persistencia**: Esta capa se encarga de la interacción con la base de datos. Utiliza métodos de acceso a datos para guardar y recuperar información de manera eficiente.
4. **Capa de Integración**: Facilita la comunicación entre diferentes microservicios y sistemas externos, utilizando protocolos como HTTP, AMQP, entre otros.

## Componentes del Sistema  
- **Servicios REST**: Permiten la comunicación entre el cliente y el servidor mediante solicitudes HTTP.  
- **Base de Datos**: Almacena la información del sistema y permite consultas eficientes.  
- **Mensajería**: Se usa para la comunicación asíncrona entre microservicios, permitiendo que los servicios interactúen de manera más flexible y desacoplada.  

## Requisitos  
- **Java 11 o superior**: Para el desarrollo del microservicio.  
- **Framework Spring Boot**: Para simplificar la configuración y el desarrollo de nuevos endpoints REST.  
- **Base de datos**: PostgreSQL para la persistencia de datos.  
- **Sistema de Mensajería**: AzureQueue para la comunicación entre microservicios.  

## Flujos de Datos  
El flujo de datos dentro del microservicio se inicia cuando un usuario realiza una solicitud a través de la capa de presentación. La solicitud es enviada a la capa de negocio, donde se procesa la información. Luego, se utilizan los métodos de acceso a datos para interactuar con la base de datos cuando es necesario. Los resultados se devuelven a la capa de presentación y, si corresponde, se envían notificaciones a otros microservicios a través de la capa de integración. Este flujo asegura que los datos se manejen de manera fluida y eficiente, garantizando una experiencia de usuario óptima.
