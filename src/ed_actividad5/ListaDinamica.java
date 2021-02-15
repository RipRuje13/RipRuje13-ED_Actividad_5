package ed_actividad5;

/**
 *
 * @author Noriega
 */
public class ListaDinamica<T> {

    //Atributos
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamano;

    public ListaDinamica() {
        primero = null;
        ultimo = null;
        tamano = 0;
    }

    public boolean isEmpty() {
        return tamano == 0;
    }

    public int size() {
        return tamano;
    }
    
    //Devuelve el elemento en la posicion indicada
    public T get(int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return getPrimero(); //toma el primero
        } else if (index == size() - 1) {
            return getUltimo(); //toma el ultimo
        } else {

            //Uso la funcion getNode para tomar el nodo deseado
            Nodo<T> buscado = getNodo(index);

            return buscado.getElemento();

        }

    }

    //Devuelve el primer elemento, null si esta vacia la lista
    public T getPrimero() {
        //Si esta vacia, no hay primero que tomar
        if (isEmpty()) {
            return null;
        } else {
            return primero.getElemento();
        }
    }

    //Devuelve el ultimo elemento, null si esta vacia la lista
    public T getUltimo() {
        //Si esta vacia, no hay ultimo que tomar
        if (isEmpty()) {
            return null;
        } else {
            return ultimo.getElemento();
        }
    }

     //Devuelve el nodo completo de una posicion concreta
    private Nodo<T> getNodo(int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return primero; //devuelve el primero
        } else if (index == size() - 1) {
            return ultimo; //devuelve el ultimo
        } else {

            Nodo<T> buscado = primero;

            //Busco el nodo deseado con un recorrido
            int contador = 0;
            while (contador < index) {
                contador++;
                buscado = buscado.getSiguiente();
            }

            //Me devuelve el buscado
            return buscado;

        }

    }

    //Añade un elemento al final de la lista
    public T agregaUlt(T elemento) {

        Nodo<T> aux;

        //Si esta vacia, hago lo mismo que si fuera añadir el primero
        if (isEmpty()) {
            return agregaPrim(elemento);
        } else {

            //Hago el intercambio
            aux = new Nodo<>(elemento, null);

            ultimo.setSiguiente(aux);
            ultimo = aux;

        }

        //Aumento el tamanño
        tamano++;
        return ultimo.getElemento();

    }

    // Añade el elemento al principio de la lista
    public T agregaPrim(T elemento) {

        Nodo<T> aux;

        //si esta vacia, el nodo será el primero y ultimo
        if (isEmpty()) {
            aux = new Nodo<>(elemento, null);
            primero = aux;
            ultimo = aux;
        } else {
            //Hago el intercambio
            Nodo<T> primeroActual = primero;
            aux = new Nodo<>(elemento, primeroActual);
            primero = aux;

        }

        //Aumento el tamanño
        tamano++;
        return primero.getElemento();

    }

    // Añade un elemento en una posicion indicada
    public T agrega(T elemento, int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (index == 0) {
            return agregaPrim(elemento); //Añade en la primera posicion
        } else if (index == size()) {
            return agregaUlt(elemento); //añade en la ultima posicion
        } else if ((index < 0 || index >= size())) {
            return null;
        } else {

            //toma el anterior nodo al que se esta buscando
            Nodo<T> buscado_anterior = getNodo(index - 1);

            //toma el nodo de la posicion indicada
            Nodo<T> buscado_actual = getNodo(index);

            //Creo el nuevo nodo, este apuntara al de la posicion actual
            Nodo<T> aux = new Nodo<>(elemento, buscado_actual);

            //el nodo anterior apunta al nuevo nodo
            buscado_anterior.setSiguiente(aux);

            //Aumento el tamaño
            tamano++;
            return getNodo(index).getElemento();

        }

    }

     //Devuelve el estado de la lista
    public String toString() {

        String contenido = "";

        //Si esta vacia, lo indica
        if (isEmpty()) {
            contenido = "Lista vacia";
        } else {

            Nodo<T> aux = primero;

            //Recorre la lista, mostrando el contenido
            while (aux != null) {
                contenido += aux.toString();
                aux = aux.getSiguiente();
            }

        }

        return contenido;

    }

    //Indica si existe el elemento indicado
    public boolean existe(T elemento) {

        //Si esta vacio, devuelve el false
        if (isEmpty()) {
            return false;
        } else {

            Nodo<T> aux = primero;

            //Recorremos la lista
            while (aux != null) {
                if (elemento.equals(aux.getElemento())) {
                    return true; //Existe
                }
                aux = aux.getSiguiente();
            }

            //Si no lo encuentra devuelve false
            return false;

        }
    }

    // Indica la posición del elemento
    public int posElem(T elemento) {

        //Si esta vacio, devuelvemos -1
        if (isEmpty()) {
            return -1;
        } else {

            Nodo<T> aux = primero;

            int posicion = 0;
            while (aux != null) {
                if (elemento.equals(aux.getElemento())) {
                    return posicion; //Existe
                }
                posicion++;
                aux = aux.getSiguiente();
            }
            //Si no lo encuentra devuelve -1
            return -1;

        }

    }

     // Elimina el primer elemento de la lista
    public T eliminaPrim() {

        //Si la lista esta vacia, devolvemos null
        if (isEmpty()) {
            return null;
        } else {

            //Guarda el elemento anterior
            T elemento = primero.getElemento();

            //toma el segundo
            Nodo<T> aux = primero.getSiguiente();
            primero = null; //Lo marco como null para el recolector
            primero = aux; //Este es el nuevo primero

            //En caso de que borre el ultimo elemento,el ultimo también
            if (size() == 1) {
                ultimo = null;
            }

            tamano--;

            return elemento;

        }

    }

     // Borra el ultimo elemento de la lista
    public T eliminaUlt() {

        if (isEmpty()) {
            return null;
        } else {

            //toma el elemento antes de borrar
            T elemento = ultimo.getElemento();

            //toma el penultimo
            Nodo<T> aux = getNodo(size() - 2);

            //En caso de que sea null
            //Hay 1 o dos elementos
            if (aux == null) {

                //marco el ultimo como null
                ultimo = null;
                //Si hay dos, el primero y el ultimo seran el mismo
                //Si hay 1 elemento, significa que borramos la lista
                if (size() == 2) {
                    ultimo = primero;
                } else {
                    primero = null;
                }

            } else {
                //el penultimo es el nuevo ultimo 
                //y le ponemos como siguiente nulo
                ultimo = null;
                ultimo = aux;
                ultimo.setSiguiente(null);
            }

            tamano--;

            return elemento;

        }

    }

    // Elimina el nodo de la lista en una posicion dada
    public T eliminaPos(int index) {
        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return eliminaPrim();
        } else if (index == size() - 1) {
            return eliminaUlt();
        } else {

            //toma el nodo anterior al que quiere borrar
            Nodo<T> nodo_anterior = getNodo(index - 1);

            //toma el nodo que quiero borrar
            Nodo<T> nodo_actual = getNodo(index);

            //toma el elemento antes de borrar
            T elemento = nodo_actual.getElemento();

            //toma el nodo siguiente al que quiere borrar
            Nodo<T> nodo_siguiente = nodo_actual.getSiguiente();

            //Lo marca para borrar para el recolector
            nodo_actual = null;

            //El nodo anterior apunta al nodo siguiente
            nodo_anterior.setSiguiente(nodo_siguiente);

            tamano--;

            return elemento;

        }
    }
}
