package br.com.alura.loja.testes;

import java.awt.Robot;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class teste {

	public static void main(String[] args) {

		
		int tempoMovimento = 60;
		int tempoTotal = 180;
		int i =0;
		
		while (i<=tempoTotal) {
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
		
		//System.out.println(func(1));
		 //opBinario();

	}
	
	public static void opBinario(){
		/*int[] a = new int[3];
		a[0] =1;
		a[1] =10;
		a[2] = 101;
				
		for (int i = 0; i <= 2; i++) {
			//System.out.println(a[i]);
			System.out.println(a[i] >> 3);
		}*/
		
		int p = 4>>2 ;
		System.out.println(p);
			
		
	}
	
	public static int func(int n) {
		if (n==4)
			return n;
		else
			return 2 *func(n+1);
	}

}
