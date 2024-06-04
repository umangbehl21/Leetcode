package Strings;

class Solution { //https://www.geeksforgeeks.org/problems/binary-representation-of-next-number3648/1
    String binaryNextNumber(String s) { //next number is addition by 1 in current bianry number we just need to figure out how to do in strings as it is simple one in string will become 0 as 1 + 1 in binary is 0 because carry is moved to next this only stops if the bit that recieves carry is 0 so 1 + 0 is 1 
        // code here.
       StringBuilder sb = new StringBuilder(s);
       for(int i = 0;i<sb.length();) //as there can be leading zeros in the string so first we have to remove them but the deletecharAt behaviour is after removing a character at an index every character is shifted to its left index i.e left shift by 1 in binary terms so there is no need to increment i++ as next character will come to its previous index by itself if there is 001 then first 0 will be remove at index 0 and string will be 01 now 0 which was previously on 1st index has come to the 0th index this is why no increment loop breaks when 1 is encountered no more leading zeros are there
       {
           if(sb.charAt(i) == '0')
           {
               sb.deleteCharAt(i);
           }
           else 
           {
                break;
           }
            
       }
       int i = sb.length()-1;
       while(i >= 0) //simulating binary addition of 1 in strings as all 1 turn to 0 because of 1 + 1 = 0 and carry 1 in binary and the rightmost 0 becomes 1 as it recieves carry as 1
       {
           if(sb.charAt(i) == '0')
           {
               sb.setCharAt(i,'1');
               break;
           }
           else 
           {
               sb.setCharAt(i,'0');
           }
           i--;
       }
       if(i == -1)
       {
           sb.insert(0,'1');
       }
       return sb.toString();
        
    }
}