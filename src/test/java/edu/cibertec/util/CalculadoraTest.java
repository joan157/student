package edu.cibertec.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    @Test
    void sumar_dos_numeros(){
        Calculadora cal = new Calculadora();
        int resultado = cal.sumar(2,3);
        assertEquals(5,resultado);
        assertNotEquals(6,resultado);
        assertTrue(resultado==6);
    }

    @Test
    void numero_par_impar(){
        Calculadora cal = new Calculadora();
        boolean resultado = cal.validarParImpar(12);
        assertEquals(true,resultado);
        assertNotEquals(false, resultado);
    }

    @Test
    void Concatenar_Valores(){
        Calculadora cal = new Calculadora();
        String resultado = cal.concatenarString("Juan","Garcia");
        assertEquals("Juan - Garcia", resultado);
    }

    @Test
    void Concantena_valores(){
        Calculadora cal = new Calculadora();
        int resl = cal.valorMayor(12, 14);
        assertEquals(12, resl);
    }

}
