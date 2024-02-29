package comt.equal_elements;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,15,7,4,9,10,11,12,13,14};

        if(test(arr,5))
            System.out.println("ok");
        else
            System.out.println("not ok");
    }

    private static boolean test(int[] arr, int range) {
        for(int i=0;i< arr.length-range;i++) {
            if(hasDuplicates(arr, i, i+range+1))
                return true;
        }
        return false;
    }

    private static boolean hasDuplicates(int[] arr, int start, int end) {
        for(int i=start;i<end-1;i++) {
            for(int j=i+1;j<end;j++) {
                if(arr[i]==arr[j])
                    return true;
            }
        }
        return false;
    }

}
