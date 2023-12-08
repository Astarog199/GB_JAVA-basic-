import java.util.*;

public class GB_les3 {
    public static void main(String[] args) {
        task13(createlist(10, 0, 9));
//        task14();

//        List <ArrayList<String>> catalog = new ArrayList<>();
//        task15("Война и мир", "проза",  catalog);
//        for (int i = 0; i<4; i++){
//            task15("name"+i, "janr"+i, catalog);
//        }
//        task15("Война и мир2", "janr1",  catalog);
//        System.out.println(catalog);

    }
    //создание списка
    static List<Integer> createlist(int size, int min, int max){
        List <Integer> LIST = new ArrayList<>(size);
        for(int i =0; i <size; i++){
            LIST.add(new Random().nextInt(min, max+1));
        }
        return LIST;
    }

    static void task13( List<Integer> list){
        /*
        Заполнить список десятью случайными числами.
        Отсортировать список методом sort() и вывести его на экран
         */
        Collections.sort(list); // от min до max
        list.sort(Comparator.reverseOrder()); //от max до min
        System.out.println(list);
    }

  static void task14 (int arr) {
        /*
        Создать список типа ArrayList<String>.
        Поместить в него как строки, так и целые числа.
        Пройти по списку, найти и удалить целые числа
         */

      List list = new ArrayList<>();

      list.add(1);
      list.add(2);
      list.add("text");
      list.add(1.2);

      System.out.println(list); //[1, 2, text, 1.2]

      Iterator iterator = list.iterator();
      while (iterator.hasNext()) {
        Object o = iterator.next();
            if (o instanceof Integer) {
                iterator.remove();;
            }
      }
      System.out.println(list); //[text, 1.2]
  }


    static void task15( String name, String janr, List<ArrayList<String>> list) {
                /*
        Каталог товаров книжного магазина сохранен в виде двумерного
        списка List<ArrayList<String>> так, что на 0й позиции каждого
        внутреннего списка содержится название жанра, а на остальных
        позициях - названия книг. Напишите метод для заполнения данной
        структуры.
         */

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0).equals(janr)) {
                list.get(i).add(name);
            }
            System.out.println(list.get(i).get(0));
        }
        ArrayList<String> newJanre = new ArrayList<>();
        newJanre.add(janr);
        newJanre.add(name);
        list.add(newJanre);
    }



}



