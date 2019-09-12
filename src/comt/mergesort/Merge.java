package comt.mergesort;

public class Merge {
    public static void main(String[] args) {
        int[] a = new int[]{4, 6, 1, 9, 3, 2, 8, 7, 5};
        int[] b = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        mergeSort(a, b, a.length);
        for (int i : a) {
            System.out.println(i);
        }
    }

    static void mergeSort(int[] a, int[] b, int end) {
        copy(a, 0, end, b);
        split(b, 0, end, a);
    }

    static void split(int[] b, int begin, int end, int[] a) {
        if (end - begin < 2)
            return;
        int middle = (end + begin) / 2;
        split(a, begin, middle, b);
        split(a, middle, end, b);
        merge(b, begin, middle, end, a);
    }

    static void merge(int[] a, int begin, int middle, int end, int[] b) {
        int i = begin;
        int j = middle;
        for (int k = begin; k < end; k++) {
            if (i < middle && (j >= end || a[i] <= a[j])) {
                b[k] = a[i];
                i = i + 1;
            } else {
                b[k] = a[j];
                j = j + 1;
            }
        }
    }

    static void copy(int[] a, int begin, int end, int[] b) {
        for (int i = begin; i < end; i++) {
            b[i] = a[i];
        }
    }

}
