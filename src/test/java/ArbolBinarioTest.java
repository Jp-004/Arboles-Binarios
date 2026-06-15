import java.util.Arrays;
import java.util.List;

public class ArbolBinarioTest {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO SUITE DE TESTS ===");
        
        testTieneNegativo();
        testObtenerInorder();
        testContarHojas();
        testEsBST();
        testAltura();
        
        System.out.println("=== TESTS FINALIZADOS ===");
    }

    private static ArbolBinario crearArbolNormal() {
        
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

        return new ArbolBinario(n1);
    }

    private static ArbolBinario crearArbolVacio() {
        return new ArbolBinario();
    }

    private static void testTieneNegativo() {
        System.out.println("\n-- Test 1: tieneNegativo --");
        try {
            ArbolBinario arbol = crearArbolNormal();
            ArbolBinario vacio = crearArbolVacio();

            boolean res1 = arbol.tieneNegativo();
            boolean res2 = vacio.tieneNegativo();

            if (res1 == true && res2 == false) {
                System.out.println("[PASÓ] La detección de negativos funciona.");
            } else {
                System.out.println("[FALLÓ] Esperaba (true, false) pero obtuve (" + res1 + ", " + res2 + ")");
            }
        } catch (Exception e) {
            System.out.println("[ERROR/EXCEPCIÓN] " + e.getMessage());
        }
    }

    private static void testObtenerInorder() {
        System.out.println("\n-- Test 2: obtenerInorder --");
        try {
            ArbolBinario arbol = crearArbolNormal();
            List<Integer> esperado = Arrays.asList(-3, 5, 8, 10, 15, 20);
            List<Integer> resultado = arbol.obtenerInorder();

            if (esperado.equals(resultado)) {
                System.out.println("[PASÓ] Recorrido InOrder correcto.");
            } else {
                System.out.println("[FALLÓ] Esperaba " + esperado + " pero obtuve " + resultado);
            }
        } catch (Exception e) {
            System.out.println("[ERROR/EXCEPCIÓN] " + e.getMessage());
        }
    }

    private static void testContarHojas() {
        System.out.println("\n-- Test 3: contarHojas --");
        try {
            ArbolBinario arbol = crearArbolNormal();
            ArbolBinario vacio = crearArbolVacio();

            // Las hojas son -3, 8 y 20 (total 3)
            if (arbol.contarHojas() == 3 && vacio.contarHojas() == 0) {
                System.out.println("[PASÓ] Conteo de hojas correcto.");
            } else {
                System.out.println("[FALLÓ] Esperaba (3 y 0) pero obtuve (" + arbol.contarHojas() + " y " + vacio.contarHojas() + ")");
            }
        } catch (Exception e) {
            System.out.println("[ERROR/EXCEPCIÓN] " + e.getMessage());
        }
    }

    private static void testEsBST() {
        System.out.println("\n-- Test 4: esBST --");
        try {
            ArbolBinario arbol = crearArbolNormal();
            
            // Rompemos el BST a propósito
            Nodo nFalso = new Nodo(100);
            arbol.getRaiz().getIzquierdo().setIzquierdo(nFalso); 

            if (crearArbolNormal().esBST() == true && arbol.esBST() == false) {
                System.out.println("[PASÓ] Validación BST correcta.");
            } else {
                System.out.println("[FALLÓ] El test de BST no devolvió los valores esperados.");
            }
        } catch (Exception e) {
            System.out.println("[ERROR/EXCEPCIÓN] " + e.getMessage());
        }
    }

    private static void testAltura() {
        System.out.println("\n-- Test 5: altura --");
        try {
            ArbolBinario arbol = crearArbolNormal();
            ArbolBinario vacio = crearArbolVacio();

            if (arbol.altura() == 3 && vacio.altura() == 0) {
                System.out.println("[PASÓ] Cálculo de altura correcto.");
            } else {
                System.out.println("[FALLÓ] Esperaba altura (3 y 0) pero obtuve (" + arbol.altura() + " y " + vacio.altura() + ")");
            }
        } catch (Exception e) {
            System.out.println("[ERROR/EXCEPCIÓN] " + e.getMessage());
        }
    }
}