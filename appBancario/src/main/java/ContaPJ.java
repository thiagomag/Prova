import java.math.BigDecimal;
import java.util.Scanner;

public class ContaPJ implements MovimentosConta, MovimentosCI, TaxaSaque, TaxaInvestimento {
    protected int numeroConta;
    protected BigDecimal saldoCC;
    protected BigDecimal saldoCI;

    public ContaPJ(int numeroConta, BigDecimal saldoCC, BigDecimal saldoCI) {
        this.numeroConta = numeroConta;
        this.saldoCI = saldoCI;
        this.saldoCC = saldoCC;
    }


    public BigDecimal getSaldoCC() {
        return saldoCC;
    }

    public void setSaldoCC(BigDecimal saldoCC) {
        this.saldoCC = saldoCC;
    }

    public BigDecimal getSaldoCI() {
        return saldoCI;
    }

    public void setSaldoCI(BigDecimal saldoCI) {
        this.saldoCI = saldoCI;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    @Override
    public String toString() {
        return "Numero da conta: " + numeroConta +
                ", saldo conta corrente: " + saldoCC +
                ", saldo conta investimento: \n" + saldoCI;
    }

    @Override
    public BigDecimal sacar(BigDecimal saque) {
        if (this.saldoCC.compareTo(saque) >= 0) {
            this.saldoCC = this.saldoCC.subtract(saque.add(saque.multiply(taxaSaqueTransferencia())));
            return saldoCC;
        } else {
            return null;
        }
    }

    @Override
    public BigDecimal depositar(BigDecimal deposito) {
        this.saldoCC = this.saldoCC.add(deposito);
        return saldoCC;
    }

    @Override
    public BigDecimal transferir(BigDecimal transfere) {
        if (this.saldoCC.compareTo(transfere) >= 0) {
            this.saldoCC = this.saldoCC.subtract(transfere.add(transfere.multiply(taxaSaqueTransferencia())));
        } else return null;
        return saldoCC;
    }

    @Override
    public BigDecimal aplicar(BigDecimal deposito, int prazo) {
        this.saldoCI = (this.saldoCI.add(deposito)).multiply((new BigDecimal(1).add(taxaInvestimento())).pow(prazo));
        return saldoCI;
    }

    @Override
    public BigDecimal resgatar(BigDecimal valorResgate) {
        if (this.saldoCI.compareTo(valorResgate) >= 0) {
            this.saldoCI = this.saldoCI.subtract(valorResgate);
            return saldoCI;
        }
        return null;
    }

    @Override
    public BigDecimal taxaSaqueTransferencia() {
        return new BigDecimal("0.005");
    }

    @Override
    public BigDecimal taxaInvestimento() {
        return new BigDecimal("0.02");
    }


    public void saldo() {
        System.out.printf("O saldo da conta corrente é ---> R$ %.2f\n", this.getSaldoCC());
        System.out.printf("O saldo da conta investimento é ---> R$ %.2f\n", this.getSaldoCI());
    }


    public void deposito(Scanner input) {
        System.out.println("Informe o valor do deposito na conta corrente?");
        BigDecimal deposito = input.nextBigDecimal();
        BigDecimal novoSaldoCC = this.depositar(deposito);
        this.setSaldoCC(novoSaldoCC);
    }


    public void transferencia(Scanner input) {
        System.out.println("Informe o valor da transferência:");
        BigDecimal transferencia = input.nextBigDecimal();
        System.out.println("Escolha o tipo de transferencia a ser feita:\n" +
                "1 - Transferir de conta corrente para conta de outra titularidade\n");
        int tipoTrans = input.nextInt();
        if (tipoTrans == 1) {
            BigDecimal novoSaldoCC = this.transferir(transferencia);
            if (novoSaldoCC == null) {
                System.out.println("Conta não possui saldo suficiente");
            } else {
                this.setSaldoCC(novoSaldoCC);
            }
        }
    }


    public void investir(Scanner input) {
        System.out.println("Informe o valor a ser investido (O valor investido sairá da conta corrente):");
        BigDecimal valorInvestido = input.nextBigDecimal();
        BigDecimal novoSaldoCC = this.transferir(valorInvestido);
        if (novoSaldoCC == null) {
            System.out.println("Conta não possui saldo suficiente para aplicar");
        } else {
            this.setSaldoCC(novoSaldoCC);
            System.out.println("Informe o prazo do investimento:");
            int prazo = input.nextInt();
            BigDecimal novoSaldoCI = this.aplicar(valorInvestido, prazo);
            this.setSaldoCI(novoSaldoCI);
        }
    }


    public void resgatar(Scanner input) {
        System.out.println("Informe o valor a ser resgatado (O valor resgatado irá para conta corrente):");
        BigDecimal valorResgate = input.nextBigDecimal();
        BigDecimal novoSaldoCI = this.resgatar(valorResgate);
        this.setSaldoCI(novoSaldoCI);
        BigDecimal novoSaldoCC = this.depositar(valorResgate);
        this.setSaldoCC(novoSaldoCC);
    }

    public void sacar(Scanner input) {
        System.out.println("Informe o valor do saque da conta corrente:");
        BigDecimal deposito = input.nextBigDecimal();
        BigDecimal novoSaldoCC = this.sacar(deposito);
        if (novoSaldoCC == null) {
            System.out.println("Conta não possui saldo suficiente");
        } else {
            this.setSaldoCC(novoSaldoCC);
        }
    }
}
