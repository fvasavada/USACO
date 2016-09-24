import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class mirror {
	static int n,m;
	static char mirrors[][];
	static int RIGHT = 0;
	static int LEFT = 1;
	static int UP = 2;
	static int DOWN = 3;
	static int maxReflections;
	//Target direction Possibilities
	static int target[][] = {
			{DOWN,UP},
			{UP,DOWN},
			{LEFT,RIGHT},
			{RIGHT,LEFT},
				};
	
	public static void main(String[] args) {
		
		/*
		 * Beam Direction, mirror position--> direction
		 * 	right / --> up
		 * right \ --> down
		 * left / --> down
		 * left \ --> up
		 * up / --> right 
		 * up \ --> left
		 * down \ --> right
		 * down / --> left
		 * 
		 */
		
		Scanner input;
		try {
			input = new Scanner(new File("mirror.in"));
			PrintWriter output = new PrintWriter("mirror.out");
			//Read the input
			n = input.nextInt();
			m = input.nextInt();
			mirrors = new char[n][m];
			//Read Mirror Positions nxm matrix
			for (int i = 0; i < n; i++) {
				String temp = input.next();
				for (int j = 0; j < m; j++) {
					mirrors[i][j] = temp.charAt(j);
				}
			}
			//Get Target Directions
			//Left & Right boundaries
			for (int i = 0; i < n; i++) {
				getReflection(i,0,RIGHT);
				getReflection(i,m-1,LEFT);
			}
			//Top & bottom boundaries
			for (int i = 0; i < m; i++) {
				getReflection(0,i,DOWN);
				getReflection(n-1,i,UP);
			}
			//Write output to file
			output.println(maxReflections);
			output.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * Method to compute maximum possible reflections
	 * @param: 
	 * r: row index
	 * c: column index
	 * dir: direction of incident ray
	 */
	private static void getReflection(int r, int c, int dir) {
		int localCount=0;
		//While Within Bounds
		while(!(r < 0 || c < 0 || r>=n || c >=m))
		{
				//The Logic to count Reflections
				localCount ++;
				//Get the Mirror  index
				int mirrorInd = (mirrors[r][c] == '\\' ? 0 : 1);
				
				//Update the reflection direction 
				//for next iteration
				dir = target[dir][mirrorInd];
				//Adjust the Mirror Iteration Index
				if(dir == RIGHT)
					c++;
				else if(dir == LEFT)
					c--;
				else if(dir == UP)
					r--;
				else
					r++;		
			}
			//Update Global Max
			if(maxReflections < localCount)
			{
				maxReflections =localCount;
			}

		
	}
//For reference
//	private static int getTargetDir(int direction, char pos)
//	{
//		if(direction == RIGHT){
//			if(pos == '\\')
//				return DOWN;
//				else
//					return UP;
//		}
//		if(direction == LEFT){
//			if(pos == '\\')
//				return UP;
//				else
//					return DOWN;
//		}
//		if(direction == UP){
//			if(pos == '\\')
//				return LEFT;
//				else
//					return RIGHT;
//		}
//		if(direction == DOWN){
//			if(pos == '\\')
//				return RIGHT;
//				else
//					return LEFT;
//		}
//		
//		return m;
//	}	
	
}
