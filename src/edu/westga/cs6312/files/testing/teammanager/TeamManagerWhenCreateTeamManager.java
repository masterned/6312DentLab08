package edu.westga.cs6312.files.testing.teammanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.TeamManager;

/**
 * Provides a unit test to verify the expected behavior of TeamManager's
 * constructor and toString method.
 * 
 * As the constructor and toString method do not take any parameters and the
 * state of the TeamManager object cannot change without the use of methods not
 * tested in this class, creating a second unit test (in the current state)
 * would not make any sense and would only add redundancy.
 * 
 * @author Spencer Dent
 * @version 2021-03-06
 */
public class TeamManagerWhenCreateTeamManager {

	/**
	 * Tests the team manager constructor to make sure that it properly instantiates
	 * its methods, and tests the toString to make sure it handles the no teams case
	 * as expected.
	 */
	@Test
	public void testTeamManagerConstructorShouldCreateNewTeamManagerWithEmptyTeamList() {
		TeamManager emptyTeamManager = new TeamManager();
		String actualOutput = emptyTeamManager.toString();

		String expectedOutput = "no teams in list";
		assertEquals(expectedOutput, actualOutput);
	}

}
