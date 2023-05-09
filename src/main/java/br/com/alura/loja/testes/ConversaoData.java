package br.com.alura.loja.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConversaoData {

	public static final Locale DEFAULT_LOCALE = new Locale("pt", "BR");
	private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

	public static void main(String[] args) {

		Date dataCessacaoBeneficio = null;
		dataCessacaoBeneficio = formatarData("2018-11-04T01:00:00-02:00", DATE_PATTERN);
		System.out.println("DATA : " + dataCessacaoBeneficio);
	}

	public static Date criarData(String data, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, new Locale("pt", "BR"));
		sdf.setLenient(false);
		return sdf.parse(data);
	}

	private static Date formatarData(String dt, String pattern) {
		Date data = null;
		try {
			if (dt != null) {
				data = criarData(dt, pattern);
			}
		} catch (ParseException e) {
			throw new IllegalArgumentException("Erro na Conversão do Parâmetro. " + e.getMessage());
		}
		return data;
	}

}
