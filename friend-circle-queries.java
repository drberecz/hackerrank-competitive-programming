package problemsolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CircleQueries {

    static int[] maxCircle(int[][] queries) {

        int[] res = new int[queries.length];
        int prevMax = 2;        

        List<ArrayList<Integer>> listOfFriends = new ArrayList<>();
        ArrayList<Integer> rowA = new ArrayList<>();
        ArrayList<Integer> rowB = new ArrayList<>();

        HashMap <Integer,Integer> map = new HashMap<>();
        

        for (int i = 0; i < queries.length; i++) {
            int q0 = queries[i][0];
            int q1 = queries[i][1];
            int max = -1;

            int indexQ0 = map.containsKey(q0) ? map.get(q0) : -1;
            int indexQ1 = map.containsKey(q1) ? map.get(q1) : -1;

                        
            if (indexQ0 < 0 && indexQ1 < 0) {
        ArrayList<Integer> tempSet = new ArrayList<>();
                tempSet.add(q0);
                tempSet.add(q1);
                listOfFriends.add(tempSet);
                int indexOfSet = listOfFriends.size()-1;
                map.put (q0,indexOfSet);
                map.put (q1,indexOfSet);
                
                max = prevMax; 
                //System.out.println("no common element "+ listOfSets);
            }
            else if (indexQ0 >= 0 && indexQ1 < 0) {
                rowA = listOfFriends.get(indexQ0);
                rowA.add(q1);
                map.put (q1, indexQ0);
                max  = Math.max(rowA.size(),prevMax );
              //  System.out.println("rowA++: " + rowA);
            }
            else if (indexQ0 < 0 && indexQ1 >= 0) {
                rowB = listOfFriends.get(indexQ1);
                rowB.add(q0);
                map.put (q0, indexQ1);
                max  = Math.max(rowB.size(),prevMax );
            //    System.out.println("rowB++: " + rowB);
            }

            else if (indexQ0 >= 0 && indexQ1 >= 0 && indexQ0==indexQ1) {
                max = prevMax;
            }

            else if (indexQ0 >= 0 && indexQ1 >= 0) {
                rowA = listOfFriends.get(indexQ0);
                rowB = listOfFriends.get(indexQ1);
                int sizeOfA = rowA.size();
                int sizeOfB = rowB.size();
                
                if (sizeOfA>sizeOfB){
                    for (int j = 0; j < sizeOfB; j++) {
                        int tVal = rowB.get(j); 
                        rowA.add(tVal);
                        map.put ( tVal, indexQ0);
                    }
                    
                }
                else{
                    for (int j = 0; j < sizeOfA; j++) {
                        int tVal = rowA.get(j); 
                        rowB.add(tVal);
                        map.put ( tVal, indexQ1);
                    }              
                }
               // System.out.println("merger"+ " rowA: " + rowA+ " rowB: " + rowB );
                max = Math.max(rowA.size(), Math.max(prevMax,rowB.size()));
            }

            
            prevMax = max;
        res[i] = max;
           //System.out.println(q0+ "--" +q1+ " m:"+ max + "list "+ listOfSets); 
        }        
        return res;
    }
    
    
    

    public static void main(String[] args) {

//int[][] arr ={ {9,2},{15,1},{14,3},{9,3},{3,15}  };
        
        
   //     int[][] arr = {{1, 2}, {3, 4}, {1, 3}, {5, 7}, {5, 6}, {7, 4}};
int[][] arr = {{78, 72},
{67, 74},
{65, 57},
{65, 52},
{70, 55},
{74, 70},
{58, 51},
{70, 76},
{69, 55},
{64, 78},
{67, 72},
{69, 63},
{77, 59},
{69, 64},
{70, 80},
{66, 67},
{71, 52},
{60, 77},
{80, 66},
{70, 61}};



int[] res = maxCircle(arr);
        for (int x : res) {
            System.out.println(x);
        }
    }

}
