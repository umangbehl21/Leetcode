public class LongestPalindrome {
    class Solution {
        public int longestPalindrome(String s) {
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i = 0;i<s.length();i++)
            {
                char c = s.charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
            }
            int count = 0;
            boolean isodd = false;
            for(Map.Entry<Character,Integer> it : map.entrySet())
            {
                
                int val = it.getValue();
                if(val % 2 == 0)
                {
                    count += val;
                    //  System.out.println(count);
                }
                else 
                {
                    count += val - 1; //suppose we had a string aabbbgggcc now we can use bb and gg in our palindrome together ignoring their last b and g character which we can only add a single g or b one of the two at the end 
                    isodd = true; //if string is odd we will add one to our result in the end as one odd character can be accomodated in when rest of the characters are evenly distributed
                }
            }
            // System.out.println(count);
            if(isodd)
            {
                count++;
            }
            return count;
    
        }
    }
}
