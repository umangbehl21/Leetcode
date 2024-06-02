import java.util.ArrayList;
import java.util.Collections;  //https://www.geeksforgeeks.org/problems/construct-list-using-given-q-xor-queries/1

public class PerformQueriesUsingXOr {  //optimised o(n) optimised cumulative xor till now have same impact as applying individual element for xor to each element in the list 
    class Solution {
    public static ArrayList<Integer> constructList(int q, int[][] queries) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int xor = 0;
        for(int i = queries.length - 1;i>=0;i--){ //started traversiong from the backwards where i see 1 in query i calculate new xor by doing xor with previsous xor as if we do xor of single querry on all elements or we do cumulative xor on all elements result is same and time complexity is also saved means if there are query {0,2} , {0,5}, {1,4} , {1,5} if i do xor individualy means first 5 ^ 4 then 2 ^ 4 then for query {1,5} i do xor on the result of xor of (5^4)^5 and (2^4)^5 then for each xor query we traverse every element which will lead to o(n^2) time complexity to save this we traverse from backwards we first do 0 ^ 5 = 5 then 5 ^ 4 now this result will be impact of all the cumulative xor's encountered till now as applying it individaully leads to higher time and applying it by cumulating them have same impact and less time complexity 
            
           if(queries[i][0] == 0)
            {
                int elem = xor ^ queries[i][1];
                list.add(elem);
            }
            else 
            {
                xor = xor ^ queries[i][1];
            }
        
        }
        list.add(xor); //adding xor at the end become intially at start list is 0 we do 0 ^ xor that is xor itself 
        Collections.sort(list); //sorting list to return 
        return list;
    }
}
}
