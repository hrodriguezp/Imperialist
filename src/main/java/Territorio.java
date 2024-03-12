import java.util.ArrayList;
import java.util.List;

public class Territorio {
    private String nombre;
    private Jugador propietario;
    private int numEjercitos;
    private ArrayList<Territorio> vecinos;

    public Territorio(String nombre, Jugador propietario, List<Territorio> vecinos) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.numEjercitos = 1;
        this.vecinos = new ArrayList<Territorio>();
    }

    public String getNombre() {
        return nombre;
    }

    public Jugador getPropietario() {
        return propietario;
    }

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

    public int getNumEjercitos() {
        return numEjercitos;
    }

    public void setNumEjercitos(int numEjercitos) {
        this.numEjercitos = numEjercitos;
    }

    //TODO
    public ArrayList<Territorio> vecinos() {
        return null;
    }

    //TODO
    @Override
    public String toString() {
        return "Territorio{" +
                "nombre='" + nombre + '\'' +
                ", propietario=" + propietario +
                ", numEjercitos=" + numEjercitos +
                ", vecinos=" + vecinos +
                '}';
    }
}
