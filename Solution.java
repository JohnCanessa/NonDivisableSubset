import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


/**
 * 
 */
public class Solution {

	/**
	 * complete this function
	 */
    static int nonDivisibleSubset(int k, int[] S) {
    	
        // ???? ????
        System.out.println("nonDivisibleSubset <<< k: " + k);
        System.out.print("nonDivisibleSubset <<< S: ");
        for (int s : S)
            System.out.print(s + " ");
    	
    	// **** declare array of remainders ****
    	int[] remainderArr = new int[k];
        
        // **** populate the array of remainders ****
    	for (int n : S) {
    		
    		// ???? ????
    		System.out.println("nonDivisibleSubset <<< n % k = (" + n + " % " + k + "): " + n % k);
    		
            remainderArr[n % k]++;
        }
        
    	// ???? display the contents of the array ????
    	System.out.print("nonDivisibleSubset <<< remainderArr: ");
    	for (int s : remainderArr)
    		System.out.print(s + " ");

        // ???? compute the sum of the array of remainders ????
        int sum = IntStream.of(remainderArr).sum();
        System.out.println(" sum: " + sum + " == n: " + S.length);

    	// **** set initial number of elements in the subset ****
    	int zeroRemainder = remainderArr[0];
    	
    	// ???? ????
    	System.out.println("nonDivisibleSubset <<< zeroRemainder: " + zeroRemainder);
        
    	// **** consider only one of the numbers ****
    	int numOfElementsInSubset = (zeroRemainder > 0) ? 1 : 0;
    	
    	// ???? ????
    	System.out.println("nonDivisibleSubset <<< numOfElementsInSubset: " + numOfElementsInSubset);
             
    	// **** loop moving from both ends inwards computing the elements in the subset ****
        for (int i = 1; i <= (k / 2); i++) {
        	
        	// ???? ????
        	System.out.println("nonDivisibleSubset <<< i: " + i + " k - i: " + (k - i));
        	
        	// **** ****
            if (i != (k - i)) {

                // ???? ????
                System.out.println("nonDivisibleSubset <<< max(" + remainderArr[1] + ", " + remainderArr[k - 1] + ")");

                // **** ****
                numOfElementsInSubset += Math.max(remainderArr[i], remainderArr[k - i]);
            } else {

                // ???? ????
                System.out.println("nonDivisibleSubset <<< numOfElementsInSubset++");

                // **** ****
                numOfElementsInSubset++;
            }

            // ???? ????
            System.out.println("nonDivisibleSubset <<< numOfElementsInSubset: " + numOfElementsInSubset);
        }
        
        // **** return the number of elements in the subset ****
        return numOfElementsInSubset;
    }

    
    // **** open scanner ****
    private static final Scanner scanner = new Scanner(System.in);
    
    /**
     * test scaffolding
     */
    public static void main(String[] args) throws IOException {

        // **** open buffered writter ****
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        // ???? ????
        System.out.println("main <<< n: " + n + " k: " + k);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        // **** compute the result ****
        int result = nonDivisibleSubset(k, S);

        // **** display the result ****
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        // **** close buffered writer ****
        bufferedWriter.close();

        // **** close scanner ****
        scanner.close();
    }
}
