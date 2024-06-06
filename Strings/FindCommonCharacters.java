package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters { //leetcode 1002 
        public List<String> commonChars(String[] words) {  //questions says the common characters from all the strings including the duplicacy too 
           List<String> list = new ArrayList<>();
           List<Character> temp = new ArrayList<>();
           HashMap<Character,Integer> map = new HashMap<>();
           for(int i = 0;i<words[0].length();i++)
           {
                String s = words[0];
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1); //first we add first word characters into the sentenct if first string is bella then the map will be b - 1 , e - 1 , l - 2 ,a - 1 
           }
           for(int i = 1;i<words.length;i++) //now starting from the next word in string array we check if these words cotain the same character with same frequency as it is in the map 
           {
                String s = words[i]; //extract word
                for(Map.Entry<Character,Integer> it : map.entrySet()) //iterate over map 
                {
                    char c = it.getKey(); //getting current character 
                    int freq = it.getValue(); //getting the frequency how many time it appears in the map or in the first word
                    for(int j = 0;j<s.length();j++) //iterating over the word 
                    {
                        if(s.charAt(j) == c) //if the word contains the character which is in the map we reduce the freq which signifies that character is present in the current word too atlease once
                        {
                            freq--; //we update the freq when character is found in the current word too signifying that it is common character till now and freq tells the frequency of the character in the first word or in the map and out of that total frequency how many times do the current word contains the common character so as it find same character it keeps on decrementing the frequency telling the frequency to which a character is common till now 
                            if(freq == 0) //when freq becomes 0 it signifies character appear the exact same number of times in the current word as it appears in the first word 
                            {
                                break;
                            }
                            
                        }
                    }
                    map.put(c,map.get(c)-freq); //then we reduce the frequency of character appearing in the first word by the remaining freq of the character that the current word dont contain in it i.e the duplicate of common character is more in the first word than in the current word 
                    if(map.get(c) == 0) //if we are putting 0 value in the map this means that the current word was not able to reduce any frequency of the character maintained by the first word which means now it is not a common character as it is not occuring in the current word even once so we add it in temporary list so that later we can remove this character as it is not common by atleast one occurence note : we cant remove characters by iterating over the map so i add in temporary list and later removed it 
                    {
                         temp.add(c);
                    }
                }
                for(int k = 0;k<temp.size();k++) //removing the characters that are not common anymore
                {
                    map.remove(temp.get(k));
                }
           }
           for(Map.Entry<Character,Integer> it : map.entrySet()) //iterating over the map to make output list 
           {
               char c = it.getKey();
               int freq = it.getValue();
               for(int i = 0;i<freq;i++) //adding the characters according to the frequency if a character is appearing twice in every word then we add it twice in the list of answer
               {
                    list.add(c + ""); 
               }
    
           }
            return list;
         
    
        }
    }

