package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveRecord {

    private final List<String> position;
    private boolean isMove;

    public MoveRecord() {
        this.position = new ArrayList<>();
        isMove = false;
    }

    public int nowSize() {
        return position.size();
    }

    public void updateMoveRecord(String command, boolean isMove) {
        position.add(command);
        this.isMove = isMove;
    }

    public List<String> getPosition(){
        return position;
    }

    public boolean getIsMove() {
        return isMove;
    }
}
