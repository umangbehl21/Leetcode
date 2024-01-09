public class MinimumNumberOfOperationToMakeElementsEqual {
    class Solution {
        int countOnes(int no) {
            int it = 0;
    
            while (no > 0) { //we remove set bits from right and increase the counter in this way where we encounter 1 means that is the location where bits of number with k differs so we flip the 1 bits 
                
                it++;    
    
                
                no = no & (no - 1); // to remove righmost set bit 
            }
    
            return it;
        }
        public int minOperations(int[] nums, int k) {
            
            int xor = 0;
            int i = 0;
            while(i < nums.length){
                
                xor = xor ^ nums[i];   //we do the xor of the complete array so that when we have the result of xors of all elments and we xor it with k the xor will give 0 for same bits and 1 for different bits for example xor of 4 is 100 and 1 is 001 now if we have to find minimmum operation to make 4 to 1 we do 100 ^ 001 that will be 101 means that there is only 1 common or same bit in both xor of all numbers and k which we can see in the middle bit of 4 and 1 which is both 0 so the middle bit of xor of all numbers with k also have middle bit as 0 means when bits are same there is no need to flip rest all where bits are different that is 1 means 1 bit is to be flipped so we count number of ones using kernighan algorithm            
                i++;
            }  
            
            
            return countOnes(xor^k) ; 
            
            
        }
     }
}
/*The intuition behind calculating the XOR of the original array with `k` is to identify the bits that need to be flipped to transform the XOR of the array into the desired value `k`. Let's break down the reasoning:

1. **XOR Operation:**
   - XOR is a bitwise operation that returns 1 for bits that are different and 0 for bits that are the same.
   - When you XOR an element in the array with `k`, you effectively change the bits that are different and leave the bits that are the same unchanged.

2. **Desired XOR (`k`):**
   - The goal is to make the XOR of the array elements equal to `k`.
   - By XORing the original XOR (`xor` variable) with `k`, you obtain the XOR of the bits that need to be changed to achieve the desired result.

3. **Flipping Bits:**
   - Each set bit in the result of `xor ^ k` indicates a position where the corresponding bits in `xor` and `k` are different.
   - Flipping these differing bits in the original array will transform the XOR into the desired value.

4. **Counting Set Bits:**
   - The `countOnes` function is then used to count the number of set bits in the result of `xor ^ k`.
   - The count represents the minimum number of bit flips required to make the XOR of the array elements equal to `k`.

In summary, the XOR operation with `k` helps identify the differing bits between the original array XOR and the desired XOR (`k`). Counting the set bits in this result gives the minimum number of bit flips needed to achieve the desired XOR, which corresponds to the minimum operations required. */