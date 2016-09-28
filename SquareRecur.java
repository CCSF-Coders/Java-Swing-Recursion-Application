/**
 * Created by Calvin Lee on 9/21/2016.
 */
public class SquareRecur {
    public static void main(String[] args) {

    }

    private static void cordIteration(int iterations, int set){
        int squareSetNum = (iterations - set + 1);
        if(set == iterations){
            System.out.println("Square " + squareSetNum + "!\n");
        }
        System.out.println("Drawing square...");
        if(set > 0)
        {
            System.out.println("Drew a Square " + (squareSetNum + 1)+ " on  TLC of " + "square " + (squareSetNum));
            cordIteration(iterations, set - 1);
        }
        if(set > 0){
            System.out.println("Drew a Square " + (squareSetNum + 1) + " on  TRC of " + "square " + (squareSetNum));
            cordIteration(iterations, set - 1);
        }
        if(set > 0) {
            System.out.println("Drew a Square " + (squareSetNum + 1)+ " on  BLC of " + "square " + (squareSetNum));
            cordIteration(iterations, set - 1);
        }
        if(set > 0){
            System.out.println("Drew a Square " + (squareSetNum + 1) + " on  BRC of " + "square " + (squareSetNum));
            cordIteration(iterations, set - 1);
        }
    }
}
