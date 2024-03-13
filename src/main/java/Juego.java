//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Juego {
//
//    // region Atributos
//    private Jugador[] jugadores;
//
//    private int turno;
//
//    // endregion
//
//    /**
//     * Imprime un mensaje de presentación del juego
//     */
//    public void presentacion() {
//        int n = 93, m = 33;
//        String s = "IMPERIALIST";
//        System.out.println("~".repeat(n));
//        System.out.println("~" + " ".repeat(m) + s + " ".repeat(m) + "~");
//        System.out.println("~".repeat(n));
//    }
//
//    /**
//     * Crea los jugadores y contadores del juego.
//     * Pide el nombre de cada uno de ellos por teclado para instanciarlo.
//     */
//    public void crearJugadores() {
//        int numJugadores;
//        String nombre;
//        Scanner teclado = new Scanner(System.in);
//
//        System.out.print("Cuántos jugadores: ");
//        numJugadores = Integer.parseInt(teclado.nextLine());
//
//        jugadores = new ArrayList<>();
//        for (int i = 1; i <= numJugadores; i++) {
//            System.out.print("Nombre del jugador " + i + ":");
//            nombre = teclado.nextLine();
//            //jugadores[i-1] = new Jugador(nombre);
//        }
//
//        System.out.println();
//    }
//
//    /**
//     * Cuántos jugadores están jugando
//     * @return número de jugadores
//     */
//    public int numeroJugadores() {
//        return 0;
//    }
//
//    /**
//     * Define los jugadores que van a jugar e instancia un nuevo array para los contadores
//     * (Se utiliza para hacer pruebas y no tener que pedir los datos)
//     * @param jugadores Array con los jugadores que van a jugar
//     */
//    public void setJugadores(Jugador[] jugadores) {
//        this.jugadores = jugadores;
//    }
//
//    public Jugador getJugador(int numeroJugador) {
//        return jugadores[numeroJugador-1];
//    }
//
//    public int getTurno() {
//        return turno;
//    }
//
//    public void setTurno(int turno) {
//        this.turno = turno;
//    }
//
//    /**
//     * Crea una nueva baraja y revuelve las cartas.
//     * Luego reparte las cartas entre los jugadores.
//     * Todos los jugadores deben tener el mismo número de cartas.
//     * Si el mazo no tiene un número de cartas total múltiplo del número de jugadores,
//     * habrá cartas que se queden en el mazo sin repartir.
//     * Inicializa el turno a 0.
//     */
//    public void repartirCartas() {
//        baraja = new Baraja();
//        baraja.revolver();
//        int ind = Baraja.getNumeroCartasTotales() / jugadores.length;
//        for (int i = 0; i < ind * jugadores.length; i++) {
//            baraja.sacarCarta();
//        }
//        turno = 0;
//    }
//
//    /**
//     * Juega una partida completa que consiste en jugar tantas jugadas como cartas tienen al inicio los jugadores
//     */
//    public void jugar() {
//        int ind = Baraja.getNumeroCartasTotales() / jugadores.length;
//        for (int i = 0; i < ind * jugadores.length; i++) {
//            jugarJugada();
//        }
//    }
//
//    /**
//     * Juega una jugada.
//     * Lo primero avanza el turno para que cada vez un jugador defina la característica en la que compiten.
//     * *** Se saca una carta de cada jugador y se crea una jugada con ellas. ***
//     * Se pinta la carta del jugador que le toca jugar y
//     * se pide la característica con la que quiere competir.
//     * A continuación se pintan todas las cartas de la jugada y
//     * se obtiene el valor devuelto por el método ganadores de la jugada.
//     * Con este valor se actualizan los contadores de los jugadores
//     * que representan el número de veces que han ganado aun empatando.
//     * Finalmente, se muestran los nombres de todos los ganadores de la jugada.
//     */
//    public void jugarJugada() {
//        avanzarTurno();
//        Carta[] cartas = new Carta[jugadores.length];
//        for (int i = 0; i < jugadores.length; i++) {
//            cartas[i] = jugadores[i].sacarCarta();
//        }
//        Jugada jugada = new Jugada(cartas);
//        jugada.pintarCarta(turno);
//        int caracteristica = pedirCaracteristica();
//        jugada.pintaCartas(jugadores);
//        int[] ganadores = jugada.ganadores(caracteristica);
//        actualizarContadores(ganadores);
//        mostrarGanadores(ganadores);
//    }
//
//    /**
//     * Avanza el turno de tal forma que tenga un valor de 1 al número de jugadores de forma circular
//     * Si hay 4 jugadores y avanza el turno este pasaría a ser el del jugador 1
//     * Ejemplo de como avanza el turno: 1,2,3,4,1,2,3,4,1,2,3,...
//     */
//    private void avanzarTurno() {
//        if(turno+1 == 5){
//            turno = 0;
//        }
//        turno ++;
//    }
//
//    /**
//     * Pide la característica con la que se quiere competir.
//     * Muestra en una línea las características con su número.
//     * @return número de la característica
//     */
//    public int pedirCaracteristica() {
//        String nombre = getJugador(turno).getNombre();
//        System.out.println(nombre + ", elige característica");
//        Scanner teclado = new Scanner(System.in);
//        int caracteristica;
//        System.out.print("1. Motor    ");
//        System.out.print("2. Potencia    ");
//        System.out.print("3. Velocidad    ");
//        System.out.print("4. Consumo    ");
//        System.out.println();
//        System.out.print("Característica [1-4]: ");
//        caracteristica = teclado.nextInt();
//        return caracteristica;
//    }
//
//    /**
//     * Actualiza los contadores de los jugadores que han ganado la jugada.
//     * @param ganadores array que representa los jugadores que han ganado la jugada si tienen un 1 en su posición
//     */
//    public void actualizarContadores(int[] ganadores) {
//        for (int i = 0; i < ganadores.length; i++) {
//            contadores[i] += ganadores[i];
//        }
//    }
//
//    /**
//     * Muestra los ganadores de la jugada en una lista de nombres separados por espacio.
//     * @param ganadores valor que representa los jugadores que han ganado la jugada.
//     */
//    public void mostrarGanadores(int[] ganadores) {
//        StringBuilder nombres = new StringBuilder();
//        for (int i = 0; i < ganadores.length; i++) {
//            if (ganadores[i] == 1){
//                nombres.append(jugadores[i].getNombre()) ;
//                nombres.append(" ");
//            }
//        }
//        System.out.println("Ganador(es) de la jugada: " + nombres + "\n");
//    }
//
//    /**
//     * Muestra los resultados de la partida.
//     * Muestra el nombre de cada jugador y el número de veces que ha ganado
//     * aunque al ganar haya empatado con otro jugador.
//     */
//    public void mostrarResultados() {
//        System.out.println("Resultados:");
//        System.out.println("-".repeat(20));
//        for (int i = 0; i < jugadores.length; i++) {
//            System.out.println(jugadores[i].getNombre() + " ha ganado: " + contadores[i]);
//        }
//        System.out.println("-".repeat(20));
//    }
//
//}
