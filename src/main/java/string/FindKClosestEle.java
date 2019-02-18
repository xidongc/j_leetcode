package string;

import java.util.*;
import java.util.stream.Collectors;

class Ele implements Comparable<Ele> {
     int x;
     int dis;

     Ele(int x, int dis) {
         this.x = x;
         this.dis = dis;
     }

     int getX() {
         return this.x;
     }

    @Override
    public int compareTo(Ele o) {
        if (this.dis != o.dis) {
            return Integer.compare(this.dis, o.dis);
        } else {
            return Integer.compare(this.x, o.x);
        }
    }
}

public class FindKClosestEle {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> test = new ArrayList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        Collections.sort(test, (a,b)-> Math.abs(a-x) - Math.abs(b-x));
        test = new ArrayList<>(test.subList(0, k));
        Collections.sort(test);
        return test;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Ele> arrayList = new ArrayList<>();
        for (int a : arr) {
            arrayList.add(new Ele(a, Math.abs(a - x)));
        }
        Collections.sort(arrayList);
        return arrayList.subList(0, k).stream().map(y -> y.getX()).sorted().collect(Collectors.toList());
    }

}
