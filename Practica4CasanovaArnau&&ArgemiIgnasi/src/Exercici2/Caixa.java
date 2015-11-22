package Exercici2;

public class Caixa {
	
	private int nombreElements;
	private int caixaId;
	private Polvoro[] polvorons;
	String type;
	
	public Caixa(Polvoro[] p, int nombreElements, int caixaId){
		this.polvorons = p;
		this.nombreElements = nombreElements;
		this.caixaId = caixaId;
	}

	public int getNombreElements() {return nombreElements;}
	public void setNombreElements(int nombreElements) {this.nombreElements = nombreElements;}
	public int getCaixaId() {return caixaId;}
	public void setCaixaId(int caixaId) {this.caixaId = caixaId;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	public Polvoro[] getPolvorons() {return polvorons;}
	public void setPolvorons(Polvoro[] polvorons) {this.polvorons = polvorons;}
	
	public String toString() {
		String retorn = "Caixa [nombreElements=" + nombreElements + ", caixaId=" + caixaId + "]\n";
		retorn += "Llista de polvorons:\n";
		for (int i = 0; i < polvorons.length; ++i) 
			retorn += (i+1) + ". " + polvorons[i].toString() + "\n";
		
		retorn += "S'ha retornat correctament tots els polvorons de la caixa.\n";
		return retorn;
	}

	public boolean EsAvorrida() {
		boolean avorrit = false;
		for (int i = 0; i < this.polvorons.length/2 && !avorrit; ++i)
			if (AvorritRec(this.polvorons[i],this.polvorons,0,this.polvorons.length-1) > polvorons.length/2) {
				this.type = this.polvorons[i].getTipus();
				avorrit = true;
			}
		return avorrit;
	}

	private int AvorritRec(Polvoro p, Polvoro[] polvorons, int inici, int fi) {
		int mig = (fi+inici)/2;
		if (fi == inici) {
			if (p.equals(polvorons[inici])) return 1;
			else return 0;
		}
		else return AvorritRec(p,polvorons,inici,mig) + AvorritRec(p,polvorons,mig+1,fi);
	}
}
