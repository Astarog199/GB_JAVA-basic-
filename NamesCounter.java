import java.util.ArrayList;
import java.util.HashMap;


/*
Вы работаете с приложением для учета имен пользователей. Ваша задача - разработать программу, которая принимает на вход пять имен пользователей (или использует имена по умолчанию, если аргументы не предоставлены) и подсчитывает, сколько раз каждое имя встречается.
Программа должна использовать HashMap для хранения имен и их количества вхождений.
По завершении, программа выводит результат в виде пар "имя - количество".

На входе:
'Elena'
'Elena'
'Elena'
'Ivan'
'Ivan'

На выходе:
{Ivan=2, Elena=3}

 */



public class NamesCounter {
    private HashMap<String, Integer> names = new HashMap<>();


    // Метод для добавления имени в HashMap
    public void addName(String name) {
        // Введите свое решение ниже
        if(names.containsKey(name)){
           int val = names.get(name)+1;
           names.put(name, val);
        }else {
            names.put(name, 1);
        }

    }

    // Метод для вывода содержимого HashMap
    public void showNamesOccurrences() {
        // Введите свое решение ниже
        System.out.println(names.toString());

    }
}
