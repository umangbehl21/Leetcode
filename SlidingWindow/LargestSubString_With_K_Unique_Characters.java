package SlidingWindow;

import java.util.HashMap;

public class LargestSubString_With_K_Unique_Characters //largest substring with k distinct characters in the string 
{
     public int longestkSubstr(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>(); //in hashmap we store character along with its frequency in the current window 
        int maxlen = 0;
        int i = 0;
        int j = 0;
        while(j < s.length())
        {
            if(map.size() <= k)  //if number of keys in map are less than or equal to k then keep on adding characters when this condition adds a character which make size of map greater than k then second condition do not run so size for string which have unique characters greater than k is not calculated 
            {
              map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0) + 1);
            }
            if(map.size() == k) //map contains the characters and their frquency in the current window og i to j so if size of map is equal to k then it means their are k unique characters in the current window then keep on calculating the max length.  max length will not be calculated when mapsize increases k which means there is one character more than the k unique characters in the current window of i to j so its length will not be stored 
            {
                maxlen = Math.max(maxlen,j-i + 1);
            }
            if(map.size() > k) //if map size becomes greater than k which means there are more than k unique characters in the current window 
            {   
                while(map.get(s.charAt(i)) != 1 ) //then start incrementing i from begining of window and keep on incrementing and also reducing frequency of character in the map from which i gets incremented until we get a character whose frequency in the current window is 1 
                {
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    
                    i++;
                }
                if(map.get(s.charAt(i)) == 1) //when we get a character whose frequency is 1 we can remove it from map so that only k unique characters remain in map 
                {
                    map.remove(s.charAt(i));
                    i++; //we also increment from the removed character to next 
                }           
            }
            j++;
            
        }
        if(maxlen == 0) //if maxlen remains 0 means there is no k unique characters in complete string then return -1
        {
            return -1;
        }
        else 
        {
            return maxlen;
        }
        
        
    }
}
