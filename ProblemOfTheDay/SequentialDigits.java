import java.util.ArrayList;
import java.util.List;

public class SequentialDigits { //leetcode 1291 
    class Solution { //self done dry run to understand
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> ans = new ArrayList<>();
            if(low == 1000000000)
            {
                return ans;
            }
            int st = low;
            int count = 2;
            int start = 1;
            int add = 1;
            while(st > 9 && st < 1000000000)
            {
                start = start * 10 + count;
                add = add * 10 + 1;
                count++; 
                st = st/10;
            }
            int initial = start;
            while(start <= high)
            {
                if(start >= low)
                    ans.add(start);
                if(start % 10 == 9)
                {
                    start = initial * 10 + count;
                    initial = start;
                    add = add * 10 + 1;
                    count++;
                    continue;
                }
                 start = start + add;
            }
            return ans;
        }
    }
}
