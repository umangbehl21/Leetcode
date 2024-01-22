import java.util.HashSet;

public class SetMisMatch {
        public int[] findErrorNums(int[] nums) {
        int ans[] = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1;i<=nums.length;i++) //adding numbers in set from 1 to n 
        {
            set.add(i);
        }
        for(int i = 0;i<nums.length;i++) //now we check what elements in array are present in set and if it is present in set we remove it from set if some elements come second time in array it didn't get located in set as it was removes so it is our duplicate element now after removing all the elements that are present in the array adn in the set now remaining 1 element in the set is that element which was never removed from the set as it was not present in the array so the missing element is that 
        {
            if(set.contains(nums[i]))
            {
                set.remove(nums[i]);
            }
            else 
            {
                ans[0] = nums[i];
            }
        }
        for(int i : set)
        {
            ans[1] = i;
        }
        return ans;
    }
}
