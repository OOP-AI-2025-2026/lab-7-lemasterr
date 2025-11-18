package ua.opnu;

import java.util.Arrays;

public class Student {
    private String name;
    private String group;
    private int[] marks;

    public Student(String name, String group, int[] marks) {
        this.name = name;
        this.group = group;
        this.marks = Arrays.copyOf(marks, marks.length);
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int[] getMarks() {
        return Arrays.copyOf(marks, marks.length);
    }

    // Чи є хоча б одна заборгованість (оцінка < 60)
    public boolean hasDebt() {
        for (int m : marks) {
            if (m < 60) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
}
