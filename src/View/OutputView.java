package View;


import Model.studyCafe.Seat;
import Model.studyCafe.SeatRepository;
import Model.user.User;

import java.util.List;

public class OutputView {

    private static final String BAD_INPUT = "잘못된 입력입니다. 시스템을 종료합니다.";

    /** Phase 1 */
    private static final String PHASE_ONE_MESSAGE = "[1] 회원가입 [9] 종료\n숫자만 입력해주세요.";
    private static final String PHASE_ONE_MESSAGE_RETRY = "잘못된 입력입니다. 1 ~ 2 의 숫자로 입력해주세요.";

    // [2] 회원가입
    private static final String SIGNUP_TRY_MESSAGE = "\n회원가입하실 아이디와 비밀번호를 입력해주세요.(예시: 홍길동 1234)\n종료를 원하시면 9 를 입력해주세요.";
    private static final String SIGNUP_SUCCESS_MESSAGE = "\n%s 아이디로 회원가입에 성공했습니다.";
    // [3] 종료
    private static final String EXIT_MESSAGE = "스터디 카페 프로그램을 종료합니다.";

    /** Phase 2 */
    // [1] 로그인
    private static final String SIGNIN_TRY_MESSAGE = "\n로그인하실 아이디와 비밀번호를 입력해주세요.(예시: 홍길동 1234)\n종료를 원하시면 9 를 입력해주세요.";
    private static final String SIGNIN_SUCCESS_MESSAGE = "\n%s 아이디로 로그인에 성공했습니다.";


    private static final String MAIN_MESSAGE = "[1] 좌석 예약 생성 [2] 좌석 예약 취소 [3] 나의 남은 시간 확인 [4] 금액 투입 [9] 종료\n숫자만 입력해주세요.";
    private static final String MAIN_MESSAGE_RETRY = "잘못된 입력입니다. 1 ~ 4 의 숫자로 입력해주세요.";
    // [1] 좌석 예약 생성
    private static final String RESERVATION_CREATE_TRY_MESSAGE = "예약을 생성하실 좌석의 번호를 입력해주세요.\n종료를 원하시면 9 를 입력해주세요.";
    private static final String RESERVATION_CREATE_SUCCESS_MESSAGE = "%d 번 좌석 예약 생성에 성공했습니다.";
    private static final String RESERVATION_CREATE_FAIL_MESSAGE = "%d 번 좌석 예약 생성에 실패했습니다.";
    // [2] 좌석 예약 취소
    private static final String RESERVATION_DELETE_TRY_MESSAGE = "예약을 취소하실 좌석의 번호를 입력해주세요.\n종료를 원하시면 9 를 입력해주세요.";
    private static final String RESERVATION_DELETE_SUCCESS_MESSAGE = "%d 번 좌석 예약 취소에 성공했습니다.";
    private static final String RESERVATION_DELETE_FAIL_MESSAGE = "%d 번 좌석 예약 취소에 실패했습니다.";
    // [3] 나의 남은 시간 확인
    private static final String TIME_CHECK_SUCCESS_MESSAGE = "현재 남은 나의 시간은 %s 분 입니다.";
    // [4] 금액 투입
    private static final String PAYMENT_CHARGE_TRY_MESSAGE = "투입하실 금액을 입력해주세요.\n종료를 원하시면 9 를 입력해주세요.";
    private static final String PAYMENT_CHARGE_SUCCESS_MESSAGE = "%d 원 금액 투입에 성공했습니다.";
    private static final String PAYMENT_CHARGE_FAIL_MESSAGE = "%d 원 금액 투입에 실패했습니다.";

    private static final String SEAT_FORMAT = "[%d %s]";

    public void printBadInputMessage() {
        System.out.println(BAD_INPUT);
    }

    /** Phase 1 */
    // 초기 메시지
    public void printPhaseOneMessage() {
        System.out.println(PHASE_ONE_MESSAGE);
    }

    // 회원가입
    public void printSignupTryMessage() {
        System.out.println(SIGNUP_TRY_MESSAGE);
    }

    public void printSignupSuccessMessage(User signupUser) {
        System.out.println(String.format(SIGNUP_SUCCESS_MESSAGE, signupUser.getInfo().getId()));
    }



    public void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }

    /** Phase 2 */
    // 로그인
    public void printSigninTryMessage() {
        System.out.println(SIGNIN_TRY_MESSAGE);
    }

    public void printSigninSuccessMessage(User signinUser) {
        System.out.println(String.format(SIGNIN_SUCCESS_MESSAGE, signinUser.getInfo().getId()));
    }


    /** Phase 3 */
    // 메인 메시지
    public void printMainMessage() {
        System.out.println(MAIN_MESSAGE);
    }

    // 좌석 예약
    public void printReservationCreateTryMessage() {
        System.out.println(RESERVATION_CREATE_TRY_MESSAGE);
    }

    public void printReservationCreateSuccessMessage() {
        System.out.println(RESERVATION_CREATE_SUCCESS_MESSAGE);
    }

    public void printReservationCreateFailMessage() {
        System.out.println(RESERVATION_CREATE_FAIL_MESSAGE);
    }

    // 좌석 취소
    public void printReservationDeleteTryMessage() {
        System.out.println(RESERVATION_DELETE_TRY_MESSAGE);
    }

    public void printReservationDeleteSuccessMessage() {
        System.out.println(RESERVATION_DELETE_SUCCESS_MESSAGE);
    }

    public void printReservationDeleteFailMessage() {
        System.out.println(RESERVATION_DELETE_FAIL_MESSAGE);
    }

    // 금액 투입
    public void printPaymentTryMessage() {
        System.out.println(PAYMENT_CHARGE_TRY_MESSAGE);
    }

    public void printPaymentSuccessMessage() {
        System.out.println(PAYMENT_CHARGE_SUCCESS_MESSAGE);
    }

    public void printPaymentFailMessage() {
        System.out.println(PAYMENT_CHARGE_FAIL_MESSAGE);
    }




    public void printSeats(SeatRepository seats) {
        List<Seat> list = seats.getSeats();
        list.stream().forEach(seat -> String.format(SEAT_FORMAT, seat.getSeatNumber(), seat.getIsConquered()));
    }



}
