package Assegurancsa;

import java.util.Date;

public class TotRisc extends Vehicle{
	
	
	public TotRisc(Date dateEmissio, int numeroPolissa, Client client,
			float impoort, Agent corredor, String matricula, int edatConductorHabitual, float bonificacions, float franquicia, int anysVehicle) {
		super(dateEmissio, numeroPolissa, client, impoort, corredor, matricula, edatConductorHabitual, bonificacions);
		this.franquicia = franquicia;
		this.anysVehicle = anysVehicle;
	}
	
	private float franquicia;
	private int anysVehicle;
	public float getFranquicia() {
		return franquicia;
	}
	public void setFranquicia(float franquicia) {
		this.franquicia = franquicia;
	}
	public int getAnysVehicle() {
		return anysVehicle;
	}
	public void setAnysVehicle(int anysVehicle) {
		this.anysVehicle = anysVehicle;
	}
	
	
	public String toString() {
		return "TotRisc [franquicia=" + franquicia + ", anysVehicle="
				+ anysVehicle + ", getMatricula()=" + getMatricula()
				+ ", getEdatConductorHabitual()=" + getEdatConductorHabitual()
				+ ", getBonificacions()=" + getBonificacions()
				+ ", getDateEmissio()="
				+ getDateEmissio() + ", getNumeroPolissa()="
				+ getNumeroPolissa() + ", getClient()=" + getClient()
				+ ", getImpoort()=" + getImpoort() + ", getCorredor()="
				+ getCorredor() + "]";
	}
	
	
	

}
