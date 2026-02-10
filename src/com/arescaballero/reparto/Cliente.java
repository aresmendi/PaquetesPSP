package com.arescaballero.reparto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
    static void main(String[] args) {
        try (Socket sc = new Socket("localhost", 12345)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al conectar con el servidor: " + e.getMessage());
        }
    }
}
