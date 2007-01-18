package galapagos.tests;

import junit.framework.TestCase;
import galapagos.*;

public class GalapagosFinchTest extends TestCase {

	public void testGalapagosFinch1 () {
		// Checking new finch.
		GalapagosFinch fi1 = new GalapagosFinch(5, 10, 2, new Samaritan());
		assertTrue(fi1.age() == 0);
		assertTrue(fi1.hitpoints() == 5);
		assertTrue(fi1.behavior().toString().equals("Samaritan"));
		assertTrue(fi1.status() == FinchStatus.ALIVE);
		
		// Checking makeOlder and age.
		fi1.makeOlder();
		assertTrue(fi1.age() == 1);
		
		// Checking status.
		fi1.makeOlder();
		assertTrue(fi1.status() == FinchStatus.DEAD_AGE);
		
		// Checking changeHitPoints
		fi1.changeHitpoints(0);
		assertTrue(fi1.hitpoints() == 5);
		
		fi1.changeHitpoints(12);
		assertTrue(fi1.hitpoints() == 10);
		
		// Checking status (a finch that is both dead by
		// ticks and age has the status DEAD_TICKS).
		fi1.changeHitpoints(-10);
		assertTrue(fi1.status() == FinchStatus.DEAD_TICKS);
		
		GalapagosFinch fi2 = new GalapagosFinch(5,10,2,new Cheater());
		
		// Checking decide.
		assertTrue(fi1.decide(fi2) == fi1.behavior().decide(fi2));
	}
	
}