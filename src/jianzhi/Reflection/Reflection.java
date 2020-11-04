package jianzhi.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] argv) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object leo = constructor.newInstance("leo", 10);
        Person aiyou = (Person) leo;
        aiyou.show();
        Field field = clazz.getDeclaredField("age");
        field.set(aiyou,10);
        System.out.println(aiyou);
        Method method = clazz.getDeclaredMethod("show");
        method.invoke(aiyou);
    }

}
class Test{
    public static void aiai(){
    }
}