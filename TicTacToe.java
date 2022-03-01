import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	 Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		
		char[][] gb= {{' ','|',' ','|',' '},
				  {'-','+','-','+','-'},
			      {' ','|',' ','|',' '}, 
			      {'-','+','-','+','-'},
			      {' ','|',' ','|',' '}
	};
		printGB(gb);
		
		while (true) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your placement 1-9");
		int pos=scan.nextInt();
		while (playerPositions.contains(pos) || cpuPositions.contains(pos)) {
			System.out.println("Position taken");
			
			pos=scan.nextInt();
			
			

		}
		
		playerpos(gb,pos,"player");
		
		
		Random rand=new Random();
		int cpuPos=rand.nextInt(9)+1;
		while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
			System.out.println("Position taken");
			
			cpuPos=rand.nextInt(9)+1;
			
			

		}
		
		
		playerpos(gb,cpuPos,"cpu");
		printGB(gb);
		
		String result=checkWinner();
		
			System.out.println(result);
		
		
		
		
	 }
		
		
		
		
		

	}
	
	public static void printGB(char[][] gb) {
		
		for(char[] row:gb) {
			for(char c:row) { 
				System.out.print(c);
			}
			System.out.println();
		}
		
	}
	public static void playerpos(char[][] gb,int pos,String playerType) {
		char let=' ';
		if(playerType.equals("player")) {
			let='X';
			playerPositions.add(pos);
		}else if(playerType.equals("cpu")) {
			let='O';
			cpuPositions.add(pos);
		}
		switch(pos) {
			case 1:
				gb[0][0]=let;
				break;
			case 2:
				gb[0][2]=let;
				break;
			case 3:
				gb[0][4]=let;
				break;
			case 4:
				gb[2][0]=let;
				break;
			case 5:
				gb[2][2]=let;
				break;
			case 6:
				gb[2][4]=let;
				break;
			case 7:
				gb[4][0]=let;
				break;
			case 8:
				gb[4][2]=let;
				break;
			case 9:
				gb[4][4]=let;
				break;
			default:
				break;
			}
			
	}
	public static String checkWinner() {
		
		
		List topRow= Arrays.asList(1,2,3);
		List midRow=Arrays.asList(4,5,6);
		List botRow=Arrays.asList(7,8,9);
	    List leftCol=Arrays.asList(1,4,7);
		List midCol=Arrays.asList(2,5,8);
		List rightCol=Arrays.asList(3,6,9);
		List diag1=Arrays.asList(1,5,9);
		List diag2=Arrays.asList(3,5,7);
		
		
		List<List> winning=new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(diag1);
		winning.add(diag2);
		
		for(List l: winning) {
			if(playerPositions.containsAll(l)) {
			return "player is winner";
			
		}else if(cpuPositions.containsAll(l)) {
			return "cpu is winner";
		}else if(playerPositions.size()+cpuPositions.size()==9){
			return "no one wins";
		}
		
		
		
		}
		return "";
		
		
		
		
	
	}
	
}


