
public class ArbolAVL {

    /* ====================================================================
     * EJERCICIO 1: Obtener la altura de un nodo de forma segura.
     * Si el nodo es null, su altura es 0. Si no, retorna su atributo altura.
     * ==================================================================== */
    public int obtenerAltura(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }

        return nodo.getAltura();
    }

    /* ====================================================================
     * EJERCICIO 2: Calcular el Factor de Balance.
     * Fórmula: Altura(Hijo Izquierdo) - Altura(Hijo Derecho)
     * ==================================================================== */
    public int factorBalance(NodoAVL nodo) {
        return obtenerAltura(nodo.getIzquierdo()) - obtenerAltura(nodo.getDerecho());
    }

    /* ====================================================================
     * EJERCICIO 3: Rotación Simple a la Derecha.
     * 'y' es la raíz desbalanceada. Su hijo izquierdo ('x') pasará a ser
     * la nueva raíz. Retorna la nueva raíz ('x').
     * ==================================================================== */
    public NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.getIzquierdo();
        NodoAVL T2 = x.getDerecho();

        x.setDerecho(y);
        y.setIzquierdo(T2);

        y.setAltura(1 + Math.max(obtenerAltura(y.getIzquierdo()), obtenerAltura(y.getDerecho())));
        x.setAltura(1 + Math.max(obtenerAltura(x.getIzquierdo()), obtenerAltura(x.getDerecho())));
        return x;
    }

    /* ====================================================================
     * EJERCICIO 4: Rotación Simple a la Izquierda.
     * 'x' es la raíz desbalanceada. Su hijo derecho ('y') pasará a ser
     * la nueva raíz. Retorna la nueva raíz ('y').
     * ==================================================================== */
    public NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.getDerecho();
        NodoAVL T1 = y.getIzquierdo();

        y.setIzquierdo(x);
        x.setDerecho(T1);

        x.setAltura(1 + Math.max(obtenerAltura(x.getIzquierdo()), obtenerAltura(x.getDerecho())));
        y.setAltura(1 + Math.max(obtenerAltura(y.getIzquierdo()), obtenerAltura(y.getDerecho())));

        return y;
    }
}