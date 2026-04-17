public class VerificadorCPF {
    String cpf;

    public boolean validarCPF(String cpf) {
        boolean isValid = false;
        int[] cpfArray = new int[11];

        System.out.println("==================================================");
        System.out.println("|               VERIFICAÇÃO DE CPF               |");
        System.out.println("==================================================");

        //Extraindo apenas os números do cpf
        String cpfLimpo = cpf.replaceAll("\\D", "");
        System.out.println("CPF limpo: " + cpfLimpo);

        //Conferindo se o tamanho está correto
        if (cpfLimpo.length() != 11) {
            System.out.println("CPF invalido: O tamanho do cpf deve conter 11 digitos");
            isValid = false;
            return isValid;
        }else {
            System.out.println("Tamanho do cpf: [" + cpfLimpo.length() + "] Válido");
        }

        for (int i = 0; i < cpfLimpo.length(); i++) {
            char c = cpfLimpo.charAt(i);
            int digito = Character.getNumericValue(c);
            cpfArray[i] = digito;
        }

        System.out.print("CPF Array: [");
        for (int i = 0; i < 11; i++) {
            if (i == 10) {
                System.out.println(cpfArray[i] + "]");
            }else {
                System.out.print(cpfArray[i]);
            }
        }

        //Conferindo se todos os digitos são iguais, comprando o primeiro digito com os demais
        System.out.println("Conferindo se todos os digitos são iguais: ");
        System.out.println("Primeiro digito: " + cpfArray[0]);
        for (int i = 1; i <= cpfLimpo.length()-1; i++) {
            System.out.println("Digito [" + (i+1) + "]: " + cpfArray[i]);
            isValid = false;
            if (cpfArray[0] != cpfArray[i]) {
                isValid = true;
                break;
            }
        }
        if (isValid == true) {
            System.out.println("Nem todos os números são iguais, continuando a checagem...");
        }else {
            System.out.println("Todos os números são iguais: CPF inválido!!");
            return isValid;
        }

        //Validção do primeiro digito
        int multiplicador1 = 10;
        int soma1 = 0;

        System.out.println("Validação do primeiro digito:");
        for (int i = 0; i < cpfLimpo.length(); i++) {
            if (multiplicador1 == 2) {
                System.out.print(cpfArray[i] + "x" + multiplicador1 + " = ");
            }else {
                System.out.print(cpfArray[i] + "x" + multiplicador1 + " + ");
            }
            int resultado = cpfArray[i] * multiplicador1;
            soma1 += resultado;
            multiplicador1--;
            if (multiplicador1 < 2) {
                break;
            }
        }
        System.out.println(soma1);

        int resto1 = (soma1 *10)%11;
        System.out.println("Resto é igual ao primeiro digito pós hífen [" + cpfArray[9] + "]? -> (" + soma1 + "x10)%11 = " + resto1 );
        if (resto1 == 10) {
            resto1 = 0;
        }
        if ( (resto1 == cpfArray[9]) ) {
            System.out.println("Checagem válida");
            isValid = true;
        }else {
            System.out.println("Checagem inválida");
            isValid = false;
            return isValid;
        }
        System.out.println("resto1: " + resto1);


        //Validação do segundo digito
        int multiplicador2 = 11;
        int soma2 = 0;

        System.out.println("Validação do segundo digito:");
        for (int i = 0; i < cpfLimpo.length(); i++) {
            if (multiplicador2 == 2) {
                System.out.print(cpfArray[i] + "x" + multiplicador2 + " = ");
            }else {
                System.out.print(cpfArray[i] + "x" + multiplicador2 + " + ");
            }
            int resultado = cpfArray[i] * multiplicador2;
            soma2 += resultado;
            multiplicador2--;
            if (multiplicador2 < 2) {
                break;
            }
        }
        System.out.println(soma2);

        int resto2 = (soma2 *10)%11;
        System.out.println("Resto é igual ao primeiro digito pós hífen [" + cpfArray[10] + "]? -> (" + soma2 + "x10)%11 = " + resto2 );

        if (resto2 == 10) {
            resto2 = 0;
        }
        if ( (resto2 == cpfArray[10]) ) {
            System.out.println("Checagem válida");
            isValid = true;
        }else {
            System.out.println("Checagem inválida");
            isValid = false;
            return isValid;
        }

        return isValid;
    }

}
