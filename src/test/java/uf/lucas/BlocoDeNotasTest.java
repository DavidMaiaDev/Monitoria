package uf.lucas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlocoDeNotasTest {

    private BlocoDeNotas blocoDeNotas;

    @BeforeEach
    void setUp() {
        blocoDeNotas = new BlocoDeNotas();
    }

    @Test
    void adicionarAnotacao_dandoCerto() throws Exception {
        Anotacao anotacao = new Anotacao("Sample text");
        boolean verificar = blocoDeNotas.adicionarAnotacao(anotacao);
        assertTrue(verificar);

        blocoDeNotas.removerAnotacao(1);
    }

    @Test
    void editarAnotacao_dandoCerto() throws Exception {
        Anotacao anotacao = new Anotacao("Sample text");
        blocoDeNotas.adicionarAnotacao(anotacao);
        blocoDeNotas.editarAnotacao(1, "novo texto");
        assertEquals("novo texto", anotacao.getText());

        blocoDeNotas.removerAnotacao(1);
    }

    @Test
    void editarAnotacao_dandoErrado() throws Exception {
        Anotacao anotacao = new Anotacao("Sample text");
        blocoDeNotas.adicionarAnotacao(anotacao);
        blocoDeNotas.editarAnotacao(2, "novo texto");
        assertNotEquals("novo texto", anotacao.getText());

        blocoDeNotas.removerAnotacao(1);
    }

    @Test
    void removerAnotacao_dandoCerto() throws Exception {
        Anotacao anotacao = new Anotacao("Sample text");
        blocoDeNotas.adicionarAnotacao(anotacao);
        blocoDeNotas.removerAnotacao(1);
        assertTrue(blocoDeNotas.getAnotacoes().isEmpty());
    }

    @Test
    void removerAnotacao_dandoErrado() throws Exception {
        Anotacao anotacao = new Anotacao("Sample text");
        blocoDeNotas.adicionarAnotacao(anotacao);
        blocoDeNotas.removerAnotacao(2);
        assertFalse(blocoDeNotas.getAnotacoes().isEmpty());
    }

    @Test
    void buscarAnotacoes_dandoCerto() throws Exception {
        Anotacao anotacao = new Anotacao("Sample text");
        blocoDeNotas.adicionarAnotacao(anotacao);

        Anotacao anotacaoProcurar = blocoDeNotas.buscarAnotacoesPorTexto("Sample");
        assertNotNull(anotacaoProcurar);
        assertEquals(anotacao, anotacaoProcurar);
    }

    @Test
    void buscarAnotacoes_lancandoThrow() throws Exception {
        Anotacao anotacao = new Anotacao("Sample text");
        blocoDeNotas.adicionarAnotacao(anotacao);

        assertThrows(Exception.class, () -> blocoDeNotas.buscarAnotacoesPorTexto("teste"));
    }
}