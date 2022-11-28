package bridge.domain;

import bridge.exception.BridgeRangeException;

public class BridgeSizeCommand {

    private final static int MIN_BRIDGE_SIZE = 3;
    private final static int MAX_BRIDGE_SIZE = 20;

    private final int size;

    public BridgeSizeCommand(int size) {
        validate(size);
        this.size = size;
    }

    private void validate(int size) {
        validateSizeRange(size);
    }

    private void validateSizeRange(int size) {
        if ((size < MIN_BRIDGE_SIZE) || (size > MAX_BRIDGE_SIZE)) {
            throw new BridgeRangeException(MIN_BRIDGE_SIZE, MAX_BRIDGE_SIZE);
        }
    }

    public int getSize() {
        return size;
    }
}
