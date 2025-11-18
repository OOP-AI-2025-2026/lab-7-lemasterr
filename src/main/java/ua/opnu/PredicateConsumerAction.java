package ua.opnu;

import java.util.function.Predicate;

public class PredicateConsumerAction {

    // Метод, який приймає Predicate та Consumer.
    // Дія виконується тільки тоді, якщо Predicate повертає true.
    public static void processIf(
            int[] input,
            Predicate<Integer> condition,
            java.util.function.Consumer<Integer> action
    ) {
        for (int value : input) {
            if (condition.test(value)) {
                action.accept(value);
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {-5, -2, -1, 0, 1, 2, 3, 4, 10};

        // Лямбда 1: число додатне
        Predicate<Integer> isPositive = n -> n > 0;

        // Лямбда 2: вивести число
        java.util.function.Consumer<Integer> print =
                n -> System.out.println("Підходить: " + n);

        System.out.println("Додатні числа:");
        processIf(numbers, isPositive, print);

        // Ще один приклад: парні числа
        Predicate<Integer> isEven = n -> n % 2 == 0;
        java.util.function.Consumer<Integer> printEven =
                n -> System.out.println("Парне: " + n);

        System.out.println("\nПарні числа:");
        processIf(numbers, isEven, printEven);
    }
}
