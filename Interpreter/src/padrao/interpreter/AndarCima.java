package padrao.interpreter;

public class AndarCima implements InterpretadorExpressao{
    private int posicao;
    private int numero;

    public AndarCima (int posicao, Numero numero) {
        this.posicao = posicao;
        this.numero = numero.getNumero();
    }

    public int[] interpretar() {
        return new int[]{posicao + numero, 0};
    }
}
