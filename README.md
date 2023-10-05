
Para levantar un container de mysql se utilizo el siguiente comando:

`docker run -d -p 8090:3306 --name mysql -e MYSQL_ROOT_PASSWORD=yms_clave -e MYSQL_USER=yms_user -e MYSQL_PASSWORD=yms_clave -e MYSQL_DATABASE=yms mysql`


Para crear la imagen de Docker del proyecto actual

`docker build -t parcial-arquitectura:latest .`
