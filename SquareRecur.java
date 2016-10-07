/**
 * Created by Calvin Lee on 9/21/2016.
 * A main class for making one square on the corner of each square recursively.
 *
 * @author Karl Nicholas
 * @author Calvin Lee
 * @author Yu-Hsiang Huang
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
        if(set > 0)//Top left corner recursive
        {
            System.out.println("Drew a Square " + (squareSetNum + 1)+ " on  TLC of " + "square " + (squareSetNum));
            cordIteration(iterations, set - 1);
        }
        if(set > 0){//Top right corner recursive
            System.out.println("Drew a Square " + (squareSetNum + 1) + " on  TRC of " + "square " + (squareSetNum));
            cordIteration(iterations, set - 1);
        }
        if(set > 0) {//Bottom left corner recursive
            System.out.println("Drew a Square " + (squareSetNum + 1)+ " on  BLC of " + "square " + (squareSetNum));
            cordIteration(iterations, set - 1);
        }
        if(set > 0){//Bottom right corner recursive
            System.out.println("Drew a Square " + (squareSetNum + 1) + " on  BRC of " + "square " + (squareSetNum));
            cordIteration(iterations, set - 1);
        }
    }
}
