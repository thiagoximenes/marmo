package br.com.ximenes.simpleproject.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.RequestScoped;


@RequestScoped
public class IndexService {
	
	public String actualDate(String recipeDate) {
		
		int dia = 0;
		int month = 0;
		int year = 0;
		
		
		
			Calendar cal = Calendar.getInstance();
			if (recipeDate != null) {
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(recipeDate);
					cal.setTime(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				month = cal.get(Calendar.MONTH) + 1;
			} else {
				month = cal.get(Calendar.MONTH) + 1;
			}
		
		
		
		
		
		
		
		return recipeDate;
	}
	
	
	public String getMonth(int i) {
		String month = "";
		
		switch (i) {
			case 1:
				month = "Janeiro";
				break;
			case 2:
				month = "Fevereiro";
				break;
			case 3:
				month = "Março";
				break;
			case 4:
				month = "Abril";
				break;
			case 5:
				month = "Maio";
				break;
			case 6:
				month = "Junho";
				break;
			case 7:
				month = "Julho";
				break;
			case 8:
				month = "Agosto";
				break;
			case 9:
				month = "Setembro";
				break;
			case 10:
				month = "Outubro";
				break;
			case 11:
				month = "Novembro";
				break;
			case 12:
				month = "Dezembro";
				break;
	
			default:
				month = "Mês não encontrado.";
				break;
		}
			
		return month;
	}
}
