public class VerificadorCell {
    /** <b>Requisitos:</br>
     * <b>- String recebida tem que ser menor ou igual a 13</br>
     * <b>- Conferir se o número recebido é telefone ou celular;</br>
     * <b>- Conferir se possui DDD ou/e DDI</br>
    */
    public boolean validarCell(String cell) {
        boolean isValid=false;


        System.out.println("===========================================================");
        System.out.println("|             VERIFICADOR DE TELEFONE/CELULAR             |");
        System.out.println("===========================================================");

        //Extraindo apenas os números do telefone/celular
        String cellLimpo = cell.replaceAll("\\D", "");

        System.out.println("Verificando tamanho:");
        if (cellLimpo.length() > 13 || cellLimpo.length() < 8) {
            isValid = false;
            System.out.println("    - ERRO: Tamanho inválido!!");
            return isValid;
        }else {
            isValid = true;
            System.out.println("    - Tamanho válido. Continuando verificação...");
        }

        //Destacando os casos com DDI, e retirando ele para facilitar o resto
        if (cellLimpo.length() == 13 || cellLimpo.length() == 12) {

            if (cellLimpo.startsWith("55")) {
                System.out.println("Retirando o DDI:\n    - Número com DDI: " + cellLimpo);
                cellLimpo = cellLimpo.substring(2);
                System.out.println("    - Número sem DDI: " + cellLimpo);
            } else {
                isValid = false;
                System.out.println("Checando o DDI:\n    - ERRO: Digite o DDI do Brasil!!");
                return isValid;
            }
        }

        int tamanho = cellLimpo.length();
        System.out.println("Verifição final (tipo de número && se é válido): ");
        switch (tamanho) {
            case 8:
                if (cellLimpo.startsWith("9")) {
                    isValid = false;
                    System.out.println("    - Número: " + cellLimpo + "\n    - Tipo: Telefone (fixo) sem DDD\n    - ERRO: Fixo não pode iniciar com 9!!");
                }else {
                    isValid = true;
                    System.out.println("    - Número: " + cellLimpo + "\n    - Tipo: Telefone (fixo) sem DDD");
                }
                break;
            case 9:
                if (!cellLimpo.startsWith("9")) {
                    isValid = false;
                    System.out.println("    - Número: " + cellLimpo + "\n    - Tipo: Celular (móvel) sem DDD\n    - ERRO: Móvel não pode iniciar sem o 9!!");
                }else {
                    isValid = true;
                    System.out.println("    - Número: " + cellLimpo + "\n    - Tipo: Celular (móvel) sem DDD");
                }
                break;
            case 10:
                if (cellLimpo.charAt(2) == '9') {
                    isValid = false;
                    System.out.println("    - Número: " + cellLimpo + "\n    - Tipo: Telefone (fixo) com DDD\n    - ERRO: Fixo não pode iniciar com 9!!");
                }else if (cellLimpo.charAt(0) == '0' || cellLimpo.charAt(1) == '0') {
                    isValid = false;
                    System.out.println("    - Número: " + cellLimpo + "\n    - Tipo: Telefone (fixo) com DDD\n    - ERRO: DDD's não contém 0!!");
                }else {
                    isValid = true;
                    System.out.println("    - Número: " + cellLimpo + "\n    - Tipo: Telefone (fixo) com DDD");
                }
                break;
            case 11:
                if (cellLimpo.charAt(2) != '9') {
                    isValid = false;
                    System.out.println("    - Número: " + cellLimpo + "\n    - Tipo: Celular (móvel) com DDD\n    - ERRO: Móvel não pode iniciar sem o 9!!");
                }else if (cellLimpo.charAt(0) == '0' || cellLimpo.charAt(1) == '0') {
                    isValid = false;
                    System.out.println("    - Número: " + cellLimpo + "\n    - Tipo: Celular (móvel) com DDD\n    - ERRO: DDD's não contém 0!!");
                }else {
                    isValid = true;
                    System.out.println("    - Número: " + cellLimpo + "\n    - Tipo: Celular (móvel) com DDD");
                }
                break;
        }

        return isValid;
    }
}
