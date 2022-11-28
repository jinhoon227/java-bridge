package bridge.domain;

import bridge.exception.MovementCommandInvalidException;

import java.util.Arrays;

public enum MovementCommand {

    UP("U", 1),
    DOWN("D", 0);

    private final String command;
    private final int index;

    MovementCommand(String command, int index) {
        this.command = command;
        this.index = index;
    }

    public static String indexToCommand(int index) {
        return Arrays.stream(values())
                .filter(movement -> movement.index == index)
                .findAny()
                .map(movement -> movement.command)
                .orElseThrow(MovementCommandInvalidException::new);
    }
}
