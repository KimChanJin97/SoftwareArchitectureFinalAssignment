package Model.exceptions.payment;

public class PaymentNot1KsException extends IllegalArgumentException {
    public PaymentNot1KsException() {
        super("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
    }
}
