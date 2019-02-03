import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String[] dict = new String[31];

    dict[0] = " o' clock";
    dict[1] = "one";
    dict[2] = "two";
        dict[3] = "three";
        dict[4] = "four";
        dict[5] = "five";
        dict[6] = "six";
        dict[7] = "seven";
        dict[8] = "eight";
        dict[9] = "nine";
        dict[10] = "ten";
        dict[11] = "eleven";
        dict[12] = "twelve";
        dict[13] = "thirteen";
        dict[14] = "fourteen";
        dict[15] = "quarter";
        dict[16] = "sixteen";
        dict[17] = "seventeen";
        dict[18] = "eighteen";
        dict[19] = "nineteen";
        dict[20] = "twenty";
        dict[21] = "twenty one";
        dict[22] = "twenty two";
        dict[23] = "twenty three";
        dict[24] = "twenty four";
        dict[25] = "twenty five";
        dict[26] = "twenty six";
        dict[27] = "twenty seven";
        dict[28] = "twenty eight";
        dict[29] = "twenty nine";     
        dict[30] = "half";

    boolean past_or_to = (m<=30) ? true:false;

    String m_char = ( m<2 ) ? " minute" : " minutes";
    String pt_char = ( past_or_to ) ? " past" : " to";
    if ( !past_or_to ) h+=1;
    if ( h>12 ) h-=12;
    if ( m>30) m= 60 - m; 

    if (m == 0) return dict[h] + dict[0];
    if ( m==15 || m==30){
        return dict[m] + pt_char + " " + dict[h];
    }

    return dict[m] + m_char + pt_char + " " + dict[h];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
