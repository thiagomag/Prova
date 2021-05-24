import java.util.Arrays;

public class ClientePJ extends Cliente {
    protected String cnpj;
    protected String agencia;
    protected ContaPJ[] contasPJ;

    public ClientePJ(String nome, String email, String tipoPFouPJ, String cnpj, ContaPJ[] contasPJ) {
        super(nome, email, tipoPFouPJ);
        this.cnpj = cnpj;
        this.agencia = "0080-9";
        this.contasPJ = contasPJ;
    }

    @Override
    public String getAgencia() {
        return agencia;
    }

    @Override
    public ContaPJ[] getContasPJ() {
        return contasPJ;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome +
                ", email: " + email +
                ", é PF ou PJ: " + tipoPFouPJ +
                ", cnpj: " + cnpj +
                ", agencia: " + agencia;
    }
}
