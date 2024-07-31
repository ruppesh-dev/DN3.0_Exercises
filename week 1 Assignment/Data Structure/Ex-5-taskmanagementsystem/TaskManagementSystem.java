package taskManagementSystem;

public class TaskManagementSystem {
    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        Task task1 = new Task(1, "Task 1", "Pending");
        Task task2 = new Task(2, "Task 2", "In Progress");
        Task task3 = new Task(3, "Task 3", "Completed");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        System.out.println("All tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for Task ID 2:");
        Task searchResult = taskList.searchTask(2);
        if (searchResult != null) {
            System.out.println(searchResult);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting Task ID 2:");
        boolean deleteResult = taskList.deleteTask(2);
        System.out.println("Task deleted: " + deleteResult);

        System.out.println("\nAll tasks after deletion:");
        taskList.traverseTasks();
    }
}