package less1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Лямбда
        System.out.println("Лямбды");
        PainInterface painInterface = new PainInterface() {
            @Override
            public String action(int x, int y) {
                return String.valueOf(x+y);
            }
        };
        System.out.println(painInterface.action(5,3));

        PainInterface painInterface1 = (x,y)-> String.valueOf(x+y);
        System.out.println(painInterface1.action(5,3));

        PainInterface painInterface2 = (x,y)-> String.valueOf(Integer.compare(x,y));
        System.out.println(painInterface2.action(1,5));

        PainInterfaceInt painInterface3 = Integer::sum;
        PainInterfaceInt painInterface4 = Integer::compare;
        System.out.println(painInterface3.action(5,3));
        System.out.println(painInterface4.action(1,3));
        System.out.println();


        //Stream API
        System.out.println("Stream API");
        List<String> list = Arrays.asList("Privet"," mir", " nakonec", " to!");
        list = list.stream().filter(str ->str.length()>4).collect(Collectors.toList());
        System.out.println("Длинна элементов листа больше 4 v1");
        for (String item:list) {
            System.out.println(item);
        }
        System.out.println("v2");
        list.stream().filter(str ->str.length()>4).forEach(s-> System.out.println(s));

        System.out.println("v3");
        list.stream().filter(str ->str.length()>4).forEach(System.out::println);

        System.out.println("Несколько фильтров");
        list.stream().filter(str ->str.length()>4).filter(s -> s.contains("o")).forEach(System.out::println);


        System.out.println();
        System.out.println("квадраты чисел из листа");
        Arrays.asList(1,2,3,4,5).stream().map(chislo->"Число: " +  chislo + ". квадрат числа - " + chislo*chislo).forEach(System.out::println);

        System.out.println();
        System.out.println("stream().sorted");
        Arrays.asList(2,5,4,7,5,9).stream().sorted().forEach(System.out::println);

        System.out.println();
        System.out.println("stream().sorted");

        Arrays.asList(2,5,4,7,5,9).stream().sorted().distinct().forEach(System.out::println);

        System.out.println();
        System.out.println("Класс User");

        List<User> list1 = Arrays.asList(new User("Юрий", 25),new User("Аркадий", 45),new User("Павел", 12));

        System.out.println("Убавить у User по 5 лет");
        list1.stream().map(user -> new User(user.name, user.age-5)).forEach(System.out::println);
        System.out.println("Убавить у User по 5 лет и отсортировать");
        list1.stream().map(user -> new User(user.name, user.age-5)).filter(user -> user.age<=25).forEach(System.out::println);


    }
}
