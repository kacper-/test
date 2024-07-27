package comt.forname;

import java.util.concurrent.Callable;

public class Test implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "test";
    }
}
