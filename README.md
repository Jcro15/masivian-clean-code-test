# masivian-clean-code-test

## Pre-requisitos
* [Docker](https://www.docker.com/) - Administrador de contenedores
* [Maven](https://maven.apache.org/) - Administrador de dependencias
* [Git](https://git-scm.com/) - Sistema de control de versiones
* [Java](https://www.java.com/) - Tecnología para el desarrollo de aplicaciones

## Instrucciones de uso 

Para descargar el proyecto se debe usar 
```
git clone https://github.com/Jcro15/masivian-clean-code-test
```

Una vez descargado el proyecto este debe compilarse usando el siguiente comando

```
mvn package 
```


Para ejecutar la aplicación se debe definir la variable de entorno REDIS_HOST 
(192.168.99.100 en dockerToolBox o 172.17.0.1 por defecto en docker engine ) y luego
usar el comando 

```
docker-compose up -d 
```

## Construido con

* [Maven](https://maven.apache.org/) - Administrador de dependencias
* [Docker](https://www.docker.com/) - Administrador de contenedores


## Autor

* **Juan Camilo Rojas Ortiz** - *Estudiante de ingeniería de sistemas* 

## Licencia

Este proyecto esta bajo la licencia GNU(General Public License) los detalles se pueden encontrar en el archivo [LICENSE](LICENSE)

