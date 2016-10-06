package del1;

public class Dice {
	/**
	 * Roll a 6 sided dice returning a value between 1 and 6.
	 * @return
	 */
	public int roll() {
		// vi caster Math.random double til int. Vi adderer 1 til at starte med så randomnumber ikke kan blive 0.
		int randomnumber= (int)(Math.random()*6+1);
		return randomnumber;
	}

}
