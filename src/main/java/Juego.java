import java.util.ArrayList;
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



    public void repartirTerritorios() {
        //TODO
        mapa.
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
