package ProblemOfTheDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int req = nums.length/3;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> ans = new ArrayList<>();
         for(int i : nums)
        {
            if(map.containsKey(i) && map.get(i) > req)
            {
                ans.add(i);
                map.remove(i);
            }
        }
        return ans;
    }
}
