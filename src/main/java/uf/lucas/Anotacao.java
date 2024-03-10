package uf.lucas;
import java.time.LocalDate;

public class Anotacao {
    private int id;
    private static int nextId = 1;
    private String text;
    private LocalDate dataCriacao;

    public Anotacao(String text) {
        this.text = text;
        this.id = nextId++;
        this.dataCriacao = LocalDate.now(); //Data atual
    }

    public String getText() {
        return this.text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "numeroIdentificacao=" + this.id +
                ", texto='" + this.text + '\'' +
                ", dataCriacao=" + this.dataCriacao +
                '}';
    }
}