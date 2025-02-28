package Interface;

import Dominio.Panes;

public interface Metodos2 {

	public void buscarNombre(String nombre,Panes pan);
	
	public void buscarSabor(String sabor,Panes pan);
	
	public void calcularDinero();
	
	public void editarBuscandoNombre(String nombre);
	
	public void elimminarBuscandoNombre(String nombre,Panes pan);
}
