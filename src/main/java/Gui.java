import java.util.ArrayList;
import java.util.Scanner;

public class Gui {
    public static void mostrarMenu() {
        System.out.println("*************************************************");
        System.out.println("*   I   M   P   E   R   I   A   L   I   S   T   *");
        System.out.println("*************************************************");
        System.out.println(" 1. Ver mapa");
        System.out.println(" 2. Consultar territorios");
        System.out.println(" 3. Consultar vecinos");
        System.out.println(" 4. Atacar");
        System.out.println(" 0. Finalizar juego");
        System.out.println("*************************************************");
    }

    public static int leerOpcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public static String leerVecinos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Territorio: ");
        return scanner.nextLine().trim();
    }

    public static ArrayList<Jugador> leerJugadores() {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Cuántos jugadores: ");
        int numJugadores = Integer.parseInt(teclado.nextLine());

        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i <= numJugadores; i++) {
            System.out.print("Nombre del jugador " + ":");
            String nombre = teclado.nextLine();
            jugadores.add(new Jugador(nombre));
        }
        return jugadores;
    }

//    public static Posicion leerPosicion() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.printf("%22s: ", "Número de la fila");
//        int numeroFila = scanner.nextInt();
//        System.out.printf("%22s: ", "Número de la columna");
//        int numeroColumna = scanner.nextInt();
//        return new Posicion(numeroFila, numeroColumna);
//    }

    public static boolean leerConfirmacion(String txt, String iniConfirmacion) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s: ", txt);
        String respuesta = scanner.nextLine().trim();
        return respuesta.toUpperCase().startsWith(iniConfirmacion.toUpperCase());
    }

    /*
    Este metodo debe extraer los territorios que se van a enfrentar
    uno del atacante y uno del atacado, ademas de hacer las comprobaciones necesarias
    como si los territorios son vecinos, si tienen las tropas necesarias etc.
     */

    public static ArrayList<Territorio> leerAtaque() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Territorio> territorios = new ArrayList<>();
        System.out.println("Selecciona de tus territorios el que quieras usar para atacar");
        String tAtacante = scanner.nextLine();

        System.out.println("Selecciona el territorio que quieres atacar");
        String tDefensor = scanner.nextLine();

        //TODO

        return territorios;
    }
}
