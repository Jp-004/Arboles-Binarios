import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArbolAVLTest {

    private ArbolAVL arbol;

    @BeforeEach
    public void setUp() {
        arbol = new ArbolAVL();
    }

    @Test
    public void testObtenerAlturaYFactorBalance() {
        NodoAVL raiz = new NodoAVL(10);
        raiz.setAltura(3);
        
        NodoAVL izq = new NodoAVL(5);
        izq.setAltura(2); // Inclinado a la izquierda
        
        raiz.setIzquierdo(izq);

        assertEquals(0, arbol.obtenerAltura(null), "Un nodo nulo debe tener altura 0");
        assertEquals(3, arbol.obtenerAltura(raiz), "Debe devolver la altura del atributo");
        
        // Factor de balance de la raíz: Altura Izq (2) - Altura Der (0) = 2
        assertEquals(2, arbol.factorBalance(raiz), "El factor de balance debe ser 2 (desbalanceado a la izquierda)");
    }

    @Test
    public void testRotacionDerecha() {
        // Armamos un árbol degenerado hacia la izquierda (Línea recta: 30 -> 20 -> 10)
        NodoAVL n30 = new NodoAVL(30);
        NodoAVL n20 = new NodoAVL(20);
        NodoAVL n10 = new NodoAVL(10);

        n30.setIzquierdo(n20);
        n20.setIzquierdo(n10);

        // Simulamos las alturas antes de la rotación
        n10.setAltura(1);
        n20.setAltura(2);
        n30.setAltura(3);

        // Ejecutamos tu método de rotación sobre el nodo 30
        NodoAVL nuevaRaiz = arbol.rotacionDerecha(n30);

        // Verificaciones de punteros
        assertEquals(20, nuevaRaiz.getValor(), "El 20 debería haber subido a ser la nueva raíz");
        assertEquals(10, nuevaRaiz.getIzquierdo().getValor(), "El 10 debería seguir a la izquierda del 20");
        assertEquals(30, nuevaRaiz.getDerecho().getValor(), "El 30 debería haber bajado a la derecha del 20");

        // Verificaciones de actualización de alturas
        assertEquals(1, nuevaRaiz.getIzquierdo().getAltura(), "La altura del 10 debe ser 1");
        assertEquals(1, nuevaRaiz.getDerecho().getAltura(), "La altura del 30 debe ser 1");
        assertEquals(2, nuevaRaiz.getAltura(), "La altura del 20 (nueva raíz) debe ser 2");
    }

    @Test
    public void testRotacionIzquierda() {
        // Armamos un árbol degenerado hacia la derecha (Línea recta: 10 -> 20 -> 30)
        NodoAVL n10 = new NodoAVL(10);
        NodoAVL n20 = new NodoAVL(20);
        NodoAVL n30 = new NodoAVL(30);

        n10.setDerecho(n20);
        n20.setDerecho(n30);

        // Simulamos las alturas antes de la rotación
        n30.setAltura(1);
        n20.setAltura(2);
        n10.setAltura(3);

        // Ejecutamos tu método de rotación sobre el nodo 10
        NodoAVL nuevaRaiz = arbol.rotacionIzquierda(n10);

        // Verificaciones de punteros
        assertEquals(20, nuevaRaiz.getValor(), "El 20 debería haber subido a ser la nueva raíz");
        assertEquals(10, nuevaRaiz.getIzquierdo().getValor(), "El 10 debería haber bajado a la izquierda del 20");
        assertEquals(30, nuevaRaiz.getDerecho().getValor(), "El 30 debería seguir a la derecha del 20");

        // Verificaciones de actualización de alturas
        assertEquals(1, nuevaRaiz.getIzquierdo().getAltura(), "La altura del 10 debe ser 1");
        assertEquals(1, nuevaRaiz.getDerecho().getAltura(), "La altura del 30 debe ser 1");
        assertEquals(2, nuevaRaiz.getAltura(), "La altura del 20 (nueva raíz) debe ser 2");
    }

    @Test
    public void testExisteYObtenerMinimo() {
        // Armamos un mini BST manualmente para probar
        NodoAVL raiz = new NodoAVL(20);
        raiz.setIzquierdo(new NodoAVL(10));
        raiz.setDerecho(new NodoAVL(30));
        raiz.getIzquierdo().setIzquierdo(new NodoAVL(5));
        raiz.getIzquierdo().setDerecho(new NodoAVL(15));

        // Prueba de existencia
        assertTrue(arbol.existe(raiz, 15), "Debería encontrar el 15");
        assertTrue(arbol.existe(raiz, 20), "Debería encontrar la raíz (20)");
        assertFalse(arbol.existe(raiz, 99), "No debería encontrar el 99");

        // Prueba de mínimo
        assertEquals(5, arbol.obtenerMinimo(raiz), "El valor mínimo del árbol es 5");
        assertNull(arbol.obtenerMinimo(null), "El mínimo de un árbol vacío debería ser null");
    }

    @Test
    public void testInsertarAVL_RotacionSimple() {
        NodoAVL raiz = null;
        
        // Insertamos en orden descendente (provoca tobogán a la izquierda)
        raiz = arbol.insertar(raiz, 30);
        raiz = arbol.insertar(raiz, 20);
        raiz = arbol.insertar(raiz, 10); // ¡Acá debería dispararse la rotación a la derecha!

        // Verificamos que el 20 subió a la raíz
        assertEquals(20, raiz.getValor(), "La nueva raíz debería ser 20 tras la rotación");
        assertEquals(10, raiz.getIzquierdo().getValor(), "El hijo izquierdo debe ser 10");
        assertEquals(30, raiz.getDerecho().getValor(), "El hijo derecho debe ser 30");
    }

    @Test
    public void testInsertarAVL_RotacionDoble() {
        NodoAVL raiz = null;
        
        // Insertamos formando un "codo" (Izquierda-Derecha)
        raiz = arbol.insertar(raiz, 30);
        raiz = arbol.insertar(raiz, 10);
        raiz = arbol.insertar(raiz, 20); // ¡Acá debe haber rotación doble!

        // Verificamos que el árbol quedó perfectamente balanceado
        assertEquals(20, raiz.getValor(), "La nueva raíz debería ser 20 tras la rotación doble");
        assertEquals(10, raiz.getIzquierdo().getValor(), "El hijo izquierdo debe ser 10");
        assertEquals(30, raiz.getDerecho().getValor(), "El hijo derecho debe ser 30");
    }
}