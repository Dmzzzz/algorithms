package leetcode;

public class CommonPrefix {

    public static void main(String[] args) {

        String[] arraysOfStrings = {"fly", "flight", "flow"};

        System.out.println(commonPrefix(arraysOfStrings));

    }

    public static String commonPrefix(String[] arr) {
        String result = arr[0];
        for (int i = 1; i < arr.length ; i++) {
           while (result.indexOf(arr[i]) != 0 ) {
               result.substring(0, result.length()-1);
           }
        }
        return  result;
    }

}
