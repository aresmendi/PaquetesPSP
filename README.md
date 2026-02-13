# 🚀 PaquetesPSP

Repositorio de la práctica de **Programación de Servicios y Procesos (PSP)** centrada en la creación de aplicaciones cliente-servidor usando **hilos** y **sockets** en Java.

Esta práctica forma parte de los contenidos de DAM (Desarrollo de Aplicaciones Multiplataforma) y aborda conceptos clave de comunicación en red y concurrencia en Java, implementando una solución distribuida que permite el envío y recepción de paquetes entre múltiples clientes y un servidor.

---

## 📌 Descripción del Proyecto

La aplicación implementa un esquema de comunicación **cliente-servidor** mediante **sockets TCP** en Java. Utiliza **hilos** para gestionar múltiples conexiones de clientes de forma concurrente, permitiendo que cada conexión sea atendida de forma independiente sin bloquear el servidor principal. :contentReference[oaicite:1]{index=1}

El proyecto contiene:

- **Servidor multihilo**  
  - Escucha conexiones entrantes en un puerto definido.
  - Crea un hilo por cada cliente conectado para atender su comunicación sin interferir con otros clientes.
  - Gestiona el envío y recepción de paquetes de datos.

- **Cliente**  
  - Se conecta al servidor mediante sockets.
  - Envía y recibe mensajes o paquetes de datos.
  - Permite interacción con el servidor de forma concurrente.

---

## 🧠 Conceptos Clave

Este proyecto demuestra varios conceptos fundamentales de PSP y programación de redes:

### 🧵 Concurrencia con hilos

Los hilos (**threads**) permiten que el servidor atienda múltiples clientes al mismo tiempo, lo que mejora la capacidad de respuesta y evita bloqueos en la escucha de nuevas conexiones. :contentReference[oaicite:2]{index=2}

### 🌐 Comunicación mediante Sockets

Los **sockets TCP** proporcionan un canal de comunicación bidireccional entre el cliente y el servidor, donde ambos pueden enviar y recibir información a través de flujos de entrada/salida. :contentReference[oaicite:3]{index=3}

---

## 📁 Estructura del Proyecto

PaquetesPSP/
├── src/
│ └── com/arescaballero/reparto/
│ ├── Cliente.java
│ ├── Servidor.java
│ └── (otras clases auxiliares)
├── .gitignore
└── PaqueteriaPrueba.iml


- `Cliente.java`: Lógica de conexión y comunicación cliente-servidor.
- `Servidor.java`: Implementación del servidor multihilo.
- Otras clases: Gestión de paquetes, constantes, utilidades.

---

## 🛠️ Cómo Ejecutar

1. **Compilar la aplicación**  
   Asegúrate de tener instalado JDK compatible (Java 8 o superior).

2. **Ejecutar el servidor**  
   Abre una terminal y ejecuta:
java Servidor

3. **Ejecutar uno o más clientes**  
Abre otra terminal por cliente:
java Cliente


Cada cliente se conectará al servidor y podrá intercambiar mensajes de forma independiente.

---

## 🧪 Consideraciones

- El servidor debe iniciarse antes de ejecutar los clientes.
- Puedes probar múltiples instancias del cliente para verificar que el servidor responde concurrentemente.
- Asegúrate de que el puerto de escucha no esté ocupado por otras aplicaciones.

---

## 🎯 Objetivos de Aprendizaje

Este proyecto permite al alumno:

- Entender cómo funcionan los **sockets TCP** en Java.
- Crear servidores capaces de atender **múltiples clientes en paralelo** usando hilos.
- Gestionar la lectura y escritura en streams de red.
- Aplicar técnicas de concurrencia para evitar bloqueos y asegurar la correcta comunicación.

---

## 📌 Licencia

Este repositorio no especifica licencia. El uso del código debe respetar los derechos de autor del autor original.


