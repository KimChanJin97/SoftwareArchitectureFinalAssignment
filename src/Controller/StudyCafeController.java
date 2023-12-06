package Controller;

import Model.user.User;
import Model.user.UserService;
import View.InputView;
import View.OutputView;

public class StudyCafeController {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    private static final UserService USER_SERVICE = new UserService();


    public void phaseOne() {
        printPhaseOneMessage();
        String PhaseOneChoice = enterPhaseOneChoice();
        proceedPhaseOne(Integer.parseInt(PhaseOneChoice));
    }

    public void phaseTwo() {
        printPhaseTwoMessage();
        proceedPhaseTwo();
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
    private void printPhaseTwoMessage() {
        OUTPUT_VIEW.printSigninTryMessage();
    }

    private User proceedPhaseTwo() {
        User signinUser = USER_SERVICE.repeatSignin(); // 유효한 값(아이디 패스워드) 입력 전까지 반복
        OUTPUT_VIEW.printSigninSuccessMessage(signinUser);
        return signinUser;
    }

    /** Phase 3 */


}
