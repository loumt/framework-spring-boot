package algorithm;

import org.junit.Test;

/**
 * 输出一个字符串的所有排列
 */
public class Test3 {

    @Test
    public void test3(){
        String str = "abcfa";
        char[] ch = getCharArr(str);
        System.out.println(ch);
        swapMain(ch,0);
    }

    public char[] getCharArr(String s){
        char[] c = s.toCharArray();
        return c;
    }

    public void swap(char[] ch,int index,int end){
        char temp = ch[index];
        ch[index] = ch[end];
        ch[end] = temp;
    }

    public void swapMain(char[] ch, int index){
        if(index == ch.length) return;

        for(int i = index;i< ch.length - 1 ;i++){
            char[] chTemp = ch.clone();
            if(chTemp[index]==chTemp[i+1]){
                System.out.println("Repeat...");
            }else{
                swap(chTemp,index,i + 1);
                System.out.println(chTemp);
            }

        }
        swapMain(ch, index + 1);
    }


}
