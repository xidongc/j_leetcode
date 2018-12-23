package bisect;

public class Version implements VersionControl {
    private int version = 10;

    Version(int version){
        this.version = version;
    }

    public boolean isBadVersion(int version) {
        if(version > this.version){
            return true;
        } else{
            return false;
        }
    }

    public int firstBadVersion(int n) {
        int start=0;
        int end = n;
        int mid;
        while(start <= end) {
            mid = (start+end)/2;
            if(isBadVersion(mid) && !isBadVersion(mid-1)){
                System.out.println(mid-1);
                return mid-1;
            } else if (!isBadVersion(mid)){
                start = mid+1;
            } else{
                end = mid - 1;
            }
        }
        return n;
    }
}
