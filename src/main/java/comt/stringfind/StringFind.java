package comt.stringfind;

public class StringFind {
    public static void main(String[] args) {
        String a = "aaddd";
        int[] r = find(a);
        for (int i : r) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int[] find(String s) {
        if (s == null || s.isEmpty())
            return new int[]{-1, 0};
        int p = 0;
        int l = -1;
        int t = 0;
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                t++;
            } else {
                t = 1;
                c = s.charAt(i);
            }
            if (t > l) {
                l = t;
                p = i - t + 1;
            }
        }
        return new int[]{p, l};
    }
}


