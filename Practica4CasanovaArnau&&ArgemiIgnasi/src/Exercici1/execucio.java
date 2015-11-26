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
		for (int z=0; z < nombreGasolineres; ++z){gasolineres[z] = (int) Math.floor(Math.random()*kmCotxeDipositPle/2+1);}
		
		
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
			for (int i = 0; i < nombreGasolineres; ++i){
				int ii = i+1;
				msgLN("Introdueix la distancia entre les gasolineres " + i + " i " + ii);
				kmEntreGasolineres = sc.nextInt();
				gasolineres[i] = kmEntreGasolineres;
			}
		}
		
		TecnicaVorac ruta = new TecnicaVorac(ciutatOrigen, ciutatDesti, nombreGasolineres, kmCotxeDipositPle, kmEntreCiutats, gasolineres);
		ruta.seleccioGasolinera();
		msg(ruta.toString());

		/*
		candidats: totes les gasolineres menys la primera, que es d'on surt el cotxe, com a minim parara a distanciaEntreCiutats/kmDipositPle
		funcio seleccio: volem optimitzar el viatge, per tant la nostre funcio consultara els km k pot recorre amb el diposit ple i escollira la gasolinera que s'apropi m�s als km k pot recorre(mes petit o igual)
		sempre trobara la millor solucio
		*/
	}

	//Missatges per pantalla
	private static void msg(String s) {
		System.out.print(s);
		
	}
	
	private static void msgLN(String s) {
		System.out.println(s);
		
	}

}