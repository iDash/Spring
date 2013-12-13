package reflections;

import java.lang.reflect.Method;

public class ObjectFactory {
    public static <T> T createObject(Class<T> clazz) throws Exception {
        T object = clazz.newInstance();

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
            if (annotation != null) {
                for (int i = 0; i < annotation.repeat(); i++) {
                    method.invoke(object);
                }
            }
        }

        return object;
    }
}
