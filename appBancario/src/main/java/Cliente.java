import java.util.Scanner;

public class Cliente {
    protected String nome;
    protected String email;
    protected String tipoPFouPJ;

    public Cliente(String nome, String endereco, String tipoPFouPJ) {
        this.nome = nome;
        this.email = endereco;
        this.tipoPFouPJ = tipoPFouPJ;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoPFouPJ() {
        return tipoPFouPJ;
    }

    public Object getAgencia() {
        return null;
    }

    public Object getNumeroConta() {
        return null;
    }

    public ContaPF[] getContasPF() {
        return null;
    }

    public ContaPJ[] getContasPJ() {
        return null;
    }

}
    

