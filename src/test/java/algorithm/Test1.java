package algorithm;

import org.junit.Test;

public class Test1 {


    public int[][] getArr() {
        int[][] num = new int[10][6];
        int count = 1;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = count++;
            }
        }
        return num;
    }


    @Test
    public void testArr() {
        int[][] num = getArr();

        //output
        String[] str = new String[num[0].length];

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                if (i == 0) {
                    str[j] = num[i][j] + "";
                } else {
                    str[j] += " " + num[i][j];
                }
//                System.out.println(num[i][j]);
            }
        }
        System.out.println("=======矩阵=======");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        System.out.println("=======矩阵=======");

        System.out.println("=======start========");
        output(num, 0, num[0].length - 1);
        System.out.println("=======start========");
    }

    public void output(int[][] num, int start, int end) {
        if(start > end || end < 0) return;

        for (int i = start; i <= end; i++) {
            System.out.print(" "+num[i][start]);
        }

        for (int i = start + 1; i <= end; i++) {
            System.out.print(" "+num[end][i]);
        }

        for (int i = end - 1; i >= start; i--) {
            System.out.print(" "+num[i][end]);
        }

        for (int i = end - 1; i > start; i--) {
            System.out.print(" "+num[start][i]);
        }
        output(num, start + 1, end - 1);
    }





}
