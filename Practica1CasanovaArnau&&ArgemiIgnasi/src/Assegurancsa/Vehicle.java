package Assegurancsa;

import java.util.Date;

public class Vehicle extends Asseguransa{
	

	public Vehicle(Date dateEmissio, int numeroPolissa, Client client,
			float impoort, Agent corredor, String matricula, int edatConductorHabitual, float bonificacions) {
		super(dateEmissio, numeroPolissa, client, impoort, corredor);
		this.matricula = matricula;
		this.edatConductorHabitual = edatConductorHabitual;
		this.bonificacions = bonificacions;
	}
	
	public Vehicle(Date dateEmissio, int numeroPolissa, Client client,
			float impoort, Agent corredor, String matricula, int edatConductorHabitual){
		this(dateEmissio,numeroPolissa, client, impoort, corredor, matricula, edatConductorHabitual, 0);
	}
	

	private String matricula;
	private int edatConductorHabitual;
	private float bonificacions;
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getEdatConductorHabitual() {
		return edatConductorHabitual;
	}
	public void setEdatConductorHabitual(int edatConductorHabitual) {
		this.edatConductorHabitual = edatConductorHabitual;
	}
	public float getBonificacions() {
		return bonificacions;
	}
	public void setBonificacions(float bonificacions) {
		this.bonificacions = bonificacions;
	}
	
	
	public void incrementaBonificacions(int tantPercent) throws Exception{
		if (tantPercent < 0) throw new Exception("No es pot incrementar un nombre negatiu.");
		this.bonificacions = bonificacions + tantPercent;
		
	}
	
	public void decrementaBonificacions(int tantPercent) throws Exception{
		if (tantPercent > 0) throw new Exception("No es pot incrementar un nombre positiu.");
		this.bonificacions = bonificacions + tantPercent;
	}

	public String toString() {
		return "Vehicle [matricula=" + matricula + ", edatConductorHabitual="
				+ edatConductorHabitual + ", bonificacions=" + bonificacions
				+ ", getDateEmissio()=" + getDateEmissio()
				+ ", getNumeroPolissa()=" + getNumeroPolissa()
				+ ", getClient()=" + getClient() + ", getImpoort()="
				+ getImpoort() + ", getCorredor()=" + getCorredor() + "]";
	}
	
}
