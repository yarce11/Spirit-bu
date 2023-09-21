package com.modisteria.dl.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.modisteria.dl.model.Citas;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("form")
public class ReporteCitasPDF extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Citas> citas = (List<Citas>) model.get("citas");
		
		//Fuentes, tamaños y colores para cada sección
		Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14);
		Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14);
		Font fuenteDatosCeldas = FontFactory.getFont(FontFactory.HELVETICA,14);
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.open();
		
		PdfPCell celda = null;
		
		//Tabla para el título del pdf
		PdfPTable tablaTitulo = new PdfPTable(1);
		
		celda = new PdfPCell(new Phrase("LISTADO GENERAL DE CITAS", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(20);
		
		//Tabla para mostrar el listado de citas
		PdfPTable tablaCitas = new PdfPTable(6); //Cantidad de columnas en la tabla
		tablaCitas.setWidths(new float[] {0.5f,2f,2.5f,2f,2f,2f});
		
		celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaCitas.addCell(celda);
		
		celda = new PdfPCell(new Phrase("FECHA", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaCitas.addCell(celda);
		
		celda = new PdfPCell(new Phrase("OBJETIVO", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaCitas.addCell(celda);
		
		celda = new PdfPCell(new Phrase("IMAGEN", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaCitas.addCell(celda);
		
		celda = new PdfPCell(new Phrase("USUARIO", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaCitas.addCell(celda);
		
		celda = new PdfPCell(new Phrase("ESTADO", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaCitas.addCell(celda);
		
		//Foreach para mostrar los datos de cada cita
		
		for (Citas cita : citas) {
			celda = new PdfPCell(new Phrase((String.valueOf(cita.getId())), fuenteDatosCeldas));
			celda.setPadding(5);
			tablaCitas.addCell(celda);
			
			celda = new PdfPCell(new Phrase((cita.getFecha().toString()), fuenteDatosCeldas));
			celda.setPadding(5);
			tablaCitas.addCell(celda);
			
			celda = new PdfPCell(new Phrase((cita.getObjetivo()), fuenteDatosCeldas));
			celda.setPadding(5);
			tablaCitas.addCell(celda);
			
			celda = new PdfPCell(new Phrase((cita.getImagen()), fuenteDatosCeldas));
			celda.setPadding(5);
			tablaCitas.addCell(celda);
			
			celda = new PdfPCell(new Phrase((cita.getNombre_usuario()), fuenteDatosCeldas));
			celda.setPadding(5);
			tablaCitas.addCell(celda);
			
			celda = new PdfPCell(new Phrase((cita.getEstado().getNombre_estado()), fuenteDatosCeldas));
			celda.setPadding(5);
			tablaCitas.addCell(celda);
		}
		/*
		citas.forEach(cita -> {
			tablaCitas.addCell(String.valueOf(cita.getId()));
			tablaCitas.addCell(cita.getFecha().toString());
			tablaCitas.addCell(cita.getObjetivo());
			tablaCitas.addCell(cita.getImagen());
			//tablaCitas.addCell(cita.getTalla());
			tablaCitas.addCell(cita.getNombre_usuario()); //Aqui como está conectado a la tabla usuarios deberia ser: tablaCitas.addCell(cita.getUsuario().getUsuario()); el primer get es de citas y el segundo es de usuarios
			tablaCitas.addCell(cita.getEstado().getNombre_estado()); //el primer get es de citas y el segundo es de estado
		});*/
		
		
		//Anexamos las tablas al documento
		document.add(tablaTitulo);
		document.add(tablaCitas);
		document.close();

	}

}
