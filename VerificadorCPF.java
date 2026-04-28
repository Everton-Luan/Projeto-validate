public class VerificadorCPF {
    String cpf;

    public boolean validarCPF(String cpf) {
        int[] cpfArray = new int[11];

        //Extraindo apenas os números do cpf
        String cpfLimpo = cpf.replaceAll("\\D", "");

        //Conferindo se o tamanho está correto
        if (cpfLimpo.length() != 11) {
            return false;
        }

        for (int i = 0; i < 11; i++) {
            char c = cpfLimpo.charAt(i);
            int digito = Character.getNumericValue(c);
            cpfArray[i] = digito;
        }

        //Conferindo se todos os digitos são iguais, comprando o primeiro digito com os demais
        for (int i = 1; i < 11; i++) {
            if (cpfArray[0] != cpfArray[i]) {
                break;
            }else if(i == 11){
                return false;
            }
        }

        //Validção do primeiro digito
        int multiplicador1 = 10;
        int soma1 = 0;

        for (int i = 0; i < 11; i++) {
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
        if (resto1 != cpfArray[9]) {
            return false;
        }

        //Validação do segundo digito
        int multiplicador2 = 11;
        int soma2 = 0;

        for (int i = 0; i < 11; i++) {
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
        if ( (resto2 != cpfArray[10]) ) {
            return false;
        }
        return true;
    }
}
