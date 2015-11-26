package Exercici1;

import java.util.ArrayList;
import java.util.Scanner;

public class execucio {
	public static void main(String args[]) throws Exception{
		
		//Introducci� de les dades aleatoriament
		String[] inici = {"Barcelona","Granollers", "l'Ametlla","Tarragona", "Lleida", "Vic","Vielha"};
		String[] fi = {"Girona","Matar�", "la Garriga","Badalona", "la Roca", "Canovelles","Ripoll"};
		String ciutatOrigen = inici[(int) Math.floor(Math.random()*inici.length)];
		String ciutatDesti = fi[(int) Math.floor(Math.random()*fi.length)];
		
		int kmEntreCiutats = (int) Math.floor(Math.random()*600+1);
		int kmCotxeDipositPle = (int) Math.floor(Math.random()*(120-40+1)+40);
		int nombreGasolineres = (int) Math.floor(Math.random()*(30-15+1)+1);
		int kmEntreGasolineres = 0;
		int acc = 0;
		int[] gasolineres = new int[nombreGasolineres+1];
		vectorRandom(gasolineres,nombreGasolineres,kmCotxeDipositPle,kmEntreCiutats);
		while (gasolineres[nombreGasolineres] < 1 || gasolineres[nombreGasolineres] > kmCotxeDipositPle) vectorRandom(gasolineres,nombreGasolineres,kmCotxeDipositPle,kmEntreCiutats);
		
		//Inici de l'excecuci�
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
			while (gasolineres[nombreGasolineres] < 1 || gasolineres[nombreGasolineres] > kmCotxeDipositPle) {
				msgLN("Les distancies que has introduit no són correctes.");
				msgLN("Torna-ho a provar");
				acc = 0;
				for (int i = 0; i < nombreGasolineres; ++i){
					ii = i+1;
					msgLN("Introdueix la distancia entre les gasolineres " + i + " i " + ii);
					kmEntreGasolineres = sc.nextInt();
					acc += kmEntreGasolineres;
					gasolineres[i] = kmEntreGasolineres;
				}
				gasolineres[nombreGasolineres] = kmEntreCiutats - acc;
			}
		}
		//Primer creem la ruta, seguidament calculem la ruta optima i finalment treiem totes les dades de la ruta
		TecnicaVorac ruta = new TecnicaVorac(ciutatOrigen, ciutatDesti, nombreGasolineres, 
				kmCotxeDipositPle, kmEntreCiutats, gasolineres);
		ArrayList<Integer> resultat = ruta.seleccioGasolinera();
		if (resultat != null) {
			for (int i = 0; i < resultat.size()-1; ++i) {
				msgLN((i+1)+ ". " + resultat.get(i) + " km");
			}
		}
		
		msg(ruta.toString());

		/*
		candidats: totes les gasolineres s�n candidates a ser punts de parada
		funci� selecci�: volem optimitzar el viatge realitzant el menor n�mero de parades possible, 
		per tant la nostre funci� consultar� els km que pot recorre amb el diposit ple i escollir� 
		la gasolinera que s'apropi m�s als km que pot recorre(m�s petit o igual)
		La nostre soluci� sempre trobar� la millor soluci� perquè sempre agafem la gasolinera
		*/
	}

	//Funcio Auxiliar
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