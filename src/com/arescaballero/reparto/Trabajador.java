package com.arescaballero.reparto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trabajador implements Runnable{
    private final Camion camion;
    final ArrayList<String> PRODUCTOS = new ArrayList<>(List.of("Pan", "Huevos", "Pescado", "Verduras", "Leche", "Cereales", "Maquillaje", "Lejía", "Ibuprofenos", "Jack Daniels", "Cerveza"));


    public Trabajador(Camion camion) {
        this.camion = camion;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Error con el trabajador que se duerme: " + e.getMessage());
            }
            Caja caja = new Caja(camion.generarId(), PRODUCTOS.get(new Random().nextInt(PRODUCTOS.size())));
            camion.cargar(caja);
            System.out.println("Cargamos " + caja);
        }
        System.out.println("Trabajador "+ Thread.currentThread().threadId() + "ha acabado");
    }
}
