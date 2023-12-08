public class HeapSort {

    static void buildTree(int[] tree) {
        int n = tree.length;

        for (int i = n /2- 1; i >= 0; i--) {
            Heapify (tree, i, n);
        }
    }

    static void heapSort(int[] sortArray) {
        int n = sortArray.length;
        buildTree(sortArray);

        for (int i =n-1; i>=0; i--){
            int temp = sortArray[i];
            sortArray[i] = sortArray[0];
            sortArray[0] = temp;

            Heapify(sortArray, 0, i);
        }
    }
    private static void Heapify(int[] arr, int i, int n) {
        int l = i*2+1;
        int r = i*2+2;
        int largest = i;

        if(l<n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if(i != largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            Heapify(arr, largest, n);
        }
    }
}
