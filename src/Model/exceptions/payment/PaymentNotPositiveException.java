package Model.exceptions.payment;

public class PaymentNotPositiveException extends IllegalArgumentException {
    public PaymentNotPositiveException() {
        super("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
    }
}
