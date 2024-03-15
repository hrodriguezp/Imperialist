import java.io.*;
import java.util.*;

public class Mapa {

    private Map<String, List<String>> lista;


   public Mapa() {
       this.lista = new LinkedHashMap<>();
   }

    public void loadWorld() {
        String line;
        File file = new File(Ctes.PATH_TERRITORIOS);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ( (line = reader.readLine()) != null ) {
                if (line.isEmpty()) { continue; }
                String[] a = line.split(Ctes.EXP_TERRITORIO_SPLITTER);

                // ...
                String [] st = a[0].split(":");
                String territorioPrincipal = st[0];
                String[] vecinos = st[1].split(", ");
                List<String> vecinosTOLIST = new ArrayList<>(Arrays.stream(vecinos).toList());
                lista.put(territorioPrincipal,vecinosTOLIST);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void agregarTerritorio(String territorioPrincipal, List<String> vecinos) {
        lista.put(territorioPrincipal, new ArrayList<>(vecinos));
    }
    @Override
    public String toString() {
        return lista.toString();
    }
    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        mapa.loadWorld();
        System.out.println(mapa.toString());
    }
}


