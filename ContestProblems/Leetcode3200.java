public class Leetcode3200 {
    class Solution { //maximum height achievable 
        public int maxHeightOfTriangle(int red, int blue) {  //on dry run on red = 5 and blue = 6 we can notice that when we start with white color ball we can achieve height of 4 but when we start with black color we can achieve height of 3 so we have to make two different calls to check whether starting with blue give us optimal solution or starting with red give us optimal solution 
            return Math.max(helper(red,blue),helper(blue,red)); //once start from red another start from blue 
        }
        public int helper(int first,int second) //once first will be red and second will be and secondly first will be blue and second will be red 
        {
            int lc = 1; //LC IS levelcount means number of balls required at that level
            int height = 0;
            while(first >= 0 && second >= 0) //why = to zero because suppose one color balls have now placed n balls at the level and is now finished and it is turn of next color ball to fill next level and it is not finished so if one is 0 we must enter while to fill next level even if both are zero then one of the count of color balls will become negative and there is a if in the while if any ball become negative return the current height 
            {
                if(lc % 2 == 0)
                {
                    first -= lc; //subtracting from first color ball
                }
                else 
                {
                    second -= lc; //subtracting from second color ball 
                }
                if(first < 0 || second < 0) //when a ball count becomes 0 and it is that color ball turn to fill the level but in the above if else by reducing the level count from the 0 the ballcount becomes negative so it cant fill the current level return height  
                {
                    System.out.println(height);
                    return height;
                }
                height++; 
                lc++; //levelcount incremented we need one more ball than the previous level 
            }
            return height;
    
        }
    }
}
