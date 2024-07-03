import java.util.Arrays;

public class Leetcode1509 { //tricky one its all about increasing atmost 3 smallest values to number where largest - smallest is minimum or decreasing atmost 3 largest value to number where largest - smallest is minimum by atmost we means we can even increase two of the smallest value and decrease one largest value from the end likewise 4 combinations can be obtained explained below 
    class Solution {
    public int minDifference(int[] nums) { //min difference can be obtained if we change our largest and smallest element value but there are more than one way we have to change them some testcases are 10,20,30,40,41 another is 10,20,30,31,40 another is 10 , 20 , 21 , 25 , 40 in the first case it is beneficial to bring your smallest element upto 40 so that 41- 40 is 1 so we change first 3 element , in the second testcase it is better to change the first three smallest values till 31 as 40 - 31 = 9 will become smallest in third testcase changing first two smallest to 21 and last largest to 25 so difference is 25-21 becomes smallest so on every testcase we have to take minimum from fours options  
        Arrays.sort(nums);
        int n = nums.length;
        if(n <= 4)
        {
            return 0;
        }
        int res = Integer.MAX_VALUE;
       for(int i = 0;i<4;i++) //4 moves we can skip last three largest element or we can skip last two largest and one smallest from the beginning or we can skip first two elements from begining and last element from the end or we can remove all elements from begining 
       {
          res = Math.min(res,nums[n-1-3+i]-nums[i]);
       }
       return res;
    }
}
}
