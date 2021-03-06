package edu.westga.cs6312.files.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Provides unit tests to verify the expected behavior of TeamManager's addTeam
 * and getTeams methods.
 * 
 * As they are a mutator-accessor pair on the same instance variable, I felt it
 * made the most sense to test them both in the same class. I tried to test them
 * separately, though, in order to prevent one from influencing the other.
 * 
 * @author Spencer Dent
 * @version 2021-03-06
 */
public class TeamManagerWhenAddTeam {

	/**
	 * Tests addTeam on a new TeamManager by adding a single team. It verifies that
	 * the list of teams is updated and only shows the new team that was just added.
	 */
	@Test
	public void testAddTeamWhenAddingOneTeamToNewManagerShouldContainListWithOnlyThatTeam() {
		TeamManager singleTeamManager = new TeamManager();
		singleTeamManager.addTeam(new Team("Lone Rangers", 5, 2));
		String actualOutput = singleTeamManager.toString();

		String expectedOutput = "The Lone Rangers with 5 wins and 2 losses";
		assertEquals(expectedOutput, actualOutput);
	}

	/**
	 * Test addTeam on a new TeamManager by calling the method multiple times,
	 * adding multiple teams. This makes sure that the developer did not hard-code
	 * the value and that the list is accepting multiple values.
	 */
	@Test
	public void testAddTeamWhenAddingMultipleTeamsToManagerShouldContainAllAddedTeams() {
		TeamManager multipleTeamsManager = new TeamManager();
		multipleTeamsManager.addTeam(new Team("Heroes", 10, 0));
		multipleTeamsManager.addTeam(new Team("Villains", 0, 10));
		String actualOutput = multipleTeamsManager.toString();

		String expectedOutput = "The Heroes with 10 wins and 0 losses\nThe Villains with 0 wins and 10 losses";
		assertEquals(expectedOutput, actualOutput);
	}

	/**
	 * Tests getTeams on a TeamManager without any teams added to it. It should
	 * return an empty list of teams.
	 */
	@Test
	public void testGetTeamsOnEmptyManagerShouldReturnEmptyList() {
		TeamManager emptyManager = new TeamManager();
		ArrayList<Team> actualListOfTeams = emptyManager.getTeams();

		ArrayList<Team> expectedListOfTeams = new ArrayList<Team>();
		assertEquals(expectedListOfTeams, actualListOfTeams);
	}

	/**
	 * Tests getTeams on a TeamManager with a single Team. It should return a list
	 * containing that Team.
	 */
	@Test
	public void testGetTeamsOnManagerWithOneTeamShouldReturnListWithOneTeam() {
		Team loneRangers = new Team("Lone Rangers", 5, 2);

		TeamManager singleTeamManager = new TeamManager();
		singleTeamManager.addTeam(loneRangers);
		ArrayList<Team> actualListOfTeams = singleTeamManager.getTeams();

		ArrayList<Team> expectedListOfTeams = new ArrayList<Team>();
		expectedListOfTeams.add(loneRangers);

		assertEquals(expectedListOfTeams, actualListOfTeams);
	}

	/**
	 * Tests getTeams on a TeamManager with multiple teams. Should return a list
	 * containing all of the teams.
	 */
	@Test
	public void testGetTeamsOnManagerWithMultipleTeamsShouldReturnListWithMultipleTeams() {
		Team heroes = new Team("Heroes", 10, 0);
		Team villains = new Team("Villains", 0, 10);

		TeamManager multipleTeamsManager = new TeamManager();
		multipleTeamsManager.addTeam(heroes);
		multipleTeamsManager.addTeam(villains);
		ArrayList<Team> actualListOfTeams = multipleTeamsManager.getTeams();

		ArrayList<Team> expectedListOfTeams = new ArrayList<Team>();
		expectedListOfTeams.add(heroes);
		expectedListOfTeams.add(villains);

		assertEquals(expectedListOfTeams, actualListOfTeams);
	}
}
