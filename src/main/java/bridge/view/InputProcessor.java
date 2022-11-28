package bridge.view;

import java.util.function.Supplier;

public class InputProcessor<T> {

    private final Supplier<T> processor;

    public InputProcessor(Supplier<T> processor) {
        this.processor = processor;
    }

    public T process() {
        while(true){
            try {
                return processor.get();
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
        }
    }
}
