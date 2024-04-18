import java.util.ArrayList;
import java.util.List;

public class Territorio {
    private String nombre;
    private int numEjercitos;
    private ArrayList<Territorio> vecinos;
    private Jugador propietario;

    public Territorio(String nombre) {
        this.nombre = nombre;
        this.numEjercitos = 1;
        this.vecinos = new ArrayList<>();
        this.propietario = new Jugador();
    }

    public Territorio(String nombre, ArrayList<Territorio> vecinos){
        this.nombre=nombre;
        numEjercitos= 1;
        this.vecinos = vecinos;

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

    public void setPropietario(Jugador propietario){
        this.propietario = propietario;
    }

    public Jugador getPropietario(){
        return propietario;
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

    public boolean esVecino(Territorio territorio){
        for (Territorio vecino : vecinos) {
            if(vecino.getNombre().equals(territorio.getNombre())){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getNombresVecinos() {
        ArrayList<String> vecinosCast = new ArrayList<String>();
        for (Territorio s : vecinos) {
            Territorio territorio = new Territorio(s.getNombre());
            vecinosCast.add(territorio.getNombre());
        }
        return vecinosCast;
    }

//    public void addVecino(String nVecino) {
//        Territorio territorio = new Territorio(nVecino);
//        vecinos.add(territorio);
//    }

    public void addVecino(Territorio territorio) {
        vecinos.add(territorio);
    }

    public void pierdeEjercito(){
        numEjercitos--;
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
