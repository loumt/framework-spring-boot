package algorithm;

import org.junit.Test;

public class Test2 {

    @Test
    public void findSum() {

        int[] arr = {11, 2, 3, 4, 5, 6, 100, 3, 4, 5, 6, 1, 6, 4, 3};
        int sum = 111;

        for (int i = 0; i < arr.length; i++) {
            int sum2 = 0;
            int index = i ;

            while (sum2 < sum) {
                sum2 += arr[index ++];
            }

//            System.out.println(index + " : " + sum2);

            if(sum2 == sum){
                System.out.println("Found i: " + i );
                break;
            }else{
                System.out.println("Index :  " +i + " Not Found");
            }
        }

    }

}
