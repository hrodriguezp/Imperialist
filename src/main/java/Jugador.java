import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private String siglas;
    private int ejercitoDisponible;
    private int posicion;

    private ArrayList<Territorio> territorios = new ArrayList<>();


    public Jugador(String nombre, int posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.siglas = nombre.toUpperCase().substring(1,4);
}
public Jugador(String nombre) {
        this.nombre = nombre;
        this.posicion = 0;
        this.siglas = nombre.toUpperCase().substring(1,4);
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public int getEjercitoDisponible() {
        return ejercitoDisponible;
    }

    public void setEjercitoDisponible(int ejercitoDisponible) {
        this.ejercitoDisponible = ejercitoDisponible;
    }

    public void colocarEjercitos(Territorio territorio, int cantidad) {
        if (ejercitoDisponible >= cantidad) {
            territorio.setNumEjercitos(territorio.getNumEjercitos() + cantidad);
            ejercitoDisponible -= cantidad;
        } else {
            System.out.println("No tienes ejércitos disponibles.");
        }
    }



    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", siglas='" + siglas + '\'' +
                ", ejercitoDisponible=" + ejercitoDisponible +
                '}';
    }
}
