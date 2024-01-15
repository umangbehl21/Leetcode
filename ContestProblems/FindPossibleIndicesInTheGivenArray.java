package ContestProblems;

import java.util.ArrayList;
import java.util.List;

public class FindPossibleIndicesInTheGivenArray { //leetcode 3006
    class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
              ArrayList<Integer> ans = new ArrayList<>();
              while (j <= s.length() - b.length())
               {
                if (s.substring(j, j + b.length()).equals(b.substring(0, b.length()))) 
                {
                     ans.add(j);
                    
                }
                    j++;
                }
            while(i <= s.length()-a.length())
            {
              
              if (s.substring(i, i + a.length()).equals(a.substring(0, a.length()))) {
                  for(int it = 0;it<ans.size();it++)
                  {
                      if(Math.abs(i-ans.get(it)) <= k)
                      {
                          list.add(i);
                          break;
                      }

                  }
                
                }
                
                i++;
                
            }
           
            return list;
            
  
    }
}
}
