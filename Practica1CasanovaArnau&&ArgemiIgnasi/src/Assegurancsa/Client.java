package Assegurancsa;

public class Client extends Persona {
	
	public Client(String nom, String adreca, long telefon, long dNI,
			String poblacio, String compteBancari) {
		super(nom, adreca, telefon, dNI, poblacio);
		this.compteBancari = compteBancari;
	}

	private String compteBancari;

	public String getCompteBancari() {
		return compteBancari;
	}

	public void setCompteBancari(String compteBancari) {
		this.compteBancari = compteBancari;
	}

	public String toString() {
		return "Client [compteBancari=" + compteBancari + ", getNom()="
				+ getNom() + ", getAdreca()=" + getAdreca() + ", getTelefon()="
				+ getTelefon() + ", getDNI()=" + getDNI() + ", getPoblacio()="
				+ getPoblacio() + "]";
	}
}
