package comt.forname;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("comt.forname.Test");
            Callable<String> x = (Callable<String>)c.getDeclaredConstructor().newInstance();
            System.out.println(x.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
