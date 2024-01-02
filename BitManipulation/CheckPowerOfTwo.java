package BitManipulation;

public class CheckPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
        {
            return false;
        }
        else if((n & n-1) == 0)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}
