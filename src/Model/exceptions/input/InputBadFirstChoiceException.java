package Model.exceptions.input;

public class InputBadFirstChoiceException extends IllegalArgumentException {

    public InputBadFirstChoiceException() {
        super("[ERROR] 올바르지 않은 선택입니다.");
    }
}
