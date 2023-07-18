package SlidingWindow;

import java.util.HashMap;

public class CountOccurencesOfAnagram {
    
    int search(String pat, String txt) {
        int k = pat.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int a = 0;a<pat.length();a++)
        {
           char ch = pat.charAt(a);
           map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int i = 0;
        int j = 0;
        int count = map.size();
        int ans = 0;
        while(j < txt.length())
        {
            if(map.containsKey(txt.charAt(j)))
            {
                char ch = txt.charAt(j);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0)
                {
                    count--;
                }
            }
            if((j - i + 1) == k)
            {
                if(count == 0)
                {
                   ans++;
                }
                if(map.containsKey(txt.charAt(i)))
                {
                    map.put(txt.charAt(i),map.get(txt.charAt(i))+1);
                    if(map.get(txt.charAt(i)) == 1) //only increase count if exclusion of ith element from current window makes its frequency in hashmap 1 which means that it was zero before and character with frequency zero had decremented count because it exists at the first element in the window and its count in hashmap is also 1 only 
                    {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}
