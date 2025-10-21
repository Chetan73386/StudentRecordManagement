import java.util.ArrayList;
import java.util.Scanner;

// Student class (Encapsulation)
class Student {
    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setMarks(double marks) { this.marks = marks; }

    // Display student details
    public void display() {
        System.out.printf("%-10d %-20s %-10.2f\n", id, name, marks);
    }
}

// Main class
public class StudentRecordManagement {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();

    // Add Student
    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("✅ Student added successfully!\n");
    }

    // View All Students
    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students available!\n");
            return;
        }
        System.out.printf("%-10s %-20s %-10s\n", "ID", "Name", "Marks");
        for (Student s : students) {
            s.display();
        }
        System.out.println();
    }

    // Update Student
    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();
                s.setName(name);
                s.setMarks(marks);
                System.out.println("✅ Student updated successfully!\n");
                return;
            }
        }
        System.out.println("❌ Student not found!\n");
    }

    // Delete Student
    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("✅ Student deleted successfully!\n");
                return;
            }
        }
        System.out.println("❌ Student not found!\n");
    }

    // Main Menu
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();1

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("🚪 Exiting... Goodbye!");
                default -> System.out.println("❌ Invalid choice! Try again.\n");
            }
        } while (choice != 5);
    }
}
