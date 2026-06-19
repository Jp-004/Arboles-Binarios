
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

    /* ====================================================================
     * EJERCICIO 5: Buscar si existe un valor en el árbol.
     * (Aprovechá la propiedad del BST: menores a la izq, mayores a la der)
     * ==================================================================== */
    public boolean existe(NodoAVL nodo, int valorBuscado) {
        if (nodo == null) {
            return false;
        }

        if (nodo.getValor() == valorBuscado) {
            return true;
        } else if (nodo.getValor() > valorBuscado) {
            return existe(nodo.getIzquierdo(), valorBuscado);
        } else {
            return existe(nodo.getDerecho(), valorBuscado);
        }
    }

    /* ====================================================================
     * EJERCICIO 6: Encontrar el valor MÍNIMO del árbol.
     * Pista: ¿Hacia dónde tenés que viajar para encontrar lo más chico?
     * ==================================================================== */
    public Integer obtenerMinimo(NodoAVL nodo) {
        if (nodo == null) {
            return null;
        }

        if (nodo.getIzquierdo() == null) {
            return nodo.getValor();
        }

        return obtenerMinimo(nodo.getIzquierdo());
    }

    /* ====================================================================
     * EJERCICIO 7: EL JEFE FINAL - Insertar un valor manteniendo el AVL.
     * ==================================================================== */
    public NodoAVL insertar(NodoAVL nodo, int valor) {
        // 1. Inserción normal de BST (Caso base y recursión)
        if (nodo == null) {
            return new NodoAVL(valor); 
        }

        if (valor < nodo.getValor()) {
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setDerecho(insertar(nodo.getDerecho(), valor));
        } else {
            return nodo; // Si el valor ya existe, no hacemos nada (sin duplicados)
        }

        // 2. Actualizar altura del nodo actual
        nodo.setAltura(1 + Math.max(obtenerAltura(nodo.getIzquierdo()), obtenerAltura(nodo.getDerecho())));

        // 3. Calcular el factor de balance de este nodo
        int balance = factorBalance(nodo);

        // 4. Evaluar los 4 casos de desbalance y aplicar rotaciones
        if (balance > 1 && valor < nodo.getIzquierdo().getValor()) {
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && valor > nodo.getDerecho().getValor()) {
            return rotacionIzquierda(nodo);
        }

        if (balance > 1 && valor > nodo.getIzquierdo().getValor()) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && valor < nodo.getDerecho().getValor()) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }
        
        return nodo;
    }
}