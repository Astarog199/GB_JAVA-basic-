import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

public class GB_les1 {
    public static void main(String[] args) {

    task6(2, -2);
    }

    static void  task0 () {
        /*
        Написать программу, которая запросит пользователя ввести <Имя> в консоли.
        Получит введенную строку и выведет в консоль сообщение “Привет, <Имя>!”
        */
        Scanner sc = new Scanner(System.in);
        System.out.print("Hello and welcome!");
        System.out.println("What is your name?");
        String name = sc.nextLine();
        System.out.printf("Hello %s!", name);
        sc.close();
    }

    static void task1() {
        /*
        Задание №1+
        В консоли запросить имя пользователя. В зависимости от
        текущего времени, вывести приветствие вида
        "Доброе утро, <Имя>!", если время от 05:00 до 11:59
        "Добрый день, <Имя>!", если время от 12:00 до 17:59;
        "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
        "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = sc.nextLine();
        sc.close();

        LocalTime time = LocalTime.now();
        int hour = LocalTime.now().getHour();

        if (hour >= 5 & hour< 12)
            System.out.printf("Good morning %s!", name);
        else if (hour >= 12 & hour< 18)
            System.out.printf("Good afternoon %s!", name);
        else if (hour >= 18 & hour< 23)
            System.out.printf("Good evening %s!", name);
        else System.out.printf("Good night %s!", name);
    }

    static void task2() {
        /*
        Задание №2
        Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести
        максимальное количество подряд идущих 1.
         */
        int[] arr = {1,1,0,1,1,1};
        int max=0;
        for(int i =0; i< arr.length; i++){
        if (arr[i] == 1){
            max++;
        } else {
            max = 0;
        }
        }
        String res = String.format("Maximum number of consecutive 1: %d", max);
        System.out.println(res);
    }

    static void task3(){
        /*
        Задание №3
        Дан массив numbs = [3,2,2,3] и число val = 3.
        Если в массиве есть числа, равные заданному, нужно перенести
        эти элементы в конец массива.
        Таким образом, первые несколько (или все) элементов массива
        должны быть отличны от заданного, а остальные - равны ему.
         */

        int[] numbs = {2,3,2,3,7,2,3,5};
        int val = 3;
        int el = numbs.length-1; // 4

        int box;

        for(int i =0; i <= el; i++){
            if (numbs[el] == val){
                el--;
            } else if(numbs[i] == val ){
                System.out.println("numbs[" + i +"]" + " => " + numbs[i]);
                box = numbs[el];
                numbs[el] = numbs[i];
                numbs[i] = box;
                el--;
            }
        }
        System.out.println();
        for(int x =0; x < numbs.length; x++){
            System.out.println("numbs[" + x + "]" + numbs[x]);
        }
    }

    static void task4(){
        /*
        Задание №4
        Напишите метод, который находит самую длинную строку общего
        префикса среди массива строк.
        Если общего префикса нет, вернуть пустую строку "".
         */



    }

    static void task5(){
        /*
        Задание №5
        Во фразе "Добро пожаловать на курс по Java"
        переставить слова в обратном порядке.
         */

        String str = "Добро пожаловать на курс по Java";
        String[] parts = str.toLowerCase().split(" ");
        for(int i = parts.length - 1; i>=0; i--){
            if (i==parts.length - 1) {
                String box = parts[i].toUpperCase(Locale.ROOT);
                parts[i]=box;
            }
            System.out.print(parts[i] + " ");
        }
    }

    static void task6(int a, int b){
        /*
        Задание №6 (доп)
        Реализовать функцию возведения числа а в степень b.
        Сводя количество выполняемых действий к минимуму.
        Пример 1: а = 3, b = 2, ответ: 9
        Пример 2: а = 2, b = -2, ответ: 0.25
        Пример 3: а = 3, b = 0, ответ: 1
         */
        double res = 1;
            for (int i = 0; Math.abs(b) > i; i++) {
                res *= a;
            }
        System.out.println( b>0 ? res : 1/res);
    }
}