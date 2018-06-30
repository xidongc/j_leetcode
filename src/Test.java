public class Test {
    public static void main(String[] a){
        System.out.println("Start Program...");
        ArraySolution arr = new ArraySolution();
        int[] nums = new int[]{1,2,3,4,5,7,8,9,10};
        int target = 6;
        System.out.println(arr.searchInsert(nums, target));
    }
}
