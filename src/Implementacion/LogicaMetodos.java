package Implementacion;

import java.util.ArrayList;
import java.util.List;

import Dominio.Panes;
import Interface.Metodos;
import Interface.Metodos2;

public class LogicaMetodos implements Metodos, Metodos2 {

	private List<Panes> listar = new ArrayList<Panes>();

	// validar que el nombre del pan no se repita
	@Override
	public void guardar(Panes pan) {
		// TODO Auto-generated method stub

		// 1--Recorrer los registro de la lista
		// 2-- comaprar cada registro de la lista
		// 3--bandera por si no existe

		boolean bandera = false;

		for (Panes p : listar) {
			if (p.getNombre().equals(pan.getNombre())) {
				// ese pan ya esxite
				System.out.println("Ese nombre de pan ya existe, no se puede guardar");
				bandera = true;
			}
		}
		if (bandera == false) {
			listar.add(pan);
			System.out.println("Se guardo con exito");
		}
	}

	@Override
	public List<Panes> mostrar() {
		// TODO Auto-generated method stub
		return listar;
	}

	@Override
	public Panes buscarXIndice(int indice) {
		// TODO Auto-generated method stub
		return listar.get(indice);
	}

	@Override
	public void editar(int indice, Panes pan) {
		// TODO Auto-generated method stub
		listar.set(indice, pan);

	}

	@Override
	public void eliminar(int indice) {
		// TODO Auto-generated method stub
		listar.remove(indice);
	}

	@Override
	public void buscarNombre(String nombre, Panes pan) {

		boolean encontrado = false;
		// System.out.println(nombre);
		// System.out.println(pan.getNombre());
		for (Panes p : listar) {
			if (p.getNombre().equals(nombre)) {

				System.out.println("Se encontro " + p);
				encontrado = true;
				break;
			}

		}
		if (!encontrado) {
			System.out.println("No se encontro pan");
		}

	}

	@Override
	public void buscarSabor(String sabor, Panes pan) {
		boolean encontrado = false;
		for (Panes p : listar) {
			if (p.getSabor().equals(sabor)) {

				System.out.println("Se encontro " + p);
				encontrado = true;
			}

		}

		if (encontrado == false) {
			System.out.println("No se encontro el pan" + "");
		}

	}

	@Override
	public void calcularDinero() {
		// TODO Auto-generated method stub
		float dinero = 0;
		for (Panes p : listar) {
			dinero += p.getPrecio() * p.getExistencia();
		}
		System.out.println("Total de dinero: " + dinero);

	}

	@Override
	public void editarBuscandoNombre(String nombre) {
		// TODO Auto-generated method stub

		Panes encontrado = null;
		// System.out.println(nombre);
		// System.out.println(pan.getNombre());
		for (int i = 0; i < listar.size(); i++) {
			if (nombre.equals(listar.get(i).getNombre())) {
				System.out.println("Ingresa le nuevo sabor");
				
				listar.set(i, pan);
				
				break;

			}
		}
	}

	@Override
	public void elimminarBuscandoNombre(String nombre, Panes pan) {
		// TODO Auto-generated method stub

		boolean encontrado = false;
		for (int i = 0; i < listar.size(); i++) {

			if (nombre.equals(listar.get(i).getNombre())) {
				// si existe
				listar.remove(i);
				System.out.println("Elemento eliminado");
				encontrado = true;
				break;
			}

		}
		if (encontrado == false) {
			System.out.println("No existe registro");
		}
	}
}
