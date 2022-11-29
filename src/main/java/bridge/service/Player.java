package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.MoveRecord;
import bridge.exception.TotalTryMaxException;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private MoveRecord moveRecord;
    private int totalTry;

    public Player() {
        this.moveRecord = new MoveRecord();
        totalTry = 0;
    }

    public void initRetryPlayer() {
        moveRecord = new MoveRecord();

        validateTotalTry();
        totalTry++;
    }

    private void validateTotalTry() {
        if (totalTry >= Integer.MAX_VALUE) {
            throw new TotalTryMaxException();
        }
    }

    public boolean isPlayerLastSpace(Bridge bridge) {
        return ((moveRecord.nowSize() == bridge.bridgeSize()) && moveRecord.getIsMove());
    }

    public void updateMoveRecord(Bridge bridge, String command) {
        int now = moveRecord.nowSize();
        moveRecord.updateMoveRecord(command, command.equals(bridge.nowSpace(now)));
    }

    public boolean isPlayerMove() {
        return moveRecord.getIsMove();
    }

    public MoveRecord getMoveRecord() {
        return moveRecord;
    }

    public int getTotalTry() {
        return totalTry;
    }
}
