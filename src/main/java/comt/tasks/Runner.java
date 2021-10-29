package comt.tasks;

public class Runner implements Runnable{
    private int val;
    @Override
    public void run() {
        val = 2;
        System.out.println(val);
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
