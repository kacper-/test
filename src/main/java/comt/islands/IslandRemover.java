package comt.islands;

public class IslandRemover {
    private final int[] m;
    private final int[] result;
    private final int s;

    public IslandRemover(int[] m) {
        this.m = m;
        s = (int) Math.sqrt(m.length);
        result = new int[m.length];
    }

    public int[] remove() {
        copyZeros();
        startFromRing();
        markZeros();
        return result;
    }

    private void markZeros() {
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                int index = i * s + j;
                if (result[index] == -1)
                    result[index] = 0;
            }
        }
    }

    private void mark(int index) {
        if (index < 0 || index >= m.length)
            return;
        if (m[index] == 1 && result[index] == -1) {
            result[index] = 1;
            mark(index - s);
            mark(index + s);
            mark(index - 1);
            mark(index + 1);
        }
    }

    private void startFromRing() {
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                if (i == 0 || i == s - 1 || j == 0 || j == s - 1)
                    mark(i * s + j);
            }
        }
    }

    private void copyZeros() {
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                int index = i * s + j;
                if (m[index] == 0)
                    result[index] = 0;
                else
                    result[index] = -1;
            }
        }
    }
}
