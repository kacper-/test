package comt.reference;

public class Reference {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("aaddd");
        System.out.println(a);
        change(a);
        System.out.println(a);
    }

    private static void change(StringBuffer a) {
        a = new StringBuffer("bbb");
        System.out.println(a);
    }

}


