import java.util.*;
import java.io.*;

public class scode {

	public static void main(String[] args) throws Exception {

		Scanner stdin = new Scanner(new File("scode.in"));
		String s = stdin.next();

		// Solve and write out the result.
		FileWriter fout = new FileWriter(new File("scode.out"));
		fout.write((solve(s, 0))+"\n");
		fout.close();
	}

	// Wrapper function.
	public static int solve(String s, int countIt) {

		// Here is what we count.
		int n = s.length();
		if (n%2 == 0) return countIt;

		// Whether or not we count it!
		int res = countIt;

		// Recursively solve relevant substrings, only making second recursive call, if necessary.
		int left = solve(s.substring(0, n/2+1),1);
		int right = s.substring(n/2).compareTo(s.substring(0, n/2+1)) == 0 ? left : solve(s.substring(n/2),1);

		// Prepend last (n-1)/2 or append first (n-1)/2
		if (s.substring(n/2+1).equals(s.substring(0, n/2)))
			res += (left+right);

		// Prepend first (n-1)/2.
		if (s.substring(n/2, n-1).equals(s.substring(0, n/2)))
			res += right;

		// Append last (n-1)/2
		if (s.substring(1, n/2+1).equals(s.substring(n/2+1)))
			res += left;

		// We're done!
		return res;
	}
}
