package comt.roman;

public class Main {
    public static void main(String[] args) {
        System.out.println(Roman.to(new Roman[]{Roman.X, Roman.L, Roman.V, Roman.I, Roman.I}));
        Roman[] r = Roman.from(47);
        for (Roman e : r)
            System.out.print(e.name());
        System.out.println();
    }

}
