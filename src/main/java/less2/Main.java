package less2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //Через Class создаем обьект класса Car
        Class<?> car = Class.forName("less2.Car");
        //получаем конструкторы класса
        Constructor<?>[] constructors  = car.getConstructors();
        //выводим конструкторы чтобы правильно создать обьект
        for(Constructor constructor: constructors){
            System.out.println(constructor);
        }

        //выбираем из массива необходимый конструктор
        //и создаем обьект
        Object gaz = constructors[0].newInstance("GAZ");
        //вывод обьекта
        System.out.println(gaz);

        //получаем список полей класса
        Field[] fields= gaz.getClass().getFields();
        for(Field field: fields){
            System.out.println(field);
        }
        //выбираем необходимое поле
        int tmp = fields[fields.length-1].getInt(gaz);
        //задаем новое значение
        fields[fields.length-1].setInt(gaz,tmp*2);

        System.out.println(gaz);


        //получаем методы класса
        Method[] methods = gaz.getClass().getDeclaredMethods();
        for(Method method: methods){
            System.out.println(method);
        }






    }
}
