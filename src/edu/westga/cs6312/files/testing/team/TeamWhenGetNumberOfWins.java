package edu.westga.cs6312.files.testing.team;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.Team;

/**
 * Provides unit tests to verify the expected behavior of Team's getNumberOfWins
 * method. It should return the number of wins stored in the object.
 * 
 * @author Spencer Dent
 * @version 2021-03-08
 */
public class TeamWhenGetNumberOfWins {

	/**
	 * Tests getNumberOfWins to make sure it returns the object's stored number of
	 * wins.
	 */
	@Test
	public void testGetNumberOfWinsOnNewTeamShouldReturnStoredNumberOfWins() {
		Team heroes = new Team("Heroes", 10, 0);
		int actualNumberOfWins = heroes.getNumberOfWins();

		assertEquals(10, actualNumberOfWins);
	}

	/**
	 * Tests getNumberOfWins again with a different object in order to guarantee
	 * that the developer did not hard-code the result of the first test.
	 */
	@Test
	public void testGetNumberOfWinsAgainToPreventHardCoding() {
		Team villains = new Team("Villains", 0, 10);
		int actualNumberOfWins = villains.getNumberOfWins();

		assertEquals(0, actualNumberOfWins);
	}
}
