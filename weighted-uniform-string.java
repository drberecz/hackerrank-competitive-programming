import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        TreeSet<Integer> list = weighStr (s);     
        String[] res = new String[queries.length];
        for ( int i=0; i<queries.length; ++i ){
     res[i] = (  list.contains ( queries[i] )) ?
       "Yes" : "No"; 
         
        }
    return res;
    }

    static TreeSet <Integer> weighStr ( String str){
    int len = str.length();
        TreeSet<Integer> tree = new TreeSet<Integer>();
    int accu =(str.charAt(0) - 'a')+1;
    tree.add ( accu );
    if ( len<2 ) return tree;
    for ( int i=1; i<len; ++i ){
        int temp = (str.charAt(i) - 'a') + 1;
        if ( str.charAt(i) ==str.charAt(i-1) ){
            accu += temp;
        }else accu = temp;
        tree.add(accu);
    }


    return tree;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
