package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Class c = null;
        Object human = null;
        String result = null;
        try {
            // создайм инстанс необходимого перформера
            c = Class.forName("reflection.Human");
            human = c.newInstance();

            // задаём сигнатуру метода который будем вызывать (у нас везде контекст)
            Class[] paramTypes = new Class[]{String.class};

            // получаем рефлекшн на метод
            Method method = c.getMethod("say", paramTypes);

            // вызываем метод
            result = (String) method.invoke(human, "Hello");
        } catch (ClassNotFoundException e) {
            // не найден класс (нет такой роли)
        } catch (NoSuchMethodException e) {
            // нет такой команды (команда приходит в виде атрибуита со страницы)
        } catch (InstantiationException e) {
            // проблема создания инстанса класса (логируем)
        } catch (IllegalAccessException e) {
            // нет доступа к конструктору или методу (логируем)
        } catch (InvocationTargetException e) {
            // вызванная команда бросила эксепшн (логируем
        }
        System.out.println(result);
    }
}
