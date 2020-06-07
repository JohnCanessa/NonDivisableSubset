import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/*
 * 
 */
public class Solution {

	/*
	 * complete this function
	 */
    static int nonDivisibleSubset(int k, int[] S) {
    	
//    	// ???? ????
//    	System.out.println("k: " + k);
//    	System.out.print("S: ");
//    	for (int s : S)
//    		System.out.print(s + " ");
//    	System.out.println("\n");
    	
    	// **** declare and populate array of remainders ****
    	int[] remainderArr = new int[k];
    	
    	for (int n : S) {
    		
    		// ???? ????
    		System.out.println("n % k (" + n + " % " + k + "): " + n % k);
    		
    		remainderArr[n % k]++;
    	}
    	
    	// ???? ????
    	System.out.print("remainderArr: ");
    	for (int s : remainderArr)
    		System.out.print(s + " ");
    	System.out.println("\n");

    	// **** set initial number of elements in the subset ****
    	int zeroRemainder = remainderArr[0];
    	
    	// ???? ????
    	System.out.println("        zeroRemainder: " + zeroRemainder);
    	
    	// **** consider only one of the numbers ****
    	int numOfElementsInSubset = (zeroRemainder > 0) ? 1 : 0;
    	
    	// ???? ????
    	System.out.println("numOfElementsInSubset: " + numOfElementsInSubset + "\n");
    	 	
    	// **** ****
        for (int i = 1; i <= (k / 2); i++) {
        	
        	// ???? ????
        	System.out.println("i: " + i + " k - i: " + (k - i));
        	
        	// **** ****
            if (i != k - i) {
                numOfElementsInSubset += Math.max(remainderArr[i], remainderArr[k - i]);
            } else {
                numOfElementsInSubset++;
            }

            // ???? ????
            System.out.println("numOfElementsInSubset: " + numOfElementsInSubset);
        }
        
        // **** return the number of elements in the subset ****
        return numOfElementsInSubset;
    }

    
    private static final Scanner scanner = new Scanner(System.in);
    
    /*
     * test scaffolding
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
