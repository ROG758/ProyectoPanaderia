package Main;

import java.time.LocalDate;
import java.util.Scanner;

import Dominio.Panes;
import Implementacion.LogicaMetodos;

public class Principal {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/// delclarar las variables
		Scanner lectura = null;

		String nombre;
		float precio;
		int existencia, munuPrinc, indice;
		String sabor;
		LocalDate fechaLabo;
		
		/*System.out.println("se agrega estas lineas de codigo");
		float operacion = 3.1416f*5;
		System.out.println(operacion);*/

		Panes pan = null;

		LogicaMetodos imp = new LogicaMetodos();

		do {
			System.out.println("MENÚ PPRINCIPAL DE - PANADERIA");
			System.out.println("1---ALTA DE PAN");
			System.out.println("2---MOSTRAR");
			System.out.println("3---BUSCAR");
			System.out.println("4---EDITAR");
			System.out.println("5---ELIMINAR");
			System.out.println("6---BUSCAR POR NOMBRE");
			System.out.println("7---BUSCAR ¨POR SABOR");
			System.out.println("8---CALCULAR TOTAL DINERO INVERTIDO");
			System.out.println("9---EDITAR BUSCANDO EL NOMBRE");
			System.out.println("10---ELIMINAR BUSCANDO POR NOMBRE");
			System.out.println("11---SALIR");

			lectura = new Scanner(System.in);
			munuPrinc = lectura.nextInt();

			switch (munuPrinc) {
			case 1:
				try {
					System.out.println("Ingrese el nombre");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();

					System.out.println("Ingrese el precio");
					lectura = new Scanner(System.in);
					precio = lectura.nextFloat();

					System.out.println("Ingrese la existencia");
					lectura = new Scanner(System.in);
					existencia = lectura.nextInt();

					System.out.println("Ingrese el sabor");
					lectura = new Scanner(System.in);
					sabor = lectura.nextLine();

					System.out.println("Ingrese la fecha de elaboración : Ejemplo : año-dia.dia");
					lectura = new Scanner(System.in);
					String fecha = lectura.nextLine();

					fechaLabo = LocalDate.parse(fecha);

					// crear objeto
					pan = new Panes(nombre, precio, existencia, sabor, fechaLabo);

					// guardar
					imp.guardar(pan);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al guardar " + e.getMessage());
				}
				break;

			case 2:
				if (imp.mostrar().size() > 0) {
					System.out.println(imp.mostrar());
				} else {
					System.out.println("No hay registros");
				}
				break;

			case 3:
				try {
					System.out.println("Ingrese el indice del registro a buscar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// buscar
					pan = imp.buscarXIndice(indice);
					System.out.println("Se encontro " + pan);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al buscar " + e.getMessage());
				}
				break;

			case 4:
				try {
					System.out.println("Ingrese el indice del registro a editar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// Para editar primero hay que buscar
					pan = imp.buscarXIndice(indice);
					System.out.println("Se encontro " + pan.getNombre());

					// ingresar nuevo dato
					System.out.println("Ingrese el nuevo nombre del pan");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();

					// actualizacion
					pan.setNombre(nombre);
					imp.editar(indice, pan);
					System.out.println("Se edito correctamente");

					// actualización
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al editar " + e.getMessage());
				}
				break;

			case 5:
				try {
					System.out.println("Ingrese el indice a eliminar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// eliminar
					imp.eliminar(indice);
					System.out.println("Se elimino con éxito");

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error a eliminar " + e.getMessage());
				}
				break;

			case 6:
				try {
					System.out.println("Ingrese el nombre del pan a buscar");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();

					// buscar
					imp.buscarNombre(nombre, pan);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("no se puedo encontrar " + e.getMessage());
				}
				break;

			case 7:
				try {
					System.out.println("Ingrese el sabor del pan a buscar");
					lectura = new Scanner(System.in);
					sabor = lectura.nextLine();

					imp.buscarSabor(sabor,pan);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("no se puedo encontrar" + e.getMessage());
				}
				break;

			case 8:
				imp.calcularDinero();
				break;
			case 9:
				try {
					System.out.println("Ingrese EL nombre del pan");
					lectura= new Scanner(System.in);
					nombre = lectura.nextLine();
					
					//
					System.out.println("Ingrese nuevo precio");
					lectura= new Scanner(System.in);
					sabor = lectura.nextLine();
					
					
					//imp.editarBuscandoNombre(nombre, pan);
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("No se puedo editar" + e.getMessage());
				}
				
				break;

			case 10:
				try {
					System.out.println("Ingrese el nombre a elimiar ");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();
					
					imp.elimminarBuscandoNombre(nombre, pan);
				} catch (Exception e) {
					// TODO: handle exception
				System.out.println("No se puedo eliminar" + e.getMessage());
				}
				break;

			case 11:
				break;
			}

		} while (munuPrinc < 11);
	}

}
