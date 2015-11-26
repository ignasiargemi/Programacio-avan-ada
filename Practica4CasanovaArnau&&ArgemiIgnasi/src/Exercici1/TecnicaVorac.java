package Exercici1;

import java.util.ArrayList;

public class TecnicaVorac {
	
	//Atributs
	private String ciutatOrigen;
	private String ciutatDesti;
	private int kmEntreCiutats, nombreGasolineres, kmCotxeDipositPle;
	private int[] distanciaEntreGasolineres;
	private int parades = 0;
	
	//Creador
	public TecnicaVorac(String origen, String desti, int numGas, int kmDip, int kmC, int[] gasolineres){
		this.ciutatOrigen = origen;
		this.ciutatDesti = desti;
		this.nombreGasolineres = numGas;
		this.kmCotxeDipositPle = kmDip;
		this.kmEntreCiutats = kmC;
		this.distanciaEntreGasolineres = gasolineres;
	}

	//Getters i Setters
	public String getCiutatOrigen() {return ciutatOrigen;}
	public void setCiutatOrigen(String ciutatOrigen) {this.ciutatOrigen = ciutatOrigen;}
	public String getCiutatDesti() {return ciutatDesti;}
	public void setCiutatDesti(String ciutatDesti) {this.ciutatDesti = ciutatDesti;}
	public int getKmEntreCiutats() {return kmEntreCiutats;}
	public void setKmEntreCiutats(int kmEntreCiutats) {this.kmEntreCiutats = kmEntreCiutats;}
	public int getnombreGasolineres() {return nombreGasolineres;}
	public void setnombreGasolineres(int nombreGasolineres) {this.nombreGasolineres = nombreGasolineres;}
	public int getKmCotxeDipositPle() {return kmCotxeDipositPle;}
	public void setKmCotxeDipositPle(int kmCotxeDipositPle) {this.kmCotxeDipositPle = kmCotxeDipositPle;}
	public int getParades(){return this.parades;}

	//Selecciï¿½ de ruta
	public ArrayList<Integer> seleccioGasolinera() throws Exception{
		ArrayList<Integer> resultat = null;
		if(noPara()) {
			int comptadorKM = 0;
			if(this.nombreGasolineres == 1) {
				if (this.distanciaEntreGasolineres[0] < this.kmCotxeDipositPle && this.distanciaEntreGasolineres[1] < this.kmCotxeDipositPle) {
					this.parades = 1;
					resultat = new ArrayList<Integer>();
					resultat.add(this.distanciaEntreGasolineres[0]);
				}
				else {
					msgLN("No pot arribar a la gasolinera");
					return null;
				}
			}
			else {
				resultat = new ArrayList<Integer>();
				int inici = 0;
				comptadorKM = 0;
				while (comptadorKM < this.kmEntreCiutats && inici < this.distanciaEntreGasolineres.length) {
					int posMax = select(inici);
					if (posMax != -1) {
						int suma = 0;
						for (int i = 0; i < posMax; ++i) suma += this.distanciaEntreGasolineres[i];
						resultat.add(suma);
						inici = posMax;
					}
				}
				msgLN("-----------------------------------------------------");
				msgLN("El vehicle haurà  de fer " + parades + " parades a les gasolineres");
				msgLN("-----------------------------------------------------");
			}
		}
		return resultat;
	}
	
	
	private int select(int inici) {
		int suma = this.kmCotxeDipositPle;
		boolean trobat = false;
		if (inici < this.distanciaEntreGasolineres.length) {
			while (!trobat) {
				if (inici < this.distanciaEntreGasolineres.length) {
					if (suma < this.distanciaEntreGasolineres[inici]) {
						++this.parades;
						trobat = true;
						return inici;
					}
					else {
						suma -= this.distanciaEntreGasolineres[inici];
						++inici;
					}
				}
				else trobat = true;
			}
			return inici;
		}
		else return -1;
	}

	//Comprova les excepcions
	private boolean noPara() throws Exception {
		int parades = -1;
		if (this.kmCotxeDipositPle > this.kmEntreCiutats) parades = 0;
		for (int i = 0; i < this.distanciaEntreGasolineres.length;++i) {
			if (this.distanciaEntreGasolineres[i] > this.kmCotxeDipositPle) {
				msgLN("No pot arribar a la gasolinera\n");
				return false;
			}
		}
		if (parades == 0) {
			msgLN("-------------------------------------------------------");
			msgLN("El vehicle no haurà  de fer cap parada a les gasolineres");
			msgLN("-------------------------------------------------------");
			return false;
		}
		else return true;
	}

	//toString
	public String toString() {
		return "Caracteristiques del Viatge:\nCiutat d'Origen = " + ciutatOrigen + "\nCiutat de Desti = " + ciutatDesti + "\nkm Entre Ciutats = "
				+ kmEntreCiutats + "\nkm Entre Gasolineres\n" + toString(this.distanciaEntreGasolineres) + "Nombre de Gasolineres = "
				+ nombreGasolineres + "\nkm Cotxe DipositPle = " + kmCotxeDipositPle;
	}
	
	public String toString(int[] dist) {
		String res = "";
		for (int i = 0; i < dist.length; ++i) {
			res+=(i+1) + ". " +dist[i] + " km\n";
		}
		return res;
	}
	
	//Missatges per pantalla	
	private static void msgLN(String s) {
		System.out.println(s);
	}
}