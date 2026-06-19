import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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

    @Test
    public void testObtenerPreorder() {
        // El recorrido original esperado para el árbol de prueba es:
        // Raíz(10), va a la izq(5), izq(-3), der(8), sube y va a la der(15), der(20)
        List<Integer> esperado = Arrays.asList(10, 5, -3, 8, 15, 20);
        List<Integer> resultado = arbolNormal.obtenerPreorder();
        
        assertEquals(esperado, resultado, "El recorrido PreOrder no coincide");
        assertTrue(arbolVacio.obtenerPreorder().isEmpty(), "El PreOrder de un árbol vacío debe ser una lista vacía");
    }

    @Test
    public void testObtenerPostorder() {
        // El recorrido original esperado para el árbol de prueba es:
        // Todo a la izq(-3), luego der(8), raíz(5), luego der profunda(20), raíz(15), raíz principal(10)
        List<Integer> esperado = Arrays.asList(-3, 8, 5, 20, 15, 10);
        List<Integer> resultado = arbolNormal.obtenerPostorder();
        
        assertEquals(esperado, resultado, "El recorrido PostOrder no coincide");
        assertTrue(arbolVacio.obtenerPostorder().isEmpty(), "El PostOrder de un árbol vacío debe ser una lista vacía");
    }

    @Test
    public void testEspejar() {
        // 1. Espejamos el árbol normal
        arbolNormal.espejar();
        
        // 2. Si el árbol se espejó bien, su recorrido InOrder debe ser 
        // exactamente al revés que el InOrder normal.
        List<Integer> inOrderEsperado = Arrays.asList(20, 15, 10, 8, 5, -3);
        List<Integer> inOrderObtenido = arbolNormal.obtenerInorder();
        
        assertEquals(inOrderEsperado, inOrderObtenido, "El árbol no se espejó correctamente. Los punteros no se invirtieron.");
        
        // 3. Un árbol vacío no debería tirar error al intentar espejarse
        assertDoesNotThrow(() -> arbolVacio.espejar(), "El método espejar no debe fallar (NullPointerException) si el árbol está vacío");
    }
}