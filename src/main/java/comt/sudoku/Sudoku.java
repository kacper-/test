package comt.sudoku;

public class Sudoku {
    public static void main(String[] args) {
        int[] m = new int[]{
                3, 0, 0, 0, 0, 0, 0, 2, 0,
                0, 8, 0, 4, 3, 2, 0, 1, 0,
                0, 5, 0, 0, 0, 0, 6, 0, 0,
                0, 7, 4, 8, 6, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 8,
                0, 3, 0, 1, 0, 0, 7, 0, 0,
                0, 0, 0, 2, 9, 6, 8, 7, 1,
                6, 0, 0, 0, 0, 0, 3, 4, 0,
                1, 9, 0, 7, 0, 0, 0, 0, 6
        };
        new Solver().solve(m, 0);
    }
}
