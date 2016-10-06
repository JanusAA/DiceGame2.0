package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import del1.Dice;
import del1.DiceCup;

public class JUnittest {

	Dice d1;
	Dice d2;

	DiceCup d6;

	@Before
	public void setUp() throws Exception {
		d1 = new Dice();
		d2 = new Dice();
		d6 = new DiceCup();
	}


	@After
	public void tearDown() throws Exception {
		d1 = null;
		d2 = null; 
		d6 = null;
	}

	/*
	 * Tester om responstiden er under 333 ms for slag med raflebæger.
	 */
	@Test 
	public void testRollDiceCup() {
		d6.rollDiceCup();
		//System.out.println(d6.rollDiceCup());
	}
	
	@Test
	/* Vi tester om vores DiceCup er pålidelig i forhod
	 * til det teoretiske udfald af slag med to terninger.
	 * Vi har sat vores fejlmargin til 4%.
	 * Dvs. vi forventer et udfald mellem et max og min neveau.
	*/
	public void testRollDiceCupWORules() {
		
		int  two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0, ten = 0, eleven = 0, twelve = 0;
		
		d6.rollDiceCupWORules();
		for (int i=1; i<110001; i++) {
			int roll = d6.rollDiceCupWORules();
			
			if (roll == 2){
				two ++;
			}
			else if (roll == 3){
				three ++;
			}
			else if (roll == 4){
				four ++;
			}
			else if (roll == 5){
				five ++;
			}
			else if (roll == 6){
				six ++;
			}
			else if (roll == 7){
				seven ++;	
			}
			else if (roll == 8){
				eight ++;
			}
			else if (roll == 9){
				nine ++;
			}
			else if (roll == 10){
				ten ++;
			}
			else if (roll == 11){
				eleven ++;
			}
			else if (roll == 12){
				twelve ++;
			}
			
		}
		
		
		assertTrue("Error " + two, 3180 >= two); 
		assertTrue("Error " + two, 2936 <= two);

		assertTrue("Error " + three, 6361 >= three); 
		assertTrue("Error " + three, 5871 <= three);

		assertTrue("Error " + four, 9530 >= four); 
		assertTrue("Error " + four, 8796 <= four);

		assertTrue("Error " + five, 12710 >= five); 
		assertTrue("Error " + five, 11732 <= five);

		assertTrue("Error " + six, 15890 >= six); 
		assertTrue("Error " + six, 14658 <= six);
		
		assertTrue("Error " + seven, 19070 >= seven); 
		assertTrue("Error " + seven, 17604 <= seven);
		
		assertTrue("Error " + eight, 15890 >= eight); 
		assertTrue("Error " + eight, 14668 <= eight);
		
		assertTrue("Error " + nine, 12710 >= nine); 
		assertTrue("Error " + nine, 11732 <= nine);
		
		assertTrue("Error " + ten, 9530 >= ten); 
		assertTrue("Error " + ten, 8796 <= ten);
		
		assertTrue("Error " + eleven, 6361 >= eleven); 
		assertTrue("Error " + eleven, 5871 <= eleven);
		
		assertTrue("Error " + twelve, 3180 >= twelve); 
		assertTrue("Error " + twelve, 2936 <= twelve);
		
}

	/**
	 * Tester om raflebægeret er pålideligt, dvs. tester om der kan slås 1000 slag uden fejl hænder. 
	 */
	@Test
	public void testRollDiceCupMultipleTimes() {
		for (int i=1; i<1001; i++) {
			d6.rollDiceCup();
			//System.out.println(d6.rollDiceCup());
			
		}	
	
	
	}
}
