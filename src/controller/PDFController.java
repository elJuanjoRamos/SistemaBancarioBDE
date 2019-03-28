/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.io.IOException;
import beans.*;
import controller.*;
import java.util.StringTokenizer;
import javafx.event.EventType;
import javafx.scene.control.Cell;

/**
 *
 * @author Juan José Ramos
 */
public class PDFController {
    
    /*SINGLETON*/
    private static PDFController instance;
    
    public static PDFController getPDFController(){
        if(instance == null){
            instance = new PDFController();
        }
        return instance;
    }
    
    /*RUTAS*/
    
    public static final String ruta = String.valueOf(System.getProperty("user.dir")) + "\\pdf\\'t";
    
    public static final String rutaClientes = ruta.replace("'t", "\\pdfClilentes.pdf");
    
    /*VARIABLES*/
    
     
    public void crearPDFClientes() throws IOException{
        PdfWriter writer = new PdfWriter(rutaClientes);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        
        Table table = new Table(new float[]{2,4,4,4});
        String linea = "id,nombre,direccion,telefono";
        crearContenido(table, linea, true);
        
        
        
        
        document.add(new Paragraph("Reporte de Clientes"));
        document.close();
    }
    
    public void crearContenido(Table table, String linea, boolean l) {
        StringTokenizer token = new StringTokenizer(linea, ",");
        
        while(token.hasMoreTokens()){
            if (l) {
                //table.addHeaderCell(new Cell().add(linea));
            }
        }
            
        
        Cliente[] cliente = ClienteController.getClienteController().getArregloCliente();
        
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] != null) {
                table.addCell("fdsffafds");
                table.addCell(cliente[i].getNombre());
            }
        }
        
        
    }
}
