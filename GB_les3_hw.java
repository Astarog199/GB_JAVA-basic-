import java.util.ArrayList;

public class GB_les3_hw {
    public static void main(String[] args) {
        int [] arr = new int[]{5, 1, 6, 2, 3, 4};
        hw1_forLes3(arr);
//        hw2_forLes3(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
//        hw3_forLes3(new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9});
        for (int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    static int[] hw1_forLes3(int[] a){
//        5, 1, 6, 2, 3, 4

        int length = a.length;
        if (length ==1) return a;

        int mid = length/2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for (int i=0; i<mid; i++){
            left[i] = a[i];
        }

        for (int i=mid; i<length; i++){
            right[i-mid] = a[i];
        }

        left = hw1_forLes3(left);
        right = hw1_forLes3(right);
        return  merge(a, left, right);
    }

    private static int[]  merge( int[] a, int []left, int [] right){
        int l_leng = left.length;
        int r_leng = right.length;
        int i=0;
        int j=0;
        int idx = 0;

        while (i<l_leng && j<r_leng){
            if(left[i]<right[j]){
                a[idx]=left[i];
                i++;
                idx++;
            }else {
                a[idx] = right[j];
                j++;
                idx++;
            }
        }

        for (int index_l =i; index_l< l_leng; index_l++){
            a[idx++]=left[index_l];
        }

        for (int index_r =j; index_r< l_leng; index_r++){
            a[idx++]=right[index_r];
        }
        return a;
    }


    static void hw2_forLes3(Integer[] arr){

        ArrayList<Integer> list = new ArrayList<>();
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            if((arr[i]%2!=0)){
                list.add(arr[i]);
            }
        }
        System.out.println(list);
    }

    static void hw3_forLes3(Integer[] arr){
        /*
            Напишите функцию analyzeNumbers, которая принимает на вход целочисленный список arr и:
            Сортирует его по возрастанию и выводит на экран
            Находит минимальное значение в списке и выводит на экран - Minimum is {число}
            Находит максимальное значение в списке и выводит на экран - Maximum is {число}
            Находит среднее арифметическое значений списка и выводит на экран - Average is =  {число}
            Напишите свой код в методе analyzeNumbers класса Answer. Метод analyzeNumbers принимает на вход один параметр:

            Integer[] arr - список целых чисел
            arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
            analyzeNumbers(arr)

            // [1, 2, 3, 4, 5, 6, 7, 8, 9]
            // Minimum is 1
            // Maximum is 9
            // Average is = 5
         */
        int length = arr.length;
//        List <Integer> ArrList = Arrays.asList(arr);
        int sum =0;
        ArrayList <Integer> ArrList = new ArrayList<>();


        for (int i = 0; i <= length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            ArrList.add(arr[i]);
        }

//        Collections.sort(ArrList); // от min до max
//        ArrList.sort(Comparator.naturalOrder());

        int min = (ArrList.get(0));
        int Max = (ArrList.get(length-1));

        for (int i = 0; i < length; i++) {
            sum += ArrList.get(i);
        }
        int Average = (sum/length);

        System.out.println(ArrList);
        System.out.println("Minimum is " + min);
        System.out.println("Maximum is " + Max);
        System.out.println("Average is = " + Average);

    }

}
