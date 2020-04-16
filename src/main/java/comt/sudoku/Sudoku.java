package comt.sudoku;

public class Sudoku {
    public static void main(String[] args) {
        int[][] s = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5, 5, 5, 5, 5},
                {6, 6, 6, 6, 6, 6, 6, 6, 6},
                {7, 7, 7, 7, 7, 7, 7, 7, 7},
                {8, 8, 8, 8, 8, 8, 8, 8, 8},
                {9, 9, 9, 9, 9, 9, 9, 9, 9}
        };

        Solver solver = new Solver(s);
        solver.print();
    }
}
