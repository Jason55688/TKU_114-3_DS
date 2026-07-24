public class TaskNode {

    String id;
    String description;
    boolean completed;
    TaskNode next;

    public TaskNode(String id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
        this.next = null;
    }
}