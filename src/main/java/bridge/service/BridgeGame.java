package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.MoveRecord;
import bridge.domain.MovementCommand;
import bridge.domain.RetryCommand;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Player player;

    public BridgeGame(Bridge bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
    }

    public void initBridgeGame() {
        player.initRetryPlayer();
    }

    public boolean isGameClear() {
        return player.isPlayerLastSpace(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(MovementCommand movementCommand) {
        player.updateMoveRecord(bridge, movementCommand.getCommand());
    }

    public boolean isPlayerMove() {
        return player.isPlayerMove();
    }

    public MoveRecord playerMoveRecord() {
        return player.getMoveRecord();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(RetryCommand retryCommand) {
        return retryCommand.getValue();
    }

    public Player getPlayerResult() {
        return player;
    }
}
