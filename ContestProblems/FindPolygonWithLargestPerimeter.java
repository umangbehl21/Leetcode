package ContestProblems;

import java.util.Arrays;

public class FindPolygonWithLargestPerimeter {  //https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/description/
    class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int i = 0;
        while(i < nums.length)
        {
            sum += nums[i];
            if(i == nums.length-2)
            {
                break;
            }
            i++;
        }
        if(sum > nums[nums.length-1])
        {
            return sum + nums[nums.length-1];
        }
        else 
        {
            while(i >= 2)
            {
                long temp = sum;
                temp = temp - nums[i];
                if(temp > nums[i])
                {
                    return sum;
                }
                sum -= nums[i];
                i--;
            }
        }
        return -1;

    }
}
}
