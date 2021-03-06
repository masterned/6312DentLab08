package edu.westga.cs6312.files.testing.team;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.Team;

/**
 * Provides unit tests to verify the expected behavior of Team's constructor and
 * toString method.
 * 
 * @author Spencer Dent
 * @version 2021-03-06
 */
public class TeamWhenCreateTeam {

	/**
	 * Tests the constructor to make sure that it is setting the instance variables
	 * as expected.
	 */
	@Test
	public void testTeamConstructorShouldCreateNewTeamWithProvidedFields() {
		Team heroes = new Team("Heroes", 10, 0);
		String actualOutput = heroes.toString();

		String expectedOutput = "The Heroes with 10 wins and 0 losses";
		assertEquals(expectedOutput, actualOutput);
	}

	/**
	 * Tests the constructor again to prevent the developer from hard-coding the
	 * return values.
	 */
	@Test
	public void testTeamConstructorAgainToPreventHardCoding() {
		Team villains = new Team("Villains", 0, 10);
		String actualOutput = villains.toString();

		String expectedOutput = "The Villains with 0 wins and 10 losses";
		assertEquals(expectedOutput, actualOutput);
	}
}
