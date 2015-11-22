package Exercici1;

public class TecnicaVorac {
	private String ciutatOrigen;
	private String ciutatDesti;
	private int kmEntreCiutats, kmEntreGasolineres, nombreGasolineres, kmCotxeDipositPle;
	
	public TecnicaVorac(String origen, String desti, int distGas, int numGas, int kmDip, int kmC){
		this.ciutatOrigen = origen;
		this.ciutatDesti = desti;
		this.kmEntreGasolineres = distGas;
		this.nombreGasolineres = numGas;
		this.kmCotxeDipositPle = kmDip;
		this.kmEntreCiutats = kmC;
	}

	public String getCiutatOrigen() {
		return ciutatOrigen;
	}

	public void setCiutatOrigen(String ciutatOrigen) {
		this.ciutatOrigen = ciutatOrigen;
	}

	public String getCiutatDesti() {
		return ciutatDesti;
	}

	public void setCiutatDesti(String ciutatDesti) {
		this.ciutatDesti = ciutatDesti;
	}

	public int getKmEntreCiutats() {
		return kmEntreCiutats;
	}

	public void setKmEntreCiutats(int kmEntreCiutats) {
		this.kmEntreCiutats = kmEntreCiutats;
	}

	public int getkmEntreGasolineres() {
		return kmEntreGasolineres;
	}

	public void setkmEntreGasolineres(int kmEntreGasolineres) {
		this.kmEntreGasolineres = kmEntreGasolineres;
	}

	public int getnombreGasolineres() {
		return nombreGasolineres;
	}

	public void setnombreGasolineres(int nombreGasolineres) {
		this.nombreGasolineres = nombreGasolineres;
	}

	public int getKmCotxeDipositPle() {
		return kmCotxeDipositPle;
	}

	public void setKmCotxeDipositPle(int kmCotxeDipositPle) {
		this.kmCotxeDipositPle = kmCotxeDipositPle;
	}

	public void seleccioGasolinera() throws Exception{
		int parades = -1;
		if (this.kmCotxeDipositPle > this.kmEntreCiutats) parades = 0;
		if (this.kmCotxeDipositPle < this.kmEntreGasolineres || this.kmCotxeDipositPle < this.kmEntreCiutats/this.nombreGasolineres) throw new Exception("No pot arribar a la gasolinera");
		if (parades == 0) {
			System.out.println("-------------------------------------------------------");
			System.out.println("El vehicle no haurà  de fer cap parada a les gasolineres");
			System.out.println("-------------------------------------------------------");
		}
		else {
			String stops = "";
			parades = 0;
			int comptadorKM = 0;
			int KMcotxe = this.kmCotxeDipositPle;
			while (comptadorKM < this.kmEntreCiutats) {
				if (KMcotxe < this.kmEntreGasolineres) {
					KMcotxe = this.kmCotxeDipositPle;
					++parades;
					stops += parades + ". Parada al km " + comptadorKM + "\n";
				}
				else {
					comptadorKM += this.kmEntreGasolineres;
					KMcotxe -= this.kmEntreGasolineres;
				}
				
			}
			System.out.println("-----------------------------------------------------");
			System.out.println("El vehicle haurà  de fer " + parades + " parades a les gasolineres");
			System.out.println("-----------------------------------------------------");
			System.out.println(stops);
		}
	}

	public String toString() {
		return "Caracteristiques del Viatge:\nCiutat d'Origen = " + ciutatOrigen + "\nCiutat de Desti = " + ciutatDesti + "\nkm Entre Ciutats = "
				+ kmEntreCiutats + "\nkm Entre Gasolineres = " + kmEntreGasolineres + "\nNombre de Gasolineres = "
				+ nombreGasolineres + "\nkm Cotxe DipositPle = " + kmCotxeDipositPle;
	}
	
	
}
