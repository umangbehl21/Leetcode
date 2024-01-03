package BitManipulation;

public class SetTheRightMostUnsetBit {
    public class Solution {
        public static int setBits(int N){
            // Write your code here.
            int num = N;
            int i= 0;
            while(num > 0)
            {
                if((num | 1) == num) //if by doing or operation with the number number remain same means that it is not the unset bit of number so we do i++ that it is a set bit if there was an unset bit number would have been increased so when the numbmer increase we break i store the number of set bits from the back giving the position of where to place set bit 
                {
                    i++;
                    num = num >> 1;
                }
                else //if number changes after or operation then we break means we know how much we will shift one to place it under the unset bit to make it 1 
                {
                    break; 
                }
            }
            if(num == 0) //if number becomes 0 it means that it has all set bits else block in loop never executed 
            {
                return N;
            }
            int mask = 1 << i;
            N = N | mask; //do or operation with original number 
            return N;
        }
    }
    
}
