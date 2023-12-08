import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneBook {

/*

Программа должна иметь следующие функции:

add(String name, Integer phoneNum): Добавляет запись в телефонную книгу.
Если запись с именем name уже существует, добавляет новый номер телефона в существующую запись.
Если запись с именем name не существует, создает новую запись с этим именем и номером телефона phoneNum.

find(String name): Поиск номеров телефона по имени в телефонной книге.
Если запись с именем name существует, возвращает список номеров телефона для этой записи.
Если запись с именем name не существует, возвращает пустой список.

getPhoneBook(): Возвращает всю телефонную книгу в виде HashMap, где ключи - это имена, а значения - списки номеров телефона.

На входе:
'Alice'
'Bob'
'123456'
'789012'

На выходе:
[123456, 789012]
{Bob=[789012], Alice=[123456, 789012]}
[]
     */

    private HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    void add(String name, Integer phoneNum){
        ArrayList<Integer> phoneNumbers= new ArrayList<>();

        if(phoneBook.containsKey(name)){
//            если имя уже есть в книге
            ArrayList<Integer> n = phoneBook.get(name);
            phoneNumbers.addAll(n);
            phoneNumbers.add(phoneNum);
            phoneBook.put(name, phoneNumbers);
        }else {
            phoneNumbers.add(phoneNum);
            phoneBook.put(name, phoneNumbers);
        }
    }

    ArrayList<Integer> find(String name){
        if(phoneBook.containsKey(name)){
            return phoneBook.get(name);
        }else {
            return new ArrayList<Integer>();
        }
    }

    Map<String, ArrayList<Integer>> getPhoneBook(){
        Map<String, Integer> counts = new HashMap<>(); //создаю новый список телефонов
        Map<String, ArrayList<Integer>> counts2 = new LinkedHashMap<>();

        for (Map.Entry<String, ArrayList<Integer>> entry : phoneBook.entrySet()) {
            String key = entry.getKey();// вытаскиваю ключ
            ArrayList<Integer> value = (entry.getValue()); // вытаскиваю значения ключа
            int lengEl = value.size(); //получаю количество телефонов каждого абонента
              counts.put(key, lengEl); // добавляю в коллекцию counts имя и количество номеров
        }
        //сортировка
        counts.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(element -> {
                    String key = element.getKey();
                    ArrayList<Integer> value = (phoneBook.get(key));
                    counts2.put(key, value);
                });
        return counts2;
    }
}