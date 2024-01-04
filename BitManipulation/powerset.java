package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class powerset {
    class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> ans = new ArrayList<>();

            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    ans.add(nums[j]);
                }
            }
            list.add(ans);
        }
        return list;
    }
}

}
