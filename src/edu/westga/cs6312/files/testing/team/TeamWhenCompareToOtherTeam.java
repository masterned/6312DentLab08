package edu.westga.cs6312.files.testing.team;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.Team;

/**
 * Provides unit tests to verify the expected behavior of Team's compareTo
 * method.
 * 
 * @author Spencer Dent
 * @version 2021-03-07
 */
public class TeamWhenCompareToOtherTeam {

	/**
	 * Tests the case of a team being compared to itself. It should return 0.
	 */
	@Test
	public void testCompareToWhenPassedSameTeamShouldReturn0() {
		Team kahled = new Team("DJ Kahled", 0, 0);
		int actualComparison = kahled.compareTo(kahled);

		assertEquals(0, actualComparison);
	}

	/**
	 * Tests the case where the calling Team should come before the Team passed in
	 * as an argument due to winning percentage.
	 */
	@Test
	public void testCompareToWhenArgumentTeamHasLowerWinPercentageShouldReturnNegative1() {
		Team heroes = new Team("Heroes", 10, 0);
		Team villains = new Team("Villains", 0, 10);
		int actualComparison = heroes.compareTo(villains);

		assertEquals(-1, actualComparison);
	}

	/**
	 * Tests the case where the calling Team should come after the argument team due
	 * to their winning percentage.
	 */
	@Test
	public void testCompareToWhenArgumentTeamHasHigherWinPercentageShouldReturn1() {
		Team villains = new Team("Villains", 0, 10);
		Team heroes = new Team("Heroes", 10, 0);
		int actualComparison = villains.compareTo(heroes);

		assertEquals(1, actualComparison);
	}

	/**
	 * Tests the case where the calling Team should come before the argument Team
	 * even though their winning percentages are the same due to their number of
	 * wins.
	 */
	@Test
	public void testCompareToWhenArgumentTeamHasSameWinPercentButLowerCountShouldReturnNegative1() {
		Team twins = new Team("Twins", 4, 2);
		Team onlys = new Team("Onlys", 2, 1);
		int actualComparison = twins.compareTo(onlys);

		assertEquals(-1, actualComparison);
	}

	/**
	 * Tests the case where the calling Team should come after the argument Team
	 * even though they have the same winning percentage due to having a lower
	 * number of wins.
	 */
	@Test
	public void testCompareToWhenArgumentTeamHasSameWinPercentButHigherCountShouldReturn1() {
		Team onlys = new Team("Onlys", 2, 1);
		Team twins = new Team("Twins", 4, 2);
		int actualComparison = onlys.compareTo(twins);

		assertEquals(1, actualComparison);
	}

	/**
	 * Tests tha case where the two Teams have the same winning percentage and
	 * number of wins. They should stay in the same order if they are sorted.
	 */
	@Test
	public void testCompareToWhenTeamsHaveSameWinPercentAndCountShouldReturn0() {
		Team mirrors = new Team("Mirrors", 11, 11);
		Team reflections = new Team("Reflections", 11, 11);

		int actualComparison = mirrors.compareTo(reflections);
		assertEquals(0, actualComparison);
	}

	/**
	 * Tests the case where the calling Team should come before the argument Team
	 * based upon winning percentage (though the number of wins is the same).
	 */
	@Test
	public void testCompareToWhenArgumentTeamHasSameWinCountButLowerPercentShouldReturnNegative1() {
		Team fewerLosses = new Team("Fewer Losses", 2, 1);
		Team greaterLosses = new Team("Greater Losses", 2, 3);

		int actualComparison = fewerLosses.compareTo(greaterLosses);
		assertEquals(-1, actualComparison);
	}

	/**
	 * Tests the case where the calling Team should come after the argument Team due
	 * to winning percentage (though the number of wins is the same).
	 */
	@Test
	public void testCompareToWhenArgumentTeamHasSameWinCountButHigherPercentShouldReturn1() {
		Team greaterLosses = new Team("Greater Losses", 2, 3);
		Team fewerLosses = new Team("Fewer Losses", 2, 1);

		int actualComparison = greaterLosses.compareTo(fewerLosses);
		assertEquals(1, actualComparison);
	}

	/**
	 * Tests the case where the calling Team should come before the argument Team
	 * due to winning percentage (though the argument Team has a greater number of
	 * wins).
	 */
	@Test
	public void testCompareToWhenArgumentTeamHasHigherWinCountButLowerWinPercentageShouldReturnNegative1() {
		Team fewerLosses = new Team("Fewer Losses", 2, 0);
		Team greaterLosses = new Team("Greater Losses", 100, 3);
		
		int actualComparison = fewerLosses.compareTo(greaterLosses);
		assertEquals(-1, actualComparison);
	}
	
	/**
	 * Tests the case where the calling Team should come after the argument Team
	 * due to winning percentage (though the argument Team has a fewer number of
	 * wins).
	 */
	@Test
	public void testCompareToWhenArgumentTeamHasLowerWinCountButHigherWinPercentageShouldReturn1() {
		Team greaterLosses = new Team("Greater Losses", 100, 3);
		Team fewerLosses = new Team("Fewer Losses", 2, 0);

		int actualComparison = greaterLosses.compareTo(fewerLosses);
		assertEquals(1, actualComparison);
	}
}
