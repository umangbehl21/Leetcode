package BitManipulation;

public class SwapUsingBitManipulation {
    public class Solution{
        public static void swapNumber(int []a, int []b) {
            // Write your code here.
                
            a[0]=a[0]^b[0]; //1^2 
            b[0]=a[0]^b[0]; //1^2^2 = 1
            a[0]=a[0]^b[0]; //1^2^1 = 2
            
        }
    }
}
