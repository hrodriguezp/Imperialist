import java.util.*;

public class Juego {

    // region Atributos
    private ArrayList<Jugador> jugadores;

    private int turno;

    private Mapa mapa;

    // endregion

    public Juego() {
        this.mapa = new Mapa();
        jugadores = Gui.leerJugadores();
    }

    public void run() {
        int numOpc;
        boolean bExit = false;

        mapa.loadWorld();

        while (!bExit) {
            Gui.mostrarMenu();
            numOpc = Gui.leerOpcion();
            bExit= ejecutarOpcion(numOpc);
        }

    }

    private boolean ejecutarOpcion(int numOpc) {
        switch (numOpc) {
            case Ctes.OPC_EXIT:
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
                //atacar();
                realizarAtaque();
                return false;
            default:
                return false;
        }
    }

    private void realizarAtaque() {
        ArrayList<Territorio> participantes = Gui.leerAtaque();
        Territorio territorioAtacante = participantes.get(0);
        Territorio territorioAtacado = participantes.get(1);
        jugadores.get(turno).atacar(territorioAtacante, territorioAtacado);
    }

    private void mostrarMapa() {
        mapa.pintar();
    }
    private void mostrarTerritorios() {

    }
    private ArrayList<Territorio> mostrarVecinos(String territorio) {
        return mapa.getVecinos(territorio);
    }


//    public void presentacion() {
//        int n = 93, m = 33;
//        String s = "IMPERIALIST";
//        System.out.println("~".repeat(n));
//        System.out.println("~" + " ".repeat(m) + s + " ".repeat(m) + "~");
//        System.out.println("~".repeat(n));
//    }



    public void repartirEjercitos() {
        switch (jugadores.size()) {
            case 2 -> {
                for (Jugador jugador : jugadores) {
                    jugador.setEjercitoDisponible(Ctes.NUM_EJERCITOS2);
                }
            }
            case 3 -> {
                for (Jugador jugador : jugadores) {
                    jugador.setEjercitoDisponible(Ctes.NUM_EJERCITOS3);
                }
            }
            case 4 -> {
                for (Jugador jugador : jugadores) {
                    jugador.setEjercitoDisponible(Ctes.NUM_EJERCITOS4);
                }
            }
            case 5 -> {
                for (Jugador jugador : jugadores) {
                    jugador.setEjercitoDisponible(Ctes.NUM_EJERCITOS5);
                }
            }
            case 6 -> {
                for (Jugador jugador : jugadores) {
                    jugador.setEjercitoDisponible(Ctes.NUM_EJERCITOS6);
                }
            }
        }
    }

    public int territoriosARepartir() {
        switch (jugadores.size()) {
            case 2 -> {
                return Ctes.NUM_EJERCITOS2;
            }
            case 3 -> {
                return Ctes.NUM_EJERCITOS3;
            }
            case 4 -> {
                return Ctes.NUM_EJERCITOS4;
            }
            case 5 -> {
                return Ctes.NUM_EJERCITOS5;
            }
            case 6 -> {
                return Ctes.NUM_EJERCITOS6;
            }
        }
        return 0;
    }

    public void repartirTerritorios() {
        //TODO: Sin terminar
        mapa = new Mapa();
        List<String> territorios = mapa.getTerritorios();
        Collections.shuffle(territorios);
        for (Jugador jugador : jugadores) {
            for (String territorio : territorios) {
                if (jugador.getTerritorios().size() == territoriosARepartir()) {
                    jugador.addTerritorios(mapa.getTerritorio(territorio));
                }
            }

        }
    }


    public void jugar() {
        //TODO Jugar partida completa
        repartirTerritorios();
    }


    public void jugarJugada() {
        //TODO Jugada de un jugador activo
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
        int resultado = tiradaAtaque.compararTirada(tiradaDefensa);
        return resultado;
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