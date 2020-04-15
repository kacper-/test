package comt.mapreduce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapReduce {
    private static String[] names = new String[]{
            "Bus", "Car", "bus", "car", "train", "car", "bus", "car", "train", "bus", "TRAIN", "BUS", "buS",
            "caR", "CAR", "car", "BUS", "TRAIN"
    };

    public static void main(String[] args) {
        List<String> list = Arrays.asList(names);
        Map<String, Integer> map = list.parallelStream().
                reduce(new HashMap<>(), MapReduce::accumulator, MapReduce::combinator);
        for (String key : map.keySet())
            System.out.println(String.format("%s = %d", key, map.get(key)));
    }

    private static Map<String, Integer> accumulator(Map<String, Integer> a, String i) {
        if (a.containsKey(i))
            a.put(i, a.get(i) + 1);
        else
            a.put(i, 1);
        return a;
    }

    private static Map<String, Integer> combinator(Map<String, Integer> a, Map<String, Integer> b) {
        return a;
    }
}
