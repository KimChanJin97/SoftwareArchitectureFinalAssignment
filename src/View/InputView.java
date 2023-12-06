package View;

import Model.exceptions.input.InputBadFirstChoiceException;
import Model.exceptions.input.InputBadIdPasswordException;
import Model.exceptions.payment.PaymentNotNumericException;
import Model.exceptions.seat.SeatNotNumericException;

import java.util.Scanner;
import java.util.function.Supplier;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final int FIRST_CHOICE_RANGE_START = 1;
    private static final int FIRST_CHOICE_RANGE_END = 3;

    private static final String ID_PASSWORD_SEPARATOR = " ";
    private static final String NUMERIC_REGEX = "^[1-9]\\d*$";

    private static final int SECOND_CHOICE_RANGE_START = 1;
    private static final int SECOND_CHOICE_RANGE_END = 5;

    /** Phase 1 */
    // [1] 회원가입 [0] 종료
    public String repeatEnterPhaseOneChoice() {
        return repeatUntilValidInput(this::enterPhaseOneInput);
    }

    public String enterPhaseOneInput() {
        String choice = scanner.nextLine();
        validatePhaseOne(choice);

        return choice;
    }

    // 회원가입
    public String repeatEnterIdPasswordToSignup() {
        return repeatUntilValidInput(this::enterIdPasswordToSignup);
    }

    private String enterIdPasswordToSignup() {
        String idPassword = scanner.nextLine();
        validateEnterIdPassword(idPassword);

        return idPassword;
    }

    /** Phase 2 */
    // 로그인
    public String repeatEnterIdPasswordToSignin() {
        return repeatUntilValidInput(this::enterIdPasswordToSignin);
    }

    private String enterIdPasswordToSignin() {
        String idPassword = scanner.nextLine();
        validateEnterIdPassword(idPassword);

        return idPassword;
    }

    /** Phase 3 */
    // 금액 투입
    public String repeatEnterPayment() {
        return repeatUntilValidInput(this::enterPayment);
    }

    private String enterPayment() {
        String payment = scanner.nextLine();

        return payment;
    }

    // 좌석 예약
    public String repeatEnterSeat() {
        return repeatUntilValidInput(this::enterSeat);
    }

    private String enterSeat() {
        String seat = scanner.nextLine();

        return seat;
    }


    // 유효성 검사
    private void validatePhaseOne(String choice) {
        int intChoice = Integer.parseInt(choice.trim());

        if (intChoice < FIRST_CHOICE_RANGE_START || intChoice > FIRST_CHOICE_RANGE_END) {
            throw new InputBadFirstChoiceException();
        }
    }

    // 로그인, 회원가입
    private void validateEnterIdPassword(String idPassword) {
        String[] split = idPassword.split(ID_PASSWORD_SEPARATOR);

        if (split.length != 2) {
            throw new InputBadIdPasswordException();
        }
    }

    // 금액 투입
    private void validateEnterPayment(String payment) {
        if (!payment.matches(NUMERIC_REGEX)) {
            throw new PaymentNotNumericException();
        }
    }

    // 좌석 예약
    private void validateEnterSeat(String seat) {
        if (!seat.matches(NUMERIC_REGEX)) {
            throw new SeatNotNumericException();
        }
    }

    // Supplier
    private <T> T repeatUntilValidInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
