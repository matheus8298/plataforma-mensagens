class Mensagem {
    protected String campanha;
    protected int quantidade;

    public Mensagem(String campanha, int quantidade) {
        this.campanha = campanha;
        this.quantidade = quantidade;
    }

    public double calcularCusto() {
        return 0.0;
    }

    public String getCanal() {
        return "Mensagem";
    }

    public void exibirResumo() {
        System.out.printf("%s | %s | %d envios | R$ %.2f\n",
                getCanal(), campanha, quantidade, calcularCusto());
    }
}

class Email extends Mensagem {

    public Email(String campanha, int quantidade) {
        super(campanha, quantidade);
    }

    @Override
    public double calcularCusto() {
        double valor = quantidade * 0.02;
        if (quantidade > 1000) {
            valor = valor - (valor * 0.10);
        }
        return valor;
    }

    @Override
    public String getCanal() {
        return "E-mail";
    }
}

class SMS extends Mensagem {

    public SMS(String campanha, int quantidade) {
        super(campanha, quantidade);
    }

    @Override
    public double calcularCusto() {
        return quantidade * 0.15;
    }

    @Override
    public String getCanal() {
        return "SMS";
    }
}

public class Main {
    public static void main(String[] args) {

        Mensagem[] envios = new Mensagem[3];
        envios[0] = new Email("boas-vindas", 2500);
        envios[1] = new Email("promocao-agosto", 800);
        envios[2] = new SMS("codigo-verificacao", 300);

        double total = 0.0;

        for (int i = 0; i < envios.length; i++) {
            envios[i].exibirResumo();
            total = total + envios[i].calcularCusto();
        }

        System.out.println();
        System.out.printf("TOTAL DA FATURA: R$ %.2f\n", total);

        if (total > 100.0) {
            System.out.println("Atencao: fatura acima do limite contratado.");
        } else {
            System.out.println("Fatura dentro do limite.");
        }
    }
}

