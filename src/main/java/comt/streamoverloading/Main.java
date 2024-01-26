package comt.streamoverloading;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<BaseType> list = List.of(new TypeA(), new TypeB());
        list.forEach(BaseType::methodOne);
    }
}
