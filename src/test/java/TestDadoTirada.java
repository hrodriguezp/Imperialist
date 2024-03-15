import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDadoTirada {
    @Test
    public void testDadoValorEntreUnoYSeis() {
        Dado dado = new Dado();
        int valor = dado.getValor();
        assertTrue(valor >= 1 && valor <= 6);
    }

    @Test
    public void testTiradaConstructor() {
        Tirada tirada = new Tirada(3);
        assertNotNull(tirada);
    }

    @Test
    public void testTiradaGetValor() {
        Tirada tirada = new Tirada(3);
        int valor = tirada.getValor(1);
        assertTrue(valor >= 1 && valor <= 6);
    }

    @Test
    public void testTiradaCompararTirada() {
        Tirada tirada1 = new Tirada(3);
        Tirada tirada2 = new Tirada(3);
        int perdidas = tirada1.compararTirada(tirada2);
        assertTrue(perdidas >= 0 && perdidas <= 3);
    }
}
