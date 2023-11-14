package ProblemOfTheDay;

import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters {
     public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        
        int[] timeToReach = new int[n];
        
        for (int i = 0; i < n; i++) {
            timeToReach[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        }
        
        Arrays.sort(timeToReach);
        
        int count = 1;
        
        int timePassed = 1;
        for (int i = 1; i < n; i++) {
            if (timeToReach[i] - timePassed <= 0) {
                return count;
            }
            
            count++;
            timePassed++;
        }
        
        return count;
    }
}
