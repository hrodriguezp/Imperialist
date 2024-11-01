import java.nio.file.FileSystems;

public class Ctes {
    public static final String PATH_TERRITORIOS = "data" + FileSystems.getDefault().getSeparator() + "territorios.txt";
    public static final String EXP_TERRITORIO_SPLITTER = "\s*-\s*";

    public static final int NUM_EJERCITOS2 = 40;
    public static final int NUM_EJERCITOS3 = 35;
    public static final int NUM_EJERCITOS4 = 30;
    public static final int NUM_EJERCITOS5 = 25;
    public static final int NUM_EJERCITOS6 = 20;
    public static final int OPC_EXIT = 0;
    public static final int OPC_MAPA = 1;
    public static final int OPC_TERRITORIOS = 2;
    public static final int OPC_VECINOS = 3;
    public static final int OPC_ATACAR = 4;

}
