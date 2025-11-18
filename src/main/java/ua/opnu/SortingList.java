package ua.opnu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, -2, 10, 3, 0, -7, 8, 1));

        System.out.println("Початковий список: " + list);

        // 1. Сортування за зростанням
        list.sort((a, b) -> Integer.compare(a, b));
        System.out.println("Сортування ↑: " + list);

        // 2. Сортування за спаданням
        list.sort((a, b) -> Integer.compare(b, a));
        System.out.println("Сортування ↓: " + list);

        // 3. Сортування за модулем за зростанням
        list.sort(Comparator.comparingInt(Math::abs));
        System.out.println("Сортування за |x| ↑: " + list);

        // 4. Сортування за модулем за спаданням, при рівному модулі – за зростанням
        list.sort((a, b) -> {
            int cmp = Integer.compare(Math.abs(b), Math.abs(a)); // спочатку ↓ за |x|
            if (cmp != 0) return cmp;
            return Integer.compare(a, b); // якщо |a| == |b| – порівняти самі числа ↑
        });
        System.out.println("Сортування за |x| ↓: " + list);
    }
}
