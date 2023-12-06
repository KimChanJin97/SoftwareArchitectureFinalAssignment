package Model.user;

import Model.exceptions.user.UserAlreadyExistingException;
import Model.exceptions.user.UserNotExistingException;
import Model.studyCafe.Seat;
import View.InputView;
import View.OutputView;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UserService {

    private static final InputView INPUT_VIEW = new InputView();

    private static final UserRepository USER_REPOSITORY = new UserRepository();
    private static final String ID_PASSWORD_SEPARATOR = " ";

    /** Phase 1 */
    public User repeatSignup() {
        return repeatUntilValidInput(this::signup);
    }

    // 회원가입
    private User signup() {
        String idPassword = INPUT_VIEW.repeatEnterIdPasswordToSignup(); // 유효한 값 입력할 때까지 반복

        String id = idPassword.split(ID_PASSWORD_SEPARATOR)[0];
        String password = idPassword.split(ID_PASSWORD_SEPARATOR)[1];

        Info info = new Info(id, password, false);
        Seat seat = new Seat(0, false);
        Time time = new Time(0, 0, 0);
        User user = new User(info, seat, time);

        USER_REPOSITORY.save(user);

        return user;
    }

    /** Phase 2 */
    public User repeatSignin() {
        return repeatUntilValidInput(this::signin);
    }

    // 로그인
    private User signin() {
        String idPassword = INPUT_VIEW.repeatEnterIdPasswordToSignin(); // 유효한 값 입력할 때까지 반복

        String id = idPassword.split(ID_PASSWORD_SEPARATOR)[0];
        String password = idPassword.split(ID_PASSWORD_SEPARATOR)[1];

        User optUser = USER_REPOSITORY.findByLoginId(id)
                .filter(user -> user.getInfo().getPassword().equals(password))
                .orElse(null);

        if (optUser == null) {
            throw new UserNotExistingException();
        } else {
            return optUser;
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
