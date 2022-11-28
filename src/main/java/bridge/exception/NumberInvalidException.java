package bridge.exception;

public class NumberInvalidException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_NO_NUMBER = "[ERROR] 숫자가 아닌 입력 또는 입력범위를 초과 했습니다.";

    public NumberInvalidException() {
        super(EXCEPTION_MESSAGE_NO_NUMBER);
    }
}
