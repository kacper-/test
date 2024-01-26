package comt.streamoverloading;

public interface BaseType {
    default void methodOne() {
        System.out.println(this.getClass().getName());
    }
}
