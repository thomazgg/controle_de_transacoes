import java.util.Scanner;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

public class Conta extends Pessoa implements Transacao {

    // Declarando Scanner e Random
    Scanner input = new Scanner(System.in);
    Random numero = new Random();
    Pessoa p1 = new Pessoa();

    // Declarando variaveis da conta
    private Integer idConta = 1 + numero.nextInt(9999);;
    private int saques;
    private double saldo;

    // Classe conta
    public Conta(Integer idConta, double saldo_inicial) {
        this.idConta = idConta;
        saldo = saldo_inicial;
        saques = 0;
    }

    // Id Conta
    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    // Saldo
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Saques
    public int getSaques() {
        return saques;
    }

    public void setSaques(int saques) {
        this.saques = saques;
    }

    // 1 Implementacao: compra a vista
    @Override
    public double vista(double valor) {
        try {
            // tem saldo na conta?
            if (saldo >= valor) { // se tem, entao:
                saldo -= valor;
                saques++;
                System.out.println("> Valor da compra: " + valor);
                System.out.println("> Novo saldo: " + saldo + "\n");
                System.out.println("> Data de transacao: " + dataTransacao() + "\n");
            } else { // se nao tem, entao:
                System.out.println("> Saldo insuficiente!\n");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("Compra a vista de R$" + valor + " efetuada");
        return saldo;
    }

    // 2 Implementacao: compra parcelada
    @Override
    public double parcelada(double valor) {
        try {
            // tem saldo na conta?
            if (saldo >= valor) { // se tem, entao:
                saldo -= valor;
                saques++;
                System.out.println("> Valor da parcela: " + valor);
                System.out.println("> Novo saldo: " + saldo + "\n");
                System.out.println("> Parcela de R$" + valor + " efetuada" + "\n");
                System.out.println("> Data de transacao: " + dataTransacao() + "\n");
            } else { // se nao tem, entao:
                System.out.println("> Saldo insuficiente!\n");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return saldo;
    }

    // 3 Implementacao: saque
    @Override
    public double saque(double valor) {
        try {
            // tem saldo na conta?
            if (saldo >= valor) { // se tem, entao:
                saldo -= valor;
                saques++;
                System.out.println("> Valor do saque: " + valor);
                System.out.println("> Novo saldo: " + saldo + "\n");
                System.out.println("> Saque de R$" + valor + " efetuado");
                System.out.println("> Data de transacao: " + dataTransacao() + "\n");
            } else { // se nao tem, entao:
                System.out.println("> Saldo insuficiente!\n");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return saldo;
    }

    // 4 Implementacao: pagamento
    @Override
    public double pagamento(double valor) {
        saldo += valor;
        System.out.println("> Pagamento efeutado de: " + valor);
        System.out.println("> Novo saldo: " + saldo);
        System.out.println("> Data de transacao: " + dataTransacao() + "\n");
        return saldo;
    }

    // 5 Implementacao: data da compra
    @Override
    public String dataTransacao() {
        Date data = new Date();
        SimpleDateFormat dataAtual = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = dataAtual.format(data);
        return dataHoje;
    }

    // ! Abrir conta
    public void abrirConta() {
        // Declarando as variaveis
        double inicial;
        // Obtendo os dados iniciais do Cliente
        System.out.println("\n========Cadastrando novo cliente========");
        System.out.print("Ente com seu nome: ");
        p1.setNome(input.next());

        System.out.print("Digite seu cpf: ");
        p1.setCpf(input.next());

        System.out.print("Entre com o valor: ");
        inicial = input.nextDouble();

        // Criando a conta de um cliente
        Conta minhaConta = new Conta(this.idConta, inicial);
        minhaConta.iniciar();
        input.close();
    }

    // ! Mostrar extrato da conta
    public void extrato() {
        System.out.println("\t_________________________________");
        System.out.println("\t\t     Extrato");
        System.out.println("\t Nome: " + p1.getNome());
        System.out.println("\t CPF: " + p1.getCpf());
        System.out.println("\t Numero da conta: " + this.idConta);
        System.out.printf("\t Saldo atual: %.2f\n", this.saldo);
        System.out.println("\t Saques realizados hoje: " + this.saques);
        System.out.println("");
        System.out.println("\t_________________________________\n");
    }

    // Iniciar
    public void iniciar() {

        int op;
        do {
            exibeMenu();
            op = input.nextInt();
            escolheOpcao(op);
        } while (op != 7);
    }

    // Exibir o Menu
    public void exibeMenu() {
        System.out.println("\t=================================");
        System.out.println("\t|\t 1. Abrir Conta      \t|");
        System.out.println("\t|\t 2. Compra a vista   \t|");
        System.out.println("\t|\t 3. Compra parcelada \t|");
        System.out.println("\t|\t 4. Saque            \t|");
        System.out.println("\t|\t 5. Pagamento        \t|");
        System.out.println("\t|\t 6. Extrato          \t|");
        System.out.println("\t|\t 7. Sair             \t|");
        System.out.println("\t=================================\n");
        System.out.println("Escolha uma opcao: ");
    }

    // Escolher a opcao
    public void escolheOpcao(int op) {

        double valor;
        switch (op) {

            // 1. Abrir Conta
            case 1:
                abrirConta();
                break;

            // 2. Compra a vista
            case 2:
                System.out.print("Qual o valor da compra: ");
                valor = input.nextDouble();
                vista(valor);
                break;

            // 3. Compra parcelada
            case 3:
                System.out.print("Qual o valor da parcela: ");
                valor = input.nextDouble();
                parcelada(valor);
                break;

            // 4. Saque
            case 4:
                System.out.print("Quanto o valor do saque: ");
                valor = input.nextDouble();
                saque(valor);
                break;
            // 5. Pagamento
            case 5:
                System.out.print("Qual o valor do pagamento: ");
                valor = input.nextDouble();
                pagamento(valor);
                break;
            // 6. Extrato
            case 6:
                extrato();
                iniciar();
                break;

            // 7. Sair
            case 7:
                System.out.println("Sistema encerrado.");
                break;

            default:
                System.out.println("Opcao invalida");
                iniciar();
        }
    }
}