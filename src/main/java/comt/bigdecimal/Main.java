package comt.bigdecimal;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("0.1");
        double f1 = 0.1f;
        System.out.println(bigDecimal.add(bigDecimal).add(bigDecimal));
        System.out.println(f1 + f1 + f1);
    }
}
