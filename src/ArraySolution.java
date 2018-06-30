public class ArraySolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        } else {
            int cols = matrix[0].length;
            if(cols == 0){
                return false;
            }
            int r = 0;
            int c = cols-1;
            while(r < rows && c >= 0){
                if(target > matrix[r][c]){
                    r += 1;
                } else if(target < matrix[r][c]){
                    c -= 1;
                } else{
                    return true;
                }
            }
            return false;
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int low_end = -1;
        int high_end = -1;
        int mid;
        while(start <= end){
            mid = start + (start-end)/2;
            if(nums[mid] > target){
                end = mid-1;
            } else if(nums[mid] < target){
                start = mid + 1;
            } else {
                low_end = mid;
                for (int i = mid - 1; i >= 0; i--) {
                    if(nums[i] != target) {
                        break;
                    } else{
                        low_end = i;
                    }
                }
                break;
            }
        }
        if(low_end == -1) {
            return ret;
        } else{
            start = 0;
            end = n-1;
            while(start <= end){
                mid = (start + end)/2;
                if(nums[mid] > target){
                    end = mid-1;
                } else if(nums[mid] < target){
                    start = mid+1;
                } else{
                    high_end = mid;
                    for(int i=mid+1; i<n;i++){
                        if(nums[i] == target){
                            high_end = i;
                        } else{
                            break;
                        }
                    }
                    break;
                }
            }
        }
        ret = new int[]{low_end, high_end};

        return ret;
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end){
            mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return start;
    }
}
