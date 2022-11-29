package bridge.view;

import bridge.domain.MoveRecord;
import bridge.domain.MovementCommand;

import java.util.stream.Collectors;

public class MapMaker {
    private static final String START_MAP = "[ ";
    private static final String FINISH_MAP = " ]";
    private static final String INTERVAL_BRIDGE = " | ";
    private static final String COLLECT = "O";
    private static final String LAST_COLLECT = "O$";
    private static final String WRONG = "X";
    private static final String BLANK = " ";

    public String makeMap(MoveRecord moveRecord, MovementCommand movementCommand) {
        String intervalMap = moveRecord.getPosition().stream()
                .map(upDown -> convertUpDownToResult(upDown, movementCommand))
                .collect(Collectors.joining(INTERVAL_BRIDGE));

        if (!moveRecord.getIsMove()) {
            intervalMap = intervalMap.replaceAll(LAST_COLLECT, WRONG);
        }
        return START_MAP + intervalMap + FINISH_MAP;
    }

    private String convertUpDownToResult(String upDown, MovementCommand movementCommand) {
        if (upDown.equals(movementCommand.getCommand())) {
            return COLLECT;
        }
        return BLANK;
    }
}
