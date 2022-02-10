package test;

import org.junit.jupiter.api.Test;
import padrao.interpreter.InterpretadorExpressao;
import padrao.interpreter.InterpretadorExpressaoMovimento;

import static org.junit.jupiter.api.Assertions.*;

public class InterpretadorExpressaoTest {
    @Test
    void deveMovimentarParaCima() {
        InterpretadorExpressao interpretador = new InterpretadorExpressaoMovimento("^ 2");
        assertEquals(2, interpretador.interpretar()[0]);
    }

    @Test
    void deveMovimentarParaBaixo() {
        InterpretadorExpressao interpretador = new InterpretadorExpressaoMovimento("v 2");
        assertEquals(-2, interpretador.interpretar()[0]);
    }

    @Test
    void deveMovimentarParaDireita() {
        InterpretadorExpressao interpretador = new InterpretadorExpressaoMovimento("> 2");
        assertEquals(2, interpretador.interpretar()[1]);
    }

    @Test
    void deveMovimentarParaEsquerda() {
        InterpretadorExpressao interpretador = new InterpretadorExpressaoMovimento("< 2");
        assertEquals(-2, interpretador.interpretar()[1]);
    }

    @Test
    void deveMovimentarPosicoesCombinadas() {
        InterpretadorExpressao interpretador = new InterpretadorExpressaoMovimento("> 2 v 1 < 3 ^ 4 ^ 2 > 4 v 2");
        int arrayPosicao[] = {3, 3};
        assertEquals(arrayPosicao[0], interpretador.interpretar()[0]);
        assertEquals(arrayPosicao[1], interpretador.interpretar()[1]);
    }

    @Test
    void deveRetonarExcecaoElementoInvalido() {
        try {
            InterpretadorExpressao interpretador = new InterpretadorExpressaoMovimento("* 2 v");
            int arrayPosicao[] = {-1, 2};
            assertEquals(arrayPosicao[0], interpretador.interpretar()[0]);
            assertEquals(arrayPosicao[1], interpretador.interpretar()[1]);
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Expressão com elemento inválido", e.getMessage());
        }
    }

    @Test
    void deveRetonarExcecaoInvalida() {
        try {
            InterpretadorExpressao interpretador = new InterpretadorExpressaoMovimento("> 2 v");
            int arrayPosicao[] = {-1, 2};
            assertEquals(arrayPosicao[0], interpretador.interpretar()[0]);
            assertEquals(arrayPosicao[1], interpretador.interpretar()[1]);
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Expressão inválida", e.getMessage());
        }
    }
}
