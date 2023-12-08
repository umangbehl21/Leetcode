package greedy;

import java.util.Arrays;

public class MinimumNumberOfCoinAdded {
       public int minimumAddedCoins(int[] coins, int target) {
        int added = 0;
        int osum = 0; //obtainable target that we can make when there are no coins 
        Arrays.sort(coins); //importance of sort is  Sorting ensures that you start with the smallest coins first, making it easier to fill in the gaps for smaller values. Additionally, sorting helps in identifying the minimum coin value that can be added to the array.
       
        for(int coin : coins)
        {
            while(coin > osum + 1) //then we cant make a small coin by taking help of big coin
            {
                added++;
                int newcoin = osum + 1;
                osum +=  newcoin;
                if(osum >= target) return added;
            }
            osum += coin;
            if(osum >= target) return added;
        }
        while(osum < target)
        {
            added++;
            int newcoin = osum + 1;
            osum += newcoin;
            if(osum >= target) return added;
        }
        return added;
    }

}

/* The solution you provided is a greedy algorithm that aims to minimize the number of coins needed to obtain a target sum. Let's break down the intuition behind this solution:

### Sorting:
The sorting step is crucial in this solution because it allows you to process coins in ascending order. Sorting ensures that you start with the smallest coins first, making it easier to fill in the gaps for smaller values. Additionally, sorting helps in identifying the minimum coin value that can be added to the array.

### Main Loop:
The main loop iterates over each coin in the sorted array. The goal is to fill the gaps between the current obtainable sum (`osum`) and the next coin value. If the current coin is greater than `osum + 1`, it means there is a gap, and you need to add a new coin.

### Filling Gaps:
Inside the main loop, there is a while loop that continues until the current coin can help fill the gap. It increments the `added` count, calculates the value of the new coin (`newcoin = osum + 1`), adds it to the obtainable sum (`osum += newcoin`), and checks if the target has been reached (`osum >= target`). This process ensures that you add the smallest possible coin to fill the gap.

### Terminating Conditions:
The main loop also checks if the current coin has made the obtainable sum greater than or equal to the target. If so, the function returns the `added` count, as the target can be obtained with the current coins.

### Final Loop:
After processing all available coins, there might still be a gap between the obtainable sum and the target. The final loop fills this gap by adding new coins until the obtainable sum is greater than or equal to the target.

### Overall Intuition:
1. **Greedy Approach:** The algorithm prioritizes adding the smallest possible coins first, minimizing the number of coins needed to reach the target.
2. **Gap Filling:** The main loop focuses on identifying and filling gaps between the current obtainable sum and the next coin value.
3. **Sorting:** Sorting ensures that the algorithm starts with the smallest coins, helping in efficient gap filling.

This approach is effective because it optimally handles the addition of coins to obtain the target sum in a greedy manner. The goal is to efficiently fill the gaps using the smallest possible coins. */
