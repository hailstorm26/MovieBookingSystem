package Ticket;

public class Payment {
    public static boolean validateCard(String cardNumber) {
        return isNumeric(cardNumber) && cardNumber.length() == 16;
    }

    public static boolean validateCVV(String CVV) {
        return isNumeric(CVV) && CVV.length() == 3;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }


}
