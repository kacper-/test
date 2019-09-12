package comt.matrix;

public class Matrix {
    public static void main(String[] args) {
        int[][] a = new int[][]{{4, 6, 1, 9}, {3, 2, 8, 7}, {5, 2, 9, 0}};
        int[][] b = rotate(a, 5);
        for (int i[] : a) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
        System.out.println();
        for (int i[] : b) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    static int[][] rotate(int[][] a, int i) {
        int m = i % 2 == 0 ? a.length : a[0].length;
        int n = i % 2 == 0 ? a[0].length : a.length;
        int[][] b = new int[m][n];
        map(a, i, b);
        return b;
    }

    static void map(int[][] a, int r, int[][] b) {
        int m = a.length;
        int n = a[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                switch (r % 4) {
                    case 0:
                        b[i][j] = a[i][j];
                        break;
                    case 1:
                        b[n - j - 1][i] = a[i][j];
                        break;
                    case 2:
                        b[m - i - 1][n - j - 1] = a[i][j];
                        break;
                    case 3:
                        b[j][m - i - 1] = a[i][j];
                        break;
                }
            }
        }
    }

}
