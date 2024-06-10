import java.util.HashMap;

public class ContinousSubarraySum {
    class Solution {
    public boolean checkSubarraySum(int[] nums, int k) { 
        HashMap<Integer,Integer> map = new HashMap<>(); //map to store remainder 
        map.put(0,-1);
        int sum = 0;
        int rem = 0;
        for(int i = 0;i<nums.length;i++)
        {
            sum += nums[i];
            rem = sum % k;
            System.out.println(rem);
            if(map.containsKey(rem) ) //if remainder was previously seen means the numbers which are added after where the remainder was previously seen that numbers together when added are mutiple of k means if they are completely divisible by k 
            {
                if(i - map.get(rem) >= 2) //the size of subarray should be greater or equal to two
                   return true;
            }
            else 
            {
                map.put(rem,i); //storing reaminder and th eindex where it is seen 
            }

        }
        if(sum == 0 && nums.length > 1)
        {
            return true;
        }
        return false;

    }
}
}
