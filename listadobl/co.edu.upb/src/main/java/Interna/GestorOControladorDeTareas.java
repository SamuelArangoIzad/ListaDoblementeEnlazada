package Interna;

import java.util.ArrayList;
import java.util.Comparator;

import listadoblementeenlazada.co.edu.upb.ListaDobleEnlazada;


public class GestorOControladorDeTareas {
	private ListaDobleEnlazada<GestionDeTareas> listaTareas;
	//controlador de acceso privado donde solo se tiene acceso por medio de 
	//esta clase a la lista doblemente enlazada de objetos de tipo gestionDeTareas
	
	public GestorOControladorDeTareas() {
		listaTareas = new ListaDobleEnlazada<GestionDeTareas>(null, null, 0);
	}//El constructor de lla clase que inicia la lista de tareas como una lista doblemente enlazada vacia
	public void agregarLaTarea(GestionDeTareas tarea) {
		listaTareas.agregarAlFinal(tarea);//Agrega una nueva al final de la lista de tareas
	}
	public GestionDeTareas eliminarTarea(int indice) {
		return listaTareas.eliminarDelMedio(indice); //Elimina la tarea por medio del indice que se especifica en la lista de tareas
		//y devuelve lo que se elimino
	}
	public void mostrasTareas() {
		listaTareas.mostrarLista();//Muestra todas las tareas en la lista de tareas
	}
	
	//METODOS QUE SE DEBEN REALIZAR PARA PROBAR NUESTRA LISTA DOBLEMENTE ENLAZADA
	/**
	 * 1 Añadir y eliminar tareas y recordatorios _/
	 * 2 Ordenar tareas por prioridad o fehca _/
	 * 3 Ver tareas anteriores y futuras _/
	 * 4 Crear una lista doble que maneje las tareas y recordatorios _/
	 * 5 Implementar el sistema para modificar el orden de tareas _/
	 */
	public void ordenarPorPrioridad() {
        ArrayList<GestionDeTareas> tareas = listaTareas.obtenerElementos();
        tareas.sort(Comparator.comparingInt(GestionDeTareas::getPrioridad));
        listaTareas = new ListaDobleEnlazada<>(null, null, 0);
        for (GestionDeTareas tarea : tareas) {
            listaTareas.agregarAlFinal(tarea);
        }
    }
	
}
