package comt.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        MyInteger i = new MyInteger(1);
        Map<MyInteger, String> map = new HashMap<>();
        map.put(i, "OK");
        i.setI(2);
        System.out.println(map.get(i));
        System.out.println(i.hashCode());
    }
}
