package Presentacio;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Arbre.AcbRecorrible;
import Arbre.ArbreException;


public class exercici {
	public static void main(String[] args) throws ArbreException {
		String arrel = System.getProperty("user.dir");
		String cami = arrel +"/src/";
		Scanner sc = new Scanner(System.in);
		boolean correcte = false;
		System.out.println("Introdueix el nom de l'arxiu:");
		String c = cami + sc.nextLine()+ ".txt";
		File arxi = new File(c);
		while (!correcte) {
			if (!arxi.exists()) {
				System.out.println("Nom incorrecte!");
				System.out.println("Introdueix el nom de l'arxiu:");
				c = cami + sc.nextLine()+ ".txt";
				arxi = new File(c);
			}
			else correcte = true;
		}
			
		System.out.println();
		String text = llegirText(c);
		
		AcbRecorrible<String> arbre = new AcbRecorrible<String>(AcbRecorrible.ORDRE_ASCENDENT);	
		AcbRecorrible<String> arbre2 = new AcbRecorrible<String>(AcbRecorrible.ORDRE_DESCENDENT);
		String paraula = null;
	    String[] separat = text.split("([\\s!?\"',;:.]+)");
	    for (int i = 0; i <separat.length;++i) {
	    	 paraula = separat[i];
	         if(paraula.length()>=10){
	        	 try {
						arbre.inserir(paraula.toUpperCase());
						arbre2.inserir(paraula.toUpperCase());
			
					} catch (Exception e) {}
	         }
	     }
     	
		System.out.println("LLISTA DE PARAULES LLARGUES");
		System.out.println("------ -- -------- --------");
		System.out.print(arbre.toString());
		System.out.println();
		System.out.println("LLISTA DE PARAULES LLARGUES ('CENSURAT')");
		System.out.println("------ -- -------- -------- ------------");
		cami = arrel +"/src/Excl.txt";
		String paraulesExcloses = llegirText(cami);
		String[] parExcolses = paraulesExcloses.split("([\\s!?\"',;:.]+)");
		for (int i = 0; i <parExcolses.length;++i) {
	    	 paraula = parExcolses[i];
				try {
					arbre.esborrar(paraula);
					arbre2.esborrar(paraula);
				} catch (Exception e) {	}
	     }
		System.out.println(arbre2.toString());
	}
			
		private static String llegirText(String arxiu) {
			
		    String text = null;
		    File file = new File(arxiu);
		    FileReader reader = null;
		    try {
		        reader = new FileReader(file);
		        char[] chars = new char[(int) file.length()];
		        reader.read(chars);
		        text = new String(chars);
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        if(reader != null){
		        	try {
		    			reader.close();
		    		} catch (IOException e) {
		    			e.printStackTrace();
		    		} 
	        	}
		    }
		    return text;
		}

}