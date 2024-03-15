import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Juego {

    // region Atributos
    private ArrayList<Jugador> jugadores;

    private int turno;

    private Mapa mapa;

    // endregion


//    public void presentacion() {
//        int n = 93, m = 33;
//        String s = "IMPERIALIST";
//        System.out.println("~".repeat(n));
//        System.out.println("~" + " ".repeat(m) + s + " ".repeat(m) + "~");
//        System.out.println("~".repeat(n));
//    }

    public void crearJugadores() {
        int numJugadores;
        String nombre;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Cuántos jugadores: ");
        numJugadores = Integer.parseInt(teclado.nextLine());

        jugadores = new ArrayList<>();
        for (int i = 0; i <= numJugadores; i++) {
            System.out.print("Nombre del jugador " + i + ":");
            nombre = teclado.nextLine();
            jugadores.add(new Jugador(nombre, i));
            switch (numJugadores){
                case 2:
                    jugadores.get(i).setEjercitoDisponible(Ctes.NUM_EJERCITOS2);
                case 3:
                    jugadores.get(i).setEjercitoDisponible(Ctes.NUM_EJERCITOS3);
                case 4:
                    jugadores.get(i).setEjercitoDisponible(Ctes.NUM_EJERCITOS4);
                case 5:
                    jugadores.get(i).setEjercitoDisponible(Ctes.NUM_EJERCITOS5);
                case 6:
                    jugadores.get(i).setEjercitoDisponible(Ctes.NUM_EJERCITOS6);
            }
        }


        System.out.println();
    }


    public int numeroJugadores() {
        return jugadores.size();
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Jugador getJugador(int numeroJugador) {
        return jugadores.get(numeroJugador);
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

        //Es para saber cuantos ejercitos tiene cada jugador igual no va en esta clase.
    private int obtenerEjercitosPorJugador(int numJugadores) {
        int ejercitosTotales = 0;
        switch (numJugadores) {
            case 2:
                ejercitosTotales = 40;
                break;
            case 3:
                ejercitosTotales = 35;
                break;
            case 4:
                ejercitosTotales = 30;
                break;
            case 5:
                ejercitosTotales = 25;
                break;
            case 6:
                ejercitosTotales = 20;
                break;
        }
        return ejercitosTotales / numJugadores;
    }



    public void repartirTerritorios() {
        //TODO
        mapa = new Mapa();
        List<String> territorios = mapa.getTerritorios();
        Collections.shuffle(territorios);
        int numJugadores = jugadores.size();
        int indexTerritorio = 0;
        for (String territorio : territorios) {
            Jugador jugadorActual = jugadores.get(indexTerritorio % numJugadores);
            Territorio terr = new Territorio(territorio);
            jugadorActual.addTerritorios(terr);
            indexTerritorio++;
        }
    }


    public void jugar() {
        //TODO Jugar partida completa
    }


    public void jugarJugada() {
        //TODO Jugada de un jugador activo
    }


    private void avanzarTurno() {
        if (turno + 1 == numeroJugadores()) {
            turno = 0;
        }
        turno++;
    }


}
