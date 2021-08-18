package codewars;

public class SquareOfSquares {

    public static void main(String[] args) {

        System.out.println(isSquare(25));

    }

    public static boolean isSquare(int number) {
        return Math.sqrt(number) % 1 == 0;
    }

}