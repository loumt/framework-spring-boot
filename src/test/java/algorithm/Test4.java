package algorithm;

import org.junit.Test;

import java.util.*;

public class Test4 {

    @Test
    public void test4() {
        int[] is = {12, 12, 532, 2};
        Set<Integer> iss = combine(is);
        System.out.println(iss);
        System.out.println(iss.toArray()[0]);
    }

    public int swap(int[] is, int index, int end) {
        int temp = is[index];
        is[index] = is[end];
        is[end] = temp;

        String s ="";
        for (int i=0;i< is.length;i++){
            s += is[i];
        }
        return Integer.parseInt(s);
    }

    public Set<Integer> combine(int[] is) {
        Set<Integer> rs = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int i= 0; i< is.length;i++){
            for(int j= i + 1;j< is.length; j++){
                int[] is2 = is;
                rs.add(swap(is2,i,j));
            }
        }
        return rs;
    }
}
