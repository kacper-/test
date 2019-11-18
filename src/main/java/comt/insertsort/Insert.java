package comt.insertsort;

public class Insert {
    public static void main(String[] args) {
        int[] a = new int[]{4, 6, 1, 9, 3, 2, 8, 7, 5};
        insert(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    static void insert(int[] a) {
        for (int j = 1; j < a.length; j++) {
            if (a[j] < a[j - 1]) {
                move(a, j);
            }
        }
    }

    private static void move(int[] a, int j) {
        for (int i = j; i > 0; i--) {
            if (a[i] < a[i - 1])
                swap(a, i);
        }
    }

    static void swap(int[] a, int i) {
        int tmp = a[i];
        a[i] = a[i - 1];
        a[i - 1] = tmp;
    }
}
