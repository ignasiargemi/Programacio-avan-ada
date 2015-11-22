package Cua_i_pila;

public interface Cua<E> {
	
	public void encuar(E item);
	
	public E desencuar() throws Exception;
	
	public boolean cua_buida();
	
	public void inicialitzar_cua();
	
	public E consultar_cua() throws Exception;
	
	public void buidar();
	
}
