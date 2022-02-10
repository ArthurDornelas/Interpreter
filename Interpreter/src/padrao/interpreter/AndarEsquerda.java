package padrao.interpreter;

public class AndarEsquerda implements InterpretadorExpressao{
    private int posicao;
    private int numero;

    public AndarEsquerda (int posicao, Numero numero) {
        this.posicao = posicao;
        this.numero = numero.getNumero();
    }

    public int[] interpretar() {
        return new int[]{0, posicao + (numero * -1)};
    }
}
