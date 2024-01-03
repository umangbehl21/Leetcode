import java.util.ArrayList;

public class NumberOfLaserBeamInaBank {
    class Solution {
    public int numberOfBeams(String[] bank) {
        if(bank.length == 1)
        {
            return 0;
        }
        ArrayList<Integer> freq = new ArrayList<>();
        for(int i = 0;i<bank.length;i++)
        {
            String s = bank[i];
            int count = 0;
            for(char c : s.toCharArray())
            {
                if(c == '1')
                {
                    count++;
                }
            }
            if(count > 0)
            {
                freq.add(count);
            }
        }
        int res = 0;
        for(int i = 0;i<freq.size()-1;i++)
        {
            res += freq.get(i) * freq.get(i+1);
        }
        return res;
        

    }

}
}
