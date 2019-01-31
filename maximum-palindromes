import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


    public static long factorial(int number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }

    public static void initialize(String s) {
    s.toLowerCase();
    }


    public static int answerQuery(String str, int l, int r) {
    // Return the answer for this query modulo 1000000007.
    String sub = str.substring ( l-1, r);


    int len =  sub.length();
    int odds_cou = 0; 
    if ( len ==1 ) return 1;
    Map <Integer, Integer> map_evens = new HashMap <>();
    for ( int i = 0; i<len; ++i ){
        int ch = (sub.charAt(i) -'a');
        if ( !map_evens.containsKey(ch)){ map_evens.put ( ch, 1);}
        else {
            map_evens. put ( ch, (map_evens.get(ch)+1));
        }

    }
    int total = 0, repeats=0;
    for ( int key=0; key<28; ++key) {
        if ( !map_evens.containsKey(key) ) continue;
        int val = map_evens.get(key);
        if ( val==1 ){ odds_cou++;continue;}
        if ( val%2!=0) {
            odds_cou ++;
            val -=1;
        }
        val = val/2;
        total += val;
        if ( val>1 ) repeats +=val;
    }

    long multi_even = factorial (total)/factorial (repeats);
    long multi_odd=( odds_cou>1 ) ? odds_cou : 1;

    return (int)((multi_odd* multi_even)%1000000007);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        Result.initialize(s);

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int l = Integer.parseInt(firstMultipleInput[0]);

                int r = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.answerQuery(s, l, r);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
