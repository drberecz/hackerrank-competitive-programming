import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        long res = 0;
        if ( c[0] > b[b.length-1] )return 0;


//precompute permutations of B&C arrays
//store values in int[] d
        int[] d =new int[b.length];
        int iC= 0;
        for ( int i=0; i<b.length; ++i){
            while ( iC>=0 && iC< c.length ){
                if ( c[iC] <= b[i] ){++iC; continue;}               
                if (c[iC] > b[i]) { --iC;  break;}
                }

            if ( iC<0) { d[i] =0; iC=0; continue;}
            if ( iC>= c.length) {d[i] = c.length; --iC; continue;} 
            d[i] = iC+1;

        }        

    for(  int j = 0;j<a.length;++j){
        int temp = a[j];
        int iB = b.length -1;

        while ( iB>=0 ){
        if ( temp > b[iB] ) break;
            res += d[iB];
            --iB;
        }
    }
    return res;
    }




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);


        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        TreeSet<Integer> treeA = new TreeSet <>();
        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            treeA.add( arraItem );
        }
        int xt1 = treeA.size();
        int[] arra = new int[xt1];
        int i1 = 0;
        for (Integer x1 : treeA) {
            arra[i1++] = x1;
        }



        TreeSet<Integer>  treeB = new TreeSet<>();
        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            if (arrbItem>=arra[0]) treeB.add( arrbItem );
        }
        if ( treeB.isEmpty() ) treeB.add( -1 );

        int xt2 = treeB.size();
        int[] arrb = new int[xt2];
        i1 = 0;
        for (Integer x1 : treeB) {
            arrb[i1++] = x1;
        }

        TreeSet<Integer> treeC = new TreeSet<>();

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
        if(arrcItem<=arrb[arrb.length-1]) treeC.add( arrcItem );
        }
        if (treeC.isEmpty())  treeC.add(Integer.MAX_VALUE);

        int xt3 = treeC.size();
        int[] arrc = new int[xt3];
        i1 = 0;
        for (Integer x1 : treeC) {
            arrc[i1++] = x1;
        }


        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
