import java.util.ArrayList;
import java.util.List;
public class GPACalculator {
    private final List<Course> courses = new ArrayList<>();
    public void addCourse(Course course) {
        courses.add(course);
    }
    public List<Course> getCourses() {
        return courses;
    }
    public double calculateGPA() {
        if (courses.isEmpty()) return 0.0;
        double totalQualityPoints = 0.0;
        int totalCredits = 0;
        for (Course c : courses) {
            totalQualityPoints += (c.getGradePoint() * c.getCredits());
            totalCredits += c.getCredits();
        }
        return totalCredits == 0 ? 0.0 : totalQualityPoints / totalCredits;
    }
    public int getTotalCredits() {
        int total = 0;
        for (Course c : courses) {
            total += c.getCredits();
        }
        return total;
    }
}