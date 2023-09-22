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
import com.modisteria.dl.model.Usuario;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Siempre debemos indicar que este archivo es un componente de Spring boot con la siguiente anotación
@Component("usuarios")
public class ReporteUsuariosPDF extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//No generar advertencias
		@SuppressWarnings("unchecked")
		//Variable usuarios de tipo lista con objetos de tipo usuario, el get trae un objeto usuario que es la lista de todos los usuarios
		List<Usuario> usuarios = (List<Usuario>) model.get("usuarios");
		
		//Fuentes y tamaños para cada sección
		Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14);
		Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14);
		Font fuenteDatosCeldas = FontFactory.getFont(FontFactory.HELVETICA,14);
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.open();
		
		PdfPCell celda = null;
		
		//Tabla para el título del pdf
		PdfPTable tablaTitulo = new PdfPTable(1); //Num columnas
		
		celda = new PdfPCell(new Phrase("LISTADO GENERAL DE USUARIOS", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(20);
		
		//Tabla para mostrar el listado de usuarios
		PdfPTable tablaUsuarios = new PdfPTable(6); //Cantidad de columnas en la tabla
		tablaUsuarios.setWidths(new float[] {0.5f,2f,2.5f,2f,2f,2f});
		
		celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("NOMBRE", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("CORREO", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("TELÉFONO", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("CONSTRASEÑA", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("ROL", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(93, 173, 226));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		//Foreach para mostrar los datos de cada usuario
		
		for (Usuario usuario : usuarios) {
			celda = new PdfPCell(new Phrase((String.valueOf(usuario.getId())), fuenteDatosCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase((usuario.getNombre_completo()), fuenteDatosCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase((usuario.getCorreo()), fuenteDatosCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase((usuario.getTelefono()), fuenteDatosCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase((usuario.getPassword()), fuenteDatosCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase((usuario.getRol().getNombre()), fuenteDatosCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
		}
		/*
		usuarios.forEach(usuario -> {
			tablaUsuarios.addCell(String.valueOf(usuario.getId()));
			tablaUsuarios.addCell(usuario.getNombre_completo());
			tablaUsuarios.addCell(usuario.getCorreo());
			tablaUsuarios.addCell(usuario.getTelefono());
			//tablaCitas.addCell(cita.getTalla());
			tablaUsuarios.addCell(usuario.getPassword()); //Aqui como está conectado a la tabla usuarios deberia ser: tablaCitas.addCell(cita.getUsuario().getUsuario()); el primer get es de citas y el segundo es de usuarios
			tablaUsuarios.addCell(usuario.getRol().getNombre()); //el primer get es de citas y el segundo es de estado
		});
			});*/
		
		
		//Anexamos las tablas al documento
		document.add(tablaTitulo);
		document.add(tablaUsuarios);
		document.close();

	}
	
}
