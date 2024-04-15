import java.util.ArrayList;

public class Tirada {

    private Dado dado;
    private int valor1;
    private int valor2;
    private int valor3;
    private int numDados;

    public Tirada(int numDados) {
        this.numDados = numDados;
        this.dado = new Dado();
        this.valor1 = 0;
        this.valor2 = 0;
        this.valor3 = 0;
        comprobacionNumDados();
        ordenarDados();
    }

    private void comprobacionNumDados(){
        if (numDados >= 1) {
            dado.tirar();
            valor1 = dado.getValor();
        }
        if (numDados >= 2) {
            dado.tirar();
            valor2 = dado.getValor();
        }
        if (numDados == 3) {
            dado.tirar();
            valor3 = dado.getValor();
        }
    }

    private void ordenarDados() {
        if (valor1 < valor2) {
            int aux = valor1;
            valor1 = valor2;
            valor2 = aux;
        }
        if (valor2 < valor3) {
            int aux = valor2;
            valor2 = valor3;
            valor3 = aux;
        }
        if (valor1 < valor2) {
            int aux = valor1;
            valor1 = valor2;
            valor2 = aux;
        }
    }

    public int getValor(int indice) {
        if (indice == 1) {
            return valor1;
        } else if (indice == 2) {
            return valor2;
        } else {
            return valor3;
        }
    }


    public int compararTirada(Tirada otra) {
        int perdidas = 0;
        if (valor1 <= otra.getValor(1)) {
            perdidas++;
        }else {
            perdidas--;
        }
        if (valor2 != 0 && otra.valor2 != 0) {
            if (valor2 <= otra.getValor(2)) {
                perdidas++;
            } else {
                perdidas--;
            }
        }
        return perdidas;
    }

}