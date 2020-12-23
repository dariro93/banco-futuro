# Evaluación de matriz de riesgos

Este proyecto simula la ejecución de la evaluación de la matriz de riesgos para una compañía (incluido el Banco del Futuro). Los requisitos para correr este proyecto son:

1. Tener una base de datos PostgreSQL con el esquema que se crea usando el script [schema.sql] (./src/main/resources/db/schema.sql) el cual se encarga de crear una tabla que contiene las compañías con sus valores simulados de su matriz de riesgos.

### Swagger

Para ver los recursos swagger abrir la url http://<ip-del-despliegue>:8866/swagger-ui/ (asegurarse de incluir el slash al final)

### Cómo funciona

Al iniciar la aplicación se crean las compañías especificadas en el archivo [application.yml](./src/main/resources/application.yml) bajo la propiedad "companies" (por defecto bancofuturo y appgate) y a su vez se simula un matriz de riesgos usando valores aleatorios (representando el valor calculado de impacto vs urgencia) que más adelante podrán ser evaluados para saber su nivel de riesgo.

 * El proyecto soporta crear nuevas compañías (con datos aleatorios)
 * Se puede calular la matriz de riesgos para cada una de las compañías creadas: Se devuelve una matriz que contiene el valor del riesgo y su nivel. Este puede ser bajo, medio, alto y crítico de acuerdo a los siguientes umbrales: 
        
        * 0 <= risk < 25 -> Bajo -> Color verde
        * 25 <= risk < 50 -> Medio -> Color amarillo
        * 50 <= risk < 75 -> Alto -> Color Naranja
        * 75 <= risk < 100 -> Crítico -> Color rojo

### Pruebas unitarias

Se hizo el caso de prueba para la clase [PopulatorServiceImpl.java] (./src/main/java/com/bancofuturo/usecase/service/impl/PopulatorServiceImpl.java) y la clase que hace las pruebas unitarias está ubicada en [PopulatorServiceImplTest.java] (./src/test/java/com/bancofuturo/usecase/service/impl/PopulatorServiceImplTest.java)

### Despliegue 

Se hizo un despliege en un contenedor Docker bajo la siguiente url (url interna): http://192.168.243.61:8866/swagger-ui/

`PARA DESPLEGAR`:

El despliegue se hace a través de un contenedor Docker y todo lo requerido se encuentra en la carpeta [deployment] (./deployment/). Esto debe hacerse en un entorno Linux con docker instalado ejecutando el siguiente comando: 

    ** docker build -t bancofuturo .
    ** docker run -d --name bancofuturo -p 8866:8866 -p 5432:5432 -e DATABASE_NAME=postgres -e POSTGRES_DB=postgres -e POSTGRES_PASSWORD=postgres bancofuturo

######## IMPORTANTE -> Para poder construir la imagen docker debe construirse el proyecto ejecutando el comando mvn package y el jar que se genera debe copiarse a la carpeta [deployment] (./deployment/) 
