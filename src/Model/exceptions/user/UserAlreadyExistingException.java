package Model.exceptions.user;

public class UserAlreadyExistingException extends IllegalArgumentException {
    public UserAlreadyExistingException() {
        super("[ERROR] 이미 존재하는 유저 아이디입니다.");
    }
}
