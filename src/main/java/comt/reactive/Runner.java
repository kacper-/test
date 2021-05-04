package comt.reactive;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Runner {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");
        Supplier<String> supplier = new Supplier<>() {
            int count = 0;

            @Override
            public String get() {
                if (count >= list.size())
                    return null;
                return list.get(count++);
            }
        };

        Stage<String, String> stage = new Stage<>(supplier) {
            @Override
            public String process(String s) {
                if (s != null)
                    return s.toUpperCase();
                return null;
            }
        };

        Stage<String, String> sink = new Stage<>(stage) {
            @Override
            public String process(String s) {
                return s;
            }

            @Override
            public void sink(String s) {
                System.out.println(s);
            }
        };

        sink.run();
    }
}
