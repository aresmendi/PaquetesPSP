package com.arescaballero.reparto;

public class Caja {
    int id;
    String nombre;

    public Caja(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return "caja " + id + ". " + nombre;
    }
}
