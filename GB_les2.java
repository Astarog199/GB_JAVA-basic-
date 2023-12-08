import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class GB_les2 {
    public static void main(String[] args) {
        System.out.println(task7('h', 'a', 20));
        task8("aaaabbbcdd");
        task9();
        System.out.println(task10("101"));
        task11("TEST ", 5);
        task12("test");
    }

    static String task7(char c1, char c2, int n) {
        /*
        Дано четное число N (>0) и символы c1 и c2. Написать метод, который вернет строку длины N,
        которая состоит из чередующихся символов c1 и c2, начиная с c1.
         */

        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < n / 2; j++) {
            stringBuilder.append(c1).append(c2);
        }
        return stringBuilder.toString();
    }

    static void task8(String str) {
        /*
        Напишите метод, который сжимает строку. Пример: вход aaaabbbcdd => a4b3c1d2
         */
        int count = 0; //счётчик
        char[] chars = str.toCharArray(); // создаём из строки массив
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                stringBuilder.append(chars[i - 1]).append(count + 1);
                count = 0;
            } else {
                count++;
            }
        }
        stringBuilder.append(chars[chars.length - 1]).append(count + 1);
        System.out.println(stringBuilder);
    }

    static void task9() {
        /*
        Напишите метод, который принимает на вход строку (String)
        и определяет является ли строка палиндромом (возвращает boolean значение).

        Палиндро́м — число, буквосочетание, слово или текст, одинаково читающееся в обоих направлениях.
        Например, число 101; слова «топот»
         */

        String str1 = "Например";
        String str = str1.toLowerCase();
        char[] arr = str.toCharArray();
        int length = str1.length();
        String[] arr2 = new String[length];
        int count = 0;

        for (int i = length - 1; i >= 0; i--) {
            arr2[count] = String.valueOf(arr[i]);
            count++;
        }
        String str2 = String.join("", arr2);
        boolean res = Objects.equals(str1, str2);

        if (res) {
            System.out.println("Палиндро́м: " + str + " => " + str2 + " результат true");
        } else {
            System.out.println("Палиндро́м: " + str + " => " + str2 + " результат false");
        }

    }


    static boolean task10(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        String str2 = stringBuilder.reverse().toString();
        return str.equals(str2);
    }

    static void task11(String str, int n){
        String text = str.repeat(n);

        try (FileWriter writer = new FileWriter("text.tht", true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void  task12(String text){
//        логирование  info warning fatal

        Logger logger= Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.tht");
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.addHandler(fileHandler);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);


        try (FileWriter writer = new FileWriter("text.tht")) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, e.getMessage());
        }

        fileHandler.close();
        logger.getHandlers()[0].close();
    }
}
