import java.util.*;

public class Worker {
    int id;
    int salary;
    String firstName;
    String lastName;

    @Override
    public String toString() {
        String res = String.format("id:%d first Name:%s last Name:%s salary:%d", id, firstName, lastName, salary);
        return res;
    }


    public boolean equals(Object obj) {
        Worker t =(Worker) obj;
        return id == t.id && firstName == t.firstName;

    }

    @Override
    public int hashCode() {
        return id;
    }

    public static void main(String[] args) {
            Worker w1 = new Worker();
            w1.firstName = "Иван";
            w1.lastName = "Иванов";
            w1.salary = 100;
            w1.id = 001;

            Worker w2 = new Worker();
            w2.firstName = "Пётр";
            w2.lastName = "Петров";
            w2.salary = 100;
            w2.id = 002;

            Worker w3 = new Worker();
            w3.firstName = "Иван";
            w3.lastName = "Сидоров";
            w3.salary = 100;
            w3.id = 003;

            Worker w4 = new Worker();
            w4.firstName = "Иван";
            w4.lastName = "Иванов";
            w4.salary = 100;
            w4.id = 001;


        System.out.println(w1);
        System.out.println(w2);
        System.out.println(w3);



        System.out.println(w1==w4);
        System.out.println(w1.equals(w4));
        var workers = new HashSet<Worker>(Arrays.asList(w1, w2, w3));
        System.out.println(workers.contains(w4));


        }
    }
