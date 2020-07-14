package br.com.ximenes.simpleproject.converter;

import java.math.BigDecimal;

import javax.enterprise.inject.Specializes;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.BigDecimalConverter;

@SuppressWarnings("deprecation")
@Specializes
@Convert(BigDecimal.class)
public class MyBigDecimalConverter extends BigDecimalConverter{

	@Override
	public BigDecimal convert(String arg0, Class<? extends BigDecimal> arg1) {
		if(arg0 == null || arg0.isEmpty())
			return null;
		
		
		return new BigDecimal(arg0.replace(",", "."));
	}
}