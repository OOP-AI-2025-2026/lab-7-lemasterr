package ua.opnu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TwoPredicateFilter {

    // Метод фільтрації за двома умовами (два предикати)
    public static <T> T[] filter(
            T[] input,
            Predicate<T> p1,
            Predicate<T> p2,
            java.util.function.IntFunction<T[]> arrayFactory
    ) {
        List<T> result = new ArrayList<>();
        for (T el : input) {
            if (p1.test(el) && p2.test(el)) {
                result.add(el);
            }
        }
        return result.toArray(arrayFactory.apply(result.size()));
    }

    public static void main(String[] args) {
        Student[] group = {
                new Student("Антонович Микита", "AI-243", new int[]{95, 88, 76}),
                new Student("Іваненко Олена", "AI-243", new int[]{100, 100, 99}),
                new Student("Петров Сергій", "AI-142", new int[]{60, 40, 70}),
                new Student("Сидоренко Андрій", "AI-243", new int[]{59, 59, 59})
        };

        // Умова 1: студент з групи AI-243
        Predicate<Student> from243 = s -> "AI-243".equals(s.getGroup());

        // Умова 2: студент БЕЗ заборгованостей
        Predicate<Student> noDebt = s -> !s.hasDebt();

        Student[] filtered = filter(group, from243, noDebt, Student[]::new);

        System.out.println("Студенти з групи AI-243 без заборгованостей:");
        Arrays.stream(filtered).forEach(System.out::println);
    }
}
