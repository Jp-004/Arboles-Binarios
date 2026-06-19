public class NodoAVL {
    private int valor;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;

    public NodoAVL(int valor) {
        this.valor = valor;
        this.altura = 1; // Un nodo nuevo siempre arranca con altura 1
        this.izquierdo = null;
        this.derecho = null;
    }

    public int getValor() { 
        return valor; 
    }

    public void setValor(int valor) { 
        this.valor = valor; 
    }

    public int getAltura() { 
        return altura; 
    }

    public void setAltura(int altura) { 
        this.altura = altura; 
    }

    public NodoAVL getIzquierdo() { 
        return izquierdo; 
    }

    public void setIzquierdo(NodoAVL izquierdo) { 
        this.izquierdo = izquierdo; 
    }

    public NodoAVL getDerecho() { 
        return derecho; 
    }

    public void setDerecho(NodoAVL derecho) { 
        this.derecho = derecho; 
    }
}