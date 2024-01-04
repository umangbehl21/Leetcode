public class KernighanAlgoTocountSetBits {
    public class Solution{
        public static int countSetBits(int N) { //kernighan algo x = 10010100. ~x = 01101011. -x = ~x + 1 = 01101100 righmost set bit is = x & -x = 10010100 & 01101100 = 00000100 this is the righmost set bit we can subtract this from orignam number to remove right most set bit  
            int j = 0;
            
             int count = 0;
            while(j <=N)
            {
            int n = j;
            while(n!=0)
            {
                int rmsbm = n & -n; //-n is ~n + 1 in which all bits before the right most set bit are negated or opposite of orignal n so as the rightmost bit and the bits after the rightmost bit is same so if we do and operation with the orignal number rightmostbit and bits after will remain same the bits before the rightmost bit will all be 0 
                n = n - rmsbm; //one by one we 
                count++;
    
            }
            j++;
            
            }
            return count;
    
        }
    }
}
