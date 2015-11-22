package Assegurancsa;

public class Agent extends Persona {

	public Agent(String nom, String adreca, long telefon, long dNI,
			String poblacio, int antiguitat, float sou, String compteBancari) {
		super(nom, adreca, telefon, dNI, poblacio);
		this.antiguitat = antiguitat;
		this.sou = sou;
		this.compteBancari = compteBancari;
	}
	private int antiguitat;
	private float sou;
	private String compteBancari;
	
	public int getAntiguitat() {
		return antiguitat;
	}
	public void setAntiguitat(int antiguitat) {
		this.antiguitat = antiguitat;
	}
	public float getSou() {
		return sou;
	}
	public void setSou(float sou) {
		this.sou = sou;
	}
	public String getCompteBancari() {
		return compteBancari;
	}
	public void setCompteBancari(String compteBancari) {
		this.compteBancari = compteBancari;
	}
	
	public String toString() {
		
		return "Agent " + "getNom()=" + getNom() + " getAdreca()=" + getAdreca()
				+ ", getTelefon()=" + getTelefon() + ", getDNI()=" + getDNI()
				+ ", getPoblacio()=" + getPoblacio()  + " getAntiguitat()=" + getAntiguitat() + ", getSou()="
				+ getSou() + ", getCompteBancari()=" + getCompteBancari() + "]";
	}
	
	
}
