package comt.sudoku;

public class Solver {
    private int SIZE = 9;
    private int[][] sudoku;

    public Solver(int[][] sudoku) {
        this.sudoku = sudoku;
    }

    public void print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("  " + sudoku[i][j]);
            }
            System.out.println();
        }
    }
}
