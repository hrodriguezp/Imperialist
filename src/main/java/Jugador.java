import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private String siglas;
    private int ejercitoDisponible;
    private ArrayList<Territorio> territorios;

    public Jugador() {
        this.nombre = "Defecto";
        this.siglas = nombre.toUpperCase().substring(1,4);
        this.territorios = new ArrayList<>();
    }
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

    public void atacar(Territorio atacante, Territorio atacado){
        Tirada tiradaAtacante = new Tirada(3);
        Tirada tiradaAtacado = new Tirada(2);
        if (atacante.esVecino(atacado)){
            if (estaTerritorio(atacante) && !estaTerritorio(atacado)){
                if (atacante.getNumEjercitos()>= 3) {
                    tiradaAtacante.setNumDados(3);
                } else {
                    tiradaAtacante.setNumDados(atacante.getNumEjercitos());
                }
                if (atacado.getNumEjercitos()>= 2) {
                    tiradaAtacado.setNumDados(2);
                } else {
                    tiradaAtacado.setNumDados(atacante.getNumEjercitos());
                }
                for (int i = 1; i <= tiradaAtacante.getNumDados(); i++) {
                    if (atacado.getNumEjercitos()>=1) {
                        if (tiradaAtacante.getValor(i) <= tiradaAtacado.getValor(i)) {
                            atacante.pierdeEjercito();
                        } else {
                            atacado.pierdeEjercito();
                        }
                    } else {
                        return;
                    }
                }
                if (atacado.getNumEjercitos()>0){
                    atacado.setPropietario(atacante.getPropietario());
                    System.out.println("El territorio " + atacado.getNombre() + ", ha sido conquistado por " + atacante.getPropietario().getNombre());
                } else {
                    //Por terminar
                }
            }
        }
        System.out.println("El territorio " + atacante.getNombre() + ", no es vecino de " + atacado.getNombre());

    }

    public boolean estaTerritorio(Territorio territorio){
        for (Territorio territorio1 : territorios) {
            if (territorio1.getNombre().equals(territorio.getNombre())){
                return true;
            }
        }
        return false;
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
