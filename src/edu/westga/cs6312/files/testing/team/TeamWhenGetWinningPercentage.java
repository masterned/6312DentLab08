package edu.westga.cs6312.files.testing.team;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.Team;

/**
 * Provides unit tests to verify the expected behavior of Team's
 * getWinningPercentage method.
 * 
 * @author Spencer Dent
 * @version 2021-03-08
 */
public class TeamWhenGetWinningPercentage {

	/**
	 * Test the case where the team has only won. It should return 1.0.
	 */
	@Test
	public void testGetWinningPercentageOnTeamThatHasOnlyWonShouldReturn1() {
		Team heroes = new Team("Heroes", 10, 0);
		double actualWinningPercentage = heroes.getWinningPercentage();

		assertEquals(1.0, actualWinningPercentage);
	}

	/**
	 * Tests the case where the team has only lost. It should return 0.0.
	 */
	@Test
	public void testGetWinningPercentageOnTeamThatHasOnlyLostShouldReturn0() {
		Team villains = new Team("Villains", 0, 10);
		double actualWinningPercentage = villains.getWinningPercentage();

		assertEquals(0.0, actualWinningPercentage);
	}

	/**
	 * Tests the case where the team has the same number of wins as losses. It
	 * should return 0.5.
	 */
	@Test
	public void testGetWinningPercentageOnTeamWithEqualWinsAndLossesShouldReturn0Point5() {
		Team thanos = new Team("Thanos", 5, 5);
		double actualWinningPercentage = thanos.getWinningPercentage();
		
		assertEquals(0.5, actualWinningPercentage);
	}

	/**
	 * Tests the case where the team should return an irrational value.
	 */
	@Test
	public void testGetWinningPercentageWhenItShouldReturnAnIrrationalValue() {
		Team doubles = new Team("Double", 4, 2);
		double actualWinningPercentage = doubles.getWinningPercentage();

		assertEquals(0.666, actualWinningPercentage, 3);
	}

	/**
	 * Tests the case where the total number of games played is zero (resulting in
	 * weirdness to to how floating point numbers handle division by zero). It
	 * should return 0.0.
	 */
	@Test
	public void testGetWinningPercentageWhenTotalNumberOfGamesIs0ShouldReturn0() {
		Team noGames = new Team("No Games", 0, 0);
		double actualWinningPercentage = noGames.getWinningPercentage();

		assertEquals(0.0, actualWinningPercentage);
	}
}
