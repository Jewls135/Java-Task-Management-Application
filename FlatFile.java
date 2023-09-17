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
     * Method used to edit a <code>Task</code> object
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
     * Method used to read the file and input new <code>Task</code> objects
     * into the <code>Task</code> object <code>ArrayList</code> .
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
