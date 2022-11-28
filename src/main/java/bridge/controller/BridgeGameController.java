package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeSizeCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void runBridgeGame() {
        startGame();
        playGame();
    }

    private void playGame() {
    }

    private void startGame() {
        outputView.printStartGame();
        makeBridge();
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
