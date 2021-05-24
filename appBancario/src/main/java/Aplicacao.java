import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Aplicacao {
    private static ArrayList<Cliente> contasArrayList = new ArrayList<>();
    private static ArrayList<ContaPF> contaPFArrayList = new ArrayList<>();
    private static ArrayList<ContaPJ> contaPJArrayList = new ArrayList<>();
    private static Cliente cliente;
    private static String tipoPFouPJ;
    private static int novaConta;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n;

        do {
            System.out.println("-----Escolha as opções abaixo-----\n" +
                    "1 - Cadastrar cliente e abrir conta\n" +
                    "2 - Abrir nova conta\n" +
                    "3 - Consulta saldo\n" +
                    "4 - Depositar\n" +
                    "5 - Transferência\n" +
                    "6 - Investir\n" +
                    "7 - Resgatar\n" +
                    "8 - Sacar\n" +
                    "9 - Dados conta atual\n" +
                    "10 - Selecionar Conta\n" +
                    "0 - Sair");

            n = input.nextInt();

            switch (n) {
                case 1:
                    cadastro();
                    break;
                case 2:
                    if (tipoPFouPJ.equals("PF")) {
                        criarContaPF();
                        System.out.printf("Conta nº %d criada com sucesso\n", novaConta);
                    } else if (tipoPFouPJ.equals("PJ")) {
                        criarContaPJ();
                        System.out.printf("Conta nº %d criada com sucesso\n", novaConta);
                    }
                    break;
                case 3:
                    if (tipoPFouPJ.equals("PF")) {
                        System.out.println("Escolha a conta que queira ver o saldo:");
                        for (int i = 0; i < contaPFArrayList.size(); i++) {
                            System.out.printf("%d - Conta: %s\n", i + 1, contaPFArrayList.get(i).getNumeroConta());
                        }
                        int escolha = input.nextInt();
                        contaPFArrayList.get(escolha - 1).saldo();
                    } else if (tipoPFouPJ.equals("PJ")) {
                        System.out.println("Escolha a conta que queira ver o saldo:");
                        for (int i = 0; i < contaPJArrayList.size(); i++) {
                            System.out.printf("%d - Conta: %s\n", i + 1, contaPJArrayList.get(i).getNumeroConta());
                        }
                        int escolha = input.nextInt();
                        contaPJArrayList.get(escolha - 1).saldo();
                    }
                    break;
                case 4:
                    if (tipoPFouPJ.equals("PF")) {
                        System.out.println("Escolha a conta que queira fazer deposito:");
                        for (int i = 0; i < contaPFArrayList.size(); i++) {
                            System.out.printf("%d - Conta: %s\n", i + 1, contaPFArrayList.get(i).getNumeroConta());
                        }
                        int escolha = input.nextInt();
                        contaPFArrayList.get(escolha - 1).deposito(input);
                    } else if (tipoPFouPJ.equals("PJ")) {
                        System.out.println("Escolha a conta que queira fazer deposito:");
                        for (int i = 0; i < contaPJArrayList.size(); i++) {
                            System.out.printf("%d - Conta: %s\n", i + 1, contaPJArrayList.get(i).getNumeroConta());
                        }
                        int escolha = input.nextInt();
                        contaPJArrayList.get(escolha - 1).deposito(input);
                    }
                    break;
                case 5:
                    if (tipoPFouPJ.equals("PF")) {
                        System.out.println("Escolha a conta para fazer transferencia:");
                        for (int i = 0; i < contaPFArrayList.size(); i++) {
                            System.out.printf("%d - Conta: %s\n", i + 1, contaPFArrayList.get(i).getNumeroConta());
                        }
                        int escolha = input.nextInt();
                        contaPFArrayList.get(escolha - 1).transferencia(input);
                    } else if (tipoPFouPJ.equals("PJ")) {
                        System.out.println("Escolha a conta para fazer transferencia:");
                        for (int i = 0; i < contaPJArrayList.size(); i++) {
                            System.out.printf("%d - Conta: %s\n", i + 1, contaPJArrayList.get(i).getNumeroConta());
                        }
                        int escolha = input.nextInt();
                        contaPJArrayList.get(escolha - 1).transferencia(input);
                    }
                    break;
                case 6:
                    if (tipoPFouPJ.equals("PF")) {
                        System.out.println("Escolha a conta de onde sairá o dinheiro para o investimento:");
                        for (int i = 0; i < contaPFArrayList.size(); i++) {
                            System.out.printf("%d - Conta: %s\n", i + 1, contaPFArrayList.get(i).getNumeroConta());
                        }
                        int escolha = input.nextInt();
                        contaPFArrayList.get(escolha - 1).investir(input);
                    } else if (tipoPFouPJ.equals("PJ")) {
                        System.out.println("Escolha a conta de onde sairá o dinheiro para o investimento:");
                        for (int i = 0; i < contaPJArrayList.size(); i++) {
                            System.out.printf("%d - Conta: %s\n", i + 1, contaPJArrayList.get(i).getNumeroConta());
                        }
                        int escolha = input.nextInt();
                        contaPJArrayList.get(escolha - 1).investir(input);
                    }
                    break;
                case 7:
                    if (tipoPFouPJ.equals("PF")) {
                        System.out.println("Escolha a conta onde se encontra o investimento a ser resgatado:");
                        for (int i = 0; i < contaPFArrayList.size(); i++) {
                            System.out.printf("%d - Conta: %s\n", i + 1, contaPFArrayList.get(i).getNumeroConta());
                        }
                        int escolha = input.nextInt();
                        contaPFArrayList.get(escolha - 1).resgatar(input);
                    } else if (tipoPFouPJ.equals("PJ")) {
                        System.out.println("Escolha a conta onde se encontra o investimento a ser resgatado:");
                        for (int i = 0; i < contaPJArrayList.size(); i++) {
                            System.out.printf("%d - Conta: %s\n", i + 1, contaPJArrayList.get(i).getNumeroConta());
                        }
                        int escolha = input.nextInt();
                        contaPJArrayList.get(escolha - 1).resgatar(input);
                    }
                    break;
                case 8:
                    if (tipoPFouPJ.equals("PF")) {
                        System.out.println("Escolha a conta que gostaria de sacar:");
                        for (int i = 0; i < contaPFArrayList.size(); i++) {
                            System.out.printf("%d - Conta: %s\n", i + 1, contaPFArrayList.get(i).getNumeroConta());
                        }
                        int escolha = input.nextInt();
                        contaPFArrayList.get(escolha - 1).saque(input);
                    } else if (tipoPFouPJ.equals("PJ")) {
                        System.out.println("Escolha a conta que gostaria de sacar:");
                        for (int i = 0; i < contaPJArrayList.size(); i++) {
                            System.out.printf("%d - Conta: %s\n", i + 1, contaPJArrayList.get(i).getNumeroConta());
                        }
                        int escolha = input.nextInt();
                        contaPJArrayList.get(escolha - 1).sacar(input);
                    }
                    break;
                case 9:
                    dadosConta();
                    break;
                case 10:
                    contas(input);
                    break;
                case 0:
                    break;
            }
        } while (n != 0);
    }

    public static void cadastro() {
        Scanner input = new Scanner(System.in);

        System.out.println("--------Abertura de conta e cadastro de cliente--------");

        System.out.println("Informe o nome do cliente");
        String nome = input.next();

        System.out.println("Informe o email do cliente");
        String email = input.next();

        System.out.println("Informe se o cliente é PF ou PJ");
        tipoPFouPJ = input.next();

        if (tipoPFouPJ.equals("PF")) {
            System.out.println("Informe o CPF do Cliente (xxx.xxx.xxx-xx)");
            String cpf = input.next();
            ContaPF[] contaPF = criarContaPF().toArray(new ContaPF[0]);
            cliente = new ClientePF(nome, email, tipoPFouPJ, cpf, contaPF);
            contasArrayList.add(cliente);
        } else if (tipoPFouPJ.equals("PJ")) {
            System.out.println("Informe o CNPJ do Cliente (xx.xxx.xxx/xxxx-xx)");
            String cnpj = input.next();
            ContaPJ[] contaPJ = criarContaPJ().toArray(new ContaPJ[0]);
            cliente = new ClientePJ(nome, email, tipoPFouPJ, cnpj, contaPJ);
            contasArrayList.add(cliente);
        }
    }

    public static void dadosConta() {
        if (tipoPFouPJ.equals("PF")) {
            System.out.println(cliente.toString());
            System.out.print("Contas:");
            for (ContaPF contaPF : contaPFArrayList) {
                System.out.printf(" numero: %s", contaPF.getNumeroConta());
                System.out.printf(" saldo conta corrente: %s", contaPF.getSaldoCC());
                System.out.printf(" saldo conta investimento: %s", contaPF.getSaldoCI());
                System.out.printf(" saldo conta poupança: %s\n", contaPF.getSaldoPO());
            }
            System.out.println();
        } else if (tipoPFouPJ.equals("PJ")) {
            System.out.println(cliente.toString());
            System.out.print("Contas:");
            for (ContaPF contaPF : contaPFArrayList) {
                System.out.printf(" numero: %s", contaPF.getNumeroConta());
                System.out.printf(" saldo conta corrente: %s", contaPF.getSaldoCC());
                System.out.printf(" saldo conta investimento: %s", contaPF.getSaldoCI());
                System.out.printf(" saldo conta poupança: %s\n", contaPF.getSaldoPO());
            }
            System.out.println();
        }
    }

    public static void contas(Scanner input) {
        System.out.println("Escolha a conta para ver os dados");
        for (int i = 0; i < contasArrayList.size(); i++) {
            System.out.printf("%d - Nome: %s PF ou PJ: %s Agência: %s\n"
                    , i + 1, contasArrayList.get(i).getNome(), contasArrayList.get(i).getTipoPFouPJ(), contasArrayList.get(i).getAgencia());
        }
        int n = input.nextInt();
        cliente = contasArrayList.get(n - 1);
    }

    public static ArrayList<ContaPF> criarContaPF() {
        Random numero = new Random();
        int numeroConta = 1 + numero.nextInt(9999);
        contaPFArrayList.add(new ContaPF(numeroConta, new BigDecimal(0), new BigDecimal(0), new BigDecimal(0)));
        novaConta = numeroConta;
        return contaPFArrayList;
    }

    public static ArrayList<ContaPJ> criarContaPJ() {
        Random numero = new Random();
        int numeroConta = 1 + numero.nextInt(9999);
        contaPJArrayList.add(new ContaPJ(numeroConta, new BigDecimal(0), new BigDecimal(0)));
        novaConta = numeroConta;
        return contaPJArrayList;
    }
}