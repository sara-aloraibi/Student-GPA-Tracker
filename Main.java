import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GPACalculator tracker = new GPACalculator();
        Scanner sc = new Scanner(System.in);
        // Initial sample data
        tracker.addCourse(new Course("ITCS214", "Data Structures", 3, 4.0));
        tracker.addCourse(new Course("MATHS211", "Linear Algebra", 3, 3.5));
        boolean running = true;
        while (running) {
            System.out.println("\n--- Student GPA & Grade Tracker ---");
            System.out.println("1. View Enrolled Courses");
            System.out.println("2. Add New Course");
            System.out.println("3. Calculate Cumulative GPA");
            System.out.println("4. Exit");
            System.out.print("Select option: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    if (tracker.getCourses().isEmpty()) {
                        System.out.println("No courses added yet.");
                    } else {
                        tracker.getCourses().forEach(System.out::println);
                    }
                }
                case "2" -> {
                    System.out.print("Course Code: ");
                    String code = sc.nextLine().trim();
                    System.out.print("Course Title: ");
                    String title = sc.nextLine().trim();
                    System.out.print("Credits (e.g., 3): ");
                    int credits;
                    try {
                        credits = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        credits = 3; // Default fallback
                    }
                    System.out.print("Grade Point (0.0 to 4.0): ");
                    double gradePoint;
                    try {
                        gradePoint = Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        gradePoint = 0.0;
                    }
                    tracker.addCourse(new Course(code, title, credits, gradePoint));
                    System.out.println("Course added successfully.");
                }
                case "3" -> {
                    System.out.printf("Total Credits Completed: %d%n", tracker.getTotalCredits());
                    System.out.printf("Current Cumulative GPA: %.2f%n", tracker.calculateGPA());
                }
                case "4" -> {
                    running = false;
                    System.out.println("Session closed.");
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
        sc.close();
    }
}