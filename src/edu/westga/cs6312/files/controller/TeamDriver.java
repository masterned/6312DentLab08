package edu.westga.cs6312.files.controller;

import edu.westga.cs6312.files.model.TeamManager;
import edu.westga.cs6312.files.view.TeamTUI;

/**
 * Provides a controller for the Text File version of the Team Manager Program.
 * 
 * @author Spencer Dent
 * @version 2021-03-06
 */
public class TeamDriver {

	/**
	 * This method is the entry point of the application
	 *
	 * @param args Command-line arguments, not used
	 */
	public static void main(String[] args) {
		TeamManager primaryTeamManager = new TeamManager();
		TeamTUI textualUserInterface = new TeamTUI(primaryTeamManager);
		textualUserInterface.run();
	}
}
