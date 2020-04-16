package comt.sudoku;

public class Solver {

    void print(int[] m) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(" " + m[i * 9 + j]);
            System.out.println();
        }
        System.out.println();
    }

    int bad_numbers(int[] s) {
        int[] t = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 9; i++) {
            if (s[i] > 0 && t[s[i]] > 0)
                return 1;
            t[s[i]] = 1;
        }
        return 0;
    }

    int bad_row(int[] m, int row) {
        int[] t = new int[9];
        for (int i = 0; i < 9; i++)
            t[i] = m[9 * row + i];
        return bad_numbers(t);
    }

    int bad_col(int[] m, int col) {
        int[] t = new int[9];
        for (int i = 0; i < 9; i++)
            t[i] = m[9 * i + col];
        return bad_numbers(t);
    }

    int bad_sqr(int[] m, int sqr) {
        int[] t = new int[9];
        int x = (sqr % 3) * 3;
        int y = (sqr / 3) * 3;
        for (int i = 0; i < 3; i++) {
            t[3 * i] = m[9 * (y + i) + x];
            t[3 * i + 1] = m[9 * (y + i) + x + 1];
            t[3 * i + 2] = m[9 * (y + i) + x + 2];
        }
        return bad_numbers(t);
    }

    int is_bad(int[] m) {
        int sum = 0;
        for (int i = 0; i < 9; i++)
            sum += bad_row(m, i) + bad_col(m, i) + bad_sqr(m, i);
        return sum;
    }

    void solve(int[] m, int i) {
        if (is_bad(m) > 0)
            return;
        if (i == 81) {
            print(m);
            return;
        }
        if (m[i] == 0) {
            for (int j = 1; j < 10; j++) {
                m[i] = j;
                solve(m, i + 1);
            }
            m[i] = 0;
        } else {
            solve(m, i + 1);
        }
    }
}
