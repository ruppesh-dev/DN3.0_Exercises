package designPatterns.mvcExample;

public class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("Student Information:");
        System.out.println("Full Name: " + studentName);
        System.out.println("Student ID: " + studentId);
        System.out.println("Current Grade: " + studentGrade);
    }
}
