package bridge.exception;

import java.util.function.Supplier;

public class MovementCommandInvalidException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_BRIDGE_RANGE = "[ERROR] 잘못된 인덱스 또는 명령 커맨드를 입력했습니다";

    public MovementCommandInvalidException() {
        super(EXCEPTION_MESSAGE_BRIDGE_RANGE);
    }
}
