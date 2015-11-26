package Exercici1;

import java.util.Scanner;

public class execucio {
	public static void main(String args[]) throws Exception{
		
		//Introducció de les dades aleatoriament
		String[] inici = {"Barcelona","Granollers", "l'Ametlla","Tarragona", "Lleida", "Vic","Vielha"};
		String[] fi = {"Girona","Mataró", "la Garriga","Badalona", "la Roca", "Canovelles","Ripoll"};
		String ciutatOrigen = inici[(int) Math.floor(Math.random()*inici.length)];
		String ciutatDesti = fi[(int) Math.floor(Math.random()*fi.length)];
		
		int kmEntreCiutats = (int) Math.floor(Math.random()*600+1);
		int kmCotxeDipositPle = (int) Math.floor(Math.random()*(120-40+1)+40);
		//int valorEntero = Math.floor(Math.random()*(N-M+1)+M);
		int nombreGasolineres = (int) Math.floor(Math.random()*30+1);
		int kmEntreGasolineres = 0;
		int acc = 0;
		int[] gasolineres = new int[nombreGasolineres+1];
		vectorRandom(gasolineres,nombreGasolineres,kmCotxeDipositPle,kmEntreCiutats);
		while (gasolineres[nombreGasolineres] < 1) vectorRandom(gasolineres,nombreGasolineres,kmCotxeDipositPle,kmEntreCiutats);
		
		//Inici de l'excecució
		msgLN("Vols introduir les dades? [SI/NO]");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String resposta = sc.next();
		resposta.toUpperCase();
		while (!resposta.equalsIgnoreCase("SI") && !resposta.equalsIgnoreCase("NO")) {
			msgLN("Resposta Incorrecte. Respon SI o NO");
			resposta = sc.next();
		}
		
		if (resposta.equalsIgnoreCase("SI")) {
			msgLN("Introdueix la ciutat d'origen");
			ciutatOrigen = sc.next();
			msgLN("Introdueix la ciutat desti");
			ciutatDesti = sc.next();
			msgLN("Introdueix els quilometres que les separen");
			kmEntreCiutats = sc.nextInt();
			msgLN("Introdueix els quilometres que pot recorrer el cotxe amb el diposit ple");
			kmCotxeDipositPle = sc.nextInt();
			msgLN("Introdueix el nombre de gasolineres[]");
			nombreGasolineres = sc.nextInt();
			gasolineres = new int[nombreGasolineres+1];
			acc = 0; 
			int ii;
			for (int i = 0; i < nombreGasolineres; ++i){
				ii = i+1;
				msgLN("Introdueix la distancia entre les gasolineres " + i + " i " + ii);
				kmEntreGasolineres = sc.nextInt();
				acc += kmEntreGasolineres;
				gasolineres[i] = kmEntreGasolineres;
			}
			
			gasolineres[nombreGasolineres] = kmEntreCiutats - acc;
		}
		//Primer creem la ruta, seguidament calculem la ruta optima i finalment treiem totes les dades de la ruta
		TecnicaVorac ruta = new TecnicaVorac(ciutatOrigen, ciutatDesti, nombreGasolineres, 
				kmCotxeDipositPle, kmEntreCiutats, gasolineres);
		ruta.seleccioGasolinera();
		msg(ruta.toString());

		/*
		candidats: totes les gasolineres són candidates a ser punts de parada
		funció selecció: volem optimitzar el viatge realitzant el menor número de parades possible, 
		per tant la nostre funció consultarà els km que pot recorre amb el diposit ple i escollirà 
		la gasolinera que s'apropi més als km que pot recorre(més petit o igual)
		La nostre solució sempre trobarà la millor solució
		*/
	}

	private static void vectorRandom(int[] gasolineres, int nombreGasolineres, int kmCotxeDipositPle, int kmEntreCiutats) {
		int acc = 0;
		for (int z=0; z < nombreGasolineres; ++z){
			gasolineres[z] = (int) Math.floor(Math.random()*kmCotxeDipositPle+1);
			acc += gasolineres[z];
		}
		gasolineres[nombreGasolineres] = kmEntreCiutats - acc;
	}

	//Missatges per pantalla
	private static void msg(String s) {
		System.out.print(s);
		
	}
	
	private static void msgLN(String s) {
		System.out.println(s);
		
	}

}