package BitManipulation;

public class OddAndEvenUsingBitManipulation {
    public class Solution { //https://www.codingninjas.com/studio/problems/odd-even_7993579?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
        public static String oddEven(int N){
            if((N & 1)==1) //last bit of odd number is always 1 and last bit of even is always 0 if i do 100 & 1 then result will be 0 which means it is even if i do 101 & 1 result will be 1 which means number is odd
            {
                return "odd";
            }
            else 
            {
                return "even";
            }
        }
    }
}
