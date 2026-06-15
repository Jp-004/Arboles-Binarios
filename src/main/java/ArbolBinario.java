import java.util.ArrayList;
import java.util.List;

public class ArbolBinario {
    
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // Constructor rápido para los tests
    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return this.raiz;
    }

    /* ====================================================================
     * EJERCICIO 1: Retornar true si existe al menos un valor negativo.
     * ==================================================================== */
    public boolean tieneNegativo() {
        // TODO: Tu código aquí (te sugiero llamar a un método privado recursivo)
        return false; 
    }

    /* ====================================================================
     * EJERCICIO 2: Retornar una lista con los valores en recorrido InOrder.
     * ==================================================================== */
    public List<Integer> obtenerInorder() {
        // TODO: Tu código aquí
        return new ArrayList<>(); 
    }

    /* ====================================================================
     * EJERCICIO 3: Contar y retornar la cantidad de nodos HOJA.
     * ==================================================================== */
    public int contarHojas() {
        // TODO: Tu código aquí
        return 0;
    }

    /* ====================================================================
     * EJERCICIO 4: Retornar true si el árbol cumple las reglas de un BST.
     * ==================================================================== */
    public boolean esBST() {
        // TODO: Tu código aquí
        return false;
    }

    /* ====================================================================
     * EJERCICIO 5: Calcular la altura del árbol.
     * (Árbol vacío = 0, Árbol con solo raíz = 1)
     * ==================================================================== */
    public int altura() {
        // TODO: Tu código aquí
        return 0;
    }
}