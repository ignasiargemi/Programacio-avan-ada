package Cua_i_pila;

public class CuanEnll<E> implements Cua<E> {
	
	private Node<E> fiCua;
	
	private class Node<E>{
		private E inf;
		private Node<E> seg;
		
		Node(E data){
			this.inf = data;
		}
	}
	
	public CuanEnll(){
		super();
		this.inicialitzar_cua();
	}
	

	public void encuar(E item){
		Node<E> aux = new Node<E>(item);
		if(fiCua == null){
			this.fiCua = aux;
			this.fiCua.seg = aux;
		}
		else {
			aux.seg = this.fiCua.seg;
			this.fiCua.seg = aux;
			this.fiCua = aux;
		}
	}
	
	
	public E desencuar() throws Exception{
		if (cua_buida()) throw new Exception("La cua està buida!");
		Node<E> primer = this.fiCua.seg;
		E retorn = primer.inf;
		if (this.fiCua.equals(primer)) this.fiCua = null;
		else this.fiCua.seg = primer.seg;
		return retorn;
		
	}
	public boolean cua_buida(){
		if (fiCua==null) return true;
		else return false;
	}
	
	public void inicialitzar_cua(){
		if (!cua_buida()) buidar();
		else this.fiCua = null;
	}
	
	public E consultar_cua() throws Exception{
		if (cua_buida()) throw new Exception("La cua és buida");
		else return fiCua.seg.inf;
		
	}
		
	//Revisar
	public void buidar(){
		Node<E> aux = fiCua;
		while(aux.seg != null){
			fiCua = null;
			aux = aux.seg;
			fiCua = aux;
		}
	}
	
	public int quants(){
		return quants(this.fiCua);
	}
	
	private int quants( Node<E> ultim){
		if(ultim == null) return 0;
		if (ultim.seg!=null && !ultim.seg.equals(this.fiCua)) return 1 + quants(ultim.seg);
		else return 1;
	}
	
	public boolean equals(CuanEnll<E> o) {

		boolean trobat = false;
		Node<E> aux,aux2;
		
		if(!this.cua_buida() && !o.cua_buida())  {
			trobat = true;
			aux = this.fiCua.seg;
			aux2 = o.fiCua.seg;
			while(!aux.equals(this.fiCua) && trobat){
				if(aux.inf != aux2.inf){
					trobat = false;
					
				}
				aux = aux.seg;
				aux2 = aux2.seg;
			}
		}		
		return trobat;
	}
	
	public String toString() {
		String s = "";
		if(this.fiCua == null) return "";
		if(this.fiCua.seg.equals(this.fiCua)) {
			s += this.fiCua.inf.toString();
		}
		else {
			Node<E> item = this.fiCua.seg;
			while(!item.equals(this.fiCua)){
				s += item.inf.toString();
				item = item.seg;
			}
			s += item.inf.toString();
			
		}
		return s;
	}
	
	
	public CuanEnll<E> clone() throws CloneNotSupportedException {
		CuanEnll<E> copia = new CuanEnll<E>();

		if(!cua_buida()) {
			Node<E> cap = this.fiCua.seg;
			Node<E> item = cap;
			copia.encuar(item.inf);
			item = item.seg;
			while(!item.equals(cap)){
				copia.encuar(item.inf);
				item = item.seg;
			}
		}
		
	    return copia;
	}		
	
	

	

	
}
