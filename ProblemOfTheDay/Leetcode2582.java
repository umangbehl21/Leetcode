public class Leetcode2582 {
    class Solution {
        public int passThePillow(int n, int time) {
    
            int moves = n-1; //as the person which is currently holding the pillow doesn't count as a move so it takes n-1 moves in one round
            
            int crounds = time/moves;  //number of complete rounds that is fully played can be calculated as time/moves means the total moves divide by moves in one round suppose there are 10 moves to be taken and move we can take in one round is 3 now how many rounds we can complete making the 3 moves in each round , i.e 10/3 = 3 means 3 complete round can be taken as 3 * 3 = 9 we can make 9 full moves in 3 round we cant make 4 rounds as 3 * 4 is 12 and it will outlast the 10 moves so highest rounds we can play making 3 moves in a round is 9
    
            // int rmoves = time % moves;  //remaining moves is the remainder left after playing the complete rounds
    
             int rmoves = time - (crounds * moves); //this can also find remaining moves as the total moves - moves exhausted in the fully completed rounds
    
            if((crounds + 1) % 2 == 0)  //if the next round is even then it is traversed from right to left
            {
                return n-rmoves;
            }
            else 
            {
                return 1+rmoves; //if the next round is odd we move from left to right starting of left is 1 so 1+remaining moves
            }
        
        }
    } 
}
