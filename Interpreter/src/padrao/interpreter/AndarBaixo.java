package padrao.interpreter;

public class AndarBaixo implements InterpretadorExpressao{
    private int posicao;
    private int numero;

    public AndarBaixo (int posicao, Numero numero) {
        this.posicao = posicao;
        this.numero = numero.getNumero();
    }

    public int[] interpretar() {
        return new int[]{posicao + (numero * -1), 0};
    }
}
