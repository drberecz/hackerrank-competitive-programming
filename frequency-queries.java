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

public class Solution {

    // Complete the freqQuery function below.
static List<Integer> freqQuery(List<int[]> queries) {
    Map<Integer, Integer> hmap = new HashMap <>();
    List <Integer> res = new ArrayList <>();
    for ( int[] x : queries ){
        int method = x[0];
        int val    = x[1];
        switch ( method ) {
            case 1:
            if ( !hmap.containsKey(val)){
                hmap.put (val, 1);
            }
            else hmap.put ( val, hmap.get(val)+1 );
            break;
            case 2:
                if (hmap.containsKey(val)) {
                    int temp = hmap.get(val);
                    if ( temp <=1) {hmap.remove (val); break;}
                    hmap.put(val, temp -1);
                }
                break;
            case 3:
                if (hmap.containsValue(val)) {
                res.add(1);
                }else res.add(0);
                break;

        }

    }






    return res;
    }

public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
      int q = Integer.parseInt(bufferedReader.readLine().trim());
      List<int[]> queries = new ArrayList<>(q);
      Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
      for (int i = 0; i < q; i++) {
        int[] query = new int[2];
        Matcher m = p.matcher(bufferedReader.readLine());
        if (m.matches()) {
          query[0] = Integer.parseInt(m.group(1));
          query[1] = Integer.parseInt(m.group(2));
          queries.add(query);
        }
      }
      List<Integer> ans = freqQuery(queries);
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");
      }
    }
}
}
