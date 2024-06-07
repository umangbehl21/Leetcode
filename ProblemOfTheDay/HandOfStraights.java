import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

    class Solution { //leetcode 846
    public boolean isNStraightHand(int[] hand, int groupSize) { //dry run 1,1,2,3,4,5 , group size = 3 and 1,2,3,6,2,3,4,7,8 groupSize = 3
        if(hand.length % groupSize != 0)
        {
            return false;
        }
        Arrays.sort(hand);
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for(int i = 0;i<hand.length;i++)
        {
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> it : map.entrySet())
        {
            while(it.getValue() != 0) //until current frequency of element is not zero we have to find some group for it 
            {
                map.put(it.getKey(),map.get(it.getKey())-1); //we reduce the current element frequency by 1 
                for(int i = 1;i<groupSize;i++) //we start from i = 1 means we will now check with help of i that the current number + i exists in the map which tells that next consistent number exists we reduce its frequency that it is used in one group in next iteration we check next to next consecutive if number was 1 in begining in next it ceome 2 in next to next it becomes 3 then loop breaks as i becomes 3 equal to group size
                {
                    if(!map.containsKey(it.getKey() + i) ||  map.get(it.getKey()+i) == 0) //if current element dont have next concescutive element or next consecutive is 0 in hashmap means it was there in past but was used in past group making so return false
                    {
                        return false; 
                    }
                    else 
                    {
                        map.put(it.getKey()+i,map.get(it.getKey()+i)-1); //reducing the frequency to indicate that the next consecutive element is used in the current group 
                    }

                }
            }
        
        }
        return true;

    }
}

