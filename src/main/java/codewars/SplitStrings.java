package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitStrings {

    public static void main(String[] args) {

        String str ="abcde";

        System.out.println(Arrays.toString(solution(str)));

    }

    public static String[] solution(String s) {


        int length ;
        boolean unit = isMultiply(s);



        if ( unit == true) {

            length = s.length()/2;
        } else {
            s = s+"_";
            length = s.length()/2;
        }
        String[] arr = new String[length];


        int i = 0;
        int k = 0;
        int z = 2;
        while (i < length) {
            arr[i] = s.substring(k, z);
            k= k+2;
            z= z+2;
            i++;
        }

        return arr;
    }

    public static boolean isMultiply(String s) {
        return s.length() % 2 ==0;
    }

    public static String[] solutionWithList(String s) {
        List<String> list = new ArrayList<String>();
        s = s.length() % 2 == 0 ? s : s+"_";

        for (int i = 0, l =2; i < s.length(); i = i+2) {
            list.add(String.valueOf(s.substring(i,l)));
             l = l+2;
        }

        return list.toArray(new String[0]);

    }

}
