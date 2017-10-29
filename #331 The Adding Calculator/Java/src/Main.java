import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int i;
        String temp = "";

        //first number
        for (i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                break;
            } else {
                temp += input.charAt(i);
            }
        }

        int fn = Integer.parseInt(temp);
        temp = "";
        i++;

        //operation
        for (; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                break;
            } else {
                temp = temp + input.charAt(i);
            }
        }

        String operation = temp;
        temp = "";
        i++;

        //second number
        for (; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                break;
            } else {
                temp = temp + input.charAt(i);
            }
        }

        int sn = Integer.parseInt(temp);

        switch (operation) {
            case "+":
                System.out.println(add(fn, sn));
                break;

            case "*":
                System.out.println(multiply(fn, sn));
                break;

            case "/":

                try {
                    System.out.println(divide(fn, sn));
                } catch (RuntimeException re) {
                    System.out.println(re.getMessage());
                }

                break;

            case "-":
                System.out.println(minus(fn, sn));
                break;

            case "^":
                System.out.println();
                break;

            default:
                throw new RuntimeException("Unsupported Operation");
        }
    }

    private static int expo(int f, int s){



        return 0;
    }

    private static int divide(int f, int s) {
        if (f == 0 && s == 0) {
            throw new RuntimeException("Not-defined");
        } else if (s == 0) {
            return 0;
        } else if (f < 0 && s < 0) {
            f = Math.abs(f);
            s = Math.abs(s);

            return mainDivide(f, s);

        } else if (f < 0 || s < 0) {
            f = Math.abs(f);
            s = Math.abs(s);

            return -mainDivide(f, s);

        } else {
            return mainDivide(f, s);

        }
    }

    private static int mainDivide(int f, int s) {
        int number = 0;
        int i = 0;

        while (number < f) {
            number += s;
            i++;
            if (number + s > f && number != f) {
                throw new RuntimeException("Non-integral answer");
            }
        }
        return i;
    }

    private static int add(int first, int second) {
        return first + second;
    }

    private static int multiply(int first, int second) {

        if (first < 0 && second < 0) {
            //if both negative
            first = Math.abs(first);
            second = Math.abs(second);
            return mainMultiply(first, second);

        } else if (first > 0 && second > 0) {
            //if both are positive
            return mainMultiply(first, second);

        } else if (first < 0 || second < 0) {
            //if one is negative
            first = Math.abs(first);
            second = Math.abs(second);
            int nr = mainMultiply(first, second);
            nr = -nr;
            return nr;
        }
        return 0;
    }

    private static int mainMultiply(int f, int s) {
        int nr = f;
        for (int i = 0; i < s - 1; i++) {
            nr += f;
        }
        return nr;
    }

    private static int minus(int f, int s) {
        if (f > 0 && s > 0) {
            return mainMinus(f, s);

        } else if (s < 0 && f > 0) {
            return f + Math.abs(s);

        } else if (f < 0 && s > 0) {
            int rn = s + Math.abs(f);
            rn = multiply(rn, -1);
            return rn;

        } else if (f < 0 && s < 0) {
            return f+Math.abs(s);
        }

        throw new RuntimeException("minus error " + " f = " + f + " s = " + s);
    }

    private static int mainMinus(int f, int s) {
        for (int i = 0; i < f; i++) {
            if (i + s == f) {
                return i;
            }
        }
        throw new RuntimeException("mainMinus Error");
    }
}