import java.util.Arrays;

public class ClientePF extends Cliente{
    protected String cpf;
    protected String agencia;
    protected ContaPF[] contasPF;

    public ClientePF(String nome, String email, String tipoPFouPJ, String cpf, ContaPF[] contasPF) {
        super(nome, email, tipoPFouPJ);
        this.cpf = cpf;
        this.agencia = "0001-9";
        this.contasPF = contasPF;
    }

    @Override
    public String getAgencia() {
        return agencia;
    }

    @Override
    public ContaPF[] getContasPF() {
        return contasPF;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome +
                ", email: " + email +
                ", é PF ou PJ: " + tipoPFouPJ +
                ", cpf: " + cpf +
                ", agencia: " + agencia;
    }
}