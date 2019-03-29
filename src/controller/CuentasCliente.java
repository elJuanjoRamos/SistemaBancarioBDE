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
import java.util.Random;

/**
 *
 * @author Juan José Ramos
 */
public class CuentasCliente {

    private static final CuentasCliente CuentasCliente = new CuentasCliente();

    /*Instancias*/
    Random aleatorio = new Random();

    /*variables*/
    private CuentaAhorro[] cuentaAhorro = new CuentaAhorro[1000];
    private CuentaMonetaria[] cuentaMonetaria = new CuentaMonetaria[1000];
    private CuentaAhorroCliente[] cuentaAhorroCliente = new CuentaAhorroCliente[1000];
    private CuentaMonetariaCliente[] cuentaMonetariaCliente = new CuentaMonetariaCliente[1000];

    private ArrayList<CuentaAhorro> arrayListCuentaAhorro = new ArrayList();
    private ArrayList<CuentaMonetaria> arrayListCuentaMonetaria = new ArrayList();
    private ArrayList<CuentaAhorroCliente> arrayListCuentaAhorroCliente = new ArrayList();
    private ArrayList<CuentaMonetariaCliente> arrayListCuentaMonetariaCliente = new ArrayList();

    public int noCuentaMonetaria;
    public int noCuentaAhorro;
    
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date d = new Date();
        
    
    

    private CuentasCliente() {
        arrayListCuentaAhorro = new ArrayList();
        arrayListCuentaMonetaria = new ArrayList();
        arrayListCuentaAhorroCliente = new ArrayList();
        arrayListCuentaMonetariaCliente = new ArrayList();
    }

    /*SINGLETON*/
    private static CuentasCliente instance;

    public static CuentasCliente getCuentasCliente() {
        if (instance == null) {
            instance = new CuentasCliente();
        }
        return instance;
    }
    ////////////////

    /*-------------------CUENTA DE AHORRO--------------*/
    public void agregarCuentaAhorro(Double montoInicial) {
        this.noCuentaAhorro = aleatorio.nextInt(900000000 - 100000000 + 1) + 100000000;
        for (int i = 0; i < cuentaAhorro.length; i++) {
            if (cuentaAhorro[i] == null) {
                cuentaAhorro[i] = new CuentaAhorro(noCuentaAhorro, d, montoInicial);
                break;
            }
        }
    }

    public CuentaAhorro buscarCuentaAhorros(int id) {
        CuentaAhorro t = new CuentaAhorro();
        t = null;
        for (int i = 0; i < cuentaAhorro.length; i++) {
            if (cuentaAhorro[i] != null) {
                if (cuentaAhorro[i].getId() == id) {
                    t = cuentaAhorro[i];
                    break;
                }
            }
        }
        return t;
    }

    public ArrayList<CuentaAhorroCliente> getArrayCACliete(int idCliente) {
        this.arrayListCuentaAhorroCliente.clear();
        
        for (CuentaAhorroCliente c : cuentaAhorroCliente) {
            if (c!= null) {
                if (c.getCliente().getId() == idCliente) {
                    arrayListCuentaAhorroCliente.add(c);                
                }
            }
        }
        return arrayListCuentaAhorroCliente;
    }

    
    public CuentaAhorroCliente[] obtenerCuentaAhorro(int idCliente) {
        
        CuentaAhorroCliente[] ca = new CuentaAhorroCliente[1000];
        
        ca = null;
        for (CuentaAhorroCliente c : cuentaAhorroCliente) {
            if (c!= null) {
                
                if (c.getCliente().getId() == idCliente) {
                    for (int i = 0; i < ca.length; i++) {
                        if (ca[i] == null) {
                            ca[i] = c;
                            break;
                        }
                    }
                }
            }
        }
        return ca;
    }

    
   /*OBTIENE SOLO LOS ID DE LAS CUENTAS DE AHORRO DE UN CLIENTE*/
    public ArrayList<String> getArrayNoCACliete(int idCliente) {
        String[] result = new String[1000];
        ArrayList<String> arrayCuentaAhorro = new ArrayList();

        for (int i = 0; i < this.cuentaAhorroCliente.length; i++) {
            if (cuentaAhorroCliente[i] != null) {
                if (cuentaAhorroCliente[i].getCliente().getId() == idCliente) {

                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == null) {
                            result[j] = String.valueOf(cuentaAhorroCliente[i].getCuentaAhorro().getId());
                            break;
                        }
                    }
                }
            }
        }
        arrayCuentaAhorro.clear();
        for (String c : result) {
            if (c != null) {
                arrayCuentaAhorro.add(c);
            }
        }
        return arrayCuentaAhorro;
    }
    
    
    
    /*BUSCA UNA UNICA CUENTA*/
    public CuentaAhorroCliente getArrayCAClieteUnica(int idCuenta) {
        for (CuentaAhorroCliente a : cuentaAhorroCliente) {
            if (a != null) {
                if (a.getIdCuenta()== idCuenta) {
                    return a;
                }
            }
        }
        return null;
    }

    /*----------------CUENTA MONETARIA---------------*/
    
    /*AGREGAR*/
    public void agregarCuentaMonetaria(Double montoInicial) {
        this.noCuentaMonetaria = aleatorio.nextInt(900000000 - 100000000 + 1) + 100000000;
        for (int i = 0; i < cuentaMonetaria.length; i++) {
            if (cuentaMonetaria[i] == null) {
                cuentaMonetaria[i] = new CuentaMonetaria(noCuentaMonetaria, d, montoInicial);
                break;
            }
        }
    }

    /*BUSCAR UNICA*/
    public CuentaMonetaria buscarCuentaMonetaria(int id) {
        CuentaMonetaria t = new CuentaMonetaria();
        t = null;
        for (int i = 0; i < cuentaMonetaria.length; i++) {
            if (cuentaMonetaria[i] != null) {
                if (cuentaMonetaria[i].getId() == id) {
                    t = cuentaMonetaria[i];
                    break;
                }
            }
        }
        return t;
    }

    /*MOSTRAR*/
    public ArrayList<CuentaMonetariaCliente> getArrayCMCliete(int idCliente) {
        this.arrayListCuentaMonetariaCliente.clear();
        
        
        for (CuentaMonetariaCliente c : cuentaMonetariaCliente) {
            if (c != null) {
                if (c.getCliente().getId() == idCliente) {
                    arrayListCuentaMonetariaCliente.add(c);
                }
            }
        }
        return arrayListCuentaMonetariaCliente;
    }
    
    /*BUSCA UNA UNICA CUENTA MONETARIA*/
    public CuentaMonetariaCliente getArrayCMClieteUnica(int idCuenta) {
        for (CuentaMonetariaCliente a : cuentaMonetariaCliente) {
            if (a != null) {
                if (a.getIdCuenta()== idCuenta) {
                    return a;
                }
            }
        }
        return null;
    }

    /*MOSTRAR UNICAMENTE LOS IDS*/
    public ArrayList<String> getArrayNoCMCliete(int idCliente) {
        String[] result = new String[10];

        for (int i = 0; i < this.cuentaMonetariaCliente.length; i++) {
            if (cuentaMonetariaCliente[i] != null) {
                if (cuentaMonetariaCliente[i].getCliente().getId() == idCliente) {

                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == null) {
                            result[j] = String.valueOf(cuentaMonetariaCliente[i].getCuenta().getId());
                            break;
                        }
                    }
                }
            }
        }
        ArrayList<String> arrayCuentaMonetaria = new ArrayList();
        arrayCuentaMonetaria.clear();
        for (String c : result) {
            if (c != null) {
                arrayCuentaMonetaria.add(c);
            }
        }
        return arrayCuentaMonetaria;
    }
    
    
    public CuentaMonetariaCliente[] obtenerCuentaMonetaria(int idCliente) {
        
        CuentaMonetariaCliente[] cm = new CuentaMonetariaCliente[100]; 
        cm=null;
        for (CuentaMonetariaCliente c : cuentaMonetariaCliente) {
            if (c != null) {
                if (c.getCliente().getId() == idCliente) {
                    for (int i = 0; i < cm.length; i++) {
                        if (cm[i] == null) {
                            cm[i] = c;
                            break;
                            
                        }
                    }
                }
            }
        }
        
        
        
        return cm;
    }
    
    
    
    
    
    
    
    
    

    /*----------------CUENTA MONETARIA CLIENTE-------------------*/
    public void agregarCuentaMonetariaCliente(int idCliente) {
        for (int i = 0; i < cuentaMonetariaCliente.length; i++) {
            if (cuentaMonetariaCliente[i] == null) {
                cuentaMonetariaCliente[i] = new CuentaMonetariaCliente(i, ClienteController.getClienteController().buscar(idCliente), buscarCuentaMonetaria(this.noCuentaMonetaria));
                break;
            }
        }
    }

    public void agregarCuentaAhorroCliente(int idCliente) {
        for (int i = 0; i < cuentaAhorroCliente.length; i++) {
            if (cuentaAhorroCliente[i] == null) {
                cuentaAhorroCliente[i] = new CuentaAhorroCliente(i, ClienteController.getClienteController().buscar(idCliente), buscarCuentaAhorros(this.noCuentaAhorro));
                break;
            }
        }
    }

    /*OBENTER TODAS LAS CUENTAS DE UN CLIENTE */
    public ArrayList<String> getArrayCuentasCliete(int idCliente) {
        String[] result = new String[10];
        ArrayList<String> arrayCuentaMonetaria = new ArrayList();
        arrayCuentaMonetaria.clear();

        for (int i = 0; i < this.cuentaMonetariaCliente.length; i++) {
            if (cuentaMonetariaCliente[i] != null) {
                if (cuentaMonetariaCliente[i].getCliente().getId() == idCliente) {

                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == null) {
                            result[j] = String.valueOf(cuentaMonetariaCliente[i].getCuenta().getId());
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < this.cuentaAhorroCliente.length; i++) {
            if (cuentaAhorroCliente[i] != null) {
                if (cuentaAhorroCliente[i].getCliente().getId() == idCliente) {

                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == null) {
                            result[j] = String.valueOf(cuentaAhorroCliente[i].getCuentaAhorro().getId());
                            break;
                        }
                    }
                }
            }
        }

        for (String c : result) {
            if (c != null) {
                arrayCuentaMonetaria.add(c);
            }
        }
        return arrayCuentaMonetaria;
    }

}
