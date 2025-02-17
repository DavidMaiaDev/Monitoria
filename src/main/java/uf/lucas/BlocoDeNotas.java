package uf.lucas;
import java.util.ArrayList;
import java.util.List;

public class BlocoDeNotas extends Exception{
    private List<Anotacao> anotacoes;
    private List<Anotacao> exclusoes;


    public BlocoDeNotas() {
        this.anotacoes = new ArrayList<>();
        this.exclusoes = null;
    }

    public List<Anotacao> getAnotacoes() {
        return this.anotacoes;
    }

    public List<Anotacao> getExclusoes() {
        return this.exclusoes;
    }

    public boolean adicionarAnotacao(Anotacao anotacao) {
        return this.anotacoes.add(anotacao);
    }

    public void editarAnotacao(int numeroIdentificacao, String novoTexto) throws Exception {
        if(this.anotacoes.isEmpty()) throw new Exception("Lista está vazia!");
        for(Anotacao a : this.anotacoes) {
            if(a.getId() == numeroIdentificacao) {
                a.setText(novoTexto);
                return;
            }
        }
    }

    public boolean removerAnotacao(int numeroIdentificacao) throws Exception {
        if (exclusoes == null) {
            this.exclusoes = new ArrayList<>();
        }
        if(this.anotacoes.isEmpty()) throw new Exception("Lista está vazia!");

        for(Anotacao a : this.anotacoes) {
            if(a.getId() == numeroIdentificacao) {
                this.exclusoes.add(a);
                this.anotacoes.remove(a);
                return true;
            }
        }
        return false;
    }

    public Anotacao buscarAnotacoesPorTexto(String textoBusca) throws Exception {
        if(this.anotacoes.isEmpty()) throw new Exception("Lista está vazia!");
        for (Anotacao anotacao : this.anotacoes) {
            if (anotacao.getText().contains(textoBusca)) {
                return anotacao;
            }
        }
        throw new Exception("Este texto não existe!");
    }

    public List<Anotacao> listarAnotacoes() throws Exception{
        List<Anotacao> listaAuxiliar = new ArrayList<>();
        if(this.anotacoes.isEmpty()) throw new Exception("Lista está vazia!");
        System.out.println("Anotação");
        for (Anotacao anotacao : this.anotacoes) {
            listaAuxiliar.add(anotacao);
        }
        return listaAuxiliar;
    }
    public void listarExclusoes() throws Exception{
        if(this.exclusoes.isEmpty()) throw new Exception("Lista está vazia!");
        System.out.println("Exclusão");
        for (Anotacao anotacao : this.exclusoes) {
            System.out.println(anotacao.toString());
        }
    }
}