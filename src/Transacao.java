import javax.xml.crypto.Data;

public interface Transacao {

    public double vista(double valor);

    public double parcelada(double valor);

    public double saque(double valor);

    public double pagamento(double valor);

    public String dataTransacao();
}