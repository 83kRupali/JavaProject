package sort.example.sort.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SortService {

    public List<int[]> bubbleSort(int[] arr) {
        List<int[]> steps = new ArrayList<>();
        int[] a = arr.clone();
        steps.add(a.clone());
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
                steps.add(a.clone());
            }
        }
        return steps;
    }

    public List<int[]> insertionSort(int[] arr) {
        List<int[]> steps = new ArrayList<>();
        int[] a = arr.clone();
        steps.add(a.clone());
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
                steps.add(a.clone());
            }
            a[j + 1] = key;
            steps.add(a.clone());
        }
        return steps;
    }

    public List<int[]> selectionSort(int[] arr) {
        List<int[]> steps = new ArrayList<>();
        int[] a = arr.clone();
        steps.add(a.clone());
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
            steps.add(a.clone());
        }
        return steps;
    }

    // ✅ Merge Sort
    public List<int[]> mergeSort(int[] arr) {
        List<int[]> steps = new ArrayList<>();
        int[] a = arr.clone();
        steps.add(a.clone());
        mergeSortHelper(a, 0, a.length - 1, steps);
        return steps;
    }

    private void mergeSortHelper(int[] arr, int left, int right, List<int[]> steps) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(arr, left, mid, steps);
            mergeSortHelper(arr, mid + 1, right, steps);
            merge(arr, left, mid, right, steps);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, List<int[]> steps) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
            steps.add(arr.clone());
        }

        while (i < n1) {
            arr[k++] = L[i++];
            steps.add(arr.clone());
        }

        while (j < n2) {
            arr[k++] = R[j++];
            steps.add(arr.clone());
        }
    }

    // ✅ Quick Sort
    public List<int[]> quickSort(int[] arr) {
        List<int[]> steps = new ArrayList<>();
        int[] a = arr.clone();
        steps.add(a.clone());
        quickSortHelper(a, 0, a.length - 1, steps);
        return steps;
    }

    private void quickSortHelper(int[] arr, int low, int high, List<int[]> steps) {
        if (low < high) {
            int pi = partition(arr, low, high, steps);
            quickSortHelper(arr, low, pi - 1, steps);
            quickSortHelper(arr, pi + 1, high, steps);
        }
    }

    private int partition(int[] arr, int low, int high, List<int[]> steps) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                steps.add(arr.clone());
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        steps.add(arr.clone());
        return i + 1;
    }
}
