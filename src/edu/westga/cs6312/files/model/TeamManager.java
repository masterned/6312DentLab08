package edu.westga.cs6312.files.model;

import java.util.ArrayList;

/**
 * Provides a model to work with a list of Teams.
 * 
 * @author Spencer Dent
 * @version 2021-03-06
 */
public class TeamManager {
	private ArrayList<Team> listOfTeams;

	/**
	 * Initializes the list of teams, allowing new teams to be added.
	 */
	public TeamManager() {
		this.listOfTeams = new ArrayList<Team>();
	}

	/**
	 * Adds a new team to the list of teams.
	 * 
	 * @param newTeam - the new team to be added to the list
	 */
	public void addTeam(Team newTeam) {
		if (newTeam == null) {
			throw new IllegalArgumentException("Invalid team");
		}

		this.listOfTeams.add(newTeam);
	}

	/**
	 * Returns the stored list of teams.
	 * 
	 * @return the list of teams
	 */
	public ArrayList<Team> getTeams() {
		return this.listOfTeams;
	}

	/**
	 * Returns a String representing the state of the TeamManager object, listing
	 * out the stringified Teams on their own separate lines. If the list is empty,
	 * it returns a message explaining it is empty.
	 */
	@Override
	public String toString() {
		String output = "";

		if (this.listOfTeams.size() == 0) {
			return "no teams in list";
		}

		for (Team currentTeam : this.listOfTeams) {
			output += currentTeam + "\n";
		}

		return output.trim();
	}
}
