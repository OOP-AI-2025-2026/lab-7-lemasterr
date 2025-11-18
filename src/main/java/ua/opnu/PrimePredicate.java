package ua.opnu;

import java.util.function.Predicate;

public class PrimePredicate {

    // Предикат, який повертає true, якщо число є простим
    private static final Predicate<Integer> isPrime = n -> {
        if (n == null || n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    };

    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, 3, 4, 5, 16, 17, 19, 21, 97, 100};

        for (int n : numbers) {
            System.out.println("Число " + n + " просте? -> " + isPrime.test(n));
        }
    }
}
