public class Task{

    // Initializing variables
    private String title;
    private String description;
    private String dueDate;
    private int priority;
    
    // Constructor
    public Task(String newTitle, String newDescription, String newDueDate, int newPriority) {
        this.setTitle(newTitle);
        this.setDescription(newDescription);
        this.setDueDate(newDueDate);
        this.setPriority(newPriority);
    }

    // Getter and Setter methods below

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    
    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String newDueDate) {
        this.dueDate = newDueDate;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int newPriority) {
        this.priority = newPriority;
    }
    
} // End of class Task