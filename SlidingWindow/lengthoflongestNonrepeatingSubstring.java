package SlidingWindow;

import java.util.HashMap;

public class lengthoflongestNonrepeatingSubstring {
        public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int len = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right < s.length())
        {
            if(map.containsKey(s.charAt(right)))
            {
                left = Math.max(map.get(s.charAt(right))+1,left);  //updating the position of characters and brining inside the range 
            }
            map.put(s.charAt(right),right); //storing the new index or position at which the character appears again 
            len = Math.max(len,right - left + 1);
            right++;
        }
        return len;
    }
}
