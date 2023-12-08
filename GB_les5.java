import java.util.*;

public class GB_les5 {
    public static void main(String[] args) {
//        task21();
//        System.out.println(task22("foo", "bar"));
//        System.out.println(task23("a+(d*3)"));
//        System.out.println(task23("[a+(1*3)"));
//        System.out.println(task23("[6+(3*3)]"));
//        System.out.println(task23("{a}[+]{(d*3)}"));
//        System.out.println(task23("<{a}+{(d*3)}>"));
//        System.out.println(task23("{a+]}{(d*3)}"));
        task24("Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись.");
    }

    static void task21() {
        Passports passports = new Passports();

        passports.add("123456", "Иванов");
        passports.add("321456", "Васильев");
        passports.add("234561", "Петрова");
        passports.add("234432", "Иванов");
        passports.add("654321", "Петрова");
        passports.add("345678", "Иванов");

        System.out.println(passports.getByPassNum("234561"));
        System.out.println(passports.getBylastName("Иванов"));
        System.out.println(passports.getAll());
    }

    static boolean task22(String str1, String str2) {
        /*
        Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными
        и false, если нет. Строки изоморфны, если одну букву в первом слове можно заменить на
        некоторую букву во втором слове, при этом

        1. повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением
        порядка следования. (Например, add - egg изоморфны)
        2. буква может не меняться, а остаться такой же. (Например, note - code)
        Пример 1:
        Input: s = "foo", t = "bar"
        Output: false
        Пример 2:
        Input: s = "paper", t = "title"
        Output: true
         */

        if (str1.length() != str2.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            if (map.containsKey(c1[i])) {
                if (!map.get(c1[i]).equals(c2[i])) {
                    return false;
                }
            } else {
                map.put(c1[i], c2[i]);
            }
        }
        return true;
    }

    static boolean task23(String str) {
/*
Написать программу, определяющую правильность расстановки скобок в выражении.
Пример 1: a+(d*3) - истина
Пример 2: [a+(1*3) - ложь
Пример 3: [6+(3*3)] - истина
Пример 4: {a}[+]{(d*3)} - истина
Пример 5: <{a}+{(d*3)}> - истина
Пример 6: {a+]}{(d*3)} - ложь
*/
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        map.put('<','>');

        char[] c = str.toCharArray();
        for (int i=0; i<c.length; i++){
            if(map.containsKey(c[i])) stack.add(c[i]);
            if( map.containsValue(c[i])){
                if(stack.isEmpty() || map.get(stack.pop()) != c[i]) return false;
                }
            }
        if(!stack.isEmpty()) return false;
        return true;
    }

    static void task24(String str){
        /*
Взять набор строк, например,Мороз и солнце день чудесный Еще ты дремлешь друг
прелестный Пора красавица проснись.
Написать метод, который отсортирует эти строки по длине с помощью TreeMap. Строки с
одинаковой длиной не должны “потеряться”.
         */
        str = str.replace(".", " ");
        String[] words = str.split(" ");
        TreeMap<Integer, List <String>> map = new TreeMap<>();

        for (String word : words) {
            int leng = word.length();
            if(map.containsKey(leng)){
                List<String> list = map.get(leng);
                list.add(word);
            }else {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(word);
                map.put(leng, arrayList);
            }
        }
        System.out.println(map);
    }
}
