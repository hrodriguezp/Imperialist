import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TestJugador {

    private Jugador jugador;


    @BeforeEach
    void setUp() {
        jugador = new Jugador("Jugador1");
    }


    @Test
    void testGetTerritorios() {
        //TODO: DONE
        assertEquals(0, jugador.getTerritorios().size());
    }

    @Test
    void testSetTerritorios() {
        //TODO: DONE
        List<Territorio> territorios = new ArrayList<>();
        Territorio territorio1 = new Territorio("Territorio1");
        Territorio territorio2 = new Territorio("Territorio2");
        territorios.add(territorio1);
        territorios.add(territorio2);
        ArrayList<Territorio> territoriosArrayList = new ArrayList<>(territorios);
        jugador.setTerritorios(territoriosArrayList);
        assertTrue(jugador.getTerritorios().contains(territorio1));
        assertTrue(jugador.getTerritorios().contains(territorio2));
    }

    @Test
    void testGetNombre() {
        //TODO: DONE
        assertEquals("Jugador1", jugador.getNombre());
    }

    @Test
    void testSetNombre() {
        //TODO: DONE
        jugador.setNombre("NuevoNombre");
        assertEquals("NuevoNombre", jugador.getNombre());
    }

    @Test
    void testGetSiglas() {
        //TODO: DONE
        assertEquals("UGA", jugador.getSiglas());
    }

    @Test
    void testSetSiglas() {
        //TODO: DONE
        jugador.setSiglas("NEW");
        assertEquals("NEW", jugador.getSiglas());
    }

    @Test
    void testGetEjercitoDisponible() {
        //TODO: DONE
        assertEquals(0, jugador.getEjercitoDisponible());
    }

    @Test
    void testSetEjercitoDisponible() {
        //TODO: DONE
        jugador.setEjercitoDisponible(10);
        assertEquals(10, jugador.getEjercitoDisponible());
    }

    void testColocarEjercitosPrincipio_suficientesEjercitos() {
        //TODO: DONE
        Territorio territorio = new Territorio("Territorio");
        jugador.setEjercitoDisponible(5);
        jugador.colocarEjercitosPrincipio(territorio, 3);
        assertEquals(4, territorio.getNumEjercitos());
        assertEquals(2, jugador.getEjercitoDisponible());
    }

    @Test
    void testColocarEjercitosPrincipio_insuficientesEjercitos() {
        //TODO: DONE
        Territorio territorio = new Territorio("Territorio");
        jugador.setEjercitoDisponible(2);
        jugador.colocarEjercitosPrincipio(territorio, 3);
        assertEquals(1, territorio.getNumEjercitos());
        assertEquals(2, jugador.getEjercitoDisponible());
    }

    @Test
    void testAddTerritorios() {
        //TODO: DONE
        Territorio territorio = new Territorio("Territorio");
        jugador.addTerritorios(territorio);
        assertTrue(jugador.getTerritorios().contains(territorio));
    }

    @Test
    void testAtacar() {
        //TODO
    }

    @Test
    void testEstaTerritorio() {
        //TODO: DONE
        Territorio territorio = new Territorio("Territorio");
        jugador.addTerritorios(territorio);
        assertTrue(jugador.estaTerritorio(territorio));
    }

    @Test
    void testToString() {
        //TODO: DONE
        assertEquals("Jugador{nombre='Jugador1', siglas='UGA', ejercitoDisponible=0}", jugador.toString());
    }
}