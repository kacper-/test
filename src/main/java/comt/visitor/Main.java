package comt.visitor;

import java.util.Set;

public class Main {
    private static final Set set = Set.of(new AClass(), new BClass(), new AClass(), new BClass());

    public static void main(String[] args) {
        for(Object o : set) {
            //run(o);
        }
    }

    private static void run(AClass a) {

    }

    private static void run(BClass b) {

    }
}
