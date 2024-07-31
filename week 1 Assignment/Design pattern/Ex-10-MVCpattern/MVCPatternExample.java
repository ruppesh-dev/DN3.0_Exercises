package designPatterns.mvcExample;

public class MVCPatternExample {
    public static void main(String[] args) {
        
        Student student = new Student("1", "Alice Smith", "A");

        
        StudentView view = new StudentView();

        
        StudentController controller = new StudentController(student, view);

        
        controller.updateView();

        
        controller.setStudentName("Bob Johnson");
        controller.setStudentGrade("B");

        
        controller.updateView();
    }
}
