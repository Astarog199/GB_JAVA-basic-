import java.util.*;

public class GB_les6 {
    public static void main(String[] args) {
//        task25();
//        task26(crateArray(1000, 0, 24));
        Cat cat1 = new Cat("murka", "Persidskaya", "Ivan I.I", 9);
        Cat cat2 = new Cat("barsik", "Pacanskiy", "Ivan t.t", 5);
        Cat cat3 = new Cat("murka", "Persidskaya", "Ivan I.I", 9);
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);
        Set<Cat> cats = new HashSet<Cat>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        System.out.println(cats);
        System.out.println(cat1.equals(cat3));
        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());
        System.out.println(cat3.hashCode());
    }

    static Integer[] crateArray(int size, int min, int max) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(min, max);
        }
        return array;
    }

    static void task25() {
        Integer[] arr = {1, 7, 3, 9, 5, 6, 6};
        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr));
        Set<Integer> set2 = new LinkedHashSet<>(Arrays.asList(arr));
        Set<Integer> set3 = new TreeSet<>(Arrays.asList(arr));

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
    }

    static void task26(Integer[] arr) {
        /*
        1. Напишите метод, который заполнит массив из 1000 элементов случайными
        цифрами от 0 до 24.

        2. Создайте метод, в который передайте заполненный выше массив и с
        помощью Set вычислите процент уникальных значений в данном массиве и
        верните его в виде числа с плавающей запятой.
        Для вычисления процента используйте формулу:
        процент уникальных чисел = количество уникальных чисел * 100 / общее
        количество чисел в массиве.
         */
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        double percent = set.size() * 100.0 / arr.length;
        System.out.println(percent);
    }


}
