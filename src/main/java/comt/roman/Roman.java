package comt.roman;

import java.util.ArrayList;
import java.util.List;

public enum Roman {
    M(1000),
    D(500),
    C(100),
    L(50),
    X(10),
    V(5),
    I(1);

    private final int val;

    Roman(int val) {
        this.val = val;
    }

    public static Roman[] from(int v) {
        int num = Math.min(3999, v);
        int i;
        List<Roman> r = new ArrayList<>();
        for (int k = 0; k < values().length; k = k + 2) {
            i = num / values()[k].val;
            if (i > 3) {
                if (i == 9) {
                    r.add(values()[k]);
                    r.add(values()[k - 2]);
                } else {
                    if (i == 4)
                        r.add(values()[k]);
                    r.add(values()[k - 1]);
                    for (int j = 5; j < i; j++)
                        r.add(values()[k]);
                }
            } else {
                for (int j = 0; j < i; j++)
                    r.add(values()[k]);
            }
            num -= i * values()[k].val;
        }
        return r.toArray(new Roman[]{});
    }

    public static int to(Roman[] r) {
        int acc = 0;
        int next;
        for (int i = 0; i < r.length; i++) {
            next = i + 1 == r.length ? 0 : r[i + 1].val;
            if (r[i].val < next)
                acc -= r[i].val;
            else
                acc += r[i].val;
        }
        return acc;
    }
}
