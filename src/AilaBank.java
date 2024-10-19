import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class AilaBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome = "Clarice Rocha";
        String tipoConta = "Corrente";
        double saldo = 1200;
        int i = 0;
        boolean oferta = true; //variavel de controle de emprestimo | 1x R$ 100

        //Dados do cliente
        System.out.println("------------------");
        System.out.println("Cliente: " + nome);
        System.out.println("Conte " + tipoConta);
        System.out.println("Saldo: " + saldo);
        System.out.println("------------------");

        //Menu da Conta
        String menu = """
                
                -------BANCO AILA-------
                1. Consultar Saldo
                2. Depositar
                3. Sacar
                4. Fechar App
                
                """;

        while (i != 4) {
            System.out.println(menu);
            i = scanner.nextInt();

            if (i == 1) { //saldo
                System.out.println("\nSaldo de R$ " + saldo);
            } else if (i == 2) { //deposito
                System.out.println("Insira o valor do depósito: ");
                double deposito = scanner.nextDouble();
                saldo += deposito;
                System.out.println("\nNovo saldo R$ " + saldo);
            } else if (i == 3) { //saque
                System.out.println("insira o valor do saque: ");
                double saque = scanner.nextDouble();
                if (saque > saldo) { //cliente n pode sacar um valor q não tem
                    System.out.println("\nINVÁLIDO! Você tem R$" + saldo);
                    if (oferta) { //oferta para quem nao pegou o cheque ainda e quer sacar mais do que tem
                        System.out.println("\nDeseja pegar o cheque especial de R$100?");
                        System.out.println("""
                            1.SIM
                            2.NÃO
                            """);
                        int opcao = scanner.nextInt();
                        if (opcao == 1) { //aceitou o cheque especial
                            saldo += 100;
                            System.out.println("Saldo atualizado para R$" + saldo);
                            oferta = false; //Emprestimo feito, nao podera fazer de novo
                        } else {
                            System.out.println("\nSaldo R$ " + saldo); //nao quis o cheque ainda.
                        }
                    }
                } else {
                    saldo -= saque;
                    System.out.println("\nNovo saldo R$ " + saldo);
                }
            } else if (i == 4) { //sair do app
                System.out.println("Banco Aila Agradece");
            } else {
                System.out.println("\nDígito Inválido");
            }
        }
    }
}
