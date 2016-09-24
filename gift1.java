import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: fagunv1
PROG: gift1
LANG: JAVA
*/

public class gift1 {
	/*
	 * 1. Handle Names using Arrays
	 * 2. Initial Money Reserve to be handled using Arrays too
	 * Read the Input
	 *  3.Read the # of friends - line 1
	 *  4.Read the NAmes of the Friends involved & fill the names array, names[]
	 *  5. Read the Giver Name, giverNm
	 *  6. Read INitail Money Reserve, startMoney
	 *  7. Read the # of receivers, numReceivers 
	 *  8. Read the names of receivers, based on Step 7
	 *  
	 *  
	 */
	static int numOfFriends=0;
	static String[] names;
	static int[] initialReserve;
	static int[] netBalanceArray;
	
	public static void main(String[] args) {
		Scanner input;
		try {
			input = new Scanner(new File("gift1.in"));
			PrintWriter output = new PrintWriter("gift1.out");
			//#3
			numOfFriends = input.nextInt();
			//#4
			names = new String[numOfFriends];
			for(int i=0;i<numOfFriends;i++)
			{
				names[i] = input.next();
			}
			//Init
			initialReserve = new int[numOfFriends];
			netBalanceArray = new int[numOfFriends];
			//Get the Transaction Details
			for (int i = 0; i < numOfFriends; i++) {
				
				//Read the Gifter
				String gifter = input.next();
				//Read the initial money to be gifted
				int gifterIndex = getIndex(gifter);
				
				initialReserve[gifterIndex] = input.nextInt();
				//Read the Number of receivers
				int numofReceivers = input.nextInt();
				//If Number of receivers are NULL
				if(numofReceivers==0)
					continue;
				//Calculate Gift Amount
				int giftAmt = initialReserve[gifterIndex]/numofReceivers;
				//Put the Remainder of money in gifters account
				//incase of fractions
				
				netBalanceArray[gifterIndex] += initialReserve[gifterIndex] % numofReceivers;
				
				//Distribute the money to the receivers
				for (int j = 0; j < numofReceivers; j++) {
					//Read the receiver
					String receivers = input.next();
					//Allocate the money
					netBalanceArray[getIndex(receivers)] += giftAmt;
				}
				
			}
			
			//Print the Output
			for (int i = 0; i < numOfFriends; i++) {
				output.println(names[i]+' '+(netBalanceArray[i]-initialReserve[i]));
			}
			
			//output.println("");
			output.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int getIndex(String gifter) {
		// TODO Auto-generated method stub
		for (int i = 0; i < numOfFriends; i++) {
			//Find the name index
			if(gifter.equals(names[i]))
			{
				return i;
			}
		}
		
		return 0;
	}

}


/*
		5
		dave
		laura
		owen
		vick
		amr
		dave
		200 3
		laura
		owen
		vick
		owen
		500 1
		dave
		amr
		150 2
		vick
		owen
		laura
		0 2
		amr
		vick
		vick
		0 0 */