package Model.exceptions.input;

public class InputBadIdPasswordException extends IllegalArgumentException {
    public InputBadIdPasswordException() {
        super("[ERROR] 올바르지 않은 아이디 비밀번호 형식입니다.");
    }
}
