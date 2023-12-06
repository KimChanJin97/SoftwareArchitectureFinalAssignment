package Model.studyCafe;

import Model.exceptions.payment.PaymentNot1KsException;
import Model.exceptions.payment.PaymentNotNumericException;
import Model.exceptions.payment.PaymentNotPositiveException;

public class Payment {

    private int payment = 0;

    private static final String NUMERIC_REGEX = "^[1-9]\\d*$";

    public Payment(String payment) {
        validate(payment);
        this.payment += Integer.parseInt(payment);
    }

    private void validate(String payment) {
        validatePayNotNumeric(payment);

        int intPay = Integer.parseInt(payment);
        validatePayNot1Ks(intPay);
        validatePayNotPositive(intPay);
    }

    private void validatePayNot1Ks(int payment) {

        if (payment % 1000 != 0) {
            throw new PaymentNot1KsException();
        }
    }

    private void validatePayNotNumeric(String payment) {
        if (!payment.matches(NUMERIC_REGEX)) {
            throw new PaymentNotNumericException();
        }
    }

    private void validatePayNotPositive(int payment) {
        if (payment < 0) {
            throw new PaymentNotPositiveException();
        }
    }

}
