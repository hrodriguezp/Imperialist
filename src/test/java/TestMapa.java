import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMapa {

        @Test
        public void testAgregarTerritorio() {
            Mapa mapa = new Mapa();
            List<String> vecinosTerritorio1 = Arrays.asList("Territorio2", "Territorio3");
            mapa.agregarTerritorio("Territorio1", vecinosTerritorio1);
            assertTrue(mapa.toString().contains("Territorio1=[Territorio2, Territorio3]"));
        }

        @Test
        public void testAgregarTerritorioExistente() {
            Mapa mapa = new Mapa();
            List<String> vecinosTerritorio1 = Arrays.asList("Territorio2", "Territorio3");
            mapa.agregarTerritorio("Territorio1", vecinosTerritorio1);
            // Agregar territorio existente con vecinos diferentes
            List<String> nuevosVecinosTerritorio1 = Arrays.asList("Territorio4", "Territorio5");
            mapa.agregarTerritorio("Territorio1", nuevosVecinosTerritorio1);
            assertTrue(mapa.toString().contains("Territorio1=[Territorio4, Territorio5]"));
        }

        @Test
        public void testToString() {
            Mapa mapa = new Mapa();
            List<String> vecinosTerritorio1 = Arrays.asList("Territorio2", "Territorio3");
            mapa.agregarTerritorio("Territorio1", vecinosTerritorio1);
            String resultadoEsperado = "{Territorio1=[Territorio2, Territorio3]}";
            assertEquals(resultadoEsperado, mapa.toString());
        }
}


