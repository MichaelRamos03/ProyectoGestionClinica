package Utilidades;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;



public class PdfItext<E> {

    private String nombre;
    private String fecha;
    private String rutaImagen;
    private String datoTitulo;
    private Document documento;
    private FileOutputStream archivo;
    private Paragraph titulo;
    private Chapter chapter;

    public PdfItext(String nombre) {
        this.nombre = nombre;
        documento = new Document();
    }

    public void crearPDF() {
        try {
            archivo = new FileOutputStream(nombre + ".pdf");
            PdfWriter.getInstance(documento, archivo);
            documento.open();

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (DocumentException e) {
            System.err.println(e.getMessage());
        }

    }

    public void addPage(Chapter chapter) {
        try {
            //this.chapter = chapter;
            documento.add(chapter);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfItext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addTitleReport(String datoTitulo) {
        try {
            this.datoTitulo = datoTitulo;
            titulo = new Paragraph(datoTitulo);
            titulo.setAlignment(1);
            documento.add(titulo); // titulo del reporte
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfItext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addField(String label, String dato) {
        try {
            documento.add(new Paragraph(label + ": " + dato));
            documento.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfItext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addParagraph(String parrafo) {
        try {
            Paragraph texto = new Paragraph(parrafo); // aquí se puede agregar todo el texto 
            texto.setAlignment(Element.ALIGN_JUSTIFIED);
            documento.add(texto);
            documento.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfItext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void addPhrase(String txt) {
        try {          
            Phrase texto = new Phrase (txt);// aquí se puede agregar todo el texto 
            documento.add(texto);            
        } catch (DocumentException ex) {
            Logger.getLogger(PdfItext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void addEnter() {
        try {            
            Paragraph texto = new Paragraph(Chunk.NEWLINE); // Agregar un enter en la página 
            texto.setAlignment(Element.ALIGN_JUSTIFIED);
            documento.add(texto);            
        } catch (DocumentException ex) {
            Logger.getLogger(PdfItext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addTablaModel(DefaultTableModel modelo, BaseColor bgTitulo) {

        try {
            PdfPTable tabla = new PdfPTable(modelo.getColumnCount());
            tabla.setWidthPercentage(100);
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                PdfPCell colum = new PdfPCell(new Phrase(modelo.getColumnName(i)));
                colum.setBackgroundColor(bgTitulo);
                tabla.addCell(colum);
            }
            for (int f = 0; f < modelo.getRowCount(); f++) {
                for (int c = 0; c < modelo.getColumnCount(); c++) {
                    Phrase formato = new Phrase(modelo.getValueAt(f, c).toString());
                    tabla.addCell(formato);
                }
                
            }
            
            documento.add(tabla);
            documento.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfItext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addDate(String fecha) {

        try {
            Paragraph pFecha = new Paragraph(fecha);
            pFecha.setAlignment(Element.ALIGN_RIGHT);
            documento.add(pFecha);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfItext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addImg(String rutaImg, int ancho, int alto, int posx) {
        rutaImagen = rutaImg;
        Image image = null;
        try {
            image = Image.getInstance(getClass().getResource(rutaImg));//carga imagen
            image.scaleAbsolute(ancho, alto);//imagecambia tamaño
            // image.setAbsolutePosition(alto, alto);//coloca imagen en la posicion
            image.setAlignment(posx);
            ///imgs/img/
            documento.add(image);//agrega la imagen al documento
        } catch (Exception e) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error",
                    "Error con la imagen", DesktopNotify.ERROR, 4000);
        }
    }
 public void addImg(String rutaImg, int ancho, int alto, int posx, int posy) {

        Image image = null;
        try {
            image = Image.getInstance(getClass().getResource(rutaImg));//carga imagen
            image.scaleAbsolute(ancho, alto);//imagecambia tamaño
            image.setAbsolutePosition(posx, posy);//coloca imagen en la posicion
          
            chapter.add(image);//agrega la imagen a la página
        } catch (Exception e) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error",
                    "Error con la imagen", DesktopNotify.ERROR, 4000);
        }
    }
   
    public void metaData() {
        documento.addTitle("Trabajando con informes");
        documento.addSubject("Librería utilizada --> Itext");
        documento.addKeywords("Java, PDF, iText");
        documento.addAuthor("Yancy de Molina");
        documento.addCreator("Por Yancy de Molina");
    }

    public void margin(int izq, int der, int sup, int inf) {
        documento.setMargins(izq, der, sup, inf);
    }
   
   public void separator( BaseColor background) {
        try {
            String cadena="_";
            for (int i = 1; i < 87; i++) {
              cadena=cadena+"_";  
            }
            Chunk chunk = new Chunk(cadena,new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, background));
            documento.add(new Paragraph(chunk));
        } catch (DocumentException ex) {
            Logger.getLogger(PdfItext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void ClosePDF() {
        documento.close();
        DesktopNotify.setDefaultTheme(NotifyTheme.Green);
        DesktopNotify.showDesktopMessage("!!!",
                "El archivo PDF se a creado correctamente!", DesktopNotify.SUCCESS, 4000);
    }

    public String getNombre() {
        return nombre;
    }
}
