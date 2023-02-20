import java.util.Scanner;
// It is a console based project using OOPs concepts.
// Identify the objects:-
// there are 3 objects - guesser, umpire, player(all 3 does the same work)
// every object has some state and behaviour

// Guesser - it guesses the number and gives to the umpire 
class Guesser
{
	// variables are used to store number here
	// state is defined by variables and datatypes
	// behaviour is defined by methods
	int guessNum;
	
	// method here defines the behaviour/task done by the object
	public int guessNumber()
	{
		Scanner scan1=new Scanner(System.in);
		
		System.out.println("Guesser kindly guess the number");
		guessNum=scan1.nextInt();
		return guessNum;	
		
	}	

}

class Player
{
	int pguessNum;
	
	public int guessNumber()   // same method name as above called as method overloading
	{
		Scanner scan2=new Scanner(System.in);
		System.out.println("Player kindly guess the number");
		pguessNum=scan2.nextInt();
		return pguessNum;
	}
}

class Umpire
{
	
	int numFromGuesser;
	int numFromPlayer1;
	int numFromPlayer2;
	int numFromPlayer3;
	
	
	public void collectNumFromGuesser()
	{
		// since we want to call the method from guesser class we are creating its object here
		Guesser g=new Guesser();
		numFromGuesser=g.guessNumber();
		
	}
	
	
	public void collectNumFromPlayer()
	{
		Player p1=new Player();
		Player p2=new Player();
		Player p3=new Player();
		
		
		numFromPlayer1=p1.guessNumber();
		numFromPlayer2=p2.guessNumber();
		numFromPlayer3=p3.guessNumber();
	}
	
	void compare()
	{
		
		if(numFromGuesser==numFromPlayer1)
		{
			if(numFromGuesser==numFromPlayer2 && numFromGuesser==numFromPlayer3)
			{
				System.out.println("Game tied all three players guessed correctly");
			}
			else if(numFromGuesser==numFromPlayer2)
			{
				System.out.println("Player 1 and Player2 won the game");
			}
			else if(numFromGuesser==numFromPlayer3)
			{
				System.out.println("Player 1 and Player3 won ");
			}
			else
			{
			
			System.out.println("Player 1 won the game");
			}
		}
		
		
		else if(numFromGuesser==numFromPlayer2)
		{
			
			if(numFromGuesser==numFromPlayer3)
			{
			System.out.println("Player 2 and Player3 won the game");
			}
			else
			{
				System.out.println("Player 2 won the game");
			}
		}
		
		
		
		else if(numFromGuesser==numFromPlayer3)
		{
			System.out.println("Player 3 won the game");
		}
		else
		{
			System.out.println("Game lost! try again");
		}
	}
	
}


	public class Game {

	public static void main(String[] args) {
	
		Umpire u=new Umpire();
		System.out.println("Game Started");
		u.collectNumFromGuesser();
		u.collectNumFromPlayer();
		u.compare();
		System.out.println("Game Ended");

	}

}