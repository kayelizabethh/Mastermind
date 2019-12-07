public class Instructions {
	public void string() {
		System.out.println("Welcome to Mastermind."
				+"This is a text version of the board game 'Mastermind' \n"
				+"The computer will generate a secret code which consists of four different pegs\n"
				+"The pegs may be red, blue, green, violet, or yellow\n"
				+ "We represent these colors with their first inital\n"
				+"(R) - Red, (B) - Blue, (G) - Green, (Y) - Yellow, (V) - Violet\n"
				+"\nA color may appear more than once\n"
				+"Your goals is to guess the secret code of the four colours\n"
				+"After you make a guess you will be given two hints\n" 
				+"The first hint tells you how many pegs you have that are the right colour and in the right spot"
				+ "The next hint tells you if you are half right, this means you have the right color, just wrong spot\n");
		}
}
