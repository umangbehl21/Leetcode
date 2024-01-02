package BitManipulation;

public class ClearSetGetIthBit {
        public static int[] bitManipulation(int num, int i){ //https://www.codingninjas.com/studio/problems/bit-manipulation_8142533?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
            // Write your code here.
            int ans[] = new int[3];
            ans[0]=(num&(1<<i-1))>>i-1; //suppose number is 1101 first we left shift 1 to i - 1 index because indexing is 1 based if ith bit is 3 we have to left shift by 2 1101 & 0100 = 0100 then we right shift 0100 to 2 it will give answer 1  
            num = num | (1<<i-1); //left shift 1 by i-1 index then perform or operation with num if bit is 0 or 1 doesnt matter if it is |(or) by 1 it will aLWAYS SET THE BIT 
            ans[1] = num;
            ans[2] = num & (~(1<<i-1)); // to clear the bit we need to perform bit & 0 but rest of bits od num should remain same so we first we left shift 1 by i-1 then we negate it example we left shift 1 by 2 1 << 2 = 1 * 2^2 = 4 we write 4 as 0100 we negate 0100 to 1011 now all other bits are 1 so that other bits of original number dont get affected and bit to be clear is 0 any bit & 0 will always be 0 so we can clear a bit
            return ans;
    
        }
    }

