package comt.bubblesort;

public class Bubble {
    public static void main(String[] args) {
        int[] a = new int[]{4, 6, 1, 9, 3, 2, 8, 7, 5};
        bubbleSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    static void bubbleSort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            for (int i = 1; i < a.length + 1 - j; i++) {
                if (a[i - 1] > a[i])
                    swap(a, i);
            }
        }
    }

    static void swap(int[] a, int i) {
        int tmp = a[i];
        a[i] = a[i - 1];
        a[i - 1] = tmp;
    }
}
