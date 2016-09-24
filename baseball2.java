//there's probably a faster way to do this, but I don't know it
import java.io.*;
import java.util.*;

class baseball{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("baseball.in"));
		PrintWriter out = new PrintWriter(new FileWriter("baseball.out"));
		int N = Integer.parseInt(br.readLine());
		int cows[] = new int[N];
		for (int i = 0; i<N; i++){
			cows[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(cows); // only have to iterate after current
		//System.out.println(Arrays.toString(cows));
		int xy = 0;
		int yz = 0;
		int count = 0;
		for (int i = 0; i<N-2; i++){
			
			for (int j = i+1; j<N-1; j++){
				xy = cows[j] - cows[i];
				for (int k = j+1; k<N; k++){
					//System.out.println(cows[i] + " " + cows[j] + " " + cows[k]);
					yz = cows[k] - cows[j];
					if (xy<=yz && yz<=2*xy){
						count++;
					}
				}
			}
		}
		System.out.println(count);
		out.println(count);
		out.flush();
		out.close();
	}
}