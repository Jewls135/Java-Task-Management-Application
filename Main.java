import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	// Initializing variables
	private static String fileName;
	private static Scanner inFile;
	private static Scanner keyboard;
	private static PrintWriter outFile;
	private static FlatFile flatFile;
	private static boolean quit;

	public static void main(String[] args) {
		fileName = "Java-Task-Management-Application\\data.txt";
		flatFile = new FlatFile();

		try { // Try-catch statement to catch the FileNotFoundException, if caught print error
				// message and exit with a status of 1.
			inFile = new Scanner(new File(fileName)); // Instantiates the file
			flatFile.readFile(inFile); // Reads the file and converts the data
			outFile = new PrintWriter(fileName); // Writes over the file essentially clearing it
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR opening file " + fileName);
			System.out.println(exception.getMessage());
			System.out.println("in " + System.getProperty("user.dir"));
			System.out.flush();
			System.exit(1);
		} // End of try-catch statement
		runTaskManagementCLI(); 
		inFile.close(); // Closing input stream no memory leaks here.
	} // End of method main

	private static void runTaskManagementCLI() {
		keyboard = new Scanner(System.in);
		quit = false;

		System.out.println("Java Task Management Application");
			System.out.println("	- This program allows you to create, edit, and remove tasks.");
			System.out.println("	- Each task has a title, a due date, and a description.");

		while(!quit) {
			System.out.println("\nPlease enter any number 1 - 4 as listed below!");
            System.out.println("	- 1. Add Task");
            System.out.println("	- 2. Remove Task");
            System.out.println("	- 3. Edit Task");
            System.out.println("	- 4. Exit\n");
            System.out.print("Enter your choice: ");

			try {
				int choice = keyboard.nextInt();
				switch (choice) {
					case 1: // Add Task
					Task newTask;
					System.out.print("Enter due date (yyyy/MM/dd): ");
					String dueDateInput = keyboard.next();
					System.out.print("Enter title: ");
					String title = keyboard.next();
					System.out.print("Enter description: ");
					String description = keyboard.next();

					LocalDate dueDate;
					try { // Try-catch statement to parse make sure the input is correct
						DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
						dueDate = LocalDate.parse(dueDateInput, dateFormatter);
					} catch (DateTimeParseException timeParseException) {
						System.out.println("Invalid due date format. Please use yyyy/MM/dd.");
						break;
					} // End of try-catch statement

					newTask = new Task(dueDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")), title, description);
					flatFile.addTask(newTask);
    				System.out.println("Task added successfully.");
						break;
					case 2: // Remove Task
						System.out.println("Please enter the title of the task you want to remove.");
						System.out.println("	- (Case and space sensitive)");
						System.out.print("Title: ");
						if(flatFile.removeTask(keyboard.nextLine())){
							System.out.println("Task successfully removed.");
						}else{
							System.out.println("Task not found, please enter a valid title.");
							break;
						} // End of if statement

					case 3: // Edit Task
						break;
					case 4: // Exit program
						break;
					default:
						System.out.println("Invalid input.");
						break;

				} // End of switch(choice)
			} catch(InputMismatchException inputException){
				System.out.println("Invalid input.");
			} // End of try-catch statement
		} // End of while
		keyboard.close();
	} // End of method runTaskmMnagementCLI

} // End of class main