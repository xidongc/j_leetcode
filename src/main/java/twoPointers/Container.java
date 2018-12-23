package twoPointers;

public class Container {
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int max_area = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right) {
            int width = right - left;
            int len = Math.min(height[right], height[left]);
            max_area = Math.max(max_area, len * width);
            if (height[right] >= height[left]) {
                left ++;
            } else {
                right --;
            }
        }
        return max_area;
    }
}
