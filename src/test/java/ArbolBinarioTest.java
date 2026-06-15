import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArbolBinarioTest {

    private ArbolBinario arbolNormal;
    private ArbolBinario arbolVacio;

    // Esta etiqueta hace que este método se corra ANTES de cada test,
    // garantizando que siempre arranques con un árbol fresco y limpio.
    @BeforeEach
    public void setUp() {
        arbolVacio = new ArbolBinario();
        
        /*
               10
              /  \
             5    15
            / \     \
           -3  8     20
        */
        Nodo n1 = new Nodo(10);
        Nodo n2 = new Nodo(5);
        Nodo n3 = new Nodo(15);
        Nodo n4 = new Nodo(-3);
        Nodo n5 = new Nodo(8);
        Nodo n6 = new Nodo(20);

        n1.setIzquierdo(n2);
        n1.setDerecho(n3);
        n2.setIzquierdo(n4);
        n2.setDerecho(n5);
        n3.setDerecho(n6);

        arbolNormal = new ArbolBinario(n1);
    }

    @Test
    public void testTieneNegativo() {
        assertTrue(arbolNormal.tieneNegativo(), "El árbol normal debería detectar el -3");
        assertFalse(arbolVacio.tieneNegativo(), "Un árbol vacío no tiene negativos");
    }

    @Test
    public void testObtenerInorder() {
        List<Integer> esperado = Arrays.asList(-3, 5, 8, 10, 15, 20);
        List<Integer> resultado = arbolNormal.obtenerInorder();
        
        assertEquals(esperado, resultado, "El recorrido InOrder no coincide");
    }

    @Test
    public void testContarHojas() {
        assertEquals(3, arbolNormal.contarHojas(), "El árbol normal tiene 3 hojas (-3, 8 y 20)");
        assertEquals(0, arbolVacio.contarHojas(), "Un árbol vacío tiene 0 hojas");
    }

    @Test
    public void testEsBST() {
        assertTrue(arbolNormal.esBST(), "El árbol inicial es un BST válido");

        // Rompemos el BST a propósito para ver si el código se da cuenta
        Nodo nFalso = new Nodo(100);
        arbolNormal.getRaiz().getIzquierdo().setIzquierdo(nFalso); // Ponemos 100 a la izq del 5

        assertFalse(arbolNormal.esBST(), "Debería dar false porque metimos un 100 a la izquierda del 5");
    }

    @Test
    public void testAltura() {
        assertEquals(3, arbolNormal.altura(), "La altura del árbol normal debería ser 3");
        assertEquals(0, arbolVacio.altura(), "La altura de un árbol vacío debería ser 0");
    }
}