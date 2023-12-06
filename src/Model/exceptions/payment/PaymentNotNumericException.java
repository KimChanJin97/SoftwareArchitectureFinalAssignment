package Model.exceptions.payment;

public class PaymentNotNumericException extends IllegalArgumentException {
    public PaymentNotNumericException() {
        super("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
    }
}
