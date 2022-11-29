package bridge.exception;

import bridge.domain.RetryCommand;

public class RetryCommandInvalidException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE_RETRY_VALUE = "[ERROR] 재시도 여부는 %s 또는 %s 만 입력해야 됩니다.";

    public RetryCommandInvalidException() {
        super(String.format(EXCEPTION_MESSAGE_RETRY_VALUE
                , RetryCommand.RETRY.getCommand(), RetryCommand.QUIT.getCommand()));
    }
}
