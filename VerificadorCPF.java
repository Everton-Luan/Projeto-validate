public class VerificadorCPF {
    String cpf;

    public boolean validarCPF(String cpf) {
        boolean isValid = false;
        int[] cpfArray = new int[11];

        //Extraindo apenas os números do cpf
        String cpfLimpo = cpf.replaceAll("\\D", "");

        //Conferindo se o tamanho está correto
        if (cpfLimpo.length() != 11) {
            isValid = false;
            return isValid;
        }

        for (int i = 0; i < cpfLimpo.length(); i++) {
            char c = cpfLimpo.charAt(i);
            int digito = Character.getNumericValue(c);
            cpfArray[i] = digito;
        }

        //Conferindo se todos os digitos são iguais, comprando o primeiro digito com os demais
        for (int i = 1; i <= cpfLimpo.length()-1; i++) {
            isValid = false;
            if (cpfArray[0] != cpfArray[i]) {
                isValid = true;
                break;
            }
        }
        if (isValid == false){
            return isValid;
        }

        //Validção do primeiro digito
        int multiplicador1 = 10;
        int soma1 = 0;

        for (int i = 0; i < cpfLimpo.length(); i++) {
            int resultado = cpfArray[i] * multiplicador1;
            soma1 += resultado;
            multiplicador1--;
            if (multiplicador1 < 2) {
                break;
            }
        }

        int resto1 = (soma1 *10)%11;
        if (resto1 == 10) {
            resto1 = 0;
        }
        if ( (resto1 == cpfArray[9]) ) {
            isValid = true;
        }else {
            isValid = false;
            return isValid;
        }

        //Validação do segundo digito
        int multiplicador2 = 11;
        int soma2 = 0;

        for (int i = 0; i < cpfLimpo.length(); i++) {
            int resultado = cpfArray[i] * multiplicador2;
            soma2 += resultado;
            multiplicador2--;
            if (multiplicador2 < 2) {
                break;
            }
        }

        int resto2 = (soma2 *10)%11;
        if (resto2 == 10) {
            resto2 = 0;
        }
        if ( (resto2 == cpfArray[10]) ) {
            isValid = true;
        }else {
            isValid = false;
            return isValid;
        }
        return isValid;
    }
}
