
import java.util.Arrays;
public class AssignCookies {
   
        public int findContentChildren(int[] g, int[] s) {  //leetcode 455 easy 
            if(s.length == 0)
            {
                return 0;
            }
            Arrays.sort(g);
            Arrays.sort(s);
            int total = 0;
            int i = 0;
            int j = 0;
            while(i < g.length && j < s.length)
            {
                if(s[j] >= g[i])
                {
                    total += 1;
                    i++;
                    j++;
                }
                else 
                 j++;
            }
            return total;
        }
    }
