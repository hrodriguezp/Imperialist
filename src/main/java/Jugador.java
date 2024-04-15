import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private String siglas;
    private int ejercitoDisponible;
    private ArrayList<Territorio> territorios;


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.siglas = nombre.toUpperCase().substring(1,4);
        this.territorios = new ArrayList<>();
}

    public ArrayList<Territorio> getTerritorios() {
        return territorios;
    }

    public void setTerritorios(ArrayList<Territorio> territorios) {
        this.territorios = territorios;
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

    public void colocarEjercitosPrincipio(Territorio territorio, int cantidad) {
        if (ejercitoDisponible >= cantidad) {
            territorio.setNumEjercitos(territorio.getNumEjercitos() + cantidad);
            ejercitoDisponible -= cantidad;
        } else {
            System.out.println("No tienes ejércitos disponibles.");
        }
    }
    public void addTerritorios(Territorio territorio){
        territorios.add(territorio);
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
