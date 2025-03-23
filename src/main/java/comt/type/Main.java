package comt.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        try {
            Class<?> c = getGenericRuntimeType(new Wrapper<String>() {
            });
            System.out.println(c);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Class<?> getGenericRuntimeType(Wrapper<T> wrapper) throws ClassNotFoundException {
        Type type = wrapper.getClass().getGenericSuperclass();
        if (type == null) {
            return null;
        }

        if (type instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) type).getActualTypeArguments();
            String fullName = types[0].toString();
            if (fullName.contains("<")) {
                String outerName = fullName.substring(0, fullName.indexOf("<"));
                return Class.forName(outerName);
            } else {
                String innerName = fullName.substring(fullName.indexOf(" ") + 1);
                return Class.forName(innerName);
            }
        }
        return null;
    }

    static class Wrapper<T> {
    }
}
