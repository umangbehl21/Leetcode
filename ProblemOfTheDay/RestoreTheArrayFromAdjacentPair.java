import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreTheArrayFromAdjacentPair {

  Map<Integer, List<Integer>> adj = new HashMap<>();

    public int[] restoreArray(int[][] adjacentPairs) {
        for (int[] edge : adjacentPairs) {
            int x = edge[0];
            int y = edge[1];
            if(!adj.containsKey(x)) // each node of graph contains arraylist in front of it making adjacency list as hashmap because node can also contain negative value 
            {
                adj.put(x,new ArrayList<>()); //if current node is new add arraylist corresponsing to it and add its neighbour too 
                adj.get(x).add(y);  
            }
            else 
            {
                adj.get(x).add(y); //if current node is already there in map then add another neigbour in its arraylist 
            }
            if(!adj.containsKey(y))
            {
                adj.put(y,new ArrayList<>());
                adj.get(y).add(x);
            }
            else 
            {
                adj.get(y).add(x);
            }
            // adj.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            // adj.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        int root = 0;
        for (int num : adj.keySet()) {
            if (adj.get(num).size() == 1) {  //we can start from the begining or end of the undirected graph which don't hace any incoming edge 
                root = num;
                break;
            }
        }

        int[] result = new int[adj.size()];
        dfs(root, Integer.MAX_VALUE, result, 0);
        return result;
    }

    private void dfs(int node, int prev, int[] result, int i) { 
        result[i] = node;
        for (int neighbor : adj.get(node)) {
            if (neighbor != prev) { //if neigbour is not equal to the node where we have come from then add the unvisited neighbour 
                dfs(neighbor, node, result, i + 1);
            }
        }
    }
}

