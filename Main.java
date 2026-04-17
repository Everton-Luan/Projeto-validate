import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o seu cpf: ");
        String cpf = sc.nextLine();

        VerificadorCPF verificar = new VerificadorCPF();
        boolean status = verificar.validarCPF(cpf);
        System.out.println(status);
    }
}
//710.948.074-78