package br.com.alura.loja.testes;

import java.awt.Robot;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class teste {

	public static final Locale DEFAULT_LOCALE = new Locale("pt", "BR");
	private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

	public static void main(String[] args) {

		
		
		  /*Date dataCessacaoBeneficio = null;
		  
		  //dataCessacaoBeneficio = formatarData("2017-10-19T00:00:00-02:00", DATE_PATTERN);
		  dataCessacaoBeneficio = formatarData("2018-11-04T00:00:00-02:00", DATE_PATTERN);
		  
		  
		  
		  System.out.println("DATA : " + dataCessacaoBeneficio);*/
		
		  

		
		int tempoMovimento = 60;
		int tempoTotal = 120;
		int i = 0;

		while (i <= tempoTotal) {
			try {

				System.out.println("Minuto: " + i);
				Robot screenWin = new Robot();
				TimeUnit.SECONDS.sleep(tempoMovimento);
				screenWin.mouseMove(100 + i, 300 + i);

				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// System.out.println(func(1)); //opBinario();

	}

	public static Date criarData(String data, String pattern) throws ParseException {
		// LOGGER.debug("Criando data no padrão ", pattern, ". Data: ", data);
		if (data == null || pattern == null) {
			throw new IllegalArgumentException("Parâmetro não pode ser nulo");
		}

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

	public static void opBinario() {
		/*
		 * int[] a = new int[3]; a[0] =1; a[1] =10; a[2] = 101;
		 * 
		 * for (int i = 0; i <= 2; i++) { //System.out.println(a[i]);
		 * System.out.println(a[i] >> 3); }
		 */

		int p = 4 >> 2;
		System.out.println(p);

	}

	public static int func(int n) {
		if (n == 4)
			return n;
		else
			return 2 * func(n + 1);
	}

}
