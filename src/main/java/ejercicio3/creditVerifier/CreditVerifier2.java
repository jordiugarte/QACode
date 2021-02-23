package ejercicio3.creditVerifier;

public class CreditVerifier2 {
    private String message;

    public CreditVerifier2() {
    }

    public String getInterest(int ci, double credit) {
        if (credit < 1) {
            message = "Credito incorrecto";
        } else if (ASFIUtils.userIsEnabled(ci)) {
            if (credit <= 10000) {
                message = "El interes es del 15%";
            } else if (credit > 10000 && credit <= 20000) {
                message = "El interes es del 13%";
            } else {
                message = "El interes es del 5%";
            }
        } else {
            message = "El usuario no es valido";
        }
        return message;
    }
}
