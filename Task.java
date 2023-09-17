import java.util.Scanner;

/**
 * This class represents a <code>Task</code> object that has a
 * <code>dueDate</code>,
 * a <code>title</code>, and a <code>description</code>.
 * It also contains methods to create/read itself from a file, as well as
 * editing itself.
 * 
 */
public class Task {

    // Constants
    private final String DEFAULT_TITLE = "Title is empty";
    private final String DEFAULT_DUEDATE = "Date is empty";
    private final String DEFAULT_DESCRIPTION = "Description is empty";
    private final String COMMA_SPACE = ", ";

    // Variables
    private String title;
    private String description;
    private String dueDate;

    // Constructors

    /**
     * Default constructor, instantiates this <code>Task</code>'s variables with
     * constants.
     */
    public Task() {
        this.setTitle(DEFAULT_TITLE);
        this.setDescription(DEFAULT_DESCRIPTION);
        this.setDueDate(DEFAULT_DUEDATE);
    } // End of default constructor

    /**
     * Constructor used to initialize this this <code>Task</code>'s variables.
     * 
     * @param newTitle       The value to set <code>title</code> to.
     * @param newDescription The value to set <code>description</code> to.
     * @param newDueDate     The value to set <code>dueDate</code> to.
     */
    public Task(String newTitle, String newDescription, String newDueDate) {
        this.setTitle(newTitle);
        this.setDescription(newDescription);
        this.setDueDate(newDueDate);
    } // End of constructor(String, String, String)

    /**
     * Method used to read and create a <code>Task</code> from the file.
     * 
     * @param inFile The file to be read.
     * @return This <code>Task</code> object.
     */
    public Task readTask(Scanner inFile) {
        if (inFile.hasNext()) { // Default data from text file : dueDate, title, description (Comma space
                                // delimiter)
            this.setDueDate(inFile.next());
            this.setTitle(inFile.next());
            this.setDescription(inFile.next());
        } // End of if
        return this;
    } // End of method readTask

    // Getter and Setter methods below

    /**
     * Getter method used to retrieve this <code>Task</code>'s <code>title</code>.
     * 
     * @return the <code>title</code> of this <code>Task</code>.
     */
    public String getTitle() {
        return this.title;
    } // End of method getTitle

    /**
     * Setter method for the <code>title</code> variable.
     * 
     * @param newTitle new <code>title</code> to be set.
     */
    public void setTitle(String newTitle) {
        this.title = newTitle;
    } // End of method setTitle

    /**
     * Getter method used to retrieve this <code>Task</code>'s
     * <code>description</code>.
     * 
     * @return the <code>description</code> of this <code>Task</code>.
     */
    public String getDescription() {
        return this.description;
    } // End of method getDescription

    /**
     * Setter method for the <code>description</code> variable.
     * 
     * @param newDescription new <code>desscription</code> to be set.
     */
    public void setDescription(String newDescription) {
        this.description = newDescription;
    } // End of method setDescription

    /**
     * Getter method used to retrieve this <code>Task</code>'s <code>dueDate</code>.
     * 
     * @return the <code>dueDate</code> of this <code>Task</code>.
     */
    public String getDueDate() {
        return this.dueDate;
    } // End of method getDueDate

    /**
     * Setter method for the <code>dueDate</code> variable.
     * 
     * @param newDueDate new <code>dueDate</code> to be set.
     */
    public void setDueDate(String newDueDate) {
        this.dueDate = newDueDate;
    } // End of method setDueDate

    /**
     * Method to compare this <code>Task</code> to another <code>Task</code>.
     * This uses each <code>Task</code>s <code>dueDate</code>s to compare.
     * 
     * @param otherTask other <code>Task</code> to compare to.
     * @return -1, 0, or +1 depending on the comparison.
     */
    public int compareTo(Task otherTask) {
        String[] dueDate = this.getDueDate().split("/");
        String[] otherDate = otherTask.getDueDate().split("/");
        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(dueDate[i]) == Integer.parseInt(otherDate[i])) {
                continue;
            } else if (Integer.parseInt(dueDate[i]) < Integer.parseInt(otherDate[i])) {
                // If less return 1 (closer due date)
                return 1;
            } else {
                // If greater return -1 (further due date)
                return -1;
            } // End of if
        } // End of for
          // If equal return 0
        return 0;
    } // End of method compareTo

    @Override
    public String toString() { // String returned should look like DUEDATE, TITLE, DESCRIPTION
        return (this.dueDate + COMMA_SPACE + this.title + COMMA_SPACE + this.description);
    } // End of method toString

} // End of class Task