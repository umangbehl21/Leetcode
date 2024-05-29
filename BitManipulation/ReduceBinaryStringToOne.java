public class ReduceBinaryStringToOne {

        public int numSteps(String s) {
          StringBuilder sb = new StringBuilder(s); //made a mutable string to replace append and delete character 
          int i = sb.length()-1; //starting from last char
          int count = 0;
          while(i > 0)
          {
             char c = sb.charAt(i);  
             if(c == '1')  ////if last char is 1 then it means number is odd and if number is odd we add 1 at the last as binary string of odd number has 1 at the last and we add 1 in it carry will go to next bit and if that bit is 1 also carry is again move to next bit 1 + 1 = 0 carry = 1 when bit is 0 then that carry is added to 0 to make 1 if i becomes less than 0 means we crossed 0 index of string then we put 1 by incrementing i++ to make i = 0 and put 1 there so if binary string is 111 then it will become 1000 i.e 8 in decimal as 7+1 = 8
             {
                while(i >= 0 && sb.charAt(i) != '0') 
                {
                    sb.setCharAt(i,'0'); //to replace a existing character 
                    i--;
                }
                if(i < 0)
                {
                    i++;
                    sb.insert(i,'1'); //to append at the start other characters will shift by 1 
                    System.out.println("f"+sb.length());
                }
                else //if i dont become -1 as number was like 1001 i.e 9 then adding 1 at last will give carry as 1 and we find the 0 at 2nd index of 1001 so it will become 1010 i.e 10 this is why this else is used
                {
                    sb.setCharAt(i,'1');
                }
             }
       
             else  //if character is 0 at the end then we delete that character to replicate divide by 2 when number is even suppose string was "100" i.e 4 now 4/2 = 2 now right shift 100 >> 1 it will become 10 which is 2 to do this in string we delete the last character which makes number half of the current even number you can try for 8 also 
             {
                sb.deleteCharAt(i); //delete character deletes from a index 
                System.out.println("e"+ sb.length());
             }
            System.out.println("b"+ sb.length());
             count++;
             i = sb.length()-1; //update i to last index of current string builder length and run loop till i is 0 means single character is left which is 1 as in constraints s[0] = 1
          }
          return count;
        }
