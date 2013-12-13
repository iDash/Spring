package framework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(final Object o, String s) throws BeansException {
        Class originalClass = o.getClass();
        Method[] methods = originalClass.getMethods();
        boolean transactionFound = false;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Transaction.class)) {
                transactionFound = true;
                break;
            }
        }

        if (transactionFound) {
            Object proxy = Proxy.newProxyInstance(originalClass.getClassLoader(), originalClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Method originalMethod = o.getClass().getMethod(method.getName(), method.getParameterTypes());
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
        } else {
            return o;
        }
    }
}
