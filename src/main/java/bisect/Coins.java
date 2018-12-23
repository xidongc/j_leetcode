package bisect;

public class Coins {
    public int arrangeCoins(int n) {
        if (n < 0) {
            return 0;
        } else if (n <= 1) {
            return n;
        }
        long start = 1;
        long end = n;
        // bisect
        while (start < end - 1) {
            long mid = start + (end - start)/2;
            long cmp = (mid*(mid+1))/2;
            if (cmp > n) {
                end = mid;
            } else if (cmp < n) {
                start = mid;
            } else {
                return (int)mid;
            }
        }
        return (int)start;
    }
}
