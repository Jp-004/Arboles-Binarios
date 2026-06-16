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
        return tieneNegativo(this.raiz);
    }

    private boolean tieneNegativo(Nodo nodo) {
        if (nodo == null) {
            return false;
        }
        return nodo.getValor() < 0 || tieneNegativo(nodo.getIzquierdo()) || tieneNegativo(nodo.getDerecho());
    }

    /* ====================================================================
     * EJERCICIO 2: Retornar una lista con los valores en recorrido InOrder.
     * ==================================================================== */
    public List<Integer> obtenerInorder() {
        List lista = new ArrayList<Integer>();
        
        obtenerInorder(this.raiz, lista);

        return lista;
    }

    private void obtenerInorder(Nodo nodo, List<Integer> lista) {
        if (nodo == null) {
            return;
        }

        obtenerInorder(nodo.getIzquierdo(), lista);

        lista.add(nodo.getValor());

        obtenerInorder(nodo.getDerecho(), lista);
    }
    /* ====================================================================
     * EJERCICIO 3: Contar y retornar la cantidad de nodos HOJA.
     * ==================================================================== */
    public int contarHojas() {
        
        int hojas = contarHojas(this.raiz);

        return hojas;
    }

    private int contarHojas(Nodo nodo) {
        if(nodo == null) {
            return 0;
        } else if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
            return 1;
        } else {
            return contarHojas(nodo.getIzquierdo()) + contarHojas(nodo.getDerecho());
        }
    }

    /* ====================================================================
     * EJERCICIO 4: Retornar true si el árbol cumple las reglas de un BST.
     * ==================================================================== */
    public boolean esBST() {
        return esBST(this.raiz, null, null);
    }

    private boolean esBST(Nodo nodo, Integer min, Integer max) { 
        if (nodo == null) {
            return true;
        }

        if (min != null && nodo.getValor() <= min) {
            return false;
        }

        if (max != null && nodo.getValor() >= max) {
            return false;
        }

        return esBST(nodo.getIzquierdo(), min, nodo.getValor()) && esBST(nodo.getDerecho(), nodo.getValor(), max);
    }

    /* ====================================================================
     * EJERCICIO 5: Calcular la altura del árbol.
     * (Árbol vacío = 0, Árbol con solo raíz = 1)
     * ==================================================================== */
    public int altura() {
        return altura(this.raiz);
    }

    private int altura(Nodo nodo) {
        if(nodo == null) {
            return 0;
        }

        int alturaIzq = altura(nodo.getIzquierdo());
        int alturaDer = altura(nodo.getDerecho());

        return 1 + Math.max(alturaIzq, alturaDer);
    }
}