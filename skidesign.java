import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class skidesign {
	static int numOfHills;
	static int elevation[];
	static int minCost;

	public static void main(String[] args) {

		Scanner input;
		try {
			input = new Scanner(new File("skidesign.in"));
			PrintWriter output = new PrintWriter("skidesign.out");
			// Read Input
			numOfHills = input.nextInt();
			elevation = new int[numOfHills];
			for (int i = 0; i < numOfHills; i++) {
				elevation[i] = input.nextInt();
			}

			// Compute the Min cost
			// Cases: 0-17; 1-18; 2-19 ..... 83-100
			// For each category, compute the cost of
			// Modifying heights
			minCost = computeCost(0, 17);
			for (int i = 1; i <= 83; i++) {
				int cost = computeCost(i, i + 17);
				// Update Global min
				if (cost < minCost)
					minCost = cost;
			}

			output.println(minCost);
			output.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int computeCost(int minH, int maxH) {
		//For each elevation, Evaluate the current case
		int runningCost=0, delta=0;
		
		for (int j2 = 0; j2 < numOfHills; j2++) {
			//If Elevation is less than the minH
			if(elevation[j2]<minH)
			{
				delta = minH - elevation[j2];
				runningCost += delta * delta;
			}
			//If Elevation is maximum than the maxH
			if(elevation[j2]>maxH)
			{
				delta = elevation[j2] - maxH;
				runningCost += delta * delta;
			}
		}
		
		return runningCost;
	}

}
