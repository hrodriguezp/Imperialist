import java.io.*;
import java.util.*;

public class Mapa {

    private Map<String, Territorio> lista;


   public Mapa() {
       this.lista = new LinkedHashMap<>();
       loadWorld();
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
                String[] a = line.split(Ctes.EXP_TERRITORIO_SPLITTER);

                String [] st = a[0].split(":");
                String territorioPrincipal = st[0];
                Territorio territorioPrin = new Territorio(territorioPrincipal);
                String[] vecinos = st[1].split(", ");
                ArrayList<String> vecinosTOLIST = new ArrayList<>(Arrays.stream(vecinos).toList());
                terrPrim.add(territorioPrincipal);
                conVecinos.put(territorioPrincipal ,vecinosTOLIST);
                lista.put(territorioPrincipal,territorioPrin);
            }
            for (int i = 0; i < lista.size(); i++) {
                String nTerritorio = terrPrim.get(i);
                ArrayList<String> vecinosSt = conVecinos.get(nTerritorio);
                ArrayList<Territorio> vecinos = new ArrayList<>();
                for (int j = 0; j < vecinosSt.size(); j++) {
                    vecinos.add(lista.get(vecinosSt.get(i)));
                }
                lista.get(nTerritorio).setVecinos(vecinos);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public void agregarTerritorio(String territorioPrincipal, List<String> vecinos) {
//        lista.put(territorioPrincipal, new ArrayList<>(vecinos));
//    }
//
//    public List<String> getTerritorios() {
//        return new ArrayList<>(lista.keySet());
//    }
//
//    public ArrayList<String> getVecinos(String territorio){
//       return (ArrayList<String>) lista.get(territorio);
//    }
//    @Override
//    public String toString() {
//        return lista.toString();
//    }
//    public void pintar(){
//        for (String s : lista.keySet()) {
//            System.out.println(lista.get(s));
//        }
//    }

    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        mapa.loadWorld();
    }
    }