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
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.open();
		
		PdfPTable tablaTitulo = new PdfPTable(1);
		PdfPCell celda = null;
		Font fuenteTitulo = FontFactory.getFont("Helvetica", 14);
		
		celda = new PdfPCell(new Phrase("LISTADO GENERAL DE CITAS", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(28, 164, 232));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(20);
		
		PdfPTable tablaCitas = new PdfPTable(6); //Cantidad de columnas en la tabla
		
		
		citas.forEach(cita -> {
			tablaCitas.addCell(String.valueOf(cita.getId()));
			tablaCitas.addCell(cita.getFecha().toString());
			tablaCitas.addCell(cita.getObjetivo());
			tablaCitas.addCell(cita.getImagen());
			//tablaCitas.addCell(cita.getTalla());
			tablaCitas.addCell(cita.getNombre_usuario()); //Aqui como está conectado a la tabla usuarios deberia ser: tablaCitas.addCell(cita.getUsuario().getUsuario()); el primer get es de citas y el segundo es de usuarios
			tablaCitas.addCell(cita.getEstado().getNombre_estado()); //el primer get es de citas y el segundo es de estado
		});
		
		document.add(tablaTitulo);
		document.add(tablaCitas);
		document.close();

	}

}
