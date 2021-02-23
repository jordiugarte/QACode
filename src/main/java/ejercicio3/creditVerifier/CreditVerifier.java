package ejercicio3.creditVerifier;

public class CreditVerifier {

    private String message;
    private ASFI asfi = new ASFI();

    public CreditVerifier() {
    }

    public CreditVerifier(ASFI asfiMock) {
        this.asfi = asfiMock;
    }

    public String getInterest(int ci, int credit) {
        if (credit < 1) {
            message = "Credito incorrecto";
        } else if (asfi.userIsEnabled(ci)) {
            if (credit <= 10000) {
                message = "El interes es del 15%";
            } else if (credit > 10000 && credit <= 20000) {
                message = "El interes es del 13%";
            } else if (credit > 20000 && credit <= 30000) {
                message = "El interes es del 10%";
            } else {
                message = "El interes es del 5%";
            }
        } else {
            message = "El usuario no es valido";
        }
        return message;
    }
}
