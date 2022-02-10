package padrao.interpreter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class InterpretadorExpressaoMovimento implements InterpretadorExpressao{
    private InterpretadorExpressao interpretadorInicialX;
    private InterpretadorExpressao interpretadorInicialY;

    public InterpretadorExpressaoMovimento(String contexto) {
        Stack<InterpretadorExpressao> pilhaInterpretadoresX = new Stack<>();
        Stack<InterpretadorExpressao> pilhaInterpretadoresY = new Stack<>();
        List<String> elementos = Arrays.asList(contexto.split(" "));
        Iterator<String> iterator = elementos.iterator();
        pilhaInterpretadoresX.push(new Numero(0));
        pilhaInterpretadoresY.push(new Numero(0));

        while (iterator.hasNext()) {
            String elemento = iterator.next();
            if (elemento.equals("^")) {
                if(!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                String proximoElemento = iterator.next();
                if(!(proximoElemento.matches("(?:1|2|3|4|5|6|7|8|9)"))) {
                    throw new IllegalArgumentException("Expressão inválida");
                }
                Numero elementoDireita = new Numero(Integer.parseInt(proximoElemento));
                Numero posicao = (Numero) pilhaInterpretadoresY.pop();
                AndarCima interpretador = new AndarCima(posicao.getNumero(), elementoDireita);
                pilhaInterpretadoresY.push(new Numero(interpretador.interpretar()[0]));
            } else if (elemento.equals("v")) {
                if(!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                String proximoElemento = iterator.next();
                if(!(proximoElemento.matches("(?:1|2|3|4|5|6|7|8|9)"))) {
                    throw new IllegalArgumentException("Expressão inválida");
                }
                Numero elementoDireita = new Numero(Integer.parseInt(proximoElemento));
                Numero posicao = (Numero) pilhaInterpretadoresY.pop();
                AndarBaixo interpretador = new AndarBaixo(posicao.getNumero(), elementoDireita);
                pilhaInterpretadoresY.push(new Numero(interpretador.interpretar()[0]));
            } else if (elemento.equals(">")) {
                if(!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                String proximoElemento = iterator.next();
                if(!(proximoElemento.matches("(?:1|2|3|4|5|6|7|8|9)"))) {
                    throw new IllegalArgumentException("Expressão inválida");
                }
                Numero elementoDireita = new Numero(Integer.parseInt(proximoElemento));
                Numero posicao = (Numero) pilhaInterpretadoresX.pop();
                AndarDireita interpretador = new AndarDireita(posicao.getNumero(), elementoDireita);
                pilhaInterpretadoresX.push(new Numero(interpretador.interpretar()[1]));
            } else if (elemento.equals("<")) {
                if(!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                String proximoElemento = iterator.next();
                if(!(proximoElemento.matches("(?:1|2|3|4|5|6|7|8|9)"))) {
                    throw new IllegalArgumentException("Expressão inválida");
                }
                Numero elementoDireita = new Numero(Integer.parseInt(proximoElemento));
                Numero posicao = (Numero) pilhaInterpretadoresX.pop();
                AndarEsquerda interpretador = new AndarEsquerda(posicao.getNumero(), elementoDireita);
                pilhaInterpretadoresX.push(new Numero(interpretador.interpretar()[1]));
            } else {
                throw new IllegalArgumentException("Expressão com elemento inválido");
            }
        }
        interpretadorInicialX = pilhaInterpretadoresX.pop();
        interpretadorInicialY = pilhaInterpretadoresY.pop();
    }

    public int[] interpretar() {
        return new int[]{interpretadorInicialY.interpretar()[0], interpretadorInicialX.interpretar()[0]};
    }
}
