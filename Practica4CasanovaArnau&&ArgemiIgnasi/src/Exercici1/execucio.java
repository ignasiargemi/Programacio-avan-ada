package Exercici1;

import java.util.Scanner;

public class execucio {
	public static void main(String args[]) throws Exception{
		
		//Introducció de les dades aleatoriament
		String[] inici = {"Barcelona","Granollers", "l'Ametlla","Tarragona", "Lleida", "Vic","Vielha"};
		String[] fi = {"Girona","Mataró", "la Garriga","Badalona", "la Roca", "Canovelles","Ripoll"};
		String ciutatOrigen = inici[(int) Math.floor(Math.random()*inici.length)];
		String ciutatDesti = fi[(int) Math.floor(Math.random()*fi.length)];
		int kmEntreCiutats = (int) Math.floor(Math.random()*1000+1);
		int kmCotxeDipositPle = (int) Math.floor(Math.random()*120+1);
		int nombreGasolineras = (int) Math.floor(Math.random()*60+1);
		int kmEntreGasolineras = (int) Math.floor(Math.random()*50+1);
		
		//Inici de l'excecució
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
			System.out.println("Introdueix el nombre de gasolineres");
			nombreGasolineras = sc.nextInt();
			System.out.println("Introdueix la distancia entre gasolineres");
			kmEntreGasolineras = sc.nextInt();
		}
		
		TecnicaVorac ruta = new TecnicaVorac(ciutatOrigen, ciutatDesti, kmEntreGasolineras, nombreGasolineras, kmCotxeDipositPle, kmEntreCiutats);
		ruta.seleccioGasolinera();
		System.out.print(ruta.toString());
		/*
		candidats: totes les gasolineres menys la primera, que es d'on surt el cotxe, com a minim parara a distanciaEntreCiutats/kmDipositPle
		funcio seleccio: volem optimitzar el viatge, per tant la nostre funcio consultara els km k pot recorre amb el diposit ple i escollira la gasolinera que s'apropi m�s als km k pot recorre(mes petit o igual)
		sempre trobara la millor solucio
		*/
	}

}
