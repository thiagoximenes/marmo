package br.com.ximenes.simpleproject.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.DateConverter;

@SuppressWarnings("deprecation")
@Specializes
@Convert(Date.class)
@ApplicationScoped
public class DataConverter extends DateConverter {
	
	@Override
	public Date convert(String arg0, Class<? extends Date> type) {
		
		if (arg0 == null || arg0.isEmpty())
			return null;
		
		try {
			if (arg0.length() == 5)
				return new SimpleDateFormat("HH:mm").parse(arg0);
			if (arg0.length() == 10)
				return new SimpleDateFormat("dd/MM/yyyy").parse(arg0);
			return new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(arg0);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

