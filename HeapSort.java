import java.util.Arrays;

public class HeapSort {

    static void maxHeapify(int[] arr, int size, int i) {
        int n = size - 1;
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        while (left <= n && arr[left] > arr[largest]) {
            largest = left;
        }
        while (right <= n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, largest, i);
            maxHeapify(arr, size, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void heapSort(int[] arr) {
        int n = arr.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            maxHeapify(arr, arr.length, i);
        }
        for (int i = n; i >= 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, -5, -7, 9, 7, 2, 4, 0, 1, -3, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
