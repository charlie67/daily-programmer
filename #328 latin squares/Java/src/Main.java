//https://www.reddit.com/r/dailyprogrammer/comments/6v29zk/170821_challenge_328_easy_latin_squares/

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter array size");
        int arraySize = Integer.parseInt(in.nextLine());

        int[][] square = new int[arraySize][arraySize];
        System.out.println("Enter numbers");
        String[] vals = in.nextLine().split(" ");

        for (int c = 0; c < arraySize; c++) {
            for (int r = 0; r < arraySize; r++) {
                square[c][r] = Integer.parseInt(vals[(c * arraySize) + r]);
            }
        }

        int mainCounter = 0;
        int counter = 0;

        for (int i = 0; i < arraySize; i++) {
            int[] test = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                test[j] = square[i][j];
            }

            //if n is 2; 1 and 2 have to be in each row and column of the array
            int[] compare = new int[arraySize];
            for (int k = 0; k < arraySize; k++) {
                compare[k] = k + 1;
            }

            for (int j = 0; j < arraySize; j++) {
                if (test[j] - 1 < compare.length) {
                    if (compare[test[j] - 1] == test[j]) {
                        counter++;
                    }
                }

            }

            if (counter == arraySize) {
                mainCounter++;
            }
            counter = 0;
        }

        if (mainCounter == arraySize) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
