package uf.lucas;

public class Main {
    public static void main(String[] args) {
        BlocoDeNotas blocoDeNotas = new BlocoDeNotas();


        Anotacao anotacao = new Anotacao("testando bloco de notas!");
        Anotacao anotacao2 = new Anotacao("Novo teste");

        try {
            blocoDeNotas.adicionarAnotacao(anotacao);
            blocoDeNotas.adicionarAnotacao(anotacao2);
            blocoDeNotas.buscarAnotacoesPorTexto("Novo teste");
            //System.out.println(blocoDeNotas.listarAnotacoes());
            //blocoDeNotas.editarAnotacao(2, "Novo texto para teste");
            //blocoDeNotas.removerAnotacao(1);
            //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            //System.out.println(blocoDeNotas.listarAnotacoes());
            // blocoDeNotas.listarExclusoes();
            //blocoDeNotas.listarExclusoes();
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}