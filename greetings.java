import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class greetings {
	/*
	 * KEy Points
	 * Each STep could be either L o R
	 * Loop through each step that cow takes per unit time
	 * & check for number of Crossings
	 * 
	 */
	static char bmoves[], emoves[]; //Track Movements of each cow
	static int maxVal =1000000; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input;
		try {
			input = new Scanner(new File("greetings.in"));
			PrintWriter output = new PrintWriter("greetings.out");
			//Number of Lines of sample inputs of each cow
			int blines = input.nextInt();
			int elines = input.nextInt();
			//Initialize direction arrays
			bmoves = new char[maxVal];
			emoves = new char[maxVal];
			//init Number of steps of each cow/ Keep track of the Steps
			int bsteps=0,esteps=0;
			//Read Bessie's Steps
			for (int i = 0; i < blines; i++) {
				int step = input.nextInt();
				String dir =  input.next();
				for (int j = 0; j < step; j++) {
					bmoves[bsteps++] = dir.charAt(0);
				}
			}
			//Read Elsie's steps
			for (int i = 0; i < elines; i++) {
				int step = input.nextInt();
				String dir =  input.next();
				for (int j = 0; j < step; j++) {
					emoves[esteps++] = dir.charAt(0);
				}
			}
			//Simulation Problem
			//Intoduce old & new position varibales
			//Mover Left -- > -1
			//Mover Right --> +1
			int numMeetings = 0;
			int oldbpos=0, oldepos=0, newepos=0, newbpos=0;
			//Run for Max Steps
			for (int i = 0; i < Math.max(bsteps, esteps); i++) {
				//Bessie OCw Movements
				if(bmoves[i]== 'L')
				{
					newbpos = oldbpos - 1;
				}else if(bmoves[i] == 'R')
				{
					newbpos = oldbpos + 1;
				}
				//Elsie Cow <ovements
				if(emoves[i]== 'L')
				{
					newepos = oldepos - 1;
				}else if(emoves[i] == 'R')
				{
					newepos = oldepos + 1;
				}
				
				//Conditional Checks to determine the meetings
				//Case I
				if(newbpos == newepos)
				{
					if(oldbpos != oldepos)
					{
						numMeetings++;
					}
					
				}
				//CASEII
				else if((newbpos == oldepos) && (newepos == oldbpos))
				{
					numMeetings++;
				}
				//Update The Old Positions 
				oldepos = newepos;
				oldbpos = newbpos;
				
			}
			
	
			output.println(numMeetings);
			output.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
/*
4 5
3 L
5 R
1 L
2 R
4 R
1 L
3 L
4 R
2 L
*/