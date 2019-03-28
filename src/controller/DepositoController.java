/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;

/**
 *
 * @author Juan José Ramos
 */
public class DepositoController {
    /*VARIABLES*/

    private ArrayList<Deposito> arrayList = new ArrayList();

    private Deposito[] array = new Deposito[1000];

    Random aleatorio = new Random();

    private DepositoController() {
        arrayList = new ArrayList<>();
    }

    private static DepositoController instance;

    public static DepositoController getInstancia() {
        if (instance == null) {
            instance = new DepositoController();
        }
        return instance;
    }

    public void agregar(int idDepositante, String cuenta, Double monto, String tipoDeposito, Cliente cliente, String otraCuenta, String agencia) {
        System.out.println(agencia);
        Date d = new Date();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = new Deposito(aleatorio.nextInt(900000000 - 100000000 + 1) + 100000000, idDepositante, cuenta, monto, d, tipoDeposito, cliente, agencia);
                break;
            }
        }
        
        AgenciaBancaria a = AgenciaController.getAgenciaController().buscarAgenciaUnica(agencia);
        if (a != null) {
            Double efectivo = a.getEfectivo();
            a.setEfectivo(efectivo + monto);
        }
        
        if (CuentasCliente.getCuentasCliente().getArrayCAClieteUnica(Integer.parseInt(cuenta)) != null) {

            CuentaAhorroCliente c = CuentasCliente.getCuentasCliente().getArrayCAClieteUnica(Integer.parseInt(cuenta));

            Double montoInicial = c.getMontoInicial();

            c.getCuentaAhorro().setMontoInicial(montoInicial + monto);
            c.setMontoInicial(montoInicial + monto);

        } else if (CuentasCliente.getCuentasCliente().getArrayCMClieteUnica(Integer.parseInt(cuenta)) != null) {

            CuentaMonetariaCliente c = CuentasCliente.getCuentasCliente().getArrayCMClieteUnica(Integer.parseInt(cuenta));

            Double montoInicial = c.getMontoInicial();

            c.getCuenta().setMontoInicial(montoInicial + monto);
            c.setMontoInicial(montoInicial + monto);

        }

        if (!otraCuenta.equals("")) {
            if (CuentasCliente.getCuentasCliente().getArrayCMClieteUnica(Integer.parseInt(otraCuenta)) != null) {

                CuentaMonetariaCliente c = CuentasCliente.getCuentasCliente().getArrayCMClieteUnica(Integer.parseInt(otraCuenta));

                Double montoInicial = c.getMontoInicial();

                c.getCuenta().setMontoInicial(montoInicial - monto);
                c.setMontoInicial(montoInicial - monto);

            }
        }

    }

    public ArrayList<Deposito> getArrayList(int idCliente) {
        this.arrayList.clear();
        Deposito[] d = new Deposito[1000];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].getIdDepositante() == idCliente) {
                    for (int j = 0; j < d.length; j++) {
                        if (d[j] == null) {
                            d[j] = array[i];
                            break;
                        }
                    }
                }
            }
        }
        for (Deposito c : d) {
            if (c != null) {
                arrayList.add(c);
            }
        }

        return arrayList;
    }

    public boolean esNumero(String cadena) {
        boolean resultado;

        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        } catch (InputMismatchException a) {
            resultado = false;
        }

        return resultado;
    }

}
