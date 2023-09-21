import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class deals with the file on the flat level.
 * It contains an <code>ArrayList</code> of <code>Task</code> objects
 * as well as methods to create and edit <code>Task</code> objects, and a
 * <code>TaskSorter</code> to sort <code>Task</code> objects by their
 * <code>dueDates</code>.
 * 
 */
public class FlatFile {

    public static final String System = null;
    // Variables
    private ArrayList<Task> tasks;
    private TaskSorter taskSorter;

    /**
     * Default constructor, instantiating variables.
     */
    public FlatFile() {
        this.tasks = new ArrayList<Task>();
        this.taskSorter = new TaskSorter();

    } // End of default constructor

    /**
     * Method used to add a <code>Task</code> to the <code>ArrayList</code> of
     * <code>task</code> objects.
     * 
     * @param taskToAdd The <code>Task</code> object to be added.
     */
    public void addTask(Task taskToAdd) {
        tasks.add(taskToAdd);
        taskSorter.quicksort(tasks);
    } // End of method addTask

    /**
     * Method used to get a <code>Task</code> object given a <code>title</code>
     * 
     * @param taskTitle The <code>title</code> of <code>Task</code> object to be
     *                  found.
     * @return The <code>Task</code> object to be returned.
     */
    public Task getTask(String taskTitle) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTitle().equals(taskTitle)) {
                return tasks.get(i);
            } // End of if
        } // End of for
        return null;
    } // End of method getTask

    /**
     * Method used to remove a <code>task</code> from the <code>ArrayList</code> of
     * <code>Task</code> objects.
     * 
     * @param taskTitle The <code>title</code> of the <code>task</code> to be
     *                  removed.
     * @return True or False depending on if the content was found and removed.
     */
    public boolean removeTask(String taskTitle) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTitle().equals(taskTitle)) {
                tasks.remove(i);
                taskSorter.quicksort(tasks);
                return true;
            } // End of if
        } // End of for
        return false;
    } // End of method removeTask

    /**
     * Method used to edit a <code>Task</code> object.
     * 
     * @param taskToEdit The <code>Task</code> object to edit.
     * @param operation  The operation to edit with.
     * @param data       The new data to insert.
     */
    public void editTask(Task taskToEdit, int operation, String data) {
        switch (operation) {
            case 0: // Edit title
                taskToEdit.setTitle(data);
                break;
            case 1: // Edit description
                taskToEdit.setDescription(data);
                break;
            case 2: // Edit due date
                taskToEdit.setDueDate(data);
                taskSorter.quicksort(tasks); // Only need to sort here in this method since the sort is based off of
                                             // each tasks due date
                break;
        } // End of switch(operation)

    } // End of method editTask

    /**
     * Method used to read the file and input new <code>Task</code> objects.
     * into the <code>Task</code> object <code>ArrayList</code>.
     * 
     * @param inFile The file to be read.
     */
    public void readFile(Scanner inFile) {
        Task tempTask = null;
        while (inFile.hasNext()) {
            tempTask = new Task();
            tasks.add(tempTask.readTask(inFile));
        }
    } // End of method readFile

    @Override
    public String toString() {
        String returnString = "";
        for (int i = 0; i < tasks.size(); i++) {
            returnString += tasks.get(i).toString() + "\n";
        } // End of for
        return returnString;
    } // End of method toString

} // End of class FlatFile
