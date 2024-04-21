import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestMapa {

    private Mapa mapa;


    @BeforeEach
    void setUp() {
        mapa = new Mapa();
    }

    @Test
    void testGetNombresTerritorios() {
        List<String> nombresTerritorios = mapa.getNombresTerritorios();
        assertNotNull(nombresTerritorios);
        assertFalse(nombresTerritorios.isEmpty());
    }

    @Test
    void testGetTerritorios() {
        List<String> territorios = mapa.getTerritorios();
        assertNotNull(territorios);
        assertFalse(territorios.isEmpty());
    }

    @Test
    void testToString() {
        assertNotNull(mapa.toString());
    }
}