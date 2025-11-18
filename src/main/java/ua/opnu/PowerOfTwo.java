package ua.opnu;

import java.util.Arrays;
import java.util.function.Function;

public class PowerOfTwo {

    // Function: приймає n, повертає 2^n
    private static final Function<Integer, Integer> pow2 = n -> {
        if (n < 0) throw new IllegalArgumentException("n має бути >= 0");
        return 1 << n; // 1 << n == 2^n
    };

    // Метод для обробки масиву через Function
    public static int[] processArray(int[] input, Function<Integer, Integer> func) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = func.apply(input[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ns = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] powers = processArray(ns, pow2);

        System.out.println("n:   " + Arrays.toString(ns));
        System.out.println("2^n: " + Arrays.toString(powers));
    }
}
