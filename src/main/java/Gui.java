import java.io.*;
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

    public void loadWorld() {
        String line;
        File file = new File(Ctes.PATH_TERRITORIOS);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ( (line = reader.readLine()) != null ) {
                if (line.isEmpty()) { continue; }
                String[] a = line.split(Ctes.EXP_TERRITORIO_SPLITTER); // EXP_TERRITORIO_SPLITTER = "\s*-\s*";

                // ...

                //System.out.println(Arrays.toString(a));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String leerJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre del jugador: ");
        return scanner.nextLine().trim();
    }

    public static Jugador leerJugadores() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%30s: ", "Nombre del jugador");
        String nombre = scanner.nextLine().trim();
        System.out.printf("%30s: ", "Siglas del jugador");
        String siglas = scanner.nextLine().trim();
        return new Jugador(nombre);
    }

    public static Posicion leerPosicion() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%22s: ", "Número de la fila");
        int numeroFila = scanner.nextInt();
        System.out.printf("%22s: ", "Número de la columna");
        int numeroColumna = scanner.nextInt();
        return new Posicion(numeroFila, numeroColumna);
    }

    public static boolean leerConfirmacion(String txt, String iniConfirmacion) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s: ", txt);
        String respuesta = scanner.nextLine().trim();
        return respuesta.toUpperCase().startsWith(iniConfirmacion.toUpperCase());
    }

}
