package ContestProblems;

public class FindIfArrayCanBeSorted {
    class Solution {
        public boolean canSortArray(int[] nums) {
            int setbits[] = new int[nums.length];
            for(int i = 0;i<nums.length;i++)
            {
                calcsetbits(setbits,nums[i],i); //first we maintain set bits array of all elements  
            }
            for(int i = 0;i<nums.length;i++)
            {
                for(int j = i+1;j<nums.length;j++)
                {
                    if(nums[j] < nums[i])  //only if current element is greater than the next coming element we need to swap and we can only swap if setbits of the current number and the jth number is equal if they are not return false 
                    {
                        if(setbits[i] != setbits[j])
                        {
                            return false;
                        }
                    }
                }
            }
            return true;
            
        }
        public void calcsetbits(int setbits[],int num,int i)
        {
           int count = 0;
           while(num > 0)
           {
               count++;
               num = (num & num-1);
           }
           setbits[i] = count;
        }
    }
}
