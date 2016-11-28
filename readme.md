# Sistema de gestión de Cuentas Corrientes
Sistema informático desarrollado en Spring, utilizando AngularJS para consumir los servicios web RestFul implementados por la especificación de Spring Boot.
## Contenido
 - [Requisitos](#requisitos)
 - [Instalación](#instalacion)
 - [Ejecución](#ejecucion)


### Requisitos
Las versiones de las siguientes herramientas son necesarias para la configuración y ejecución del proyecto:
```
 Base de datos: PostgreSQL 9.x 
 Lenguaje de Programación: Java 1.8
 Bower: 1.7.9 o superior
 Apache Maven: 3.3.9 o superior
```
La instalación de las herramientas anteriores excede el ámbito de esta guía.

Además se asume la creación de un usuario en Postgres con una base datos y los respectivos permisos para editarla.

### Instalacion
Una vez obtenido el proyecto, y cumplido los requisitos, se debe realizar lo siguiente:
- #### Instalar dependencias del cliente
    Navegar al directorio. 
    ```
    /src/main/resources/static/
    ```
    Dentro de el, ejecutar la siguiente instrucción en la terminal:
    ```
    $ bower install
    ```
    Esto descargará y almacenará las dependencias que requiere AngularJS para poder ejecutar la aplicación correctamente. Estas dependencias se almacenan en una carpeta llamada 'bower_components'. Cabe resaltar que este paso es crucial para la correcta ejecución del proyecto. 

- #### Ejecución del Script de base de datos
    Dentro del directorio donde se encuentra la carpeta /static/, se observa un archivo llamad 'catastro.sql'. Se debe ejecutar ese Script en una base de datos vacía que debe haber sido creada con anterioridad dentro del motor de PostgreSQL.
- #### Propiedades de la aplicación
    Localizar dentro de la carpeta resources, un archivo nombrado: "example.application.properties", se debe renombrar a application.properties:
    ```
    $ mv example.application.properties application.properties
    ```
    Dentro de el, se encuentran las variables de configuración para la base de datos. Se debe modificar los siguientes elementos:
    
    ```
    spring.datasource.url=url
    spring.datasource.username=username
    spring.datasource.password=password
    ```
    Renonmbrar las variables url, username y password de acuerdo a la instalación deseada y a la base de datos y usuario creado dentro de PostgreSQL.
    
### Ejecucion
Si todo ha ido acorde y no se ha mostrado ningun error a la hora de instalar y configurar el sistema, se debe ingresar a un entorno de desarrollo y realizar un 'Clean and Build' para generar un archivo .jar dentro de la carpeta 'target', dicho jar se ejecuta de la siguiente manera:
    ```
    $ java -jar target/<nombre-ejecutable>.jar
    ```
Lo cual generará una impresión en consola que indica el booteo de Spring, el proceso se detiene y se monta el servidor embebido para escuchar peticiones en el puerto 8000 (Siempre y cuando no se haya modificado esa propiedad en el archivo application.properties), se debe ingresar a la dirección correspondiente para iniciar la aplicación 

Alternativamente si se tiene Apache Maven instalado, se ejecuta la siguiente orden dentro de la raíz del proyecto:
    ```
    $ mvn spring-boot:run
    ```
Lo cual compilará el proyecto y lo ejecutará luego de terminada la compilación dando como resultado lo anteriormente escrito.

