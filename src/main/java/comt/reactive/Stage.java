package comt.reactive;

import java.util.function.Supplier;

public abstract class Stage<P, T> implements Supplier<T> {
    private final Supplier<P> supplier;

    public Stage(Supplier<P> supplier) {
        this.supplier = supplier;
    }

    public abstract T process(P p);

    public T get() {
        return process(supplier.get());
    }

    public void run() {
        T t;
        while ((t = get()) != null) {
            sink(t);
        }
    }

    public void sink(T t) {
    }
}
