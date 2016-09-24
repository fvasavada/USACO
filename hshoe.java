import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class hshoe {
	static char shoePos[][];
	static int size;
	static int maxLength;

	public static void main(String[] args) {
		Scanner input;
		try {
			input = new Scanner(new File("gift1.in"));
			PrintWriter output = new PrintWriter("gift1.out");
			size = input.nextInt();
			// init Array
			shoePos = new char[size][size];
			// Read the Input Field Hshoes
			for (int r = 0; r < size; r++) {
				String temp = input.next();
				for (int c = 0; c < size; c++) {
					shoePos[r][c] = temp.charAt(c);
				}
			}
			// Call Function to Find max balanced path length
			searchOpen(0, 0, 0);

			// Output
			output.println(maxLength);
			output.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void searchOpen(int x, int y, int currentOpenLength) {
		// Boundary COndition
		if (x < 0 || y < 0 || x >= size || y >= size)
			return;
		// If visited
		if (shoePos[x][y] == ' ')
			return;
		// Closing Brace encountered
		if (shoePos[x][y] != '(') {
			// Look for Matching Close braces
			searchClose(x, y, currentOpenLength, 0);
		}
		//Do only for ( brace
		if(shoePos[x][y] == '(')
		{
			// Recursive Step
			shoePos[x][y] = ' ';
			searchOpen(x - 1, y, currentOpenLength + 1);
			searchOpen(x + 1, y, currentOpenLength + 1);
			searchOpen(x, y - 1, currentOpenLength + 1);
			searchOpen(x, y + 1, currentOpenLength + 1);
			shoePos[x][y] = '(';
		}
		

	}

	private static void searchClose(int x, int y, int currentOpenLength, int currentClosedLength) {
		// Set Max Length
		if ((currentClosedLength == currentOpenLength) && (currentClosedLength + currentOpenLength > maxLength)) {
			maxLength = currentClosedLength + currentOpenLength;
		}
		// Boundary COndition
		if (x < 0 || y < 0 || x >= size || y >= size)
			return;
		// Closing Brace encountered
		if (shoePos[x][y] != ')') {
			// Go Back & Keep Looking for Open Braces
			return;
		}
		// Recursive step
		shoePos[x][y] = ' ';
		searchClose(x - 1, y, currentOpenLength, currentClosedLength + 1);
		searchClose(x + 1, y, currentOpenLength, currentClosedLength + 1);
		searchClose(x, y - 1, currentOpenLength, currentClosedLength + 1);
		searchClose(x, y + 1, currentOpenLength, currentClosedLength + 1);
		shoePos[x][y] = ')';

	}

}
