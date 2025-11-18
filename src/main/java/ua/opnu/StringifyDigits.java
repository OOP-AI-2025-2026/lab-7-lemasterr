package ua.opnu;

import java.util.Arrays;
import java.util.function.Function;

public class StringifyDigits {

    // Function: число 0..9 -> слово українською
    private static final Function<Integer, String> digitToWord = n -> {
        switch (n) {
            case 0: return "нуль";
            case 1: return "один";
            case 2: return "два";
            case 3: return "три";
            case 4: return "чотири";
            case 5: return "п'ять";
            case 6: return "шість";
            case 7: return "сім";
            case 8: return "вісім";
            case 9: return "дев'ять";
            default:
                throw new IllegalArgumentException("Число має бути в діапазоні 0..9, отримано: " + n);
        }
    };

    // stringify(): масив int -> масив String
    public static String[] stringify(int[] digits, Function<Integer, String> func) {
        String[] result = new String[digits.length];
        for (int i = 0; i < digits.length; i++) {
            result[i] = func.apply(digits[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] digits = {0,1,2,3,4,5,6,7,8,9};

        String[] words = stringify(digits, digitToWord);

        System.out.println("Цифри: " + Arrays.toString(digits));
        System.out.println("Слова: " + Arrays.toString(words));
    }
}
