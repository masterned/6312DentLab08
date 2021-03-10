package edu.westga.cs6312.files.testing.team;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.Team;

/**
 * Provides unit tests to verify the expected behavior of Team's parseTeam
 * static method.
 * 
 * As we still don't have a way of testing errors without adding a lot of logic
 * to the tests, I will be relying on design by contract rather than testing
 * those cases.
 * 
 * @author Spencer Dent
 * @version 2021-03-09
 */
public class TeamWhenParseTeam {

	/**
	 * Tests to make sure that parseTeam creates a new Team using the values in the
	 * given String.
	 */
	@Test
	public void testParseTeamShouldReturnNewTeamWithGivenValues() {
		Team heroes = Team.parseTeam("Heroes, 10, 0");
		String expectedTeam = "The Heroes with 10 wins and 0 losses";

		assertEquals(expectedTeam, heroes.toString());
	}

	/**
	 * Tests parseTeam again to guarantee that the developer did not hard-code the
	 * return values in the first test.
	 */
	@Test
	public void testParseTeamAgainToPreventHardCoding() {
		Team won75Percent = Team.parseTeam("75%, 3, 1");
		String expectedTeam = "The 75% with 3 wins and 1 losses";

		assertEquals(expectedTeam, won75Percent.toString());
	}
}
