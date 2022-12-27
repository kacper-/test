package comt.sudoku;

public class Sudoku {
    public static void main(String[] args) {
        int[] m = new int[]{
                7, 0, 1, 0, 0, 0, 0, 9, 0,
                0, 5, 0, 0, 0, 2, 7, 0, 8,
                2, 0, 0, 0, 9, 0, 0, 4, 0,
                0, 0, 0, 0, 0, 8, 0, 3, 0,
                0, 0, 4, 0, 0, 0, 5, 0, 0,
                0, 1, 0, 6, 0, 0, 0, 0, 0,
                0, 8, 0, 0, 4, 0, 0, 0, 1,
                6, 0, 7, 3, 0, 0, 0, 8, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 3
        };
        new Solver().solve(m, 0);
    }
}
