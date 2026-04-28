public class VerificadorCell {
    /** <b>Requisitos:</br>
     * <b>- String recebida tem que ser menor ou igual a 13</br>
     * <b>- Conferir se o número recebido é telefone ou celular;</br>
     * <b>- Conferir se possui DDD ou/e DDI</br>
    */
    public boolean validarCell(String cell) {

        //Extraindo apenas os números do telefone/celular
        String cellLimpo = cell.replaceAll("\\D", "");

        if (cellLimpo.length() > 13 || cellLimpo.length() < 8) {
            return false;
        }

        //Destacando os casos com DDI, e retirando ele para facilitar o resto
        if (cellLimpo.length() == 13 || cellLimpo.length() == 12) {

            if (cellLimpo.startsWith("55")) {
                cellLimpo = cellLimpo.substring(2);
            } else {
                return false;
            }
        }

        int tamanho = cellLimpo.length();
        switch (tamanho) {
            case 8:

                if (cellLimpo.startsWith("9")) {
                    return false;
                }
                break;

            case 9:

                if (!cellLimpo.startsWith("9")) {
                    return false;
                }
                break;

            case 10:

                if (cellLimpo.charAt(2) == '9') {
                    return false;
                }else if (cellLimpo.charAt(0) == '0' || cellLimpo.charAt(1) == '0') {
                    return false;
                }
                break;

            case 11:

                if (cellLimpo.charAt(2) != '9') {
                    return false;
                }else if (cellLimpo.charAt(0) == '0' || cellLimpo.charAt(1) == '0') {
                    return false;
                }
                break;

            default:
                return false;
        }

        return true;
    }
}
