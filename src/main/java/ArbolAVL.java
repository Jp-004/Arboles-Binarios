
public class ArbolAVL {

    /* ====================================================================
     * EJERCICIO 1: Obtener la altura de un nodo de forma segura.
     * Si el nodo es null, su altura es 0. Si no, retorna su atributo altura.
     * ==================================================================== */
    public int obtenerAltura(NodoAVL nodo) {
        // TODO: Tu código aquí
        return -1; 
    }

    /* ====================================================================
     * EJERCICIO 2: Calcular el Factor de Balance.
     * Fórmula: Altura(Hijo Izquierdo) - Altura(Hijo Derecho)
     * ==================================================================== */
    public int factorBalance(NodoAVL nodo) {
        // TODO: Tu código aquí
        return -1;
    }

    /* ====================================================================
     * EJERCICIO 3: Rotación Simple a la Derecha.
     * 'y' es la raíz desbalanceada. Su hijo izquierdo ('x') pasará a ser
     * la nueva raíz. Retorna la nueva raíz ('x').
     * ==================================================================== */
    public NodoAVL rotacionDerecha(NodoAVL y) {
        // TODO: Tu código aquí
        // 1. Guardar las referencias necesarias (x y el subárbol derecho de x)
        // 2. Hacer los nuevos enlaces (x apunta a y, y adopta el subárbol)
        // 3. ¡Actualizar las alturas de 'y' y luego de 'x'!
        // 4. Retornar 'x'
        return null;
    }

    /* ====================================================================
     * EJERCICIO 4: Rotación Simple a la Izquierda.
     * 'x' es la raíz desbalanceada. Su hijo derecho ('y') pasará a ser
     * la nueva raíz. Retorna la nueva raíz ('y').
     * ==================================================================== */
    public NodoAVL rotacionIzquierda(NodoAVL x) {
        // TODO: Tu código aquí
        // Es exactamente el inverso al Ejercicio 3
        return null;
    }
}