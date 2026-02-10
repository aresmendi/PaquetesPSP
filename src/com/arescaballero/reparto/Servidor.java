package com.arescaballero.reparto;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket socket = new ServerSocket(12345)) {
            //Rellenamos el camión
            Camion camion = new Camion();
            Trabajador t1 = new Trabajador(camion);
            Thread hilo1 = new Thread(t1);
            System.out.println("Trabajador " + hilo1.threadId() + " entra a trabajar");
            Trabajador t2 = new Trabajador(camion);
            Thread hilo2 = new Thread(t2);
            System.out.println("Trabajador " + hilo2.threadId() + " entra a trabajar");
            hilo1.start();
            hilo2.start();
            try {
                hilo1.join();
                hilo2.join();
            } catch (InterruptedException e) {
                System.out.println("Error al trabajar: " + e.getMessage());
            }
            System.out.println("Camión lleno");
            camion.terminar();
            System.out.println("Esperando a cliente");
            //Conectamos con el cliente
            Socket socketCliente = socket.accept();
            System.out.println("Conexión con cliente establecida");
            Repartidor r = new Repartidor(camion, socketCliente);
            Thread hilo3 = new Thread(r);
            System.out.println("Repartidor conectado");
            //Empieza el repartidor
            hilo3.start();
            try {
                hilo3.join();
            } catch (InterruptedException e) {
                System.out.println("Error al repartir: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor: "+e.getMessage());
        }
    }
}
