package comt.test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String s = "sdasdgsdg";

    }

    private List<String> sortKeys(Set<String> keys) {
        return keys.stream().sorted(Comparator.comparingDouble(s -> Double.parseDouble(s))).collect(Collectors.toList());
    }
}
