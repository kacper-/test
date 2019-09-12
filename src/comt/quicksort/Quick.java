package comt.quicksort;

public class Quick {
    public static void main(String[] args) {
        int[] a = new int[]{4, 6, 1, 9, 3, 2, 8, 7, 5};
        quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }

    static void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int p = partition(a, lo, hi);
            quickSort(a, lo, p - 1);
            quickSort(a, p + 1, hi);
        }
    }

    static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int p = a[hi];
        for (int j = lo; j < hi; j++) {
            if (a[j] < p) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, hi);
        return i;
    }

    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
