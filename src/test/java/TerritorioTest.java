import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TerritorioTest {

    private Territorio territorio;

    @BeforeEach
    void setUp() {
        territorio = new Territorio("Japon");
    }

    @Test
    void testGetNombre() {
        assertEquals("Japon", territorio.getNombre());
    }

    @Test
    void testSetNumEjercitos() {
        territorio.setNumEjercitos(10);
        assertEquals(10, territorio.getNumEjercitos());
    }

    @Test
    void testVecinos() {
        List<Territorio> vecinos = territorio.vecinos();
        assertEquals(2, vecinos.size());
        assertEquals("Kamchatka", vecinos.get(0).getNombre());
        assertEquals("Mongolia", vecinos.get(1).getNombre());
    }
}