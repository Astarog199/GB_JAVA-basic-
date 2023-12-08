import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class GB_les4_hw {

    public static void main(String[] args) {
        LinkedList<Object> ll = new LinkedList<>();
        ll.add(1);
        ll.add("One");
        ll.add(2);
        ll.add("Two");
        System.out.println(ll);
        System.out.println(hw1(ll));


        calculate('+', 3, 7);
        calculate('+', 4, 7);
        calculate('<', 0, 0);

        hw3();
    }

    static LinkedList<Object> hw1(LinkedList<Object> ll) {
        /*
        Напишите класс LLTasks с методом revert, который принимал бы на вход LinkedList и возвращает “перевернутый” список.
        // Дан
        [1, One, 2, Two]

        // Вывод
        [1, One, 2, Two]
        [Two, 2, One, 1]
         */

        LinkedList<Object> list = new LinkedList<Object>();
        ListIterator<Object> iterator = ll.listIterator(ll.size());
        while (iterator.hasPrevious()){
            list.add(iterator.previous());
        }

        return list;
    }

    public static int calculate(char op, int a, int b) {
        /*
        В обычный калькулятор без логирования добавьте возможность отменить последнюю операцию.
        Отмена последней операции должна быть реализована следующим образом: если передан оператор '<' калькулятор должен вывести результат предпоследней операции.
                calculate('+', 3, 7)
                calculate('+', 4, 7)
                calculate('<', 0, 0)
                // 10
                // 11
                // 10
         */

        // Напишите свое решение ниже
        List<Object> list = new LinkedList<>();
        boolean work = true;
        int res = 0;
        switch (op) {
            case '+':
                System.out.println(a + b);
                res = a + b;
                list.add(res);
                break;
            case '-':
                System.out.println(a - b);
                res = a - b;
                list.add(res);
                break;
            case '*':
                System.out.println(a * b);
                res = a * b;
                list.add(res);
                break;
            case '/':
                System.out.println(a / b);
                res = a / b;
                list.add(res);
                break;
            case '<':
                res = (int) list.get(list.size() - 2);
                break;
            default:
                System.out.println("Err");
        }
        return res;
    }
    public static void hw3(){

        /*
        В классе MyQueue реализуйте очередь с помощью LinkedList со следующими методами:
        enqueue() - помещает элемент в конец очереди
        dequeue() - возвращает первый элемент из очереди и удаляет его
        first() - возвращает первый элемент из очереди, не удаляя
        getElements() - возвращает все элементы в очереди
        */

        Queue<Integer> queue = enqueue();
        getElements(queue);
        dequeue(queue);
        first(queue);
    }

    public static Queue<Integer> enqueue(){
        //         enqueue() - помещает элемент в конец очереди
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(10);
        queue.add(15);
        queue.add(5);
        return queue;
    }

    static void dequeue(Queue<Integer> list){
        //  dequeue() - возвращает первый элемент из очереди и удаляет его
        System.out.println(list.poll() + " dequeue() - возвращает первый элемент из очереди и удаляет его");

    }

    static void first(Queue<Integer> list){
        // first() - возвращает первый элемент из очереди, не удаляя
        System.out.println(list.peek() + " first()  - возвращает первый элемент из очереди, не удаляя");
    }

    static void getElements(Queue<Integer> list) {
        // getElements() - возвращает все элементы в очереди
        System.out.print('[');
        for (Object element : list) {
            System.out.print(element + " ");
        }
        System.out.println(']');
    }

}
