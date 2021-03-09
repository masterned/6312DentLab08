package edu.westga.cs6312.files.testing.teammanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.Team;
import edu.westga.cs6312.files.model.TeamManager;

/**
 * Provides unit tests to verify the expected behavior of TeamManager's
 * sortTeams method.
 * 
 * As the current implementation of sortTeams currently just calls
 * Collections.sort on the list, it may seem like overkill to be testing this
 * method. The primary purpose of tests like these are to prevent regression.
 * This allows the developer the freedom to try other sorting methods while
 * being able to verify its results.
 * 
 * @author Spencer Dent
 * @version 2021-03-09
 */
public class TeamManagerWhenSortTeams {

	/**
	 * Tests the case where the TeamManager does not have any Teams. The list should
	 * not change.
	 */
	@Test
	public void testSortTeamsOnEmptyTeamManagerShouldNotChangeTheListOfTeams() {
		TeamManager emptyManager = new TeamManager();
		String expectedTeams = emptyManager.toString();

		emptyManager.sortTeams();
		String actualTeams = emptyManager.toString();

		assertEquals(expectedTeams, actualTeams);
	}

	/**
	 * Tests the case where the TeamManager has 1 Team. The list should not change.
	 */
	@Test
	public void testSortTeamsOnManagerWith1TeamShouldNotChangeTheList() {
		Team loneRangers = new Team("Lone Rangers", 6, 4);

		TeamManager singleManager = new TeamManager();
		singleManager.addTeam(loneRangers);
		String expectedTeams = singleManager.toString();

		singleManager.sortTeams();
		String actualTeams = singleManager.toString();

		assertEquals(expectedTeams, actualTeams);
	}

	/**
	 * Tests the case where the list is already in sorted order. The list should not
	 * change.
	 */
	@Test
	public void testSortTeamsWhereTeamsAreInOrderShouldNotChangeList() {
		Team won100Percent = new Team("100%", 1, 0);
		Team won50Percent = new Team("50%", 1, 1);
		Team won0Percent = new Team("0%", 0, 1);

		TeamManager organizedManager = new TeamManager();
		organizedManager.addTeam(won100Percent);
		organizedManager.addTeam(won50Percent);
		organizedManager.addTeam(won0Percent);
		String expectedTeams = organizedManager.toString();

		organizedManager.sortTeams();
		String actualTeams = organizedManager.toString();

		assertEquals(expectedTeams, actualTeams);
	}

	/**
	 * Tests the case where only a single swap is required to sort the list. The
	 * list should be sorted after calling.
	 */
	@Test
	public void testSortTeamsRequiring1SwapShouldSortTheList() {
		Team villains = new Team("Villains", 0, 10);
		Team heroes = new Team("Heroes", 10, 0);

		TeamManager comicsManager = new TeamManager();
		comicsManager.addTeam(villains);
		comicsManager.addTeam(heroes);

		comicsManager.sortTeams();
		String actualTeams = comicsManager.toString();

		String expectedTeams = "The Heroes with 10 wins and 0 losses\n" + "The Villains with 0 wins and 10 losses";

		assertEquals(expectedTeams, actualTeams);
	}

	/**
	 * Tests the case where the list was in reverse order. The list should be sorted
	 * after calling.
	 */
	@Test
	public void testSortTeamsWhenTeamsAreInReverseOrderShouldSortList() {
		Team won0Percent = new Team("0%", 0, 1);
		Team won25Percent = new Team("25%", 1, 3);
		Team won50Percent = new Team("50%", 1, 1);
		Team won75Percent = new Team("75%", 3, 1);
		Team won100Percent = new Team("100%", 1, 0);

		TeamManager percentsManager = new TeamManager();
		percentsManager.addTeam(won0Percent);
		percentsManager.addTeam(won25Percent);
		percentsManager.addTeam(won50Percent);
		percentsManager.addTeam(won75Percent);
		percentsManager.addTeam(won100Percent);

		percentsManager.sortTeams();
		String actualTeams = percentsManager.toString();

		String expectedTeams = "The 100% with 1 wins and 0 losses\n" + "The 75% with 3 wins and 1 losses\n"
				+ "The 50% with 1 wins and 1 losses\n" + "The 25% with 1 wins and 3 losses\n"
				+ "The 0% with 0 wins and 1 losses";

		assertEquals(expectedTeams, actualTeams);
	}
}
