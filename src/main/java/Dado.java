
public class Dado {
    private int valor;

    public Dado() {
        this.valor = (int) (Math.random() * 6) + 1;
    }

    public int getValor() {
        return this.valor;
    }
    public void tirar() {
        this.valor = (int) (Math.random() * 6) + 1;
    }

}