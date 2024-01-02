package BitManipulation;

public class CountSetBitsInNnumbers {
    class Solution {
        public int[] countBits(int n) { //https://leetcode.com/problems/counting-bits/description/
            int ans[] = new int[n+1];
            ans[0] = 0;
            int i = 1;
            while(i <= n) //in this question n is given we have to count setbits from 0 to n and store in array for the number example 0 to 5 on 3 set bits are 2 we will store 2 on 3rd index
            {
                int num = i;
                while(num > 0)
                {
                    if((num & 1) == 1) //101 & 001 if last bit of num  is 1 answer will always be 1
                    {
                        ans[i]++;
                    }
                    num = num >> 1; 
                }
                i++;
            }
            return ans;
        }
    }
}
