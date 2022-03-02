import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		printHangman();
		
		ArrayList<String> words = new ArrayList<String>();
	
		System.out.println("Welcome to Hangman, enter the number of words you would like to use.");
		int numOfWords =s.nextInt();
		
		System.out.println("Enter words you would like to used in the game.");
		for(int i=0; i<numOfWords; i++) {
			words.add(s.next());
		}
		
		Random r = new Random();
		int ind=r.nextInt(words.size());
		String word=words.get(ind);
		
		System.out.println("word is "+word.length()+" letters long");
		guesser(word);
		
	}
	public static void guesser(String word) {
		char[] letterGuess=new char[word.length()];
		String wordGuess=" ";
		
		while(true) {
		System.out.println("\nEnter letter or if you want to guess word, type in !");
		char letter=s.next().charAt(0);
		if(letter==('!')) {
			System.out.println("Enter word guess");
			wordGuess=s.next();
		}
	    if(wordGuess.equals(word)) {
			System.out.println("\nCorrect you win!");
			break;
		}
	   
	
		
		
		for(int i=0; i<word.length(); i++) {
			if(letter==word.charAt(i)) {
				letterGuess[i]=letter;
			}
			else {
				
			}
		}
		
		printWord(letterGuess);
		int count=0;
		for(int i=0; i<word.length(); i++) {
			if(letterGuess[i]==word.charAt(i)){
				count++;
			}
			
		}
		if(count==word.length()){
			System.out.println("\nCorrect you win!");
			break;
		}
	}
		
		
		
		}
	
	
	public static void printHangman() {

	}
		
		
		
		
		
		
		
	
	public static void printWord(char[] guess) {
		for(int i=0; i<guess.length; i++) {
			System.out.print(guess[i]+" ");
		}
	}
	public static void checkWord(char[] guess,String word) {
		int count=0;
		for(int i=0; i<word.length(); i++) {
			if(guess[i]==word.charAt(i)){
				count++;
			}
			
		}
		if(count==word.length()){
			System.out.println("Correct you win!");
			
		}
	}
	
}
	
	

