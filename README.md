# Trabajo Practico Final Redes

##### dentro de la carpeta out/artifacts encontrara dos carpetas "client_jar" y "server_jar".
##### Para iniciar se debe abrir la consola en la ubicación del archivo "server_jar" donde se encuentra el .jar del server y utilizar el comando java "-jar server.jar" para ejecutar el servidor.
##### A continuación se deberá hacer lo mismo con el .jar de client que se encuentra en la carpeta "client_jar" con el comando "java -jar client.jar"
##### En la consola del usuario se pedirá una dirección de IP y el puerto del servidor al que desea conectarse, en este caso será "localhost" o su equivalente "127.0.0.1" para la dirección IP y 3000 para el puerto.
##### El servidor mostrara un mensaje con la dirección IP del dispositivo conectado.
##### El cliente podrá enviar un mensaje al servido presionando ENTER luego de ingresar algún texto, una vez sea recibido por el servidor este enviará al cliente un mensaje confirmando la recepción del mensaje.
##### Hasta 5 clientes pueden estar conectados al servidor al mismo tiempo con un numero de id asignado por el orden en el que se conectaron.
##### El mensaje recibido por el servidor se mostrará en pantalla con el id del cliente que lo envió.
##### El cliente podrá desconectarse del servidor en cualquier momento enviando como mensaje solo la letra X, tanto mayúscula como minúscula.
##### Una vez se hayan desconectado todos los clientes el servidor se cerrará.
