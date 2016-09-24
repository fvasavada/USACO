import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: fagunv1
PROG: ride
LANG: JAVA
 */

public class ride {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//Initialization Statements
			Scanner input = new Scanner(new File("ride.in"));
			PrintWriter output = new PrintWriter("ride.out");
			//Read input from file
			String str1 = input.next();
			String str2 = input.next();
			//Compare the strings
			if(convert(str1.toUpperCase()) == convert(str2.toUpperCase()))
			{
				output.println("GO");
			}else
			{
				output.println("STAY");
			}
			
			output.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int convert(String str) {
		// TODO Auto-generated method stub
		int result=1;
		//COMET
		for(int i=0;i<str.length();i++ )
		{
			result = result * (str.charAt(i) - 'A' + 1);
		}
		
		return result%47;
	}

}
