package comt.pi;

public class Pi {
    public static void main(String[] args) {
        int inside = 0;
        int count = 100000;
        double x,y;
        for(int i=0;i<count;i++) {
            x = Math.random();
            y = Math.random();
            if(x*x + y*y < 1.0)
                inside++;
        }
        double pi = 4.0 * (((double) inside )/ ((double) count));
        System.out.println(String.format("pi = %f", pi));
    }
}
