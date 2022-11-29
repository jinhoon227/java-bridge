package bridge.domain;

import bridge.exception.RetryCommandInvalidException;

import java.util.Arrays;

public enum RetryCommand {
    RETRY("R", true),
    QUIT("Q", false);

    final private String command;
    final private boolean value;

    RetryCommand(String command, boolean value) {
        this.command = command;
        this.value = value;
    }

    public static RetryCommand commandOf(String command){
        return Arrays.stream(values())
                .filter(retry -> retry.command.equals(command))
                .findAny()
                .orElseThrow(RetryCommandInvalidException::new);
    }

    public String getCommand() {
        return command;
    }

    public boolean getValue() {
        return value;
    }
}
