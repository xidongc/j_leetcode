public class Test {
    public static void main(String[] a){
        System.out.println("Start Program...");
        int[] arr = new int[]{5,7,7,8,8,10};
        int target = 7;
        ArraySolution as = new ArraySolution();
        as.searchRange(arr, target);
    }
}
