import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* The Main class serves as the entry point for the Java Task Management Application.
* This program allows users to create, edit, and remove tasks, each with a title, 
* a due date, and a description. It provides a command-line interface for managing tasks
* and stores task data in a file.
*
* NOTE: If the program stops abnormally data will be lost.
*
* @author Julian Ward
* @version 1.00
*
*/
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
			runTaskManagementCLI(); // Runs the method for command line prompts
			outFile.write(flatFile.toString()); // Writing the data to the file
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR opening file " + fileName);
			System.out.println(exception.getMessage());
			System.out.println("in " + System.getProperty("user.dir"));
			System.out.flush();
			System.exit(1);
		} // End of try-catch statement
		outFile.close(); // Closing output stream no memory leaks here.
		inFile.close(); // Closing input stream no memory leaks here.
	} // End of method main

	private static void runTaskManagementCLI() {

		keyboard = new Scanner(System.in);

		// Initializing some temporary variables
		String tempTitle;
		String tempDescription;
		String tempDate;
		Task tempTask;
		quit = false;

		System.out.println("Java Task Management Application\n");
		System.out.println("	- This program allows you to create, edit, and remove tasks.");
		System.out.println("	- Each task has a title, a due date, and a description.");

		while (!quit) {

			System.out.println("\nPlease enter any number 1 - 4 as listed below.\n");
			System.out.println("	- 1. Add Task");
			System.out.println("	- 2. Remove Task");
			System.out.println("	- 3. Edit Task");
			System.out.println("	- 4. List All Tasks");
			System.out.println("	- 5. Exit\n");
			System.out.print("Enter your choice: ");

			switch (Integer.parseInt(keyboard.nextLine())) {
				case 1:
					System.out.println("\nPlease enter the title: ");
					tempTitle = keyboard.nextLine();

					System.out.println("\nPlease enter the description: ");
					tempDescription = keyboard.nextLine();

					System.out.println("\nPlease enter the due date, xxxx/xx/xx (Year/Month/Day): ");
					tempDate = keyboard.nextLine();

					tempTask = new Task(tempTitle, tempDescription, tempDate);

					if (!tempDate.matches("^\\d{4}\\/\\d{2}\\/\\d{2}")) {
						System.out.println("\nInvalid input for the date, please read requirements above.");
					} else {
						flatFile.addTask(tempTask);
					} // End of if
					break;
				case 2:
					System.out.println("Please enter the Task's title you want to remove: ");

					if (flatFile.removeTask(keyboard.nextLine())) {
						System.out.println("\nSucessfully removed that task!");
					} else {
						System.out.println("\nError, please input a valid title (Case Sensitive)");
					} // End of if
					break;
				case 3:
					System.out.println("Please enter the title of the task you wish to edit");
					tempTitle = keyboard.nextLine();
					tempTask = flatFile.getTask(tempTitle);

					System.out.println("\nPlease enter what you would like to edit");
					System.out.println("	- 1. Title");
					System.out.println("	- 2. Description");
					System.out.println("	- 3. Due Date");

					int tempOperation = Integer.parseInt(keyboard.nextLine()) - 1;

					System.out.println("Please enter what you would like to change it to:");
					System.out.println(
							"For the due date please make sure to enter it according to the pattern below.\nxxxx/xx/xx (Year/Month/Day)");
					String tempData = keyboard.nextLine();

					if (tempOperation == 2 && tempData.matches("^\\d{4}\\/\\d{2}\\/\\d{2}")) {
						flatFile.editTask(tempTask, tempOperation, tempData);

					} else if (tempOperation == 2) {
						System.out.println("\nInvalid input for the date, please read requirements above.");
					} else {
						flatFile.editTask(tempTask, tempOperation, tempData);
					} // End of if

					break;
				case 4:
					System.out.println(flatFile.toString());
					break;
				case 5:
					quit = true;
					break;
			} // End of Switch(int)

		} // End of while(quit)

		keyboard.close(); // No memory leaks here.
	} // End of method runTaskmMnagementCLI

} // End of class main