package com.modisteria.dl.util;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.modisteria.dl.model.Usuario;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//Siempre debemos indicar que este archivo es un componente de Spring boot con la siguiente anotación
@Component("usuarios.xlsx") //No puede tener la misma ruta que en el reporte de pdf entonces debemos adicionar el formto en el que vamos a trabajar ahora que es .xlsx
public class ReporteUsuariosEXCEL extends AbstractXlsxView {
	@Override
	//Este método contiene todos los argumentos necesarios para crear un documento de excel
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment; filename=\"listado-usuarios.xlsx\"");
		Sheet hoja = workbook.createSheet("Usuarios");
		
		
		Row filaTitulo = hoja.createRow(0); //Dento del paréntesis va el indice de la fila donde coloco la información
		Cell celda = filaTitulo.createCell(0); //Como iniciamos desde la columna A en excel el indice es 0
		celda.setCellValue("LISTADO GENERAL DE USUARIOS");
		
		Row filaData = hoja.createRow(2);
		
		//Creamos un arreglo para indicar los titulos de cada columna
		String[] columnas = {"ID", "NOMBRE", "CORREO", "TELÉFONO", "CONSTRASEÑA", "ROL"};
		
		//Creamos un bucle for para que aparezcan los titulos guardados en el arreglo
		for (int i = 0; i < columnas.length; i++) {
			celda = filaData.createCell(i);
			celda.setCellValue(columnas[i]);
		}
		
		//Creamos la lista para empezar el proceso de traer la información de los usuarios
		List<Usuario> listaUsuarios = (List<Usuario>) model.get("usuarios");
		
		//Creamos un foreach para recorrer cada registro
		int numFila = 3; //Indice de la fila en la que vamos a empezar a poner los datos de los usuarios
		for (Usuario usuario : listaUsuarios) {
			filaData = hoja.createRow(numFila);
			
			filaData.createCell(0).setCellValue((String.valueOf(usuario.getId())));
			filaData.createCell(1).setCellValue(usuario.getNombre_completo());
			filaData.createCell(2).setCellValue(usuario.getCorreo());
			filaData.createCell(3).setCellValue(usuario.getTelefono());
			filaData.createCell(4).setCellValue(usuario.getPassword());
			filaData.createCell(5).setCellValue(usuario.getRol().getNombre());
			
			numFila ++;
		}
		
	}
}
