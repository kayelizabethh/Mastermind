/*
 * Kay Harper, harperke
 * The java version of the board game, Mastermind
 * Created Spring of 2018 for an extra credit assignment for CSE271
 */
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Instructions i = new Instructions();
		Mastermind m = new Mastermind();
		System.out.println("If you need instructions press 'i'\n else press 'p' to play the game");
		Scanner input = new Scanner(System.in);
		String choice = input.next();
		if(choice.equals("i")) {
			i.string();	
			m.gameLoop();
			System.out.println("The game of Mastermind will be begin");
		} else if(choice.equals("p"))
			m.gameLoop();
	}
}
