public class Course {
    private final String code;
    private final String title;
    private final int credits;
    private final double gradePoint; // e.g., 4.0 for A, 3.0 for B
    public Course(String code, String title, int credits, double gradePoint) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.gradePoint = gradePoint;
    }
    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public double getGradePoint() { return gradePoint; }
    @Override
    public String toString() {
        return String.format("[%s] %-20s | Credits: %d | Grade Point: %.2f",
                code, title, credits, gradePoint);
    }
}