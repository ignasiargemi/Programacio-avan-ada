package Exercici2;

public class Polvoro {
	
	private String tipus;
	private long id;
	

	public Polvoro() {
		super();	
	}
	
	public Polvoro(String tipus, long id){
		this.tipus = tipus;
		this.id = id;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Polvoro [tipus=" + tipus + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((tipus == null) ? 0 : tipus.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Polvoro)) return false;
		Polvoro other = (Polvoro) obj;
		if (this.tipus.equalsIgnoreCase(other.tipus))return true;
		else return false;
		
	}

}

	
