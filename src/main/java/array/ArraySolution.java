package array;

import java.util.ArrayList;

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

    public int arrayNesting(int[] nums) {
        ArrayList<Integer> ret = new ArrayList<>();
        ArrayList<Integer> loop = new ArrayList<>();
        int max_len = 0;
        // default value is false
        boolean[] bitmap = new boolean[nums.length];
        for (int i=0; i<nums.length; i++){
            loop.clear();
            int tmp = i;
            while (tmp < nums.length && tmp >=0 && !bitmap[tmp]){
                bitmap[tmp] = true;
                loop.add(nums[tmp]);
                tmp = nums[tmp];
            }
            if(loop.size() > max_len){
                ret = (ArrayList<Integer>) loop.clone();
                max_len = loop.size();
            }
        }
        System.out.println(ret);
        return max_len;
    }

    public int findPeakElement(int[] nums) {
        int start = 0;
        int len = nums.length;
        int end = len-1;
        int mid;
        while (start <= end){
            mid = (start+end)/2;
            if(mid > 0 && nums[mid-1] >= nums[mid]){
                end = mid-1;
            } else if(mid < len-1 && nums[mid+1] >= nums[mid]){
                start = mid+1;
            } else{
                System.out.println(mid);
                return mid;
            }
        }
        return -1;
    }

}
