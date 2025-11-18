package ua.opnu;

// Власний інтерфейс Consumer для Student
interface Consumer {
    void accept(Student s);
}

public class StudentConsumer {

    // Функція forEach для масиву Student
    public static void forEach(Student[] students, Consumer action) {
        for (Student s : students) {
            action.accept(s);
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Антонович Микита", "AI-243", new int[]{95, 88}),
                new Student("Іваненко Олена", "AI-243", new int[]{99, 98}),
                new Student("Петров Сергій", "AI-142", new int[]{40, 70})
        };

        // Лямбда: вивести ПРІЗВИЩЕ + ІМʼЯ (у нас воно одним рядком name)
        Consumer printSurnameName = s -> System.out.println(s.getName());

        System.out.println("ПРІЗВИЩЕ + ІМʼЯ кожного студента:");
        forEach(students, printSurnameName);
    }
}
