package ProblemOfTheDay;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode2191 {
    class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();

        for(int i = 0;i<nums.length;i++)
        {
            int num = nums[i];
            String temp = num + "";
            int rem = 0;
            for(int j = 0;j<temp.length();j++)
            {
                char c = temp.charAt(j);
                int n = c - '0'; 
                int m = mapping[n];   //mapped value
                rem = rem * 10 + m;
            }
            ArrayList<Integer> list = map.getOrDefault(rem,new ArrayList<Integer>());
            list.add(num);
            map.put(rem,list);
        }
        int ans[] = new int[nums.length];

        int j = 0;
        while(j<ans.length)
        {
           for(Map.Entry<Integer,ArrayList<Integer>> it : map.entrySet())
           {
                ArrayList<Integer> list = it.getValue();
                for(int k = 0;k<list.size();k++)
                {
                    ans[j] = list.get(k);
                    j++;
                }
           } 
        }
        return ans;

    }
}
}
