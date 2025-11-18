package ua.opnu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StudentFilter {

    // Метод фільтрації масиву студентів
    public static Student[] filter(Student[] students, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (predicate.test(s)) {
                result.add(s);
            }
        }
        return result.toArray(new Student[0]);
    }

    public static void main(String[] args) {
        Student[] group = {
                new Student("Антонович Микита", "AI-243", new int[]{95, 88, 76}),
                new Student("Іваненко Олена", "AI-243", new int[]{100, 100, 99}),
                new Student("Петров Сергій", "AI-243", new int[]{60, 40, 70}),  // є борг
                new Student("Сидоренко Андрій", "AI-243", new int[]{59, 59, 59}) // тільки борги
        };

        // Предикат: студент має хоча б одну заборгованість (оцінка < 60)
        Predicate<Student> hasDebt = Student::hasDebt;

        Student[] debtors = filter(group, hasDebt);

        System.out.println("Усі студенти:");
        Arrays.stream(group).forEach(System.out::println);

        System.out.println("\nСтуденти з хоча б однією заборгованістю (оцінка < 60):");
        Arrays.stream(debtors).forEach(System.out::println);
    }
}
