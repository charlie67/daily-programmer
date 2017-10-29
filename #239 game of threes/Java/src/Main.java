import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int input = in.nextInt();
        in.nextLine();

        while (input != 1) {
            if (input % 3 == 0) {
                System.out.println(input + " 0");
                input = input / 3;

            } else if ((input + 1) % 3 == 0) {
                System.out.println(input + " 1");
                input += 1;
                input = input / 3;

            } else if ((input - 1) % 3 == 0) {
                System.out.println(input + " -1");
                input -= 1;
                input = input / 3;

            }
        }

        System.out.println(input);
        System.exit(1);
    }
}
