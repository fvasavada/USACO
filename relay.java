import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class relay {
	static int numCows;
	
	static int receivers[];
	static char status[];
	
	public static void main(String[] args) {
		Scanner input;
		try {
			input = new Scanner(new File("relay.in"));
			PrintWriter output = new PrintWriter("relay.out");
			numCows = input.nextInt();
			//Init
			receivers = new int[numCows+1];
			status = new char [numCows+1];
			//Read the input
			for (int i = 1; i <= numCows; i++) {
				receivers[i] = input.nextInt();
			}
			//Check For the loops
			int nonLoopy=0;
			for (int i = 1; i <= numCows; i++) {
				for (int j = 1; j <= numCows; j++) {
					status[j] =  'U';
				}
				
				//Traverse & check for loops
				if(isLoopy(i) == false)
				{
					nonLoopy++;
				}
				
			}
			
			output.println(nonLoopy);
			output.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean isLoopy(int i) {
//		while(true)
//		{
			//Mark Visited
			status[i] = 'V';
			//Check If the Cow sends out message to no other cows
			//Boundary COndition
			if(receivers[i] == 0 )
			{
				return false;
			}
			///What if the COw is visited ? // Boundary Condition
			if(status[receivers[i]] == 'V')
			{
				//If Already visted Mark loopy
				return true;
			}else
				return isLoopy(receivers[i]);
			//If The Boundary  condiiton are false --> Implies, current cow non loopy
			//Move on to the next receiver in the message chain
//			i = receivers[i];
//		}
		
	}

}
/*
5
0
4
1
5
4
*/