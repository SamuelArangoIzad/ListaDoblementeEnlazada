package Interna;

public class GestionDeTareas {
//Creamos la clase tarea que representa pues las tareas con su descripcion etc
	//algo asi como un controlador
	
	
	private String descripcion;
	private int prioridad;
	private String fecha; //Se podria agregar de forma automatica el date para que lo
	//tome de forma automatica el dia que se escribio la tarea pero mejor de esta forma
	//para describir o implementar una funcionalidad mas realista
	public GestionDeTareas(String descripcion, int prioridad, String fecha) {
		super();
		this.descripcion = descripcion;
		this.prioridad = prioridad;
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "GestionDeTareas [descripcion=" + descripcion + ", prioridad=" + prioridad + ", fecha=" + fecha + "]";
	}
	
	/**
	 * ESTO SE COMUNICA CON LA LISTA DOBLE ENLAZADA DE LA FORMA QUE valor almacenado en cada nodo de la 
	 * lista doblemente enlazada. En este caso, los nodos de la lista contienen objetos de tipo 
	 * GestionDeTareas, que representan tareas con sus respectivas propiedades como el 
	 * ombre de la tarea, la prioridad y la fecha.
	 */
	
}
