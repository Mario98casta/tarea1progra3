public class Main {
    public static void main(String[] args) {

        ArbolBinario arbol = new ArbolBinario();

        arbol.insertarNodo(5);
        arbol.insertarNodo(2);
        arbol.insertarNodo(8);
        arbol.insertarNodo(1);
        arbol.insertarNodo(3);
        arbol.insertarNodo(7);


        System.out.print("Recorrido de Arbol Binario en Preorden: ");
        arbol.preorden();
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
    }

}

class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Inserta un valor en el árbol
    public void insertarNodo(int valor) {
        raiz = insertarRectificarNodo(raiz, valor);
    }

    // Función auxiliar para insertar un valor en el árbol si es mayor
    private Nodo insertarRectificarNodo(Nodo nodo, int valor) {
        if (nodo == null) {
            nodo = new Nodo(valor);
            return nodo;
        }

        if (valor < nodo.ValorNodo) {
            nodo.izquierdo = insertarRectificarNodo(nodo.izquierdo, valor);
        } else if (valor > nodo.ValorNodo) {
            nodo.derecho = insertarRectificarNodo(nodo.derecho, valor);
        }

        return nodo;
    }

    // Realiza un recorrido preorden del árbol
    public void preorden() {
        Validarpreorden(raiz);
    }

    // Función auxiliar para el recorrido preorden
    private void Validarpreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.ValorNodo + " ");
            Validarpreorden(nodo.izquierdo);
            Validarpreorden(nodo.derecho);
        }
    }
}

class Nodo {
    int ValorNodo;
    Nodo izquierdo, derecho;

    public Nodo(int ValorNodo) {
        this.ValorNodo = ValorNodo;
        izquierdo = null;
        derecho = null;
    }
}