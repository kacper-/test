package comt.construct;

public class ClassA {
    public static void main(String[] args) {
        ClassB b = new ClassB();
    }

    private String a = runA();
    public String aa;

    public ClassA() {
        aa = "AA";
        System.out.println("ClassA");
    }

    protected String runA() {
        System.out.println("runA");
        return "runA";
    }

}
