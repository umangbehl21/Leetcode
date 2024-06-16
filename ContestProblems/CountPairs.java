import java.util.HashMap;
import java.util.Map;

public class CountPairs {
    class Solution {
    public long countCompleteDayPairs(int[] hours) {
           
      // Map to store frequency of each remainder when divided by 24
        Map<Integer, Integer> remainderCount = new HashMap<>();
        long pairCount = 0;

        for (int hour : hours) {
            int remainder = hour % 24; //remainder is 0 if number is multiple of 24 and it is non zero or less than 24 if the number is not a multiple of 24 like 47 % 24 is 23 
            // Find the complement that would make the sum a multiple of 24
            int complement = (24 - remainder) % 24; //now if remainder is 23 (i.e 47 % 24) what do 23 need in it to become a multiple of 24 we can find it by (24 - 23) % 24 = 1 we find it by subtracting with 24 we do modulus by 24 because suppose remainder is 0 for number which are already multiple of 24 like 48 % 24 is 0 now how much more number we need to make it multiple of 24 we dont need anything as it is already multiple of 24 but 24 - 0 is giving 24 that we need 24 more so to avoid this we do modulus with 24 so 0 % 24 is 0 that we need zero modulating by 24 don't affect other number process of finding the complement because remainder is always less than 24 for these number say it 73 i.e 95 % 24 = 23 as we know when we do mod of number it is compressed or stay less than the mode value  
            
            // Add the count of elements with the required complement to the pair count
            pairCount += remainderCount.getOrDefault(complement, 0); //if the remainder required to make multiple of 24 is present in the map then we will get its frequency value how many times it is occuring in hours array that many pairs we can form with current hour if it is not in map 0 will be added 
            
            // Update the frequency map for the current remainder
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1); //putting the current remainder by the hour in the map 
        }
        
        return pairCount;
        
    }
}
}
