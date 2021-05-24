import java.math.BigDecimal;
import java.util.Scanner;

public class ContaPF implements MovimentosConta, MovimentosCI, MovimentosPO, TaxaInvestimento {
    protected int numeroConta;
    protected BigDecimal saldoCC;
    protected BigDecimal saldoCI;
    protected BigDecimal saldoPO;

    public ContaPF(int numeroConta, BigDecimal saldoCC, BigDecimal saldoCI, BigDecimal saldoPO) {
        this.numeroConta = numeroConta;
        this.saldoCC = saldoCC;
        this.saldoPO = saldoPO;
        this.saldoCI = saldoCI;
    }


    public Object getNumeroConta() {
        return numeroConta;
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

    public BigDecimal getSaldoPO() {
        return saldoPO;
    }

    public void setSaldoPO(BigDecimal saldoPO) {
        this.saldoPO = saldoPO;
    }

    @Override
    public String toString() {
        return  "Numero da conta: " + numeroConta +
                ", saldo conta corrente: " + saldoCC +
                ", saldo conta investimento: " + saldoCI +
                ", saldo poupança: " + saldoPO +
                "\n";
    }

    @Override
    public BigDecimal sacar(BigDecimal saque) {
        if (this.saldoCC.compareTo(saque) >= 0) {
            this.saldoCC = this.saldoCC.subtract(saque);
            return saldoCC;
        } else return null;
    }

    @Override
    public BigDecimal depositar(BigDecimal deposito) {
        this.saldoCC = this.saldoCC.add(deposito);
        return saldoCC;
    }

    @Override
    public BigDecimal transferir(BigDecimal transfere) {
        if (this.saldoCC.compareTo(transfere) >= 0) {
            this.saldoCC = this.saldoCC.subtract(transfere);
            return saldoCC;
        } else return null;
    }

    @Override
    public BigDecimal aplicar(BigDecimal deposito, int prazo) {
        this.saldoCI = (this.saldoCI.add(deposito)).multiply((new BigDecimal(1).add(taxaInvestimento())).pow(prazo));
        return saldoCI;
    }

    @Override
    public BigDecimal resgatar(BigDecimal valorResgate) {
        if (this.saldoCI.compareTo(valorResgate) >= 0){
            this.saldoCI = this.saldoCI.subtract(valorResgate);
            return saldoCI;
        } else return null;
    }

    @Override
    public BigDecimal sacarPO(BigDecimal saque) {
        if (this.saldoPO.compareTo(saque) >= 0) {
            this.saldoPO = this.saldoPO.subtract(saque);
            return saldoPO;
        } else return null;
    }

    @Override
    public BigDecimal depositarPO(BigDecimal deposito) {
        this.saldoPO = this.saldoPO.add(deposito);
        return saldoPO;
    }

    @Override
    public BigDecimal trasferirPO(BigDecimal transfere) {
        if (this.saldoPO.compareTo(transfere) >= 0) {
            this.saldoPO = this.saldoPO.subtract(transfere);
            return saldoPO;
        } else return null;
    }

    @Override
    public BigDecimal taxaInvestimento() {
        return new BigDecimal("0.01");
    }

    public void saldo() {
        System.out.printf("O saldo da conta corrente é ---> R$ %.2f\n", this.getSaldoCC());
        System.out.printf("O saldo da conta investimento é ---> R$ %.2f\n", this.getSaldoCI());
        System.out.printf("O saldo da conta poupança é ---> R$ %.2f\n", this.getSaldoPO());
    }


    public void deposito(Scanner input) {
        System.out.println("Informe o valor do deposito?");
        BigDecimal deposito = input.nextBigDecimal();

        System.out.println("Em qual conta gostaria de depositar?\n" +
                "1 - Conta Corrente\n" +
                "2 - Conta Poupança");
        int conta = input.nextInt();

        switch (conta) {
            case 1:
                BigDecimal novoSaldoCC = this.depositar(deposito);
                this.setSaldoCC(novoSaldoCC);
                break;
            case 2:
                BigDecimal novoSaldoPO = this.depositarPO(deposito);
                this.setSaldoPO(novoSaldoPO);
                break;
        }
    }


    public void transferencia(Scanner input) {
        System.out.println("Informe o valor da transferência:");
        BigDecimal transferencia = input.nextBigDecimal();
        System.out.println("Escolha o tipo de transferencia a ser feita:\n" +
                "1 - Transferir de conta corrente para conta de outra titularidade\n" +
                "2 - Transferir de conta poupanca para conta de outra titularidade\n" +
                "3 - transferir da conta corrente para conta poupanca\n" +
                "4 - transferir da conta poupança para conta corrente");
        int tipoTrans = input.nextInt();
        switch (tipoTrans) {
            case 1:
                BigDecimal novoSaldoCC = this.transferir(transferencia);
                if (novoSaldoCC == null) {
                    System.out.println("Conta não possui saldo suficiente");
                } else {
                    this.setSaldoCC(novoSaldoCC);
                }
                break;
            case 2:
                BigDecimal novoSaldoPO = this.trasferirPO(transferencia);
                if (novoSaldoPO == null) {
                    System.out.println("Conta não possui saldo suficiente");
                } else {
                    this.setSaldoPO(novoSaldoPO);
                }
                break;
            case 3:
                BigDecimal novoSaldoCC2 = this.transferir(transferencia);
                if (novoSaldoCC2 == null) {
                    System.out.println("Conta não possui saldo suficiente");
                } else {
                    this.setSaldoCC(novoSaldoCC2);
                    BigDecimal novoSadoPO2 = this.depositarPO(transferencia);
                    this.setSaldoPO(novoSadoPO2);
                }
                break;
            case 4:
                BigDecimal novoSaldoPO3 = this.trasferirPO(transferencia);
                if (novoSaldoPO3 == null) {
                    System.out.println("Conta não possui saldo suficiente");
                } else {
                    this.setSaldoPO(novoSaldoPO3);
                    BigDecimal novoSaldoCC3 = this.depositar(transferencia);
                    this.setSaldoCC(novoSaldoCC3);
                }
                break;
        }
    }


    public void investir(Scanner input) {
        System.out.println("Informe o valor a ser investido:");
        BigDecimal valorInvestido = input.nextBigDecimal();
        BigDecimal novoSaldoCC = this.transferir(valorInvestido);
        if(novoSaldoCC == null){
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
        if(novoSaldoCI == null){
            System.out.println("Saldo insuficiente na conta investimento");
        } else {
            this.setSaldoCI(novoSaldoCI);
            BigDecimal novoSaldoCC = this.depositar(valorResgate);
            this.setSaldoCC(novoSaldoCC);
        }
    }


    public void saque(Scanner input) {
        System.out.println("Informe o valor do saque?");
        BigDecimal saque = input.nextBigDecimal();

        System.out.println("Em qual conta gostaria de sacar?\n" +
                "1 - Conta Corrente\n" +
                "2 - Conta Poupança");
        int conta = input.nextInt();

        switch (conta) {
            case 1:
                BigDecimal novoSaldoCC = this.sacar(saque);
                System.out.println(this.saldoCC.compareTo(this.saldoCC.subtract(saque)));
                if (novoSaldoCC == null) {
                    System.out.println("Conta não possui saldo suficiente");
                } else {
                    this.setSaldoCC(novoSaldoCC);
                }
                break;
            case 2:
                BigDecimal novoSaldoPO = this.sacarPO(saque);
                if (novoSaldoPO == null) {
                    System.out.println("Conta não possui saldo suficiente");
                } else {
                    this.setSaldoPO(novoSaldoPO);
                }
                break;
        }
    }
}
