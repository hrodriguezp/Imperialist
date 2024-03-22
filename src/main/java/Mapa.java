import java.io.*;
import java.util.*;

public class Mapa {

    private Map<String, Territorio> lista;
    private Map<String, List<String>> nombres;
    private ArrayList<String> tPrincipal;


    public Mapa() {
        this.lista = new LinkedHashMap<>();
        this.nombres = new LinkedHashMap<>();
        this.tPrincipal = new ArrayList<>();
        loadWorld();
    }

//    public void loadWorld() {
//        String line;
//        File file = new File(Ctes.PATH_TERRITORIOS);
//        HashMap<String, ArrayList<String>> conVecinos = new HashMap<>();
//        ArrayList<String> terrPrim = new ArrayList<>();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            while ( (line = reader.readLine()) != null ) {
//                if (line.isEmpty()) { continue; }
//                String[] a = line.split(Ctes.EXP_TERRITORIO_SPLITTER);
//
//                String [] st = a[0].split(":");
//                String territorioPrincipal = st[0];
//                Territorio territorioPrin = new Territorio(territorioPrincipal);
//                String[] vecinos = st[1].split(", ");
//                ArrayList<String> vecinosTOLIST = new ArrayList<>(Arrays.stream(vecinos).toList());
//                terrPrim.add(territorioPrincipal);
//                conVecinos.put(territorioPrincipal ,vecinosTOLIST);
//                lista.put(territorioPrincipal,territorioPrin);
//            }
//            for (int i = 0; i < lista.size(); i++) {
//                String nTerritorio = terrPrim.get(i);
//                ArrayList<String> vecinosSt = conVecinos.get(nTerritorio);
//                ArrayList<Territorio> vecinos = new ArrayList<>();
//                for (int j = 0; j < vecinosSt.size(); j++) {
//                    vecinos.add(lista.get(vecinosSt.get(i)));
//                }
//                lista.get(nTerritorio).setVecinos(vecinos);
//            }
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void cargarNombres() {
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
                tPrincipal.add(territorioPrincipal);
                String[] vecinos = st[1].split(", ");
                List<String> vecinosTOLIST = new ArrayList<>(Arrays.stream(vecinos).toList());
                nombres.put(territorioPrincipal,vecinosTOLIST);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadWorld(){
        cargarNombres();
        for (int i = 0; i < nombres.size(); i++) {
            Territorio territorio = new Territorio(tPrincipal.get(i));
            lista.put(tPrincipal.get(i),territorio);
        }
        for (int i = 0; i <lista.size(); i++) {
            List<String> vString = nombres.get(tPrincipal.get(i));
            ArrayList<Territorio> vecinos = new ArrayList<>();
            for (int j = 0; j < vString.size(); j++) {
                vecinos.add(lista.get(vString.get(j)));
            }
            lista.get(tPrincipal.get(i)).setVecinos(vecinos);
        }
        System.out.println(nombres.toString());
    }

    public void agregarTerritorio(String territorioPrincipal, List<String> vecinos) {
        nombres.put(territorioPrincipal, new ArrayList<>(vecinos));
    }

    public List<String> getTerritorios() {
        return new ArrayList<>(nombres.keySet());
    }

    public ArrayList<String> getVecinos(String territorio){
        return (ArrayList<String>) nombres.get(territorio);
    }
    @Override
    public String toString() {
        return nombres.toString();
    }
    public void pintar(){
        for (String s : nombres.keySet()) {
            System.out.println(nombres.get(s));
        }
    }

    public static void main(String[] args) {
        Mapa mapa = new Mapa();
    }
}