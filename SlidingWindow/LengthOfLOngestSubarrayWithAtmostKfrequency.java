package SlidingWindow;

import java.util.HashMap;

public class LengthOfLOngestSubarrayWithAtmostKfrequency {
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(j < nums.length)
        {
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(map.get(nums[j]) > k)
            {
                count = Math.max(count,j-i);
                while(map.get(nums[j]) > k)
                {
                    map.put(nums[i],map.get(nums[i])-1);
                    i++;
                }
            }
            j++;

        }
        count = Math.max(count,j-i);
        return count;
    }
}

