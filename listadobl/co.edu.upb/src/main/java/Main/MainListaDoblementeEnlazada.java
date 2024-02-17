package Main;

import Interna.GestionDeTareas;
import Interna.GestorOControladorDeTareas;

public class MainListaDoblementeEnlazada {
    public static void main(String args[]) {
    	GestorOControladorDeTareas gestor = new GestorOControladorDeTareas();//creamos una instancia del controlador la cual pues
    	//funciona con responsabilidar para usar invocando el constructor de la clase que inicializa un nuevo objeto y 
    	//que tendra acceso a todos los metodos publicos y atributos definidos en la clase lo que permite gestionar y manipular los elementos
    	//u tareas que querramos usando las funciones que se proporcionan por la clase
    	
        gestor.agregarLaTarea(new GestionDeTareas("Hacer la compra", 2, "2024-02-17"));
        gestor.agregarLaTarea(new GestionDeTareas("Estudiar para el examen", 1, "2024-02-20"));
        gestor.agregarLaTarea(new GestionDeTareas("Reunión con el equipo", 3, "2024-02-19"));
        gestor.agregarLaTarea(new GestionDeTareas("Reunión con el equipo", 4, "2024-05-20"));
        gestor.agregarLaTarea(new GestionDeTareas("Reunión con el equipo", 6, "2024-06-21"));
        gestor.agregarLaTarea(new GestionDeTareas("Reunión con el equipo", 5, "2024-07-22"));

        
        System.out.println("Tareas actuales:");
        gestor.mostrasTareas();
        
        System.out.println("Tareas después de eliminar una: " + gestor.eliminarTarea(1));
        gestor.mostrasTareas();
        
        gestor.ordenarPorPrioridad();
        System.out.println("Tareas ordenadas por prioridad: " );
        gestor.mostrasTareas();
        

    }
}
