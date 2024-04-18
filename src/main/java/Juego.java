import java.util.*;

public class Juego {

    // region Atributos
    private ArrayList<Jugador> jugadores;

    private int turno;
    private Mapa mapa;
    private boolean fin;

    // endregion

    public Juego() {
        this.mapa = new Mapa();
        fin = false;
        jugadores = Gui.leerJugadores();
    }
    public void run() {
        int numOpc;
        boolean bExit = false;

        while (!bExit) {
            Gui.mostrarMenu();
            numOpc = Gui.leerOpcion();
            bExit= ejecutarOpcion(numOpc);
        }
    }

    private boolean ejecutarOpcion(int numOpc) {
        switch (numOpc) {
            case Ctes.OPC_EXIT:
                fin = true;
                return true;
            case Ctes.OPC_MAPA:
                mostrarMapa();
                return false;
            case Ctes.OPC_TERRITORIOS:
                mostrarTerritorios();
                return false;
            case Ctes.OPC_VECINOS:
                String territorio = Gui.leerVecinos();
                mostrarVecinos(territorio);
                return false;
            case Ctes.OPC_ATACAR:
                return realizarAtaque();
            default:
                return false;
        }
    }

    private boolean realizarAtaque() {
        ArrayList<Territorio> participantes = Gui.leerAtaque();
        Territorio territorioAtacante = participantes.get(0);
        Territorio territorioAtacado = participantes.get(1);
        jugadores.get(turno).atacar(territorioAtacante, territorioAtacado);
        return true;
    }

    private void mostrarMapa() {
        mapa.pintar();
    }
    private void mostrarTerritorios() {

    }
    private ArrayList<Territorio> mostrarVecinos(String territorio) {
        return mapa.getVecinos(territorio);
    }


    public void repartirEjercitos() {
        switch (jugadores.size()) {
            case 2 -> {
                for (Jugador jugador : jugadores) {
                    jugador.setEjercitoDisponible(Ctes.NUM_EJERCITOS2 - jugador.getTerritorios().size());
                }
            }
            case 3 -> {
                for (Jugador jugador : jugadores) {
                    jugador.setEjercitoDisponible(Ctes.NUM_EJERCITOS3 - jugador.getTerritorios().size());
                }
            }
            case 4 -> {
                for (Jugador jugador : jugadores) {
                    jugador.setEjercitoDisponible(Ctes.NUM_EJERCITOS4 - jugador.getTerritorios().size());
                }
            }
            case 5 -> {
                for (Jugador jugador : jugadores) {
                    jugador.setEjercitoDisponible(Ctes.NUM_EJERCITOS5 - jugador.getTerritorios().size());
                }
            }
            case 6 -> {
                for (Jugador jugador : jugadores) {
                    jugador.setEjercitoDisponible(Ctes.NUM_EJERCITOS6 - jugador.getTerritorios().size());
                }
            }
        }
    }

    public void repartirTerritorios() {
        mapa = new Mapa();
        List<String> territorios = mapa.getTerritorios();
        Collections.shuffle(territorios);
        int n = 0;
            for (String territorio : territorios) {
                jugadores.get(n).addTerritorios(mapa.getTerritorio(territorio));
                n++;
                    if (n > jugadores.size()){
                        n = 0;
                    }
            }
    }

    public void jugar() {
        repartirTerritorios();
        repartirEjercitos();
        while(fin){
            jugarJugada();
            if (jugadores.get(turno).getTerritorios().isEmpty()){
                jugadores.remove(turno);
            }
            if (jugadores.size() == 1){
                System.out.println("El ganador ha sido:" + jugadores.get(turno).getNombre());
                return;
            }
        }
    }
    public void jugarJugada() {
        run();
        avanzarTurno();
    }

    private static int getResultado(Territorio territorio, Territorio territorioAtacado) {
        int atacante = territorio.getNumEjercitos();
        if (atacante >= 3){
                atacante = 3;
        }
        int defensor = territorioAtacado.getNumEjercitos();
        if (defensor >=2) {
            defensor = 2;
        }
        Tirada tiradaAtaque = new Tirada(atacante);
        Tirada tiradaDefensa = new Tirada(defensor);
        return tiradaAtaque.compararTirada(tiradaDefensa);
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    private void avanzarTurno() {
        if (turno + 1 == jugadores.size()) {
            turno = 0;
        }
        turno++;
    }


}