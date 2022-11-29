package bridge.domain;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = Collections.unmodifiableList(bridge);
    }

    public int bridgeSize() {
        return bridge.size();
    }

    public String nowSpace(int now) {
        return bridge.get(now);
    }
}
