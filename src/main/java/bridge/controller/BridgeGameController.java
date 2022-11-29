package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeSizeCommand;
import bridge.domain.MovementCommand;
import bridge.domain.RetryCommand;
import bridge.service.BridgeGame;
import bridge.service.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private BridgeGame bridgeGame;

    public void runBridgeGame() {
        createBridgeGame();
        startGame();

    }



    private void startGame() {
        do {
            bridgeGame.initBridgeGame();
            if (movePlayer()) {
                return;
            }
        } while (bridgeGame.retry(askRetry()));
    }

    private RetryCommand askRetry() {
        outputView.printPleaseInputRetry();
        return inputView.readGameCommand();
    }

    private boolean movePlayer() {
        while (!bridgeGame.isGameClear()) {
            bridgeGame.move(askMovement());
            outputView.printMap(bridgeGame.playerMoveRecord());
            if (!bridgeGame.isPlayerMove()) {
                return false;
            }
        }
        return true;
    }

    private MovementCommand askMovement() {
        outputView.printChoiceMove();
        return inputView.readMoving();
    }

    private void createBridgeGame() {
        outputView.printStartGame();

        Bridge bridge = makeBridge();
        Player player = new Player();
        outputView.printNewline();

        bridgeGame = new BridgeGame(bridge, player);
    }

    private Bridge makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = askBridgeSize().getSize();
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    private BridgeSizeCommand askBridgeSize() {
        outputView.printPleaseInputBridgeLength();
        return inputView.readBridgeSize();
    }
}
