import java.util.*;

public class StudentGradeTracker {
    static class Student {
        String name;
        double[] marks;

        Student(String name, double[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double average() {
            double sum = 0;
            for (double m : marks) sum += m;
            return sum / marks.length;
        }

        double highest() {
            double max = marks[0];
            for (double m : marks) if (m > max) max = m;
            return max;
        }

        double lowest() {
            double min = marks[0];
            for (double m : marks) if (m < min) min = m;
            return min;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();

            double[] marks = new double[subjects];
            for (int j = 0; j < subjects; j++) {
                System.out.print("Marks in subject " + (j + 1) + ": ");
                marks[j] = sc.nextDouble();
            }
            sc.nextLine();
            students.add(new Student(name, marks));
        }

        System.out.println("\n========== STUDENT SUMMARY ==========");
        for (Student s : students) {
            System.out.printf("%-20s Average: %.2f  Highest: %.2f  Lowest: %.2f%n",
                    s.name, s.average(), s.highest(), s.lowest());
        }

        if (!students.isEmpty()) {
            Student top = students.get(0);
            for (Student s : students) {
                if (s.average() > top.average()) top = s;
            }
            System.out.printf("%nTop Student: %s (Average %.2f)%n", top.name, top.average());
        }

        sc.close();
    }
}