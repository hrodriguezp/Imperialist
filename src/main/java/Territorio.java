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
}
