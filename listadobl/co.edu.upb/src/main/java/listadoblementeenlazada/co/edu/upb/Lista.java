package listadoblementeenlazada.co.edu.upb;

public interface Lista<T> {
	public void agregarAlInicio(T valor); //Agregar al inicio de la lista un valor _/
	public void agregarAlFinal(T valor); //Agregar al final de la lista un valor _/
	public void insertarEnMedio(int indice, T valor); //Insertar en medio un valor _/
	public T eliminarDelInicio();//Eliminar del inicio de la lista un valor _/
	public T eliminarDelFinal();//Eliminar del final de la lista _/
	public T eliminarDelMedio(int indice); //Eliminar del medio de la lista
	public T find(int indice);//Obtener un elemento de la lista _/
    public boolean estaVacia(); //Verificar si la lista esta vacia _/
    public int tamanio();//Obtener el tamaño de la lista _/
    public void mostrarLista(); //Mostrar la lista _/
    public String toString(); // ToString Ya esta explicado en lista sencilla_/
    
    /**
     * TENER EN CUENTA QUE:
     * 
     * 1. La verificacion de la lista este vacia con el metodo de eliminar del inicio y eliminar del final
     * verificar antes si la lista esta vacia antes de intentar eliminar nodos
     * 
     * 2. Indices fuera de Rango en metodos como insertar En Medio y eliminarEnMedio, hay primero
     * que asegurar que el indice proporcionado este dentro del rango valido. Lanzando una excepcion si
     * el indice es menor que 0 o mayor que el tamanio de la lista
     * 
     * 3. Busqueda de elementos no Existentes, en el metodo de buscarElemento considerar el caso
     * en que el elemento buscado no este en la lista y maneja adecuadamente este escenario
     * 
     * IMPORTANTE !! 
     * 
     * SE APLICARA LO ANTERIOR EN UN CODIGO DE SISTEMA DE RESERVAS PAR AUN HOTEL
     * 
     * Involucrando un sistema que maneja reservas de hotel utilizando las listas dobles, donde es necesario
     * agregar funciones para:
     * 
     * 1. Agregar
     * 2. Eliminar
     * 3. Buscar Reservas
     * 
     * Asi como navegar a través de ellas, simulando el sistema de gestion de reservas real
     * 
     * 
     * FUNCIONALIDADES IMPORTANTES:
     * 
     * ° Agregar y eliminar reservas
     * ° Navegar entre reservas actuales y pasadas
     * ° Buscar reservas especificas por nombre de cliente
     * 
     * TAREAS
     * 
     * ° Implementar la lista doble para gestionar las reservas
     * ° Crear un menu para realizar operaciones de reserva
     * 
     */
}