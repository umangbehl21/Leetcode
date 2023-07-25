package SlidingWindow;

import java.util.HashMap;

public class Minimum_Window_susbtring { //minimum window substring that contains all characters of second string
     public String minWindow(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>(); //will contain character of string s
        HashMap<Character,Integer> map2 = new HashMap<>(); //represent string t and contain its character
        for(int i = 0;i<t.length();i++)
        {
            char ch = t.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        int count = 0;
        int dcount = t.length(); //desired count 
        int i = 0;
        int j = 0;
        String ans = "";
        while(true)
        {
            boolean c1 = false;
            boolean c2 = false;
            //when j becomes equal to s.length() c1 will remain false there are no character to aquire in the map 
            while(j < s.length() && count < dcount)  //acquire characters until map1 contains all the characters that are present in string t 
            {
                char ch = s.charAt(j);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                if(map1.getOrDefault(ch,0) <= map2.getOrDefault(ch,0))
                {
                    count++;
                }
                c1 = true;
                j++;
            }
            //when first loop didnt run c1 remain false then second loop will also not run as count is still less than desired count and we cannot release characters more as count of characters required to represent string t is already short 
            while(i < j && count == dcount) //collect the string and release characters until count of characters in map1 is still sufficient to make string t 
            {
                String pans = s.substring(i,j);
                if(ans.length() == 0 || pans.length() < ans.length())
                {
                    ans = pans;
                }
                char ch = s.charAt(i);
                if(map1.get(ch) == 1)
                {
                    map1.remove(ch);
                }
                else 
                {
                    map1.put(ch,map1.get(ch) - 1);
                }
                if(map1.getOrDefault(ch,0) < map2.getOrDefault(ch,0))
                {
                    count--;
                }
                c2 = true;
                i++;
            }
            if(!c1 && !c2) //c1 ans c2 used to break from outer while loop when first loop didnt run as j becomes equal to string length then c1 becomes false and second loop also donnot run as count remains short than desired count then we break out of loop  
            {
                break;
            }

        }
        return ans;
    }
}
