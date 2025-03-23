package comt.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeResolver<T> {
    Class<T> getParameterClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    String getType() {
        //return ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        //Type actualTypeArgument = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments() [0];
        //return actualTypeArgument.toString();
        //return  ((ParameterizedType)getClass().getGenericSuperclass()).toString();

        Class<T> entityClass;
        Type genericSuperClass = getClass().getGenericSuperclass();

        ParameterizedType parametrizedType = null;
        while (parametrizedType == null) {
            if ((genericSuperClass instanceof ParameterizedType)) {
                parametrizedType = (ParameterizedType) genericSuperClass;
            } else {
                genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass();
            }
        }

        entityClass = (Class<T>) parametrizedType.getActualTypeArguments()[0];
        return entityClass.getTypeName();
    }
}
