import java.util.ArrayList;
import java.util.List;

public class Territorio {
    private String nombre;
    private int numEjercitos;
    private ArrayList<String> vecinos;

    public Territorio(String nombre) {
        this.nombre = nombre;
        this.numEjercitos = 1;
        Mapa mapa = new Mapa();
        vecinos = mapa.getVecinos(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumEjercitos() {
        return numEjercitos;
    }

    public void setNumEjercitos(int numEjercitos) {
        this.numEjercitos = numEjercitos;
    }

    //TODO
    public ArrayList<Territorio> vecinos() {
        ArrayList<Territorio> vecinosCast = new ArrayList<Territorio>();
        for (String s : vecinos) {
            Territorio territorio = new Territorio(s);
            vecinosCast.add(territorio);
        }
        return vecinosCast;
    }



    //TODO
    @Override
    public String toString() {
        return "Territorio{" +
                "nombre='" + nombre + '\'' +
                ", propietario=" +
                ", numEjercitos=" + numEjercitos +
                ", vecinos=" + vecinos +
                '}';
    }
}
