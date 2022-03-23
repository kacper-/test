package comt.islands;

public class Islands {
    public static void main(String[] args) {
        int[] m = new int[]{
                1,0,0,0,0,
                1,1,1,1,0,
                1,0,0,1,0,
                1,0,1,0,0,
                1,0,0,0,0
        };

        print(m);
        System.out.print("\n");
        print(new IslandRemover(m).remove());
    }

    private static void print(int[] m) {
        int s = (int)Math.sqrt(m.length);
        for(int i=0;i<s;i++) {
            for(int j=0;j<s;j++) {
                System.out.print(" "+m[i*s+j]);
            }
            System.out.print("\n");
        }
    }
}
