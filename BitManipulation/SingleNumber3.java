class Solution {
    public int[] singleNumber(int[] nums) { //2s complement concept and finding two single occurence num in an array where all other numbers appear twice
        int xor = 0;
        for(int i = 0;i<nums.length;i++)
        {
            xor = xor ^ nums[i]; //by doing xor of all the numbers the numbers that are repeated twice becomes 0 and the numbers that are repeated once their xor will be stored example 1,2,1,3,2,5 xor of 3 ^ 5 is = 110 but the question is how we can use this xor to know that 3 and 5 leads to this result it cant tell it that but it can help to seperate 3 and 5 based on their bit difference at some position so xor was 110 it tells us that the 0th bit of 3 and 5 was same as it is 0 but the rest of bit was different we can then distinguish 3 and 5 into two groups based on the bit which is different so we create a mask from 110 we negate the 110 to 001 and then we add 1 to it , it becomes 010 it is called 2's compliment which always gives us the rightmost setbit of original value as original value was 110 it gave us 010 to differentiate on the basis of this mask 010 we do a & of this mask with original xor i.e(110 & 010) since we know in mask only rightmost shift bit is set in both the original xor and the mask so we get that mask only it can be represented as xor & (-xor i.e 2's complement)  
        }
        int mask = xor & (-xor); //xor and 2's compliment 
        System.out.println(mask);
        int num1 = 0;
        int num2 = 0;
        for(int i = 0;i<nums.length;i++)
        {
            if((nums[i] & mask) == 0) //these if else is dividing all the numbers including the single occurence number based on the bit difference at ith position that can be 0,1 and so on suppose number is 1 binary of 1 is 001 and our bit mask it 010 their and will be 0 so it will be in first group of num1 and on the other hand if number is 2 its binary is 010 and the bit mask is 010 then the result of and will be 1 it will be in different group so we have made sure that the mask we have made is according that the bit which is set in first once occuring number is not set in second once occuring number so result of & operation of one number is 1 and other is 0 to make them divide in num1 and num2 groups 
            {
                num1 = num1 ^ nums[i];
            }
            else 
            {
                num2 = num2 ^ nums[i];
            }
        }
        System.out.println(num1);
        System.out.println(num2);
        int ans[] = new int[2];
        ans[0] = num1;
        ans[1] = num2;
        return ans;

    }
}