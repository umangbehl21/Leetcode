package BitManipulation;

public class sumOfBitDifferences { //gfg 
    long sumBitDifferences(int arr[], int n) {
        long ans=0;
        for(int i = 0;i<32;i++)
        {
            long setbit = 0;
            long unset = 0;
            for(int j : arr)
            {
                if((j & (1 << i)) != 0)
                {
                    setbit++;
                }
                else 
                {
                    unset++;        
                }
            }
            ans += (setbit * unset) * 2;
        }
        return ans;
    }
}
