package com.arescaballero.reparto;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Repartidor implements Runnable {
    Camion camion;
    Socket socket;

    public Repartidor(Camion camion, Socket socket) {
        this.camion = camion;
        this.socket = socket;
    }

    @Override
    public void run() {
        try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){
            while (true) {
                Caja caja = camion.descargar();
                if(caja == null){
                    break;
                }
                String mensaje = "Entregada "+ caja + "-Cliente avisado";
                out.println(mensaje);
            }
            System.out.println("Reparto finalizado");
        } catch (IOException e){
            System.out.println("Error en repartidor: " + e.getMessage());
        }
    }
}
