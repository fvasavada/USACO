import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
//)((()())())
public class cowfind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialization Statements
		try {
			//Input Statements
			Scanner input = new Scanner(new File("cowfind.in"));
			PrintWriter output = new PrintWriter("cowfind.out");
			//String inputSample = ")((()())())";
			String inputSample = input.next();
			//Code Logic
			int countLegs=0;
			int finalCount=0;
			//Check for Hind Legs
			for (int i = 0; i < inputSample.length()-1; i++) {
				if(inputSample.charAt(i)=='(' && inputSample.charAt(i+1)=='(')
				{
					//Found Hind legs
					countLegs++;
				}
				else if(inputSample.charAt(i)==')' && inputSample.charAt(i+1)==')')
				{
					//FOund Hind & Front
					finalCount+=countLegs;
				}
			}
			
			
			//Output Statements
			output.println(finalCount);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
