# Trabajo Practico Final Redes

## Para correr este proyecto:

##### Dentro de la carpeta out/artifacts encontrara dos carpetas "client_jar" y "server_jar".
##### Para iniciar se debe abrir la consola en la ubicación del archivo "server_jar" donde se encuentra el .jar del server y utilizar el comando java "-jar server.jar" para ejecutar el servidor.
##### A continuación se deberá hacer lo mismo con el .jar de client que se encuentra en la carpeta "client_jar" con el comando "java -jar client.jar"
##### En la consola del usuario se pedirá una dirección de IP y el puerto del servidor al que desea conectarse, en este caso será "localhost" o su equivalente "127.0.0.1" para la dirección IP y 3000 para el puerto.
##### El servidor mostrara un mensaje con la dirección IP del dispositivo conectado.
##### El cliente podrá enviar un mensaje al servido presionando ENTER luego de ingresar algún texto, una vez sea recibido por el servidor este enviará al cliente un mensaje confirmando la recepción del mensaje.
##### Hasta 5 clientes pueden estar conectados al servidor al mismo tiempo con un numero de id asignado por el orden en el que se conectaron.
##### El mensaje recibido por el servidor se mostrará en pantalla con el id del cliente que lo envió.
##### El cliente podrá desconectarse del servidor en cualquier momento enviando como mensaje solo la letra X, tanto mayúscula como minúscula.
##### Una vez se hayan desconectado todos los clientes el servidor se cerrará.

## Guía de preguntas:

### 1. ¿Qué es un puerto?

##### Un puerto es una interfaz o conector ya sea interno o externo que se utiliza para comunicar diferentes tipos de elementos de hardware o elementos de software que nos permitan enviar y recibir datos de un equipo a otro.

### 2. ¿Cómo están formados los endpoints?

##### Los endpoints están compuestos por la dirección de IP y un puerto, que se utilizan para ingresar dentro de una red de comunicación.

### 3. ¿Qué es un socket?

##### Los sockets son mecanismos de comunicación entre procesos que permiten que un proceso hable (emita o reciba información ) con otro proceso incluso estando en distintas máquinas.

### 4. ¿A qué capa del modelo TPC/IP pertenecen los sockets? ¿Por qué?

##### Los sockets pertenecen a la capa de transporte del modelo TCP/IP ya que la función de la capa de transporte del modelo TCP/IP es garantizar que los paquetes lleguen sin errores y en secuencia, uno después de otro.


### 5. ¿Cómo funciona el modelo cliente-servidor con TCP/IP Sockets?

##### En el modelo cliente-servidor con TCP/IP Sockets el servidor es el programa que permanece pasivo a la espera de que alguien solicite conexión con él, y el cliente es el programa que solicita la conexión para pedir datos al servidor.

#### Servidor:

##### • Está ejecutándose y esperando a que otro quiera conectarse a él. 
##### • Nunca da "el primer paso" en la conexión.
##### • Es el que "sirve" información al que se la pida.

#### Cliente:

##### • Es el programa que da el “primer paso” en la conexión.
##### • En el momento de ejecutarlo o cuando lo necesite, intenta conectarse al servidor.
##### • Es el que solicita información al servidor.


### 6. ¿Cuáles son las causas comunes por la que la conexión entre cliente/servidor falle?

##### • El servidor no se encuentra disponible y por esto el cliente no puede conectarse al mismo.
##### • El puerto de recepción del servidor está bloqueado o cerrado.
##### • El servidor intenta enviar datos a un cliente que ya se ha desconectado.
##### • El cliente utiliza una dirección de host y/o un puerto inválido para conectarse al servidor.


### 7. Diferencias entre sockets UDP y TCP

#### El protocolo UDP:

##### UDP (User Datagram Protocol) es un protocolo no orientado a conexión. Es decir, cuando una máquina A envía paquetes a una máquina B, el flujo es unidireccional. La transferencia de datos se realiza sin prevenir al destinatario (la máquina B), y el destinatario recibe los datos sin enviar una confirmación al emisor (la máquina A).
#### Esto se debe a que los datos enviados por el protocolo UDP no permiten transmitir la información relacionada al emisor. Por ello, el destinatario no conocerá al emisor de los datos, excepto su IP.

#### El protocolo TCP:

##### Contrariamente a UDP, el protocolo TCP (Transmission Control Protocol) está orientado a conexión. Cuando una máquina A envía datos a una máquina B, la máquina B es informada de la llegada de estos, y confirma su buena recepción.
##### Aquí interviene el control CRC de datos, que se basa en una ecuación matemática que permite verificar la integridad de los datos transmitidos. De este modo, si los datos recibidos son corruptos, el protocolo TCP permite que los destinatarios soliciten al emisor que los vuelva a enviar.

### 8. Diferencia entre sync & async sockets?

#### Sockets síncronos: 
##### Establecen una comunicación bloqueante debido a que realizan un envió, esperan una respuesta, y recién luego de eso, pueden realizar otro envío de datos

#### Sockets asincrónicos:
##### Establecen una comunicación donde no hay ningún factor bloqueante y se desenvuelve de manera desestructurada la emisión y recepción de datos.
