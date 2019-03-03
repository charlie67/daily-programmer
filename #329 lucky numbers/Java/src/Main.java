import java.util.Scanner;

public class Main {
    private static int arraySize;
    private static int numbers[];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        arraySize = Integer.parseInt(input);
        int inputNumber = arraySize;
        arraySize += 50;
        numbers = new int[arraySize];

        //initialise the array

        for (int i = 0; i < arraySize; i++) {
            numbers[i] = i + 1;
        }

        int ntc, pntc;
        ntc = numbers[1];//first number to cancel is 2 or value 1 in the array
        pntc = ntc;

        cancelFirst(numbers);

        for (int i = 0; i < arraySize; i++) {
            ntc = nextNonZero(pntc, numbers);
            if (ntc > arraySize / 2) {
                break;
            }
            cancelNth(ntc, numbers);
            pntc = ntc;
        }

        if (checkNumber(inputNumber, numbers)) {
            System.out.println(inputNumber + " is a lucky number");
            System.exit(0);
        }

        System.out.println(numberBefore(inputNumber, numbers) + " < " + inputNumber + " < " + numberAfter(inputNumber, numbers));
        System.exit(0);
    }

    private static int numberBefore(int number, int a[]){
        int pon = number-1;
        for (int i=pon;i>-1;i--){
            if (a[i] !=0){
                return a[i];
            }
        }
        return 0;
    }

    private static int numberAfter(int number, int a[]){
        int pon = number-1;
        for (int i=pon;i<arraySize;i++){
            if(a[i] != 0){
                return a[i];
            }
        }
        return 0;
    }

    private static boolean checkNumber(int number, int a[]) {
        for (int i = 0; i < arraySize; i++) {
            if (a[i] == number) {
                return true;
            }
        }
        return false;
    }

    private static void cancelNth(int n, int number[]) {
        int count = 0;

        //need to count to nth number NOT nth value in the array
        //e.g. n=3 need to go to 3rd number in the array that is not 0
        for (int i = 0; i < arraySize; i++) {
            if (number[i] != 0) {
                count++;
            }
            if (count == n) {
                number[i] = 0;
                count = 0;
            }
        }

    }

    private static void cancelFirst(int number[]) {
        for (int i = 0; i < arraySize-1; i += 2) {
            number[i + 1] = 0;
        }
    }

    private static int nextNonZero(int prev, int numbers[]) {
        for (int i = prev; i < arraySize; i++) {
            if (numbers[i] != 0) {
                return numbers[i];
            }
        }
        return 0;
    }
}