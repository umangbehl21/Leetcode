public class RedistributeCharactersToMakeAllStringsEqual {
    // class Solution {
    // public boolean makeEqual(String[] words) {
    //     if(words.length == 1)
    //     {
    //         return true;
    //     }
    //     HashSet<Character> set = new HashSet<>();
    //     String s = "";
    //     for(int i = 0;i<words.length;i++)
    //     {
    //         for(int j = 0;j<words[i].length();j++)
    //         {
    //             char ch = words[i].charAt(j);
    //             if(!s.contains(Character.toString(ch)))
    //             {
    //                 s += ch; 
    //                 set.add(ch);
    //             }
    //         }
    //     }

    //     int total = set.size() * words.length;
    //     HashMap<Character,Integer> map = new HashMap<>();
    //     for(int i = 0;i<s.length();i++)
    //     {
    //         map.put(s.charAt(i),0);
    //     }
    //     for(int i = 0;i<words.length;i++)
    //     {
    //         for(int j = 0;j<words[i].length();j++)
    //         {
    //             char ch = words[i].charAt(j);
    //             map.put(ch,map.get(ch)+1);
    //         }
    //         if(i == words.length-1)
    //         {
    //            for(Map.Entry<Character,Integer> it : map.entrySet())  
    //            {
    //                if(it.getValue() % words.length != 0)
    //                {
    //                    return false;
    //                }
    //            }
    //         }
    //     }
    //     return true;


    // }
// }
class Solution {
    public boolean makeEqual(String[] words) {
        int freq[] = new int[26];
        for(int i = 0; i<words.length; i++){
            for(char ch : words[i].toCharArray()){
                freq[ch -'a']++;
            }
        }

        for(int i = 0; i<26; i++){
            if(freq[i] % words.length != 0){
                return false;
            }
        }

        return true;
    }
}
}
