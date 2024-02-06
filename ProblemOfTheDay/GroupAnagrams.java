import java.util.*;
public class GroupAnagrams { ////we sort original strings and put it in seperate array without loosing the original strings after sorting we map hashmap of string , Arraylist<String> now when we sort strings the strings which have same characters and same number of characters will be equal to each other so now all the strings which have same sorting can be kept under one ArrayList meaning that they have same characters and same number of them 
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            List<List<String>> list = new ArrayList<>();
            String stemp[] = new String[strs.length];
            for (int i = 0; i < strs.length; i++) 
            {
                String s = strs[i];
                char ch[] = s.toCharArray();  
                Arrays.sort(ch);
                stemp[i] = new String(ch); 
            }
            for (int i = 0; i < stemp.length; i++) 
            {
                String sts = stemp[i];
                if (!map.containsKey(sts)) {
                    map.put(sts, new ArrayList<>());
                }
                map.get(sts).add(strs[i]);
            }
            for (Map.Entry<String, ArrayList<String>> it : map.entrySet()) 
            {
                list.add(it.getValue());
            }
            return list;
        }
    }
    
}
