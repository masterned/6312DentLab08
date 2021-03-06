package edu.westga.cs6312.files.model;

/**
 * Provides a model for working with teams, keeping track of their names, wins,
 * and losses.
 * 
 * @author Spencer Dent
 * @version 2021-03-06
 */
public class Team {
	private String name;
	private int numberOfWins;
	private int numberOfLosses;

	/**
	 * Creates a new team based off of the provided parameters.
	 * 
	 * @param newName           - the name of the new team
	 * @param newNumberOfWins   - the number of times the new team has won
	 * @param newNumberOfLosses - the number of times the new team has lost
	 */
	public Team(String newName, int newNumberOfWins, int newNumberOfLosses) {
		if (newName == null || newName.length() < 2) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (newNumberOfWins < 0) {
			throw new IllegalArgumentException("Invalid number of wins");
		}
		if (newNumberOfLosses < 0) {
			throw new IllegalArgumentException("Invalid number of losses");
		}

		this.name = newName;
		this.numberOfWins = newNumberOfWins;
		this.numberOfLosses = newNumberOfLosses;
	}

	/**
	 * Returns a String which represents the state of the Team object, outlining
	 * each of its instance variables in a descriptive sentence.
	 * 
	 * @return the String representation of the Team object
	 */
	@Override
	public String toString() {
		return "The " + this.name + " with " + this.numberOfWins + " wins and " + this.numberOfLosses + " losses";
	}
}
