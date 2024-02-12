package ContestProblems;

public class NumberOfSubarrayThatMatchaPattern1 {  //leetcode 3034
    class Solution {
        public int countMatchingSubarrays(int[] nums, int[] pattern) {
            int count = 0;
            int plen = pattern.length;
            for(int i = 0;i<nums.length-plen;i++)
            {
                int p = 0;
                for(int j = i;j<i+plen;j++)
                {
                    if(pattern[p] == 1 && nums[j] < nums[j+1])
                    {
                        p++;
                    }
                    else if(pattern[p] == 0 && nums[j] == nums[j+1])
                    {
                        p++;
                    }
                    else if(pattern[p] == -1 && nums[j] > nums[j+1])
                    {
                        p++;
                    }
                    else 
                    {
                        break;
                    }
                    if(p == plen)
                    {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
