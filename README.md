# Sistema de informacion basico
## CRUD basico
En esta tarea se hace un crud basico donde se va a ingresar un nombre a traves de terminal, el uso de ese simple programa integrador es simple, por lo que no es necesario documentar esa parte.

### Archivo generado
Se encuentra en la propia carpeta / del repositorio local que ha de clonar

![VistaGeneral](images/mainView.png)

### CLASE DB
Al ingresarse, se instancia un objeto de la clase Db, el cual hace la conexion necesaria y cuenta con los metodos:
- StabilishConnection - devuelve la conexion
- InsertData - ingresa el nombre
- SelectData - obtiene toda la tabla usuario
- AmmountOfData - sin argumentos cuenta todos los registros, con el nombre como argumento cuenta todos los registros con ese nombre

### CLASE Writer
Se hace uso de una mala practica de programacion: instanciar un objeto que solo tiene su constructor xd
Recibe como argumentos un ArrayList con el contenido de la tabla sacado de Db y un String que es la ruta del archivo a crear
Solo crea el txt con el contenido de la tabla usuario

## Consideraciones

### Base de datos
La base de datos usada es mariadb server version 11.5.2-MariaDB Arch Linux; disponible en AUR actualizada

### JDBC
El JDBC solo fue referenciado como dependencia en el pom.xml de MAVEN, no fue necesario descargar absolutamente nada
![Conector](images/dependency.png)

### JDK
Este proyecto de MAVEN usa el java 17