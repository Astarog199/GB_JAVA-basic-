import java.util.LinkedList;
import java.util.*;

public class GB_les4 {
    public static void main(String[] args) {
//        task19();
//        task20();

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(10);

        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.empty());
    }
    private static void GetType(Object o) {
        System.out.println(o.getClass().getName());
    }

    static void task16() {
        /*
        Задание №0
            1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
            2) Замерьте время, за которое в LinkedList добавятся 10000 элементов.
            Сравните с предыдущим
         */
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new LinkedList<Integer>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            list1.add(0, i);
            System.out.println(list1);
        }

        long midle = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            list2.add(0, i);
        }
        long finish = System.currentTimeMillis();

        System.out.println("ArrayList: " + (midle - start)); //ArrayList:  45762

        System.out.println("LinkedList: " + (finish - midle)); //LinkedList: 90


        /*
        вывод: ArrayList заполняется эл-ми быстрее чем LinkedList,
        так как в LinkedList помимо того что добавляются эл-ты,
        но и каждому отдельному эл-ту присваивается ссылка
         */
    }

    static void task17(){
        /*
        Реализовать консольное приложение, которое:
        1. Принимает от пользователя строку вида
        text~num
        2. Нужно рассплитить строку по ~, сохранить text в связный список на
        позицию num.
        3. Если введено print~num, выводит строку из позиции num в связном
        списке и удаляет её из списка
         */
        List<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean work = true;
        while (work){
            System.out.println("input text: ");
            String line = scanner.nextLine();
            String[] arr = line.split("~");
            String text = arr[0];
            int num =Integer.parseInt(arr[1]);
            switch (text){
                case "print" :
                    System.out.println(list.remove(num));
                    break;
                    case "exit" :
                        System.out.println("Bye bye");
                        work = false;
                        break;
                default:
                    list.add(num, text);
            }
            System.out.println(list);
        }
    }

    static void task18(){
        /*
        Реализовать консольное приложение, которое:
        1. Принимает от пользователя и “запоминает” строки.
        2. Если введено print, выводит строки так, чтобы последняя введенная
        была первой в списке, а первая - последней.
        3. Если введено revert, удаляет предыдущую введенную строку из памяти.
         */
        List<String> list = new LinkedList<>();
        int num =0;
        Scanner scanner = new Scanner(System.in);
        boolean work = true;
        while (work) {
            System.out.println("input text: ");
            String line = scanner.nextLine();
            if (Objects.equals(line, "print")) {
                ListIterator<String> iterator = list.listIterator(list.size());
                while (iterator.hasPrevious()){
                    System.out.print(iterator.previous());
                }

            } else if (Objects.equals(line, "revert")) {
                System.out.println(list.remove(num - 1));
            } else if (Objects.equals(line, "exit")) {
                System.out.println("Bye bye");
                work = false;
            } else {
                list.add(num, line);
                num++;
            }

        }
    }
    static void task19() {
        int [] arr = new int[]{5, 1, 6, 2, 3, 4};
        /*
        Написать метод, который принимает массив элементов, помещает их в стэк
        и выводит на консоль содержимое стэка.
        */

        Stack <Integer> stack = new Stack<>();
        for(int i = 0; i <arr.length; i++){
            stack.add(arr[i]);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }
    static void task20(){
        /*
        Написать метод, который принимает массив элементов, помещает их в
        очередь и выводит на консоль содержимое очереди.
         */
        int [] arr = new int[]{5, 1, 6, 2, 3, 4};
        Queue<Integer> queue = new LinkedList<>();
        for (int i =0; i<arr.length; i++){
            queue.add(arr[i]);
        }

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        }












    }





