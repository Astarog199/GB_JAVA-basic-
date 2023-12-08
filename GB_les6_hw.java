import java.util.*;
public class GB_les6_hw {
    /*

    Реализуйте структуру телефонной книги с помощью HashMap.
    Программа также должна учитывать, что в во входной структуре
    будут повторяющиеся имена с разными телефонами, их необходимо считать,
    как одного человека с разными телефонами.

    Вывод должен быть отсортирован по убыванию числа телефонов.

     */
    public static void main(String[] args) {
        HomeWorkForLesson_6();
    }
    static void HomeWorkForLesson_6(){
    PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Bob",789012);
        phoneBook.add("Alice",123456);
        phoneBook.add("Alice",789012);
        phoneBook.add("Alice",777702);
        System.out.println(phoneBook.getPhoneBook());
    }
}
