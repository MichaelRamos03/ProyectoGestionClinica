/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;


public class PaginaItext {

    public static final Font CHAPTER_FONT = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    public static final Font PARAGRAPH_FONT = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
    public static final Font CATEGORY_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    public static final Font SUB_CATEGORY_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    public static final Font BLUE_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLUE);
    public static final Font SMALL_BOLD = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    public static final Font SMALL_COURIER = new Font(Font.FontFamily.COURIER, 9, Font.NORMAL);
    public static final Font SMALL_FONT = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);
    private Chapter chapter;

    public PaginaItext() {
        // chapter = new Chapter(1);
        chapter = new Chapter(new Paragraph(Chunk.NEWLINE),0);
        chapter.setNumberDepth(0);
    }

    public void addCapitulo(String titulo, Font font, BaseColor background) {
        Chunk chunk = new Chunk(titulo, font);
        chunk.setBackground(background);
        chapter.add(new Paragraph(chunk));
        chapter.setNumberDepth(0);
    }

    public void addCampo(String label, String dato) {
        chapter.add(new Paragraph(label + ": " + dato));
        chapter.add(Chunk.NEWLINE);
    }

    public void addParrafo(String parrafo) {
        Paragraph texto = new Paragraph(parrafo); // aquí se puede agregar todo el texto 
        texto.setAlignment(Element.ALIGN_JUSTIFIED);
        chapter.add(texto);
        chapter.add(Chunk.NEWLINE);

    }

    public void addTablaModel(DefaultTableModel modelo, BaseColor bgTitulo) {

        PdfPTable tabla = new PdfPTable(modelo.getColumnCount());
        tabla.setWidthPercentage(100);
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            PdfPCell colum = new PdfPCell(new Phrase(modelo.getColumnName(i)));
            colum.setBackgroundColor(bgTitulo);
            tabla.addCell(colum);
        }
        for (int f = 0; f < modelo.getRowCount(); f++) {
            for (int c = 0; c < modelo.getColumnCount(); c++) {
                Phrase formato = new Phrase(modelo.getValueAt(f, c).toString(), SMALL_FONT);
                tabla.addCell(formato);
            }

        }

        chapter.add(tabla);
        chapter.add(Chunk.NEWLINE);

    }

    public void addFecha(String fecha) {

        Paragraph pFecha = new Paragraph(fecha);
        pFecha.setAlignment(Element.ALIGN_RIGHT);
        chapter.add(pFecha);

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

    public void addImg(String rutaImg, int ancho, int alto, int align) {
        Image image = null;
        try {
            image = Image.getInstance(getClass().getResource(rutaImg));//carga imagen
            image.scaleAbsolute(ancho, alto);//cambia tamaño           
            image.setAlignment(align);
            chapter.add(image);//agrega la imagen a la página
        } catch (Exception e) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error",
                    "Error con la imagen", DesktopNotify.ERROR, 4000);
        }
    }

    public void addSeparadorLinea() {
        DottedLineSeparator dottedline = new DottedLineSeparator();
       // dottedline.setOffset(-2);
       // dottedline.setGap(2f);
        Paragraph paragraphE = new Paragraph();
        paragraphE.add(dottedline);
        chapter.addSection(paragraphE);
    }
 public void addTitle(String titulo, Font font, BaseColor background) {
        Chunk chunk = new Chunk(titulo, font);
        chunk.setBackground(background);
        chapter.add(new Paragraph(chunk));       
    }
    public Chapter getChapter() {
        return chapter;
    }

}
