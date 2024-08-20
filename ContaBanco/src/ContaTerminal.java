import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {

        int numero;
        String agencia;
        String nome;
        double saldo;

        try (Scanner scan = new Scanner(System.in)) {

            System.out.printf("Por favor, digite o número da Agência.\n");
            agencia = scan.next();
            
            System.out.printf("Por favor, digite o número da conta.\n");
            numero = scan.nextInt();
            
            System.out.printf("Por favor, digite o seu nome.\n");
            nome = scan.next();
            
            System.out.printf("Por favor, digite o saldo da conta.\n");
            saldo = scan.nextDouble();
            
            System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.", nome, agencia, numero, saldo);
        
        } catch (Exception e) {
        
            System.out.println(e.getMessage());
        }

    }
}
