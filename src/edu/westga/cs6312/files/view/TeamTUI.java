package edu.westga.cs6312.files.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import edu.westga.cs6312.files.model.Team;
import edu.westga.cs6312.files.model.TeamManager;

/**
 * Provides a textual view which outputs data to the console and plaintext
 * files.
 * 
 * @author Spencer Dent
 * @version 2021-03-06
 */
public class TeamTUI {
	private Scanner keyboard;
	private TeamManager primaryTeamManager;

	/**
	 * Creates a new Team Manager Textual User Interface, assigning the provided
	 * TeamManager and opening the keyboard Scanner to read input from the user.
	 * 
	 * @param newTeamManager - the TeamManager to use in the new TeamTUI
	 */
	public TeamTUI(TeamManager newTeamManager) {
		if (newTeamManager == null) {
			throw new IllegalArgumentException("Invalid TeamManager");
		}

		this.keyboard = new Scanner(System.in);
		this.primaryTeamManager = newTeamManager;
	}

	/**
	 * The primary workflow of the application. Greets the user, prompts them with
	 * menu options, and calls private helper methods based upon the user's input.
	 */
	public void run() {
		System.out.println("Welcome to the team manager application - now with files!");
		System.out.println();

		int userMenuSelection;
		do {
			this.printMenu();
			userMenuSelection = this.getUserInt("Please enter your choice: ");

			switch (userMenuSelection) {
				case 1:
					this.addTeamsFromFile();
					break;

				case 2:
					this.displaySortedTeamsToConsole();
					break;

				case 3:
					this.saveSortedTeamsToFile();
					break;

				case 4:
					System.out.println("Thank you for using the team manager application.");
					System.out.println("Goodbye!");
					break;

				default:
					System.out.println("That's not a valid menu option. Please try again.");
					break;
			}

			System.out.println();
		} while (userMenuSelection != 4);

		this.keyboard.close();
	}

	/**
	 * Prompts the user and returns their input.
	 * 
	 * @param message - the prompt to be printed to the console
	 * @return the user's input
	 */
	private String getUserInput(String message) {
		System.out.print(message);
		String userInput = this.keyboard.nextLine();

		return userInput;
	}

	/**
	 * Prompts the user for a integer with the given message, reads the input from
	 * the console, and returns the value converted into an integer.
	 * 
	 * @param message - to display to the user as a prompt
	 * @return the integer received from the user
	 */
	private int getUserInt(String message) {
		int userInt = 0;

		boolean isValid = false;
		do {
			try {
				String userInput = this.getUserInput(message);
				userInt = Integer.parseInt(userInput);
				isValid = true;
			} catch (NumberFormatException numberFormatException) {
				System.out.println("That wasn't a valid integer. Please try again.");
			}
		} while (!isValid);

		return userInt;
	}

	/**
	 * Prints the available menu options to the console.
	 */
	private void printMenu() {
		System.out.println("\t1 - Add teams from file");
		System.out.println("\t2 - Display sorted teams on console");
		System.out.println("\t3 - Save sorted teams to file");
		System.out.println("\t4 - Quit");
	}

	/**
	 * Opens a text file, reads the data on each line, creates teams based upon the
	 * data if possible, and loads the teams into the TeamManager.
	 */
	private void addTeamsFromFile() {
		String userSpecifiedPath = this.getUserInput("Please enter file name: ");
		System.out.println();

		System.out.println("Teams read:");

		try {
			File inputFile = new File(userSpecifiedPath);
			Scanner inputFileScanner = new Scanner(inputFile);

			String currentLine;

			while (inputFileScanner.hasNextLine()) {
				currentLine = inputFileScanner.nextLine();

				try {
					Team newTeam = Team.parseTeam(currentLine);

					this.primaryTeamManager.addTeam(newTeam);

					System.out.println(newTeam);
				} catch (Exception exceptionCatchAll) {
					System.out.println("~~ " + exceptionCatchAll.getMessage() + ": " + currentLine);
				}
			}

			inputFileScanner.close();
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("That input file does not exist. Returning to main menu.");
		} catch (Exception otherException) {
			System.out.println("Something went wrong. Returning to main menu");
		}
	}

	/**
	 * Displays the sorted list of Teams on the console.
	 */
	private void displaySortedTeamsToConsole() {
		this.primaryTeamManager.sortTeams();

		System.out.println("The teams are:");
		System.out.println(this.primaryTeamManager);
	}

	/**
	 * Writes the sorted teams out to the user specified file.
	 */
	private void saveSortedTeamsToFile() {
		this.primaryTeamManager.sortTeams();

		String userSpecifiedPath = this.getUserInput("Enter output file name: ");

		File outputFile = new File(userSpecifiedPath);

		if (outputFile.exists()) {
			System.out.println("Warning: " + userSpecifiedPath + " already exists.");
			String userAffirmation = this
					.getUserInput("Would you like to overwrite? (if so send \"yes\" without quotes): ");
			if (!userAffirmation.equals("yes")) {
				System.out.println("Aborting. Returning to menu.");
				return;
			}
		}

		try {
			PrintWriter outputFileWriter = new PrintWriter(outputFile);

			for (Team currentTeam : this.primaryTeamManager.getTeams()) {
				outputFileWriter.println(currentTeam);
			}

			outputFileWriter.close();
		} catch (Exception otherException) {
			System.out.println("Something went wrong. Returning to main menu.");
			return;
		}

		System.out.println("Teams saved");
	}
}
