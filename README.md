# BankayaChallenge

Aplicacion SOAP para obtener informacion de un pokemon conectandose con https://pokeapi.co/ 

Se tienen los siguientes metodos:

 - abilities
 - base_experience
 - held_items
 - id
 - name
 - location_area_encounters

Para correr el proyecto seguir los siguientes pasos:

 - Descargar el proyecto o clonarlo con el comando git clone
 - Una vez en descargado correr el comando `mvn install` en el directorio raiz del proyecto, esto compilara el proyecto y creara un ejecutable
 - Posteriormente se tiene el archivo Dockerfile para crear un contenedor, primero se tiene que crear una imagen corriendo el siguiente comando `docker build .` en la raiz del proyecto
 - Cuando la imagen este creada se ejecutara con el comando `docker run 9095:9095 <nombre_imagen>`, sustituir con el nombre o id de la imagen
 - Una vez estando arriba la aplicacion consultar el WSDL en la direccion http://localhost:9095/pokemon/pokemon.wsdl
 - Con el WSDL descargado, en un aplicativo como SOAP UI usarlo para empezar a realizar peticiones, ya que creara la estructura necesaria. Solo es necesario enviar el nombre del pokemon a consultar

Tambien se pueden visualizar los datos de las peticiones guardadas en una base de datos en memoria H2. Para esto dirigirse a la direccion http://localhost:9095/h2-console

Y con los siguientes datos ingresar al administrador de base de datos:

 - Driver Class = org.h2.Driver
 - JDBC URL = jdbc:h2:mem:dcbapp
 - User Name = sa
 - Password = password
Una vez detro solo realizar un `SELECT * FROM PETICION`

Se agregan los archivos WSDL y el proyecto de SOAP UI en la carpeta "soap" para facilitar el proceso.
