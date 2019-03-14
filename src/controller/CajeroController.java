/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Cajero;
import java.util.InputMismatchException;

/**
 *
 * @author Juan José Ramos
 */
public class CajeroController {

    private static CajeroController instancia;

    Cajero[] cajero = new Cajero[100];

    public static CajeroController getCajeroControler() {
        if (instancia == null) {
            instancia = new CajeroController();
        }
        return instancia;
    }

    public void agregar(Double efectivo, String ubicacion, String estado) {
        for (int i = 0; i < cajero.length; i++) {
            if (cajero[i] == null) {
                cajero[i] = new Cajero(i, 0, efectivo, ubicacion, estado);

                break;
            }
        }
    }

    public void borrar(int id) {
        for (int i = 0; i < cajero.length; i++) {
            if (cajero[i].getId() == id) {
                cajero[i] = null;
                break;
            }
        }
    }

    public void actualizar(int id, int transacciones, Double efectivo, String ubicacion, String estado) {
        for (int i = 0; i < cajero.length; i++) {
            Cajero c = cajero[id];
            c.setEfectivo(efectivo);
            c.setEstado(estado);
            c.setTransaccion(transacciones);
            c.setUbicacion(ubicacion);
        }
    }

    public Cajero[] buscar(String valor) {
        Cajero[] c = new Cajero[1000];
        for (int i = 0; i < cajero.length; i++) {
            if (cajero[i] != null) {
                if (cajero[i].getUbicacion().toUpperCase().contains(valor.toUpperCase())) {
                    for (int j = 0; j < c.length; j++) {
                        if (c[j] == null) {
                            c[j] = cajero[i];
                            break;
                        }
                    }
                }
            }
        }
        return c;
    }

    public Cajero[] getArray() {
        Cajero[] resultado = new Cajero[1000];
        for (int i = 0; i < cajero.length; i++) {
            if (cajero[i] != null) {
                for (int j = 0; j < resultado.length; j++) {
                    if (resultado[j] == null) {
                        resultado[j] = cajero[i];
                        break;
                    }
                }
            }
        }
        return resultado;
    }

    public void prueba() {

        for (int i = 0; i < cajero.length; i++) {
            if (cajero[i] != null) {
                System.out.println("Ubicacion " + cajero[i].getUbicacion());
                System.out.println("Efectivo " + cajero[i].getEfectivo());
                System.out.println("Transacciones " + cajero[i].getTransaccion());
                System.out.println("Estado " + cajero[i].getEstado());

            }

        }
    }

    public boolean esNumero(String cadena, String cadena2) {
        boolean resultado;

        try {
            Integer.parseInt(cadena);
            Double.parseDouble(cadena2);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        } catch (InputMismatchException a) {
            resultado = false;
        }

        return resultado;
    }

}
