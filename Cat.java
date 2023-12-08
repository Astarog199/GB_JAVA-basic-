import java.util.*;


public class Cat {
    /*
    1. Продумайте структуру класса Кот. Какие поля и методы будут актуальны для
    приложения, которое является
    а) информационной системой ветеринарной клиники
    б) архивом выставки котов
    в) информационной системой Театра кошек Ю. Д. Куклачёва
    Можно записать в текстовом виде, не обязательно реализовывать в java.
    2. Реализуйте 1 из вариантов класса Cat из предыдущего задания, можно
    использовать не все придуманные поля и методы. Создайте несколько
    экземпляров этого класса, выведите их в консоль.
    3. Добейтесь того, чтобы при выводе в консоль объекта типа Cat, выводилась
    его кличка, цвет и возраст (или другие параметры на ваше усмотрение)
    4. Создайте множество, в котором будут храниться экземпляры класса Cat - HashSet<Cat>.
    Поместите в него некоторое количество объектов.
    5. Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их во множество.
    Убедитесь, что все они сохранились во множество.

    6. Создайте метод public boolean equals(Object o)
    Пропишите в нём логику сравнения котов по параметрам, хранимым в полях. То есть, метод
    должен возвращать true, только если значения во всех полях сравниваемых объектов равны.

    7. Создайте метод public int hashCode()
    который будет возвращать hash, вычисленный на основе полей класса Cat. (Можно использовать
    Objects.hash(...))
    8. Выведите снова содержимое множества из пункта 5, убедитесь, что дубликаты удалились
     */

    private String name;
    private String breed;
    private String owner;
    private int age;
    private List<String> healthList;

    public Cat(String name, String breed, String owner, int age) {
        this.name = name;
        this.breed = breed;
        this.owner = owner;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", owner='" + owner + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Cat t = (Cat) obj;
        boolean FlagName = name == t.name;
        boolean FlagBreed = breed == t.breed;
        boolean FlagOwner = owner == t.owner;
        boolean FlagAge = age == t.age;
        return FlagName && FlagBreed && FlagOwner && FlagAge;
    }

    @Override
    public int hashCode() {
       return name.hashCode() + breed.hashCode() + owner.hashCode() * age;
    }

}
