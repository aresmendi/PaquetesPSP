package com.arescaballero.reparto;

import java.util.ArrayList;
import java.util.List;

public class Camion {
    List<Caja> cajas = new ArrayList<>();
    int idCaja = 0;
    final int CAPACIDAD = 10;
    boolean terminado = false;

    public synchronized void cargar(Caja caja) {
        while (cajas.size() == CAPACIDAD) {
            try {
                wait();
                System.out.println("Camión lleno, esperando descarga");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        cajas.add(caja);
        notifyAll();
    }
    public synchronized Caja descargar() {
        while (cajas.isEmpty() && (!terminado)) {
            try {
                wait();
                System.out.println("Camión vacío, esperando carga");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (cajas.isEmpty() && terminado) {
            return  null;
        }
        Caja caja = cajas.removeFirst();
        notifyAll();
        return caja;
    }
    public synchronized int generarId() {
        idCaja++;
        return idCaja;
    }
    public synchronized void terminar() {
        terminado = true;
        notifyAll();
    }
}
