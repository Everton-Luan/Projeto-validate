import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o seu cpf: ");
        String cpf = sc.nextLine();
        System.out.println("Digite o seu telefone/celular: ");
        String cell = sc.nextLine();

        VerificadorCPF vCPF = new VerificadorCPF();
        VerificadorCell vCell = new VerificadorCell();

        boolean statusCPF = vCPF.validarCPF(cpf);
        boolean statusCell = vCell.validarCell(cell);

        System.out.println(statusCPF);
        System.out.println(statusCell);
    }
}