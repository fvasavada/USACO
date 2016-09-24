import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/*
ID: fagunv1
PROG: friday
LANG: JAVA
*/
public class friday {
	
	static int[] daysOfMnth = {0,
							31,28, // Jan, Feb
							31,30,
							31,30,
							31,31
							,30,31
							,30,31 //Nov, Dec
							};
	
	public static void main(String[] args) {
		Scanner input;
		try {
			input = new Scanner(new File("friday.in"));
			PrintWriter output = new PrintWriter("friday.out");
		
			int years = input.nextInt();
			//TO Calculate Judge the frequency of days for each
			// Day of the week, 
			int[] frequencyDays = new int [7];
			int currentdayInd=0;
			for(int i=1900; i < 1900+years; i++)
			{
				//For the Month of February, Calculate the leap year & 
				//Adjust the number of days
				daysOfMnth[2] = 28; //Default
				//Check for leap year
				if(i% 100==0){
					//Century years
					if(i%400 == 0)
					{
						//Leap Year
						daysOfMnth[2] = 29;
						
					}
				}else if (i%4==0)
				{
					//Leap Year
					daysOfMnth[2] = 29;
				}
				
				//Now that we have the number of days for each month
				//We can calculate the frequency of days of theweek
				for(int j =1;j<=12; j++){
					//For each Month of the year
					currentdayInd = (currentdayInd + 12)%7;
					frequencyDays[currentdayInd]++;
					//Account for the Start day of each month
					//Update the current day accordingly
					currentdayInd = (currentdayInd+daysOfMnth[j]-12)%7;
				}
			}
			
			//Print Saturday & Sunday
			output.print(frequencyDays[5]+ " " + frequencyDays[6]);
			//System.out.print(frequencyDays[5]+ " " + frequencyDays[6]);
			for(int i=0; i<5;i++)
			{
				output.print(" "+ frequencyDays[i]);
				//System.out.print(" "+ frequencyDays[i]);
			}
			
			output.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
