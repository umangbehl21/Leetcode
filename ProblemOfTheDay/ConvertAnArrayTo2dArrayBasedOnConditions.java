import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConvertAnArrayTo2dArrayBasedOnConditions {
    
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for(int i : nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.get(i) > list.size())
            {
                list.add(new ArrayList<>());
                list.get(map.get(i)-1).add(i);
            }
            else 
            {
                list.get(map.get(i)-1).add(i);
            }

        }
        return list;

    }

}
