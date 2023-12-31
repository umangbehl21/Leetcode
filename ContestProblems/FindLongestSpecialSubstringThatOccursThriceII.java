package ContestProblems;

import java.util.HashMap;

class Solution {  //leetcode 2982
    HashMap<Character,Integer> map = new HashMap<>();
    public int maximumLength(String s) {
        int i = 0;
        int j = 0;
        HashMap<String,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int hmax = Integer.MIN_VALUE;
        while(j < s.length())
        {
            char ch = s.charAt(j);
            while(j<s.length() && s.charAt(j) == ch)
            {
                j++;
            }
            if(j-i > 2)
            {
                max = Math.max(max,j-i-2);
                String ts = s.substring(i,j);
                String st = s.substring(i,j-1);
                map.put(ts,map.getOrDefault(ts,0)+1);
                map.put(st,map.getOrDefault(st,0)+1);
                map.put(st,map.getOrDefault(st,0)+1);
                if(map.get(ts) > 2) 
                {
                    max = Math.max(max,ts.length());
                }
                else if(map.get(st) > 2)
                {
                    max = Math.max(max,st.length());
                }
            }
            else 
            {
                if(j-i == 2)
                {
                    String ts = s.substring(i,j);
                    map.put(""+ch,map.getOrDefault(""+ch,0)+1);
                    map.put(""+ch,map.getOrDefault(""+ch,0)+1);
                    map.put(ts,map.getOrDefault(ts,0)+1);
                    if(map.get(ts) > 2)
                    {
                        hmax = 2;
                    }
                    else if(map.get(""+ch)>2)
                    {
                        hmax = 1;
                    }
                }
                else 
                {
                     map.put(""+ch,map.getOrDefault(""+ch,0)+1);
                     if(map.get(""+ch) > 2 && hmax != 2)
                     {
                         hmax = 1;
                     }
                }
                
            }
            i=j;
        }
        if(hmax == Integer.MIN_VALUE && max == Integer.MIN_VALUE)
        {
            return -1;
        }
        else 
        {
            if(max > hmax)
            {
                return max;
            }
            else 
            {
                return hmax;
            }
        }


    }
}