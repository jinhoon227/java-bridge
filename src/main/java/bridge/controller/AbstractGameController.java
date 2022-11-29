package bridge.controller;

public abstract class AbstractGameController {

    public final void runBridgeGame() {
        try {
            startGame();
            endGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    protected abstract void startGame();

    protected abstract void endGame();
}