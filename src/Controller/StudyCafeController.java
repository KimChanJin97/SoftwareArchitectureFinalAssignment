package Controller;

import Model.studyCafe.SeatRepository;
import Model.user.User;
import Model.user.UserService;
import View.InputView;
import View.OutputView;

public class StudyCafeController {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    private static final UserService USER_SERVICE = new UserService();
    private static final SeatRepository SEAT_REPOSITORY = new SeatRepository();
    private User user;

    public void phaseOne() {
        printPhaseOneMessage();
        String PhaseOneChoice = enterPhaseOneChoice();
        proceedPhaseOne(Integer.parseInt(PhaseOneChoice));
    }

    public void phaseTwo() {
        printPhaseTwoMessage();
        user = proceedPhaseTwo();
    }

    public void phaseThree() {
        while(true){
            printPhaseThreeMessage();
            String PhaseThreeChoice = enterPhaseThreeChoice();
            if(PhaseThreeChoice.equals("5")) break;
            proceedPhaseThree(Integer.parseInt(PhaseThreeChoice));
        }
    }


    /**
     * Phase 1
     */
    private void printPhaseOneMessage() {
        OUTPUT_VIEW.printPhaseOneMessage();
    }

    private String enterPhaseOneChoice() {
        return INPUT_VIEW.repeatEnterPhaseOneChoice(); // 유효한 값(숫자 선택지) 입력 전까지 반복
    }

    private User proceedPhaseOne(int firstChoice) {
        switch (firstChoice) {
            case (1): // 회원가입
                OUTPUT_VIEW.printSignupTryMessage();
                User signupUser = USER_SERVICE.repeatSignup(); // 유효한 값(아이디 패스워드) 입력 전까지 반복
                OUTPUT_VIEW.printSignupSuccessMessage(signupUser);

                return signupUser;

            case (9): // 종료
                OUTPUT_VIEW.printExitMessage();

                return null;

            default: // 잘못된 입력
                OUTPUT_VIEW.printBadInputMessage();

                return null;
        }
    }

    /**
     * Phase 2
     */
    private void printPhaseTwoMessage() { OUTPUT_VIEW.printSigninTryMessage(); }

    private User proceedPhaseTwo() {
        User signinUser = USER_SERVICE.repeatSignin(); // 유효한 값(아이디 패스워드) 입력 전까지 반복
        OUTPUT_VIEW.printSigninSuccessMessage(signinUser);
        return signinUser;
    }

    /** Phase 3 */
    private void printPhaseThreeMessage() { OUTPUT_VIEW.printMainMessage(); }

    private String enterPhaseThreeChoice() {
        return INPUT_VIEW.repeatEnterPhaseThreeChoice(); // 유효한 값(숫자 선택지) 입력 전까지 반복
    }

    private void proceedPhaseThree(int thirdChoice) {
        switch(thirdChoice){
            case(0) : // 좌석 조회
                OUTPUT_VIEW.printSeats(SEAT_REPOSITORY);
                break;

            case(1) : // 좌석 예약 생성
                if(user.getSeat().getIsConquered()) { // 이미 좌석을 예약한 경우
                    OUTPUT_VIEW.printReservationCreateFailMessageAlreadyConquering();
                    break;
                }
                OUTPUT_VIEW.printReservationCreateTryMessage();
                USER_SERVICE.repeatReservationCreate(user, SEAT_REPOSITORY); // 유효한 값(좌석 번호) 입력 전까지 반복
                OUTPUT_VIEW.printReservationCreateSuccessMessage(user.getSeat().getSeatNumber());
                break;
            case(2) :
                if(!user.getSeat().getIsConquered()) { // 좌석을 예약하지 않은 경우
                    OUTPUT_VIEW.printReservationCancelFailMessageNotConquering();
                    break;
                }
                USER_SERVICE.seatCancellation(user, SEAT_REPOSITORY);
                OUTPUT_VIEW.printReservationDeleteSuccessMessage(user.getSeat().getSeatNumber());
                break;
        }
    }

}
