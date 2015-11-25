package Exercici1;

import java.util.Scanner;

public class execucio {
	public static void main(String args[]) throws Exception{
		
		//Introducci� de les dades aleatoriament
		String[] inici = {"Barcelona","Granollers", "l'Ametlla","Tarragona", "Lleida", "Vic","Vielha"};
		String[] fi = {"Girona","Matar�", "la Garriga","Badalona", "la Roca", "Canovelles","Ripoll"};
		String ciutatOrigen = inici[(int) Math.floor(Math.random()*inici.length)];
		String ciutatDesti = fi[(int) Math.floor(Math.random()*fi.length)];
		
		int kmEntreCiutats = (int) Math.floor(Math.random()*1000+1);
		int kmCotxeDipositPle = (int) Math.floor(Math.random()*120+1);
		int nombreGasolineres = (int) Math.floor(Math.random()*40+1);
		int kmEntreGasolineres = 0;
		int[] gasolineres = new int[nombreGasolineres];
		for (int z=0; z < nombreGasolineres; ++z){gasolineres[z] = kmEntreCiutats/nombreGasolineres;}
		
		
		//Inici de l'excecuci�
		System.out.println("Vols introduir les dades? [SI/NO]");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String resposta = sc.next();
		resposta.toUpperCase();
		while (!resposta.equalsIgnoreCase("SI") && !resposta.equalsIgnoreCase("NO")) {
			System.out.println("Resposta Incorrecte. Respon SI o NO");
			resposta = sc.next();
		}
		
		if (resposta.equalsIgnoreCase("SI")) {
			System.out.println("Introdueix la ciutat d'origen");
			ciutatOrigen = sc.next();
			System.out.println("Introdueix la ciutat desti");
			ciutatDesti = sc.next();
			System.out.println("Introdueix els quilometres que les separen");
			kmEntreCiutats = sc.nextInt();
			System.out.println("Introdueix els quilometres que pot recorrer el cotxe amb el diposit ple");
			kmCotxeDipositPle = sc.nextInt();
			System.out.println("Introdueix el nombre de gasolineres[]");
			nombreGasolineres = sc.nextInt();
			for (int i = 0; i < nombreGasolineres; ++i){
				int ii = i+1;
				System.out.println("Introdueix la distancia entre les gasolineres " + i + " i " + ii);
				kmEntreGasolineres = sc.nextInt();
				gasolineres[i] = kmEntreGasolineres;
			}
		}
		
		TecnicaVorac ruta = new TecnicaVorac(ciutatOrigen, ciutatDesti, nombreGasolineres, kmCotxeDipositPle, kmEntreCiutats, gasolineres);
		ruta.seleccioGasolinera();
		System.out.print(ruta.toString());
		/*
		candidats: totes les gasolineres menys la primera, que es d'on surt el cotxe, com a minim parara a distanciaEntreCiutats/kmDipositPle
		funcio seleccio: volem optimitzar el viatge, per tant la nostre funcio consultara els km k pot recorre amb el diposit ple i escollira la gasolinera que s'apropi m�s als km k pot recorre(mes petit o igual)
		sempre trobara la millor solucio
		*/
	}

}