package framework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class TransactionBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<String, Class>();

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Class<?> originalClass = o.getClass();
        Method[] methods = originalClass.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Transaction.class)) {
                map.put(s, originalClass);
                break;
            }
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(final Object o, String s) throws BeansException {
        final Class<?> originalClass = map.get(s);
        if (originalClass == null) {
            return o;
        }

            Object proxy = Proxy.newProxyInstance(originalClass.getClassLoader(), originalClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Method originalMethod = originalClass.getMethod(method.getName(), method.getParameterTypes());
                    if (originalMethod.isAnnotationPresent(Transaction.class)) {
                        System.out.println("Start");
                        Object retVal = method.invoke(o, args);
                        System.out.println("Stop");
                        return retVal;
                    } else {
                        return method.invoke(o, args);
                    }
                }
            });
            return proxy;
    }
}
