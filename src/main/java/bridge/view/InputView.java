package bridge.view;

import bridge.domain.BridgeSizeCommand;
import bridge.domain.MovementCommand;
import bridge.util.IntConverter;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSizeCommand readBridgeSize() {
        return new InputProcessor<>(() -> new BridgeSizeCommand(IntConverter.convert(readLine())))
                .process();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public MovementCommand readMoving() {
        return new InputProcessor<>(() -> MovementCommand.commandOf(readLine()))
                .process();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
