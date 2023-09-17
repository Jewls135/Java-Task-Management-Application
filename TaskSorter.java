import java.util.ArrayList;

/**
 * Utility Class for handling sorting an <code>ArrayList</code> of
 * <code>Task</code> objects using the quicksort algorithm.
 * The algorithm is merely adopted and slightly changed to work specifically for
 * the <code>ArrayList</code> of <code>Task</code>objects.
 */
public class TaskSorter {

    /**
     * Sorts an <code>ArrayList</code> of <code>Task</code> objects based off of
     * their due date.
     * 
     * @param tasks The <code>Arraylist</code> of <code>Task</code> objects to be
     *              sorted.
     */
    public void quicksort(ArrayList<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return;
        }
        quicksort(tasks, 0, tasks.size() - 1);
    } // End of method quicksort(ArrayList<Task>)

    /**
     * Recursive method used to do quicksort on each part of the
     * <code>ArrayList</code>.
     * 
     * @param tasks The <code>ArrayList</code> of <code>Task</code> objects to be
     *              sorted.
     * @param low   The lowest index of a <code>Task</code> object.
     * @param high  The highest index of a <code>Task</code> object.
     */
    private void quicksort(ArrayList<Task> tasks, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(tasks, low, high);
            quicksort(tasks, low, pivotIndex - 1);
            quicksort(tasks, pivotIndex + 1, high);
        } // End of if
    } // End of method quicksort(ArrayList<Task>, int, int)

    /**
     * Partitions the <code>ArrayList</code> and returns the index of the pivot
     * <code>Task</code>.
     * 
     * @param tasks The <code>ArrayList</code> of <code>Task</code> objects to be
     *              sorted.
     * @param low   The lowest index of a <code>Task</code> object.
     * @param high  The highest index of a <code>Task</code> object.
     * @return The index of the pivot <code>Task</code>.
     */
    private int partition(ArrayList<Task> tasks, int low, int high) {
        Task pivot = tasks.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Compare tasks based on their due dates, lower due date means higher priority.
            if (tasks.get(j).compareTo(pivot) > 0) {
                i++;
                swap(tasks, i, j);
            } // End of if
        } // End of for

        swap(tasks, i + 1, high);
        return i + 1;
    } // End of method partition

    /**
     * Swaps two <code>Task</code> objects in the <code>ArrayList</code>
     * 
     * @param tasks The <code>ArrayList</code> of <code>Task</code> objects that
     *              will swap two <code>Task</code> objects.
     * @param i     The index of the first <code>Task</code> object.
     * @param j     The index of the second <code>Task</code> object.
     */
    private void swap(ArrayList<Task> tasks, int i, int j) {
        Task temp = tasks.get(i);
        tasks.set(i, tasks.get(j));
        tasks.set(j, temp);
    } // End of method swap

} // End of class TaskSorter