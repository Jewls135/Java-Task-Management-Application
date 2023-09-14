public class Task {

    // Constants and other variables
    private final String DEFAULT_TITLE = "Title is empty";
    private final String DEFAULT_DUEDATE = "Date is empty";
    private final String DEFAULT_DESCRIPTION = "Description is empty";

    private String title;
    private String description;
    private String dueDate;
    
    // Constructors

    public Task(){
        this.setTitle(DEFAULT_TITLE);
        this.setDescription(DEFAULT_DESCRIPTION);
        this.setDueDate(DEFAULT_DUEDATE);
    }

    public Task(String newTitle, String newDescription, String newDueDate) {
        this.setTitle(newTitle);
        this.setDescription(newDescription);
        this.setDueDate(newDueDate);
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

    
    public int compareTo(Task otherTask) {
        String[] dueDate = this.getDueDate().split("/");
        String[] otherDate = otherTask.getDueDate().split("/");
        for(int i = 0; i < 3; i++) {
            if(Integer.parseInt(dueDate[i]) == Integer.parseInt(otherDate[i]) ) {
                continue;
            }else if(Integer.parseInt(dueDate[i]) < Integer.parseInt(otherDate[i])) {
                // If less return 1
                return 1;
            }else {
                // If greater return -1
                return -1;
            }
        }
        // If equal return 0
        return 0;
    }

    @Override
    public String toString(){
        return("-" +  this.getTitle() + "- \n\nDue date - " + this.getDueDate() + "\n\nDescription- " + this.getDescription());
    }


} // End of class Task