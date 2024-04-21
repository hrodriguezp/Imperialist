import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestTerritorio {

    private Territorio territorio;


    @BeforeEach
    void setUp() {
        territorio = new Territorio("Japon");
        Territorio coreaDelSur = new Territorio("Corea del Sur");
        Territorio china = new Territorio("China");
        List<Territorio> vecinos = new ArrayList<>();
    }


    @Test
    void testAtacarTerritorio() {
        //TODO: DONE
        territorio.setNumEjercitos(Ctes.NUM_EJERCITOS4);
        territorio.atacarTerritorio(3);
        assertEquals(27, territorio.getNumEjercitos());
    }

    @Test
    void testGetNombre() {
        //TODO: DONE
        assertEquals("Japon", territorio.getNombre());
    }

    @Test
    void testSetNumEjercitos() {
        //TODO: DONE
        territorio.setNumEjercitos(Ctes.NUM_EJERCITOS4);
        assertEquals(30, territorio.getNumEjercitos());
    }

    @Test
    void testGetNumEjercitos() {
        //TODO: DONE
        territorio.setNumEjercitos(Ctes.NUM_EJERCITOS4);
        assertEquals(30, territorio.getNumEjercitos());
    }

    @Test
    void testSetPropietario() {
        //TODO: DONE
        territorio.setPropietario(new Jugador("Aimar"));
        assertEquals("Aimar", territorio.getPropietario().getNombre());
    }

    @Test
    void testGetPropietario() {
        //TODO: DONE
        territorio.setPropietario(new Jugador("Asier"));
        assertEquals("Asier", territorio.getPropietario().getNombre());
    }

    @Test
    void testSetVecinos() {
        //TODO: DONE
        List<Territorio> vecinos = new ArrayList<>();
        vecinos.add(new Territorio("Rusia"));
        vecinos.add(new Territorio("Alaska"));
        territorio.setVecinos((ArrayList<Territorio>) vecinos);
        assertEquals(vecinos, territorio.getVecinos());
    }

    @Test
    void testGetVecinos() {
        //TODO: DONE
        List<Territorio> vecinos = new ArrayList<>();
        vecinos.add(new Territorio("Rusia"));
        vecinos.add(new Territorio("Alaska"));
        territorio.setVecinos((ArrayList<Territorio>) vecinos);
        assertEquals(vecinos, territorio.getVecinos());
    }

    @Test
    void testEsVecino() {
        //TODO: DONE
        Territorio territorio1 = new Territorio("Territorio1");
        Territorio territorio2 = new Territorio("Territorio2");
        Territorio territorio3 = new Territorio("Territorio3");
        territorio1.addVecino(territorio2);
        territorio1.addVecino(territorio3);
        assertTrue(territorio1.esVecino(territorio2));
        assertTrue(territorio1.esVecino(territorio3));
        assertFalse(territorio2.esVecino(territorio3));
    }


    @Test
    void testGetNombresVecinos() {
        //TODO: DONE
        Territorio territorio1 = new Territorio("Territorio1");
        Territorio territorio2 = new Territorio("Territorio2");
        Territorio territorio3 = new Territorio("Territorio3");
        territorio1.addVecino(territorio2);
        territorio1.addVecino(territorio3);
        ArrayList<String> nombresVecinos = new ArrayList<>(Arrays.asList("Territorio2", "Territorio3"));
        assertEquals(nombresVecinos, territorio1.getNombresVecinos());
    }

    @Test
    void testAddVecino() {
        //TODO: DONE
        Territorio territorio1 = new Territorio("Territorio1");
        Territorio territorio2 = new Territorio("Territorio2");
        territorio1.addVecino(territorio2);
        assertTrue(territorio1.esVecino(territorio2));
    }

    @Test
    void testPierdeEjercito() {
        //TODO: Done
        territorio.setNumEjercitos(Ctes.NUM_EJERCITOS4);
        territorio.pierdeEjercito();
        assertEquals(29, territorio.getNumEjercitos());
    }

    @Test
    void testToString() {
        //TODO: DONE
        Territorio territorio = new Territorio("Territorio");
        assertEquals("Territorio{nombre='Territorio', numEjercitos=1, vecinos=[]}", territorio.toString());
    }
}