package padrao.interpreter;

public class AndarDireita implements InterpretadorExpressao{
    private int posicao;
    private int numero;

    public AndarDireita (int posicao, Numero numero) {
        this.posicao = posicao;
        this.numero = numero.getNumero();
    }

    public int[] interpretar() {
        return new int[]{0, posicao + numero};
    }
}
