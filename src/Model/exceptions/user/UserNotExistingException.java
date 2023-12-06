package Model.exceptions.user;

public class UserNotExistingException extends IllegalArgumentException {
    public UserNotExistingException() {
        super("[ERROR] 올바르지 않은 아이디 또는 패스워드입니다.");
    }
}
