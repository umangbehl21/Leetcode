class Solution {  //Brute force optimised approach below
    public int countTriplets(int[] arr) {
        long a = 0;
        long b = 0;
        long ls = 0;
        long rs = 0;
        int count = 0;
        for(int i = 0;i<arr.length;i++)
        {
            for(int j = i + 1;j<arr.length;j++)
            {
                for(int k = j;k<arr.length;k++)
                {
                    if(i == j-1)
                    {
                        a = arr[i];
                    }
                    else 
                    {
                        int titl = i; //temporary iterator
                        while(titl < j)
                        {
                            ls = ls ^ arr[titl];
                            titl++;
                        }
                        a = ls;
                    }
                    if(j == k)
                    {
                        b = arr[j];
                    }
                    else 
                    {
                        int titr = j;
                        while(titr <= k)
                        {
                            rs = rs ^ arr[titr];
                            titr++;
                        }
                        b = rs;
                    }
                    if(a == b)
                    {
                        // System.out.println(i + " i " + j + " j " + " k " + k);
                        count++;
                    }
                    rs = 0;
                    ls = 0;
                }
            }
        }
        return count;
    }
}


class Solution2 {  //optimised using prefix xor if we encountered same number again that means that the xor of that subarray till where that number has occured is 0 
    public int countTriplets(int[] arr) {
        int count = 0;
    
    for (int i = 0; i < arr.length; i++) {
        int val = arr[i];
        
        for (int k = i + 1; k < arr.length; k++) {
            val = val ^ arr[k];
            
            if (val == 0) {
                count += (k - i);
            }
        }
    }
    
    return count;
    }
}
