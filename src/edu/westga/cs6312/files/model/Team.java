package edu.westga.cs6312.files.model;

/**
 * Provides a model for working with teams, keeping track of their names, wins,
 * and losses.
 * 
 * @author Spencer Dent
 * @version 2021-03-06
 */
public class Team implements Comparable<Team> {
	private String name;
	private int numberOfWins;
	private int numberOfLosses;

	/**
	 * Creates a new team based off of the provided parameters.
	 * 
	 * @param newName           - the name of the new team
	 * @param newNumberOfWins   - the number of times the new team has won
	 * @param newNumberOfLosses - the number of times the new team has lost
	 * @precondition newName != null
	 */
	public Team(String newName, int newNumberOfWins, int newNumberOfLosses) {
		if (newName == null) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (newNumberOfWins < 0) {
			throw new IllegalArgumentException("Wins must be positive");
		}
		if (newNumberOfLosses < 0) {
			throw new IllegalArgumentException("Losses must be positive");
		}

		this.name = newName;
		this.numberOfWins = newNumberOfWins;
		this.numberOfLosses = newNumberOfLosses;
	}

	/**
	 * Returns the ratio of wins to total number of games where 0 is no games won
	 * and 1 is all games won.
	 * 
	 * @return the ratio of number of games won to total number of games
	 */
	public double getWinningPercentage() {
		return (double) this.numberOfWins / (double) (this.numberOfWins + this.numberOfLosses);
	}

	/**
	 * Returns the number of times the team has won
	 * 
	 * @return the number of times the team has won
	 */
	public int getNumberOfWins() {
		return this.numberOfWins;
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

	/**
	 * Compares two teams, returning an integer representing the order they should
	 * be sorted in. If the Team that contains the method precedes the Team passed
	 * into the method, it should return -1, 0 if they are the same, and 1 if it
	 * comes after.
	 * 
	 * @return an integer describing whether the team should come before or after
	 *         the other team
	 * @precondition otherTeam != null
	 */
	@Override
	public int compareTo(Team otherTeam) {
		if (otherTeam == null) {
			throw new IllegalArgumentException("Invalid team");
		}

		int comparison = Double.compare(otherTeam.getWinningPercentage(), this.getWinningPercentage());

		if (comparison != 0) {
			return comparison;
		}

		return Integer.compare(otherTeam.getNumberOfWins(), this.numberOfWins);
	}
}
