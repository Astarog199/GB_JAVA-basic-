public class GB_les5_hw {
    public static void main(String[] args) {

        hw();
//      hw2();
//      hw3();

    }

    static void hw(){
/*
    Напишите программу, представляющую телефонную книгу.
*/
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Bob",789012);
        phoneBook.add("Alice",123456);
        phoneBook.add("Alice",789012);
        phoneBook.add("Alice",777702);
        System.out.println(phoneBook.find("Bob"));
        System.out.println(phoneBook.getPhoneBook());

    }

    static void hw2(){
        NamesCounter nc = new NamesCounter();
        nc.addName("Elena");
        nc.addName("Elena");
        nc.addName("Elena");
        nc.addName("Ivan");
        nc.addName("Ivan");
        nc.showNamesOccurrences();
    }

    static void hw3(){
        HeapSort hs = new HeapSort();
        int[] arr = {5, 8, 12, 3, 6, 9, 13};
        hs.buildTree(arr);
        hs.heapSort(arr);

        for (int i : arr){
            System.out.print(i + " ");
        }
    }


 }

