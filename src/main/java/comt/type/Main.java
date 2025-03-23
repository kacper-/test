package comt.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Type t1 = getGenericRuntimeType(new Wrapper<List<String>>() {});
        System.out.println(t1);
    }

    public static <T> Type getGenericRuntimeType(Wrapper<T> wrapper) {
        Type type = wrapper.getClass().getGenericSuperclass();
        if (type == null) {
            return null;
        }

        if (type instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType)type).getActualTypeArguments();
            return types[0];
        }
        return null;
    }

    static class Wrapper<T> {
    }
}
