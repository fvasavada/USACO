import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class msched {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input;
		try {
			input = new Scanner(new File("msched.in"));
			PrintWriter output = new PrintWriter("msched.out");
			//Read Input
			int numCows = input.nextInt();
			int[] milkingCap = new int[numCows];
			int[] deadLines = new int[numCows];
			int[] schedule = new int[10001];
			//Read Miliking Cap & deadline
			for (int i = 0; i < numCows; i++) {
				milkingCap[i] = input.nextInt();
				deadLines[i] = input.nextInt();
			}
			for (int k = 0; k < numCows; k++) {
				int maxMilk=0,maxInd=0;
				//Step1:Look For the Cow with Max Milking cap
				for (int i = 0; i < numCows; i++) {
					
					if(maxMilk < milkingCap[i])
					{
						maxMilk = milkingCap[i];
						maxInd = i;
					}
				
				}
				//Remove the scheduled cow from the pool
				milkingCap[maxInd]=0;
				//Step2:Schdule the Cow based on deadline
				int scheduleInd = deadLines[maxInd];
				//Check if time quantum already filled
				while(schedule[scheduleInd] > 0)
				{
					scheduleInd --;
				}
				//If the Slot Is available, Schedule the cow for milking
				if(scheduleInd > 0)
				{
					schedule[scheduleInd] = maxMilk;
				}
			}
			//Calculate the Sum of Milking capacities 
			//of scheduled cows
			int totalMilkCap=0;
			for (int i = 0; i <= 10000; i++) {
				totalMilkCap += schedule[i];
			}
						
			output.println(totalMilkCap);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
