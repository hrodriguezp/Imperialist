import java.io.*;
import java.util.*;

public class Mapa {

    private Map<String, Territorio> mapaNombresTerritorios;
   // private Map<String, List<String>> nombres;
    //private ArrayList<String> tPrincipal;


    public Mapa() {
        this.mapaNombresTerritorios = new LinkedHashMap<>();
       // this.nombres = new LinkedHashMap<>();
       // this.tPrincipal = new ArrayList<>();
        loadWorld();
    }

    public ArrayList<String> getNombresTerritorios(){
        return new ArrayList<>(mapaNombresTerritorios.keySet());
    }


    public void loadWorld() {
        String line;
        File file = new File(Ctes.PATH_TERRITORIOS);
        HashMap<String, ArrayList<String>> conVecinos = new HashMap<>();
        ArrayList<String> terrPrim = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ( (line = reader.readLine()) != null ) {
                if (line.isEmpty()) { continue; }
                String[] a = line.split(":");
                String nombreTerritorio = a[0].trim();
                Territorio territorio = mapaNombresTerritorios.get(nombreTerritorio);
                if (territorio == null) {
                    territorio = new Territorio(nombreTerritorio);
                    mapaNombresTerritorios.put(nombreTerritorio, territorio);
                }

                if (a.length > 1) {
                    String[] nombresVecinos = a[1].trim().split(",");
                    for (String nombreVecino : nombresVecinos) {
                        nombreVecino = nombreVecino.trim();

                        Territorio territorioVecino = mapaNombresTerritorios.get(nombreVecino);
                        if (territorioVecino==null){
                            territorioVecino = new Territorio(nombreVecino);
                            mapaNombresTerritorios.put(nombreVecino, territorioVecino);
                        }
                        territorio.addVecino(territorioVecino);
                    }
                }

            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//
//    public void cargarNombres() {
//        String line;
//        File file = new File(Ctes.PATH_TERRITORIOS);
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            while ( (line = reader.readLine()) != null ) {
//                if (line.isEmpty()) { continue; }
//                String[] a = line.split(Ctes.EXP_TERRITORIO_SPLITTER);
//                String [] st = a[0].split(":");
//                String territorioPrincipal = st[0];
//                tPrincipal.add(territorioPrincipal);
//                String[] vecinos = st[1].split(", ");
//                List<String> vecinosTOLIST = new ArrayList<>(Arrays.stream(vecinos).toList());
//                nombres.put(territorioPrincipal,vecinosTOLIST);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void loadWorld(){
//        cargarNombres();
//        for (int i = 0; i < nombres.size(); i++) {
//            Territorio territorio = new Territorio(tPrincipal.get(i));
//            mapaNombresTerritorios.put(tPrincipal.get(i),territorio);
//        }
//        for (int i = 0; i < mapaNombresTerritorios.size(); i++) {
//            List<String> vString = nombres.get(tPrincipal.get(i));
//            ArrayList<Territorio> vecinos = new ArrayList<>();
//            for (String s : vString) {
//                vecinos.add(mapaNombresTerritorios.get(s));
//            }
//            mapaNombresTerritorios.get(tPrincipal.get(i)).setVecinos(vecinos);
//        }
//        System.out.println(nombres.toString());
//    }

    public void agregarTerritorio(String nombreTerritorio, List<String> vecinos) {
        Territorio territorio = new Territorio(nombreTerritorio);
        for (String vecino : vecinos) {
            territorio.addVecino(vecino);
        }
        mapaNombresTerritorios.put(nombreTerritorio, territorio);
    }


    public List<String> getTerritorios() {
        return new ArrayList<>(mapaNombresTerritorios.keySet());
    }

    public ArrayList<Territorio> getVecinos(String territorio){
       return mapaNombresTerritorios.get(territorio).getVecinos();
    }
    @Override
    public String toString() {
//        return nombres.toString();
        return mapaNombresTerritorios.toString();
    }
    public void pintar(){
        for (String s : mapaNombresTerritorios.keySet()) {
            System.out.println(mapaNombresTerritorios.get(s));
        }
    }

    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        mapa.pintar();
    }
}