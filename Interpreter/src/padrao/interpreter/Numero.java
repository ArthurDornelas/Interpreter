package padrao.interpreter;

public class Numero implements InterpretadorExpressao{
    private int numero;

    public Numero(int numero) {
        this.numero = numero;
    }

    public int[] interpretar() {
        return new int[]{numero, 0};
    }

    public int getNumero() {
        return this.numero;
    }
}
