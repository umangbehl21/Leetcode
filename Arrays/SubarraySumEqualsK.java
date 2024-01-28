import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) { //dry run on 1,-1,0 it tells why frequency of csum can be more than 1 
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); //at first cumulative sum is 0 means if 3 is hte target and we have 3 as element in array then 3-3 give 0 so 0 should be added in map first 
        int csum = 0;
        int res = 0;
        for(int i = 0;i<nums.length;i++)
        {
            csum += nums[i];
            if(map.containsKey(csum - k)) //if cumulative sum is n and if we have encountered n-k as cumulative sum in past this means k is added to make n i.e (n-k)+k = n 
            {
                res += map.get(csum-k);
            }
            map.put(csum,map.getOrDefault(csum,0)+1);
        }
        return res;
    }
}