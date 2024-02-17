package listadoblementeenlazada.co.edu.upb;

import java.util.ArrayList;

public class ListaDobleEnlazada <T> implements Lista<T>{
	private Nodo<T> cabeza;//Inicializamos cabeza que representa o es la cabeza de la lista, este nombre puede variar el nombre de la variable
	private Nodo<T> cola;//Este campo representa el ultimo nodo de la lista
	private int tamano;//Y importante tamanio funciona como un contador que almacenara el tamanio actual de la lista
	

	public ListaDobleEnlazada(Nodo<T> cabeza, Nodo<T> cola, int tamano) {//El constructor de esta clase acepta o obtiene los 3 parametros el primer nodo que en este caso seria la cabeza
		super();//el ultimo la cola y el tamanio y estos parametros o variables las inicializamoss en null o 0 ya que los valores que se pasan obtienen o establecen que se pasen al constructors
		this.cabeza = null;//tam bien sirve para que explicitamente no haya ningun nodo enlazado inicialmente, indicando una lista vacia. Esto inicializa la lista estableciendo la cabeza como nula indicando que esta vacia
		//al principio igual para la cola y para el tamanio 
		this.cola = null;
		this.tamano = 0;
	}
	//_______________________________________________
	//METODO PARA AGREGAR AL INICIO DE LA LISTA
	@Override
	public void agregarAlInicio(T valor) {
		Nodo<T> nuevoNodo = new Nodo<>(valor, cabeza, null);//Inicializamos nuestro nodo en la cabeza
		//donde valor es el valor que se almacenara en el nuevo nodo, cabeza donde se establece la cabeza
		//como el siguiente nodo del nuevo nodo y null que como nodo anterior del nuevo nodo ya que este nuevo
		//sera el primer nodo de la lista por lo tanto no debe tener un anterior
		if(cabeza != null) {//Revisa si la cabeza es diferente de nula entonces si la cabeza contiene un valor
			cabeza.setAnterior(nuevoNodo);//lo que hace la condicion es establecer la cabeza como el anterior con el nuevoNodo
			//volviendolo el primero
		}
		cabeza = nuevoNodo;//Si no cumple con la condicion de que cabeza sea diferente del null la cabeza se volvera el nuevoNodo que inicializamos arriba
		if(cola == null) {//y si la condicion dice que la cola de nuestro nodo es nula el nuevoNodo a la vez se volvera la cabeza y la cola
			cola=nuevoNodo;//Como funciona esto entonces simplemente si la lista esta de la siguiente manera 00000 entonces agregamos el nuevo nodo y queda su representacion
			//por ejemplo 10000 los 0 no representan nada el 1 que contiene un valor entonces lo que hace es asignar ese unico valor que asignamos al inicio como cabeza y cola 
		}
		tamano++;//y se va aumentando su tamano de 1 en 1 
	}
	//____________________________________________________________
	//METODO APRA AGREGAR AL FINAL DE LA LISTA
	@Override
	public void agregarAlFinal(T valor) {
		Nodo<T> nuevoNodo=new Nodo<>(valor, null, cola);//Inicializamos nuestro nodo con valor y cola pero siguiente en este caso null y porque? para cumplir con
		//la condicion de crear un nuevo nodo y enlazarlo con el nodo cola si es que existe como su anterior y establecer null como su siguiente ya que sera la cola
		//misma logica para el anterior metodo
		if(cola!=null) {//Condicion que revisa si la cola es diferente de nula para implementar codigo dentro de esta condicion
			cola.setSiguiente(nuevoNodo);//donde hacemos un llamado por medio de cola que establecera su nuevo valor como el siguiente del nuevo nodo
		}
		cola = nuevoNodo;//Su funcionalidad es que la cola se vuelva el NuevoNodo se establezca como el ultimo nodo de la lista
		//es decir actualizar la referencia a cola y que apuntara al nuevo nodo que se ha agregado al final de la lista y usamos esto para mantener actualizada la referencia al ultimo nodo
		if(cabeza==null) {//Si cumple con la condicion de que la cabeza sea nulo 
			cabeza=nuevoNodo;//La cabeza se volvera el nuevo nodo  lo que hace su funcionalidad es decirnos o agregar algo en cabeza ya que si la cabeza es nula no tendra cola
			//el primer elemento de una lista es a cabeza Ejemplo: 000010000 no importa cuantos 0 tenga su cabeza y cola es el primer uno y unico pero si no tiene no tendra cabeza u cola
		}
		tamano++;//Y aumenta el tamano de la lista de 1 en 1 para mantener actualizada la variable de tamano

	}
	//____________________________________________________________
	//METODO PARA INSERTAR EN MEDIO O POR INDICE
	@Override
	public void insertarEnMedio(int indice, T valor) {
		Nodo<T> nodoActual = cabeza; //Inicializamos el nodo Actual como la cabeza

		if(indice < 0 || indice > tamano) {//Creamos una condicion que valide si el indice esta dentro del rango 
			//recordar que el indice si es mayor que el tamano sera un error
			throw new IndexOutOfBoundsException();
		}
		if(indice == 0) {//Condicion donde si indice es igual a 0 pues se agregara un nuevo valor en la cabeza de la lista
			agregarAlInicio(valor);//invocamos el metodo de esta clase de agregar al inicio optimizando recursos
		}
		else if(indice == tamano) {//si el indice es igual al tamano es decir que estaria en el ultimo nodo de la lista
			agregarAlFinal(valor);//Invocamos el metodo de esta clase
		}
		else {
			//creamos un for  que podra avanzar hasta la posicion anterior a la que queremos para agregar un nodo
			//para luego volver ese nodo y asignarle la posicion del nodo que existia anteriormente estableciendo las conexiones
			for(int ii=0;ii<indice-1;ii++) {
				nodoActual = nodoActual.getSiguiente();//El nodo actual se volvera el nodo del siguiente obteniendo el nodo y estableciendo
				//la conexion con el que existia antes en esa posicion
			}
			//luego del for de estar parados en la posicion del nodo que deseabamos se crea el nuevo nodo con el valor que queremos
			Nodo<T> nodoDeRemplazo = new Nodo<>(valor);
			//Esto hace referencia a que estamos creando un nuevo objeto de tipo nodo que tiene como parametro el generico T significando que
			//el nodo puede contener cualquier tipo de dato y el nodoDeRemplazo es el nombre de la variable que puede cambiar que estamos declarando
			//para hacer referencia del nuevo nodo que queremos crear, new Nodo<>(valor) se crea el nuevo nodo y se hace una llamada al constructor de la clase
			//nodo donde el valor es el parametro que deseamos pasar

			nodoDeRemplazo.setSiguiente(nodoActual.getSiguiente());//Hacemos las referencias u enlaces del nuevo nodo
			nodoDeRemplazo.setAnterior(nodoActual);
			//luego las referencias de los nodos al nuevo nodo se actualizan
			nodoActual.getSiguiente().setAnterior(nodoDeRemplazo);
			nodoActual.setSiguiente(nodoDeRemplazo);

			tamano++; //Se aumenta el tamanio de 1 en 1 ya que solamente hemos agregado 1 nodo nuevo con un valor nuevo
		}
	}
	//____________________________________________________________
	//METODO ELIMINAR DEL INICIO
	@Override
	public T eliminarDelInicio() {
		//Implementamos invocando el metodo de si esta vacia ara revisar la lista esta vacia
		//cumpliendo como se debe en lo requerido por el usuario 
		if(estaVacia()) {//Si la lista esta vacia pues que vamos a eliminar
			return null;//Retorna nulo
		}
		//luego obtenemos el valor que se desea eliminar en este caso la cabeza 
		T valor = cabeza.getValor();//Obtenemos el valor de cabeza y lo metemos en el generico de valor que puede almacenar cualquier tipo
		//integer o string
		//la cabeza no puede ser nula ya que el primer elemento de una lista es la cabeza y si no hay primer elemento no hay nada que borrar eso quiere
		//decir que si no hay primer elemento en una lista no hay nada 
		if(cabeza != null) {//Si la cabeza es diferente de nula
			cabeza.setAnterior(null);//cabeza establece el valor como anterior cortando los enlaces con el siguiente ya que se vuelve un nulo
		}else {
			//ahora si , si la cabeza es nula la cola tambien sera nula
			cola = null;//Porque no hay valores
		}
		//se actualiza el tamanio de la lista con el --
		tamano--;
		return valor; //retorna el valor del nodo que se elimino lo que
		//es importante para una operacion con el valor eliminado o saber fines de 
		//control o registro en un nivel mas grande de programa saber que se elimino
		//como que valor de usuario que valor de cantidad de productos en un inventario

	}
	//____________________________________________________________
	//METODO ELIMINAR DEL FINAL 
	@Override
	public T eliminarDelFinal() {
		//Varifica si la lista esta vacia implementamos una misma logica para este metodo como el de 
		//eliminar de inicio pero la inversa que seria en la cola
		if(estaVacia()) {
			return null; //No existen elementos
		}T valor = cola.getValor();// Obtenemos el valor de la cola y se lo asignamos a la nueva variable cola que espera
		//un generico es decir cualquier dato
		cola = cola.getAnterior(); // la cola se vuelve la cola obtenida del anterior nodo actualizando la cola al nodo anterior al ultimo nodo
		//que quiere decir esto? la nueva cola se volvera el nodo que estaba anterior de la ultima cola 

		if(cola == null) {
			cabeza=null;//Sencillo si la cola es una nula la cabeza tambien se vuelve nula
			//esto quiere decir que si tenemos una lista 000000 y la cola seria el ultimo 0 tambien la cabeza sera 0
			//y como funciona esto realmente pues que si solo existe un elemento es decir 00100 no importa su posicion este sera tanto cabeza como cola
		}else {
			//si la cola es diferente de nula, terminamos de completar u establecer su nuevo siguiente ultimo nodo
			cola.setSiguiente(null);//Esto lo que hace es establecer un valor o cortar los enlaces que tiene el siguiente nodo
			//que anterior a la actual cola antes de la implementacion de cola = cola.getAnterior(); ese siguiente era la cola pero ahora el anterior de ese es la cola
			//y su siguiente se volvera nada es decir 00111100 el cuarto 1 almacenado en una variable se actualiza esa variable y donde ahora sera el anterior 
			//a la cola y el siguiente se eliminara quedando solamente un 0011100 
		}
		tamano--;//actualizamos el tamanio de la lista
		return valor;//y retornamos el valor del nodo eliminado en este caso el que era la cola
	}
	//____________________________________________________________
	//METODO PARA ELIMINAR DEL MEDIO O INDICE
	@Override
	public T eliminarDelMedio(int indice) {
		Nodo<T> nodoActual = cabeza; //Inicializamos la cabeza en una variable de nodoActual
		if(indice <0 || indice >= tamano) {
			throw new IndexOutOfBoundsException();
		}
		if(indice==0) {
			return eliminarDelInicio();//Si la condicion del indice es 0 es decir es la cabeza invocamos el metodo de eliminarDeINICIO()
		}
		else if(indice == tamano -1) {
			return eliminarDelFinal(); //si el indice es el ultimo invocamos el metodo de eliminar del final por que -1 y no solamente igual al tamanio recordemos que nuestra lista se representa de la siguiente 
			// manera 01234 donde 0 es 1 y asi sucesivamente entonces en tamanio real tiene un espacio de 5 pero el 0 no lo cuenta
			//realmente entonces lo que hace es retroceder uno para poder pararse en 4 y eliminar ese que seria la cola realmente
		}
		else {
			for(int ii=0;ii<indice-1;ii++) {
				nodoActual = nodoActual.getSiguiente();//Iteramos en un for hasta posicionarnos uno anterior al nodo que deseamos para poder
				//obtener el siguiente y pasarlo a nuestro nodo actual
			}
			T valorEliminado = nodoActual.getSiguiente().getValor(); //creamos una variable
			//generica que almacenara el nodo que eliminemos donde invocamos nodo actual obteniendo su siguiente y su valor que almacenaremos en valor
			//eliminado
			nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente());//Establecemos el siguiente del nodo actual
			//nodo actual se establece obteniendo el siguiente nodo del siguiente cortando relaciones con el que eliminaremos
			//finalmente
			nodoActual.getSiguiente().setAnterior(nodoActual);
			//Se obtiene el siguiente y establecemos el anterior como nodoActual
			/**
			 * 1. QUE PASA REALMENTE EN LA LINEA 174 PUES nodoActual.getSiguiente() obtiene el siguiente nodo del nodoActual
			 * entonces el nodoActual se presenta como el nodo antes del nodo que se elimina y se establece con el .setAnterior
			 * (nodoActual) cuando se establece ese enlace anterior del siguiente nodo al nodoActual y entonces el siguiente nodo del eliminado
			 * es decir salta dos veces tenga la referencia u conexion con el anterior
			 * 
			 * 2. Y EN LA LINEA DE nodoActual.getSiguiente() esa parte obtiene el siguiente nodo del Actual y pues nodo actual como se
			 * dijo anteriormente es el que esta antes del que queremos borrar
			 * de nuevo .getSiguiente es para llamar al siguiente del que sera eliminado esto establece la conexion que hay entre el anterior al que 
			 * queremos eliminar y el siguiente del que queremos eliminar dejando al que sera eliminado solo sin relacion
			 * y .getSiguiente dos veces obtiene el nodo siguiente del siguiente del que sera eliminado 
			 * y ya set para establecer los enlaces y listo
			 */

			tamano--;//se disminuye el tamanio porque hemos eliminado un nodo con su valor
			return valorEliminado;//Se retorna el valor del nodo que eliminamos anteriormente
		}
	}
	//____________________________________________________________
	//METODO PARA OBTENER EL VALOR POR MEDIO DE UN INDICE
	@Override
	public T find(int indice) {
		Nodo<T> nodoActual = cabeza; //Se inicializa el nodoActual en la cabeza
		if(indice < 0 || indice >= tamano) {//Tenemos una condicion donde si el indice indicado por el usuario donde desea saber el valor que contiene
			//el nodo es menor 0 se complica buscar un valor que se encuentre de forma negativa en la lista 
			//y si el indice es mayor que el tamanio pues se sale de los parametros y de donde sale tamanio esto
			//depende de las iteraciones anteriores agregar, eliminar etc donde se actualiza cada vez el tamanio y se actualiza
			//en el metodo de saber el tamanio de nuestra lista
			throw new IndexOutOfBoundsException();//PAILA ERROR INDICE FUERA DE RANGO

		}//ACA PUEDE EXISTIR UNA PERDIDA PERO RECORDEMOS QUE EL TAMANO LO INICIALIZAMOS ARRIBA EN 0
		//ENTONCES POR ESO FUNCIONARA CON QUE TIENE QUE SER MENOR AL TAMNO ORIGINAL YA QUE
		//IMAGINEMOS QUE NUESTRA LISTA ESTA COMPUESTA DE LA SIGUIENTE FORMA 
		//0123456
		//Y DESEAMOS BUSCAR POR INDICE EL 6 ENTONCES ES MENOR QUE EL TAMANIO CLARO
		//Y NOS RETORNARA EL VALOR DE LA SECCION 6 QUE EXISTE PERO SI SOLICITAMOS 7
		//AUNQUE EXISTE SI CONTAMOS 
		//0123456
		//1234567 PUES EL 7 EXISTE PERO REALMENTE SU SIGUIENTE SU VALOR SU NODO NO EXISTE YA QUE VAN
		//DE 0123456

		for(int ii=0; ii<indice;ii++) {//Creamos un iterador for donde la lista vaya hasta alcanzar el nodo en la posicion indicada
			//por el indice esto quiere decir que se detendra hasta la parte de estar parada 1 antes sobre el indice que deseamos
			nodoActual=nodoActual.getSiguiente();//Esto quiere decir que  nodoActual ahora contendra el valor de la obtencion del nodo
			//siguiente posisionandonos de esta forma en el que deseamos por medio del indice 
		}

		return nodoActual.getValor(); //retornamos obteniendo el valor del nodoActual es decir donde nos encontramos
	}
	//____________________________________________________________
	//METODO QUE REVISA SI EL METODO ESTA VACIO
	@Override
	public boolean estaVacia() {//Metodo que sirve para saber si nuestra lista
		//esta vacia o no esperando de retorno un boolean que sea true si esta vacia
		//y false si no
		if(tamano== 0 ) {//primera condicion me dice si el tamanio es 0 entonces quiere 
			//decir que no contiene elementos entonces me retornara un true , de que esta 
			//vacia
			System.out.println("Vacia");
			return true;
		}else {//Si no cumple con la anterior condicion simplemente retorna el false
			//de que si esta o contiene la lista al menos con un elemento retornara false
			//de que no esta vacio
			System.out.println("Elementos");
			return false;
		}
	}
	//____________________________________________________________
	//METODO PARA SABER EL TAMANIO DE LA LISTA
	@Override
	public int tamanio() {
		return tamano;//Lo que hace es retornar la cantidad o los valores que tenga la variable
		//tamano en esta clase que contiene cuantos nodos u valores en la lista existan por eso en cada
		//metodo al final de cada implementacion independientemente de agregar o eliminar un ++ o --
		//para mantener esa variable actualizada
	}
	//____________________________________________________________
	//METODO PARA MOSTRAR LA LISTA
	@Override
	public void mostrarLista() {
		Nodo<T> nodoActual = cabeza; //Comenzamos inicializando la variable de nodoActual en cabeza
		System.out.println(" Lista ");//Un sout sencillo que diga que es no afecta la logica
		while(nodoActual!= null) {//un while que solo se inicializa y muestra resultados o elementos si es diferente de nulo
			//el nodoActual que inicia por cabeza esto quiere decir que pues que el while solo se detiene hasta que no haya elementos por mostrar 
			//lo que hace el sout abajjo en la linea 118 es implimir el valor obteniendo el valor del nodo actual en la primera iteracion es la cabeza
			System.out.println(nodoActual.getValor() + " <--> ");//La cadena dentro del "" no afecta la logica solamente es algo que desee aplicar
			nodoActual = nodoActual.getSiguiente();//luego del sout y imprimir el primer valor el nodoActual obtiene el siguiente nodo y lo establece 
			//en el nodoActual y se obtiene su valor y imprime en la linea 118 y asi consecutivamente hasta que el siguiente que se vuelve el actual sea nulo
			//y asi se sale del while y hace un salto de linea 
		}
		System.out.println(" ");
	}
	//_______________________________________________
	//METODO TO STRING
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Nodo<T> nodoActual = cabeza;
		while (nodoActual != null) {
			sb.append(nodoActual.getValor());
			if (nodoActual.getSiguiente() != null) {
				sb.append(" -> ");
			}
			nodoActual = nodoActual.getSiguiente();
		}
		return sb.toString();
	}
	//_______________________________________________
	public ArrayList<T> obtenerElementos(){
		ArrayList<T> elementos = new ArrayList<>();
		Nodo<T> nodoActual = cabeza;
		while(nodoActual!=null) {
			elementos.add(nodoActual.getValor());
			nodoActual = nodoActual.getSiguiente();
		}
		return elementos;
	}
	/**
	 * TENGO UNA PREGUNTA PORQUE CON TRES * ME GENERA UN PARAM <T>?
	 * 
	 * EN FIN: ESTE METODO ESTA POR FUERA DE LA INTERFACE YA QUE NO HACE PARTE DEL CONTRATO
	 * O LO QUE DEBEMOS IMPLEMENTAR EN NUESTRO PROGRAMA POR ESA RAZON NO LO INCLUI SI 
	 * SEGUIMOS ESE ORDEN DE LOGICA ENTONCES COMO FUNCIONA ESTO? DE OBTENER ELEMENTOS SENCILLO
	 * CREAMOS UN ARRALIST QUE ALMACENARA GENERICOS QUE ALMMACENARA CUALQUIER TIPO DE DATO DEFI
	 * NIMOS EL NOMBRE DEL METODO OBTENERELEMENTOS Y ELL ARRALIST SE LLAMARA ELEMENTOS QUE ALMACEN
	 * ARA LOS ELEMENTOS DE LA LISTA DOBLEMENTE ENLAZADA LUEGO DE ESO SE INICIALIZA LA VARIABLE
	 * DEL NODOACTUAL EN LA CABEZA SIGUIENTE LA LOGICA DE NUESTROS OTROS METODOS EL WHILE SE DETENDRA
	 * HASTA QUE EL SIGUIENTE Y SE PARE ALLI SEA NULO Y RETORNARA LOS ELEMENTOS . UNA VEZ INICIADO EL RECORRIDO
	 * SE INICIA EL WHILE DONDE SE EJECUTA EL NODOACTUAL DIFERENTE DE NULO Y DENTRO DEL BUCLE VIENE LO IMPORTANTE
	 * PARA SABER EL ORDEN DE PRIORIDAD DE MIS ELEMENTOS EN EL NODO QUE ESTAN EN EL MAIN PUES LO QUE HACE ES
	 * ANADIR EL VALOR DEL NODO ACTUAL A LA LISTA ELEMENTOS USANDO EL METODO ADD Y QUE ESTA SE MUEVA AL SIGUIENTE
	 * NODO DE LA LISTA ASIGNANDO NODOACTUAL AL SIGUIENTE NODO OBTENIENDO MEDIANTE EL METODO DEL GETSIGUIENTE
	 * Y CUANDO SE RECORRE TODO PUES SIMPLEMENTE SE RETORNA EL ARRAYLIST DE ELEMENTOS QUE CONTIENE TODOS LOS ELEMENTOS
	 * DE LA LISTA ENLAZAA
	 * 
	 */
	
	//_______________________________________________
	//clase interna del nodo
	private static class Nodo<T>{ //Define la clase estatica interna que es un nodo que es generico en este caso T referente a que puede contener cualquier tipo de objeto, un integer,String etc
		T valor;//se declara la variable con nombre de valor de tipo generico para almacenar el valor del nodo que se obtendra u que pertenece a ese nodo que deseamos trabajar
		Nodo<T> siguiente;//Se declara la variable del siguiente con tipo Nodo que apunta al siguiente nodo en la lista la misma funcionalidad tiene anterior pero apunta al anterior nodo de la lista
		Nodo<T> anterior;
		public Nodo(T valor) {
			this(valor, null, null);//Este constructor inicializa el nodo con un valor dado y sin algo en el siguiente u anterior garantizando que cuando implementemos el programa iniciando este completamente vacia la lista
			//de nodos
		}
		public Nodo(T valor, Nodo<T> siguiente, Nodo<T> anterior) {//Este constructor sin embargo inicializa el nodo con valor dado y el nodo siguiente y anterior
			this.valor = valor;//donde sirve para asignar un valor pasando como argumento al campo en este caso valor de la instancia actual del nodo y el this referido a la instancia actual de esta clase, se usa para distinguir
			this.siguiente = siguiente;//entre el parametro es decir el valor del constructor y el campo del valor de la clase y asi con la misma funcionalidad o implementacion funcionan this.siguiente=siguiente y this.anterior=anterior
			this.anterior = anterior;
		}
		public T getValor() {//Obtiene el valor de ese generico con el que estemos trabajando
			return valor;//y lo devuelve, no existe un set valor porque no podemos establecer un valor en un nuevo nodo. bueno se puede pero es mejor usar un remplazo de valor de variable facilitando u optimizando el sistema o codigo
		}
		public Nodo<T> getSiguiente() {//Obtiene el siguiente nodo
			return siguiente;//y retornar el siguiente nodo obteniendolo
		}
		public void setSiguiente(Nodo<T> siguiente) {//Establece el siguiente nodo 
			this.siguiente = siguiente;//y retorna su valor con el this.siguiente = siguiente haciendo referencia al siguiente nodo de la lista de esta clase 
		}
		public Nodo<T> getAnterior() {//Misma funcionalidad o implementacion en esta parte del codigo que en el getSiguiente la unica diferencia es que es con el anterior nodo
			return anterior;//anterior al nodo actual donde nos encontremos
		}
		public void setAnterior(Nodo<T> anterior) {//Misma funcionalidad o implementacion que el set siguiente estableciendo su valor pero en este caso en el anterior nodo del actual
			this.anterior = anterior;
		}
	}

}
