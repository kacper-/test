package comt.reactive;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Runner {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");

        Stage<String, String> source = new Stage<>(new Supplier<>() {
            int count = 0;

            @Override
            public String get() {
                if (count >= list.size())
                    return null;
                return list.get(count++);
            }
        }) {
            @Override
            public String process(String s) {
                return s;
            }
        };

        Stage<String, String> stage = new Stage<>(source) {
            @Override
            public String process(String s) {
                return s;
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
