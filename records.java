import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class records {
	/*
	 * Read n Loop through the input file Read the # names in a Group as a
	 * string Save these in a n array groups[] FOr each Group Check the # of
	 * occurrences keep track of the Frequency of occrances
	 */
	static int numOfGroups;
	static String groups[];
	static int maxCount;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input;
		try {
			input = new Scanner(new File("records.in"));
			PrintWriter output = new PrintWriter("records.out");
			numOfGroups = input.nextInt();
			// Init The Array
			groups = new String[numOfGroups];
			String cow1, cow2, cow3;
			for (int i = 0; i < numOfGroups; i++) {
				cow1 = input.next();
				cow2 = input.next();
				cow3 = input.next();
				// Sort these names & then Fill the groups[] array
				groups[i] = sort(cow1, cow2, cow3);
			}
			// Check the Count of groups
			for (int i = 0; i < numOfGroups; i++) {
				int matachedCount=1;
				for (int j = i+1; j < numOfGroups; j++) {
					if(groups[i].equals(groups[j]))
					{
						matachedCount++;
					}
				}
				//update global maximum
				if(matachedCount > maxCount)
				{
					maxCount = matachedCount;
				}
			}
			

			output.println(maxCount);
			output.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String sort(String n1, String n2, String n3) {
		// n1 is the greatest
		if (n1.compareTo(n2) > 0 && n1.compareTo(n3) > 0) {
			return n1 + " " + (n2.compareTo(n3) > 0 ? n2 + " " + n3 : n3 + " " + n2);
		}
		// n2
		if (n2.compareTo(n1) > 0 && n2.compareTo(n3) > 0) {
			return n2 + " " + (n1.compareTo(n3) > 0 ? n1 + " " + n3 : n3 + " " + n1);
		}
		// n3
		if (n3.compareTo(n1) > 0 && n3.compareTo(n2) > 0) {
			return n3 + " " + (n2.compareTo(n1) > 0 ? n2 + " " + n1 : n1 + " " + n2);
		}

		return "";
	}

}
