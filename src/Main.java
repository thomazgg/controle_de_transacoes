public class Main {
    public static void main(String[] args) throws Exception {
        // Criando a conta de um cliente
        Conta minhaConta = new Conta(1234, 0);
        minhaConta.abrirConta();
        minhaConta.iniciar();
    }
}