import java.util.ArrayList;
import java.util.HashSet;

public class PathCrossing { //https://leetcode.com/problems/path-crossing/description/?envType=daily-question&envId=2023-12-23
   
        class pair 
        {
            int x = 0;
            int y = 0;
            public pair(int x,int y)
            {
                this.x = x;
                this.y = y;
            }
        }
        public boolean isPathCrossing(String path) 
        {
            ArrayList<pair> adj = new ArrayList<>();
            adj.add(new pair(0,0));
            HashSet<String> set = new HashSet<>();
            set.add("00");
            for(int i = 0;i<path.length();i++)
            {
                if(path.charAt(i) == 'N')
                {
                    pair p = adj.get(i);
                    adj.add(new pair(p.x, p.y+1));
                    String s = "" + p.x + (p.y + 1);
                    if(set.contains(s))
                    {
                        return true;
                    }
                    else 
                    {
                        set.add(s);
                    }
                }
                else if(path.charAt(i) == 'E')
                {
                    pair p = adj.get(i);
                    adj.add(new pair(p.x + 1 ,p.y));
                    String s = "" + (p.x + 1) + p.y;
                    if(set.contains(s))
                    {
                        return true;
                    }
                    else 
                    {
                        set.add(s);
                    }
                }
                else if(path.charAt(i) == 'S')
                {
                    pair p = adj.get(i);
                    adj.add(new pair(p.x ,p.y - 1));
                    String s = "" + p.x + (p.y - 1);
                    if(set.contains(s) && i < path.length() - 1)
                    {
                        return true;
                    }
                    else 
                    {
                        set.add(s);
                    }
                }   
                else 
                {
                     pair p = adj.get(i);
                    adj.add(new pair(p.x - 1,p.y));
                    String s = "" + (p.x - 1) + p.y;
                    if(set.contains(s))
                    {
                        return true;
                    }
                    else 
                    {
                        set.add(s);
                    }
                }
    
            }   
            return false; 
    
        }
    }

