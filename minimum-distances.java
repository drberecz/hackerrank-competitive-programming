import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        int mini = Integer.MAX_VALUE;
        Map <Integer, Integer> map = new HashMap <>();
        int temp = 0;
        for ( int x=0; x<a.length; ++x ) {
            if ( !map.containsKey(a[x]) ) {
                map.put ( a[x] , x );
            }
            else {
                temp = x - map.get(a[x]);
                if ( temp< mini) mini = temp;
                map.put ( a[x] , x );

            }

        }



        return ( mini == Integer.MAX_VALUE  ) ? -1 : mini;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
