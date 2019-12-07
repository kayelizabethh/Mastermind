import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Mastermind {

	//properties==============================================================
	ArrayList<Character> secret;
	Scanner input = new Scanner(System.in);

	//constructor==============================================================

	//This creates a random "secret code" of letter R, B, G, Y, and V
	public Mastermind() {
		secret = new ArrayList<Character>();
		char peg;
		for(int i = 0; i < 4; i++) {
			Random rnd = new Random();
			int rndNum = rnd.nextInt(5)+1;
			switch(rndNum) {
			case 1: rndNum = 1;
			peg = 'R';
			secret.add(peg);
			break;
			case 2: rndNum = 2;
			peg = 'B';
			secret.add(peg);
			break;
			case 3: rndNum = 3;
			peg = 'V';
			secret.add(peg);
			break;
			case 4: rndNum = 4;
			peg = 'Y';
			secret.add(peg);
			break;
			case 5: rndNum = 5;
			peg = 'G';
			secret.add(peg);
			break;
			}

		}
	}

	//gameLoop()=====================================================================
	
	//This first half of the method that allows the user to input their guess
	public void gameLoop() {
		int counter = 0;
		int i = -1;
		//System.out.println(secret);  //may uncomment this to see the secret code
		while (i < 0) {
			ArrayList<Character> guesses = new ArrayList<Character>();
			System.out.println("Guess the colors the four pegs using the initals for Red, Green, Blue, Violet, or Yellow");
			String str = input.next();
			if(str.length() == 4 && !str.contains(" ")) {
				for(int j = 0; j < 4; j++) {
					guesses.add(str.charAt(j));
				}
			}
			
			/*this if statement checks to see if the input is valid
			 * if it is valid then it lists how many full right guesses there are
			 * and how many half right guesses there are
			 * it also counts the number of guesses it took
			 * */
			if(isGoodGuess(guesses) == true) {
				System.out.println("Your guess is " + guesses);
				counter++;
				if(numAllRight(guesses) == 4) {
					System.out.println("You won in " + counter + " guesses");
					//i = 0;
				} else {
					System.out.println("Number of all right " + numAllRight(guesses));
					System.out.println("Number of half right " + numHalfRight(guesses));
				}
			} else {
				System.out.println("Invalid Guess");
				System.out.println("An example of a valid guess is \'BYGB\' or \'YBBG\'\n");
			}
		}
	}

	//numAllRight()=====================================================================
	
	//this method is to see if the guess matches the secret code
	public int numAllRight(ArrayList<Character> guess) {
		int counter = 0;
		for(int i =0; i < guess.size(); i++) {
			if(guess.get(i) == secret.get(i)) {
				counter++;
			}
		}
		return counter;
	}

	//numHalfRight()=====================================================================
	
	//this methods lets the user know if their guess is half right
	//a half right guess is one that has the correct colours, just the wrong order
	public int numHalfRight(ArrayList<Character> guess) {
		ArrayList<Character> guessCopy = new ArrayList<Character>(guess);
		ArrayList<Character> secretCopy = new ArrayList<Character>(secret);
		for(int i = 0; i < guessCopy.size(); i++) {
			if(guessCopy.get(i) == secretCopy.get(i)) {
				guessCopy.remove(i);
				secretCopy.remove(i);
				i = -1;
			}
		}

		int counter = 0;
		for(int i= 0; i < guess.size(); i++) {
			if(guessCopy.contains('R') && secretCopy.contains('R')) {
				counter++;
				guessCopy.remove(guessCopy.indexOf('R'));
				secretCopy.remove(secretCopy.indexOf('R'));
			} 
			if(guessCopy.contains('G') && secretCopy.contains('G')) {
				counter++;
				guessCopy.remove(guessCopy.indexOf('G'));
				secretCopy.remove(secretCopy.indexOf('G'));
			} 
			if(guessCopy.contains('B') && secretCopy.contains('B')) {
				counter++;
				guessCopy.remove(guessCopy.indexOf('B'));
				secretCopy.remove(secretCopy.indexOf('B'));
			} 
			if(guessCopy.contains('V') && secretCopy.contains('V')) {
				counter++;
				guessCopy.remove(guessCopy.indexOf('V'));
				secretCopy.remove(secretCopy.indexOf('V'));
			} 
			if(guessCopy.contains('Y') && secretCopy.contains('Y')) {
				counter++;
				guessCopy.remove(guessCopy.indexOf('Y'));
				secretCopy.remove(secretCopy.indexOf('Y'));
			} 

		}
		return counter;
	}

	//isGoodGuess()=====================================================================
	
	//this method tells the user if their guess is valid
	public boolean isGoodGuess(ArrayList<Character> guess) {
		int counter = 0;
		for(int i = 0; i < guess.size(); i++) {
			if(guess.get(i) =='R' || 
					guess.get(i) =='G'||
					guess.get(i) =='Y'||
					guess.get(i) =='B'||
					guess.get(i) =='V') {
				counter++;
			}
		}

		if (counter == 4) {
			counter = 0;
			return true;
		} else {
			counter = 0;
			return false;
		}
	}
}
