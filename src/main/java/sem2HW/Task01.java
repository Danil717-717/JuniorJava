package sem2HW;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/*
    - Создайте абстрактный класс "Animal" с полями "name" и "age".
    - Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat")
      с уникальными полями и методами.
    - Создайте массив объектов типа "Animal" и с использованием
      Reflection API выполните следующие действия:
        - Выведите на экран информацию о каждом объекте.
        - Вызовите метод "makeSound()" у каждого объекта,
          если такой метод присутствует.
 */
public class Task01 {


    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException,
                                                            NoSuchMethodException, IllegalAccessException {
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        Animal cat1 = new Cat("Dusya", 2, "Britanka", "F");
        Animal cat2 = new Cat("Barsik", 1, "Britanec", "M");
        Animal cat3 = new Cat("Pusya", 5, "Britanka", "F");

        Animal dog1 = new Dog("Belka", 1, "Bulldog", "F");
        Animal dog2 = new Dog("Rey", 3, "Boxer", "M");
        Animal dog3 = new Dog("Tim", 3, "Boxer", "M");

        animalArrayList.add(cat1);
        animalArrayList.add(cat2);
        animalArrayList.add(cat3);
        animalArrayList.add(dog1);
        animalArrayList.add(dog2);
        animalArrayList.add(dog3);

        for (Animal a : animalArrayList) {
            System.out.println(a);
        }


        for (Animal a : animalArrayList) {
            analyzeClass(a);
        }
        System.out.println("_____ Вызов метода _____");

        for (Animal a : animalArrayList) {
            methodСall(a);
        }


    }

    public static void analyzeClass(Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = o.getClass();
        Method method = o.getClass().getMethod("toString");
        System.out.println("Имя класса: " + clazz.getName());
        System.out.println("Поля класса: " + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("Родительский класс: " + clazz.getSuperclass());
        System.out.println("Методы класса: " + Arrays.toString(clazz.getDeclaredMethods()));
        System.out.println("Конструкторы класса: " + Arrays.toString(clazz.getConstructors()));
        System.out.println(method.invoke(o));
    }

    public static void methodСall(Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = o.getClass().getMethod("say");
        System.out.println("Метод say() на обьекте: " + o.getClass() + "-" + method.invoke(o));
    }

    /*
        Подскажите пожалуйста, при вызове метода say() такой вывод в консоль
        Myau
        Метод say() на обьекте: class sem2HW.Cat-null <- этот

        Что это за null в конце появился? и как его убрать?)
     */


}
