/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import beans.*;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.property.HorizontalAlignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.StringTokenizer;
import controller.*;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.StringTokenizer;
import javafx.event.EventType;

/**
 *
 * @author Juan José Ramos
 */
public class ReporteController {

    /*SINGLETON*/
    private static ReporteController instance;

    public static ReporteController getReporteController() {
        if (instance == null) {
            instance = new ReporteController();
        }
        return instance;
    }

    /*RUTAS*/
    public String ruta = String.valueOf(System.getProperty("user.dir")) + "\\pdf\\";

    public void CrearPDFClientes() {
        String contenido = "ID" + "'" + "Nombre" + "'" + "Direccion" + "'" + "Telefono" + "\n";
        try {
            Cliente[] clientes = ClienteController.getClienteController().getArregloCliente();

            for (Cliente c : clientes) {
                if (c != null) {
                    int id = c.getId();
                    String nombre = c.getNombre();
                    String direccion = c.getDireccion();
                    String telefono = c.getTelefono();

                    contenido = contenido + id + "'" + nombre + "'" + direccion + "'" + telefono + "\n";;
                }
            }
        } catch (Exception a) {
        }
        String nombrePdf = "pdfClientes.pdf";
        String title = "Clientes Registrados";
        float[] size = {2, 10, 6, 6};
        CrearTH(nombrePdf, contenido, title, size);

    }

    public void CrearPDFEmpleado() {
        String contenido = "ID" + "'" + "Nombre" + "'" + "Direccion" + "'" + "Telefono" + "'" + " Departamento" + "'" + " Agencia" + "\n";
        try {
            Empleado[] empleado = EmpleadoController.getEmpleadoController().obtenerEmpleados();

            for (Empleado c : empleado) {
                if (c != null) {
                    int id = c.getId();
                    String nombre = c.getNombre();
                    String direccion = c.getDireccion();
                    String telefono = c.getTelefono();
                    String departamento = c.getDepartamento();
                    String agencia = c.getIdAgencia();
                    contenido = contenido + id + "'" + nombre + "'" + direccion + "'" + telefono + "'" + departamento + "'" + agencia + "\n";;

                }
            }
        } catch (Exception a) {
        }
        String nombrePdf = "pdfEmpleados.pdf";
        String title = "Empleados Registrados";
        float[] size = {2, 10, 6, 6, 6, 6};
        CrearTH(nombrePdf, contenido, title, size);

    }

    public void CrearPDFAgencias(String cadena) {
        String contenido = "ID" + "'" + "Nombre" + "'" + "Direccion" + "'" + "Telefono" + "'" + "Numero Cajas" + "'" + "Escritorios SC" + "'" + "Efectivo" + "\n";
        double total = 0;
        AgenciaBancaria[] agencias = AgenciaController.getAgenciaController().obtenerAgencias();
        String nombrePdf = "";
        String title = "";
        float[] size = {};

        try {
            for (AgenciaBancaria c : agencias) {
                if (c != null) {
                    if (cadena.equals("NoAuto")) {
                        title = "Agencias Registradas";

                        if (c.getAuto() == 0) {

                            int id = c.getId();
                            String nombre = c.getNombre();
                            String direccion = c.getDireccion();
                            String telefono = c.getTelefono();
                            int noCajas = c.getNoCajas();
                            int escritorios = c.getEscritorios();
                            double efectivo = c.getEfectivo();

                            total = total + efectivo;
                            contenido = contenido + id + "'" + nombre + "'" + direccion + "'" + telefono
                                    + "'" + noCajas + "'" + escritorios + "'" + efectivo + "\n";

                            size = new float[]{2, 10, 6, 6, 3, 3, 3};
                            nombrePdf = "pdfAgenciasSinAutoBanco";
                        }
                    } else if (cadena.equals("Auto")) {
                        title = "Agencias con Autobanco Registradas";

                        if (c.getAuto() != 0) {

                            int id = c.getId();
                            String nombre = c.getNombre();
                            String direccion = c.getDireccion();
                            String telefono = c.getTelefono();
                            int noCajas = c.getNoCajas();
                            int escritorios = c.getEscritorios();
                            double efectivo = c.getEfectivo();

                            total = total + efectivo;
                            contenido = contenido + id + "'" + nombre + "'" + direccion + "'" + telefono
                                    + "'" + noCajas + "'" + escritorios + "'" + efectivo + "\n";

                            size = new float[]{2, 10, 6, 6, 3, 3, 3};
                            nombrePdf = "pdfAgenciasConAutoBanco";
                        }
                    }
                }
            }
        } catch (Exception a) {
        }
        contenido = contenido + "-'-'-'-'-'TOTAL EFECTIVO'" + total + "'";

        CrearTH(nombrePdf, contenido, title, size);

    }

    public void CrearPDFCajeros() {
        String contenido = "ID" + "'" + "Ubicacion" + "'" + "Efectivo" + "'" + "Estado" + "'" + "Transacciones Procesadas" + "\n";

        try {
            Cajero[] cajero = CajeroController.getCajeroControler().obtenerCajeros();

            for (Cajero c : cajero) {
                if (c != null) {
                    int id = c.getId();
                    String ubicacion = c.getUbicacion();
                    Double efectivo = c.getEfectivo();
                    String estado = c.getEstado();
                    int transacciones = c.getTransaccion();

                    contenido = contenido + id + "'" + ubicacion + "'" + efectivo + "'" + estado + "'" + transacciones + "\n";

                }
            }

        } catch (Exception a) {
        }
        String nombrePdf = "pdfCajero.pdf";
        String title = "Cajeros Registrados";
        float[] size = {2, 10, 6, 6, 6};
        CrearTH(nombrePdf, contenido, title, size);

    }

    public void CrearPDFCliente(Cliente cliente) {

        String contenido = "ID" + "'" + "Nombre" + "'" + "Direccion" + "'" + "Telefono" + "'" + "-" + "\n";
        String contenidoTarjeta = "Id Tarjeta" + "'" + "Fecha" + "'" + "Credito" + "'" + "Deuda" + "'" + "-" + "\n";
        String contenidoPrestamo = "Id Prestamo" + "'" + "Fecha" + "'" + "Estado" + "'" + "Ultimo abono" + "'" + "Deuda" + "\n";;
        String contenidoCuentaAhorro = "Id Cuenta Ahorro" + "'" + "Fecha" + "'" + "Credito" + "'" + "-" + "'" + "-" + "\n";
        String contenidoCuentaMonetaria = "Id Cuenta Monetaria" + "'" + "Fecha" + "'" + "Credito" + "'" + "-" + "'" + "-" + "\n";

        Cliente c = ClienteController.getClienteController().buscar(cliente.getId());
        PrestamoCliente[] p = TarjetasYPrestamosCliente.getInstancia().obtenerPrestamos(cliente.getId());
        TarjetaCliente[] t = TarjetasYPrestamosCliente.getInstancia().obtenerTarjetaCliente(cliente.getId());
        CuentaAhorroCliente[] ca = CuentasCliente.getCuentasCliente().obtenerCuentaAhorro(cliente.getId());
        CuentaMonetariaCliente[] cm = CuentasCliente.getCuentasCliente().obtenerCuentaMonetaria(cliente.getId());

        try {
            contenido = contenido + c.getId() + "'" + c.getNombre() + "'" + c.getDireccion() + "'" + c.getTelefono() + "'" + "-" + "\n";

            if (p != null) {
                for (PrestamoCliente pc : p) {
                    if (pc != null) {
                        contenidoPrestamo = contenidoPrestamo + "'" + pc.getCodigo() + "'" + pc.getFechaPrestamo() + "'" + pc.getEstado() + "'" + pc.getAbono() + "'" + pc.getDeuda() + "'" + "\n";
                    }

                }
            } else {
                contenidoPrestamo = contenidoPrestamo + "'" + "-" + "'" + "-" + "'" + "-" + "'" + "-" + "'" + "-" + "'" + "\n";
            }

            if (t != null) {
                for (TarjetaCliente tc : t) {
                    if (tc != null) {
                        contenidoTarjeta = contenidoTarjeta + tc.getNumero() + "'" + tc.getFechaVencimiento() + "'" + tc.getCredito() + "'" + tc.getDeuda() + "'" + "-" + "\n";
                    }
                }

            } else {
                contenidoTarjeta = contenidoTarjeta + "'" + "-" + "'" + "-" + "'" + "-" + "'" + "-" + "'" + "-" + "'" + "\n";
            }

            if (cm != null) {
                for (CuentaMonetariaCliente cm1 : cm) {
                    if (cm1 != null) {
                        contenidoCuentaMonetaria = contenidoCuentaMonetaria + cm1.getIdCuenta() + "'" + cm1.getFechaApertura() + "'" + cm1.getMontoInicial() + "'" + "-" + "'" + "-" + "\n";

                    }
                }
            } else {
                contenidoCuentaMonetaria = contenidoCuentaMonetaria + "'" + "-" + "'" + "-" + "'" + "-" + "'" + "-" + "'" + "-" + "'" + "\n";

            }

            if (ca != null) {
                for (CuentaAhorroCliente cm1 : ca) {
                    if (cm1 != null) {
                        contenidoCuentaAhorro = contenidoCuentaAhorro + cm1.getIdCuenta() + "'" + cm1.getFechaApertura() + "'" + cm1.getMontoInicial() + "'" + "-" + "'" + "-" + "\n";

                    }
                }
            } else {
                contenidoCuentaAhorro = contenidoCuentaAhorro + "'" + "-" + "'" + "-" + "'" + "-" + "'" + "-" + "'" + "-" + "'" + "\n";

            }

        } catch (Exception a) {
        }
        //
        String todo = contenido + "\n" + contenidoPrestamo + "\n" + contenidoTarjeta + "\n" + contenidoCuentaAhorro + "\n" + contenidoCuentaMonetaria;
        String nombrePdf = "pdfClienteUnico.pdf";
        String title = "Detalles del cliente";
        float[] size = {2, 10, 6, 6, 6};
        CrearTH(nombrePdf, todo, title, size);

    }

    //////////////CREAR PDF////////////////////////////////////
    public void CrearTH(String nombre, String contenido, String title, float[] size) {
        ruta = ruta + nombre;
        try {
            new ReporteController().crearTah(ruta, contenido, title, size);
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + ruta);
                ruta = String.valueOf(System.getProperty("user.dir")) + "\\pdf\\";
            } catch (IOException b) {
                b.printStackTrace();
            }
        } catch (IOException a) {
            a.printStackTrace();
        }
    }

    private void crearTah(String dest, String contenido, String title, float[] size) throws IOException {
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf, PageSize.A4.rotate());
        doc.setMargins(100, 50, 50, 50);

        Paragraph header = new Paragraph("Banco del Exterior");
        Paragraph titulo = new Paragraph(title);
        Table tabla = new Table(size);
        titulo.setFontSize(22f);
        titulo.setBold();

        header.setFixedPosition(700, 550, 150);
        titulo.setFixedPosition(320, 525, 300);

        BufferedReader br = new BufferedReader(new StringReader(contenido));
        String datos = br.readLine();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                try {
                    tabla.getCell(i, j).setBorder(Border.NO_BORDER);
                } catch (Exception a) {
                }

            }
        }

        crearTabla(datos, tabla, true);

        while ((datos = br.readLine()) != null) {
            crearTabla(datos, tabla, false);
        }

        tabla.getHeader().setBold();
        tabla.setWidth(725);

        doc.add(tabla);
        doc.add(titulo);
        doc.add(header);
        doc.close();

    }

    public void crearTabla(String datos, Table tabla, boolean header) {
        StringTokenizer tk = new StringTokenizer(datos, "'");

        while (tk.hasMoreTokens()) {
            if (header) {
                tabla.addHeaderCell(new Cell().add(new Paragraph(tk.nextToken())));
            } else {
                tabla.addCell(new Cell().add(new Paragraph(tk.nextToken())));
            }
        }

    }

    public void Top(String nombre, String contenido, String title, float[] size) {
        ruta = ruta + nombre;
        try {
            new ReporteController().crearTop(ruta, contenido, title, size);
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + ruta);
                ruta = String.valueOf(System.getProperty("user.dir")) + "\\pdf\\";
            } catch (IOException b) {
                b.printStackTrace();
            }
        } catch (IOException a) {
            a.printStackTrace();
        }
    }

    public void crearTop(String dest, String contenido, String title, float[] size) throws IOException {
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);
        doc.setMargins(100, 50, 50, 50);

        Paragraph header = new Paragraph("Banco del Exterior");
        Paragraph titulo = new Paragraph(title);
        Table tabla = new Table(size);

        titulo.setFontSize(22f);
        titulo.setBold();
        header.setFixedPosition(500, 750, 150);
        titulo.setFixedPosition(250, 725, 300);

        BufferedReader br = new BufferedReader(new StringReader(contenido));
        String datos = br.readLine();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                try {
                    tabla.getCell(i, j).setBorder(Border.NO_BORDER);
                } catch (Exception a) {
                }

            }
        }

        crearTabla(datos, tabla, true);

        while ((datos = br.readLine()) != null) {
            crearTabla(datos, tabla, false);
        }

        tabla.getHeader().setBold();
        tabla.setWidth(425);

        doc.add(tabla);
        doc.add(titulo);
        doc.add(header);
        doc.close();
    }

}
