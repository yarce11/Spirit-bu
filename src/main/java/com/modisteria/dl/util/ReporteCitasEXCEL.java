package com.modisteria.dl.util;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.modisteria.dl.model.Citas;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//Siempre debemos indicar que este archivo es un componente de Spring boot con la siguiente anotación
@Component("form.xlsx") //No puede tener la misma ruta que en el reporte de pdf entonces debemos adicionar el formto en el que vamos a trabajar ahora que es .xlsx
public class ReporteCitasEXCEL extends AbstractXlsxView {
	@Override
	//Este método contiene todos los argumentos necesarios para crear un documento de excel
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment; filename=\"listado-citas.xlsx\"");
		Sheet hoja = workbook.createSheet("Citas");
		
		
		Row filaTitulo = hoja.createRow(0); //Dento del paréntesis va el indice de la fila donde coloco la información
		Cell celda = filaTitulo.createCell(0); //Como iniciamos desde la columna A en excel el indice es 0
		celda.setCellValue("LISTADO GENERAL DE CITAS");
		
		Row filaData = hoja.createRow(2);
		
		//Creamos un arreglo para indicar los titulos de cada columna
		String[] columnas = {"ID", "FECHA", "OBJETIVO", "IMAGEN", "USUARIO", "ESTADO"};
		
		//Creamos un bucle for para que aparezcan los titulos guardados en el arreglo
		for (int i = 0; i < columnas.length; i++) {
			celda = filaData.createCell(i);
			celda.setCellValue(columnas[i]);
		}
		
		//Creamos la lista para empezar el proceso de traer la información de las citas
		List<Citas> listaCitas = (List<Citas>) model.get("citas");
		
		//Creamos un foreach para recorrer cada registro
		int numFila = 3; //Indice de la fila en la que vamos a empezar a poner los datos de las citas
		for (Citas citas : listaCitas) {
			filaData = hoja.createRow(numFila);
			
			filaData.createCell(0).setCellValue(citas.getId());
			filaData.createCell(1).setCellValue(citas.getFecha().toString());
			filaData.createCell(2).setCellValue(citas.getObjetivo());
			filaData.createCell(3).setCellValue(citas.getImagen());
			filaData.createCell(4).setCellValue(citas.getNombre_usuario());
			filaData.createCell(5).setCellValue(citas.getEstado().getNombre_estado());
			
			numFila ++;
		}
		
	}
}
