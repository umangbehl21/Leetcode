package BitManipulation;

public class MinBitFlip {
    class Solution {
        public int minBitFlips(int start, int goal) { 
            return Integer.bitCount(start ^ goal);
        }
    }
    /** The trick here is to perform xor (^) operation between the goal and the start, as it will get set bits for the places where bits of start and goal are different. For example,
    goal = 00000100110110
    start = 01001001100010
    xor = 01001101010100
    Now these set bits in xor result are the minimum bits that need to be flipped in order to convert start to goal. So, we count the number of set bits in xor using Integer.bitCount(x) in Java.**/
}
