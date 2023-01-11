# Crud


## Instalación
Realizar un git clone del repositorio actual con la rama MAIN en la ruta de su preferencia


```sh
git clone https://github.com/jhtc5898/crud.git
```
Abrir el proyecto en su IDE de preferencia (Desarrollado en IntelliJ IDEA)

Levantar la base de datos existe 2 opciones
## Primera Opcion

Levantar la base de datos en un contenedor:
En la ubicación donde está el fichero encontrara el documento
```sh
postgres.yml
```
Levante el contenedor con el siguiente comando:
```sh
docker-compose -f postgres.yml up
```
El contenedor está configurado para que inicie ejecutando el init.sql que está en la carpeta [sql]  de esta manera ya tendrá generado usuarios de prueba.
POR LO CUAL SOLO DEBE LEVANTAR EL PROYECTO Y UTILIZAR CON NORMALIDAD

## Segunda Opcion
Generar una base de datos con las siguientes características:
```sh
      POSTGRES_DB: bayteq
      POSTGRES_USER: usuario
      POSTGRES_PASSWORD: password
```
o

```sh
spring.datasource.url=jdbc:postgresql://localhost:5432/bayteq?currentSchema=bayteq
spring.datasource.username=usuario
spring.datasource.password=password
```


a continuacion:

Mandamos a correr el script init.sql que se encuentra en la carpeta [sql] 

Fin proceso BD

Ahora ya podemos iniciar el proyecto:
LEVANTAR EL PROYECTO Y UTILIZAR CON NORMALIDAD

DOCUMENTACION SERVICIOS
https://documenter.getpostman.com/view/13910567/2s8Z76wpjL

## Recomendaciones
En el caso de tener alguna error con las dependencias ejecutar:
```sh
mvn clean install
```

En el caso de que no se levante el contenedor Docker puede que tenga levantado otro PostGresql en su máquina por lo cual sería recomendable cambiar el puerto en el archivo [postgres.yml]

Actual:
```sh
version: '3.3'

volumes:
  postgres_data:
    driver: local

services:
  postgres:
    image: postgres
    volumes:
      - postgres_data:/var/lib/postgresql/data
      - ./sql/init.sql:/docker-entrypoint-initdb.d/init.sql
    environment:
      POSTGRES_DB: bayteq
      POSTGRES_USER: usuario
      POSTGRES_PASSWORD: password
    ports:
      - 5432:5432
```
## Cambio de puerto Contenedor 
```sh
version: '3.3'

volumes:
  postgres_data:
    driver: local

services:
  postgres:
    image: postgres
    volumes:
      - postgres_data:/var/lib/postgresql/data
      - ./sql/init.sql:/docker-entrypoint-initdb.d/init.sql
    environment:
      POSTGRES_DB: bayteq
      POSTGRES_USER: usuario
      POSTGRES_PASSWORD: password
    ports:
      - 5433:5432
```




## License

MIT

**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
