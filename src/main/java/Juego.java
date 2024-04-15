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
                atacar();
                return false;
            default:
                return false;
        }
    }
    private void mostrarMapa() {
        mapa.pintar();
    }
    private void mostrarTerritorios() {

    }
    private ArrayList<String> mostrarVecinos(String territorio) {
        return mapa.getVecinos(territorio);
    }


//    public void presentacion() {
//        int n = 93, m = 33;
//        String s = "IMPERIALIST";
//        System.out.println("~".repeat(n));
//        System.out.println("~" + " ".repeat(m) + s + " ".repeat(m) + "~");
//        System.out.println("~".repeat(n));
//    }



    public void crearJugadores() {
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

    public void repartirTerritorios() {
        //TODO: Sin terminar
        mapa = new Mapa();
        List<String> territorios = mapa.getTerritorios();
        Collections.shuffle(territorios);
        int numJugadores = jugadores.size();
        int numTerritorio = 0;
        for (String territorio : territorios) {
            Jugador jugadorActual = jugadores.get(numTerritorio % numJugadores);
            Territorio terr = new Territorio(territorio);
            jugadorActual.addTerritorios(terr);
            numTerritorio++;
        }
    }


    public void jugar() {
        //TODO Jugar partida completa
    }


    public void jugarJugada() {
        //TODO Jugada de un jugador activo
        avanzarTurno();
    }

    public void atacar(){
        ArrayList<Territorio> extraerTerritorios = Gui.leerAtaque();
        Territorio territorio = extraerTerritorios.get(0);
        Territorio territorioAtacado = extraerTerritorios.get(1);
        Jugador jActivo = jugadores.get(turno);
        ArrayList<Territorio> territorios = jActivo.getTerritorios();
            if (territorios.contains(territorio)){
                    if (territorio.getVecinos().contains(territorioAtacado)){
                     //TODO
                        while (territorio.getNumEjercitos() > 0 || territorioAtacado.getNumEjercitos() > 0){
                            int resultado = getResultado(territorio, territorioAtacado);
                            switch (resultado){
                                case 2:
                                    territorio.atacarTerritorio(2);
                                    break;
                                case 1:
                                    territorio.atacarTerritorio(1);
                                    break;
                                case 0:
                                    territorio.atacarTerritorio(1);
                                    territorioAtacado.atacarTerritorio(1);
                                    break;
                                case -1:
                                    territorioAtacado.atacarTerritorio(1);
                                    break;
                                case -2:
                                    territorioAtacado.atacarTerritorio(2);
                                    break;
                            }
                }
            }
        }
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