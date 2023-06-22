# PRICE VALIDATOR 💰
Aplicación REST que retorna el precio de un producto dependiendo de una fecha ingresada.

Esta aplicación está construida en gradle multi-modulo utilizando la estructura clean architecture y el framework es 
Spring Boot.

## Correr la aplicacion 🚀


    ./gradlew bootRun

## Validar pruebas

    ./gradlew test

## Estructura de modulos

### DOMAIN

![domain.png](docs%2Fimg%2Fdomain.png)

En esta capa contiene dos modulos que son:

**model:** contiene todas las entidades de la aplicación, a su vez, contiene los gateways que son interfaces que utilizan los **usecase** para interactuar con los capa de infraestructura (bases de datos, api rest, MQ, etc...) usando inversión de dependencias, este modulo no tiene dependencias.

**usecase:** contiene toda la logica de negocio de la aplicación, este modulo solo depende de **model**.


### INFRAESTRUCTURE

![infraestructure.png](docs%2Fimg%2Finfraestructure.png)

Esta capa contiene tres directorios que son:

**Adapters:** contiene modulos para acceso a las datos(DB, Files, MQ, Client Rest, etc), cada modulo tiene sus propias dependencias y todos estos modulos dependen de **model**

**Entry Points:** contiene todos los puntos de entrada de la aplicación (Servicios REST, etc), depende de **model**

**Helpers:** contiene todas las librerias que sean comunes y puedan usarse a nivel de la misma capa de **insfraestructure**

### APPLICATION

![application.png](docs%2Fimg%2Fapplication.png)

Esta capa contiene el punto de inicio de la aplicación y todos los archivos de configuración.