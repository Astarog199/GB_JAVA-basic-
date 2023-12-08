import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class sort {
    public static void main(String[] args) {

        Sort(new int[]{9, 4, 8, 3, 1});
//        Sort(new int[]{9, 3, 4, 8, 2, 5, 7, 1, 6, 10});
//      Sort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
    }

    static void Sort(int[] mas) {

        int length = mas.length;
        int[] copy = mas.clone();

        int c = 0;
        int max;
        StringBuilder res = new StringBuilder();
        for (int j = length - 1; j >= 0; j--) {

            max = 0;

            for (int i = j; i >= 0; i--) {

                if (mas[i] >= max) {
                    max = mas[i];
                    c = i;
                }
            }

            copy[j] = max;

            int count = j;
            for (int x = j - 1; x >= 0; x--) {
                if (count != c) {
                    copy[x] = mas[count];
                } else {
                    count = count - 1;
                    copy[x] = mas[count];
                }
                count--;
            }



            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            String dt = formatForDateNow.format(dateNow);

            res.append(dt).append(" ").append('[');
            for (int key = 0; key < length; key++) {
                mas[key] = copy[key];
                res.append(copy[key]).append(',').append(" ");
                if (key == length - 1) {
                    res.deleteCharAt(res.length() - 1).deleteCharAt(res.length() - 1);
                    res.append(']').append("\n");
                }
            }
        }


        String text = String.valueOf(res);

        try (FileWriter writer = new FileWriter("log.txt", false)) {
            writer.write(text);
            writer.flush();
            writer.write(System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();

        }

    }


}
