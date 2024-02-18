package comt.memory;

public class Main {
    public static void main(String[] args) {
        System.out.printf("free memory: %d%n", Runtime.getRuntime().freeMemory());
        System.out.printf("max  memory: %d%n", Runtime.getRuntime().maxMemory());
    }
}
