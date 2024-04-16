import java.util.ArrayList;
import java.util.List;

public class Territorio {
    private String nombre;
    private int numEjercitos;
    private ArrayList<Territorio> vecinos;

    public Territorio(String nombre) {
        this.nombre = nombre;
        this.numEjercitos = 1;
        loadVecinos();
    }

    public Territorio(String nombre, ArrayList<Territorio> vecinos){
        this.nombre=nombre;
        numEjercitos= 1;
        this.vecinos = vecinos;

    }

    private void loadVecinos(){
        Mapa map = new Mapa();
        vecinos = map.getVecinos(nombre);
    }


    public void atacarTerritorio(int tPerdidas){
        this.numEjercitos -= tPerdidas;
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

    public void setVecinos(ArrayList<Territorio> vecinos){
        this.vecinos = vecinos;
    }

    public ArrayList<Territorio> getVecinos() {
//        ArrayList<Territorio> vecinosCast = new ArrayList<Territorio>();
//        for (Territorio s : vecinos) {
//            Territorio territorio = new Territorio(s.getNombre());
//            vecinosCast.add(territorio);
//        }
//        return vecinosCast;
        return vecinos;
    }

    public ArrayList<String> getNombresVecinos() {
        ArrayList<String> vecinosCast = new ArrayList<String>();
        for (Territorio s : vecinos) {
            Territorio territorio = new Territorio(s.getNombre());
            vecinosCast.add(territorio.getNombre());
        }
        return vecinosCast;
    }

    public void addVecino(String nVecino) {
        Territorio territorio = new Territorio(nVecino);
        vecinos.add(territorio);
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
