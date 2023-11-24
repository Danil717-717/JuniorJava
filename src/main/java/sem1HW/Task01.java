package sem1HW;

import java.util.List;

/*
     1. Напишите программу, которая использует Stream API для обработки списка чисел.
        Программа должна вывести на экран среднее значение всех четных чисел в списке.
     2. *Дополнительная задача: Переработать метод балансировки корзины товаров cardBalancing()
        с использованием Stream API
 */
public class Task01 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,4,7,8,9,15,24);
        double avg =  list.stream().mapToDouble(d->d).average().getAsDouble();
        System.out.println(avg);

    }
}
