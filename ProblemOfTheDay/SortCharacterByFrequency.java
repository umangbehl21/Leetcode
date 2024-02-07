import java.util.Arrays;
import java.util.PriorityQueue;

public class SortCharacterByFrequency {
    class Solution {
    class pair implements Comparable<pair> {
        char c;
        int freq;
        String str;

        public pair(char c, int freq, String str) {
            this.c = c;
            this.freq = freq;
            this.str = str;
        }

        public int compareTo(pair o) {
            return Integer.compare(o.freq, this.freq);
        }
    }

    public String frequencySort(String s) {
        char ch[] = s.toCharArray();
        Arrays.sort(ch);  //as we cannot remove character of our choice from priority queue we sort string so that same characters are together and we count the frequency of a character at once and then add it to priority along with its frequency and the string it will form later we remove them and the string  
        String ns = new String(ch);
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int i = 0;
        int count = 0;
        String st = "";

        while (i < ns.length()) {
            char currentChar = ns.charAt(i);
            count = 0;
            StringBuilder sb = new StringBuilder();
            while (i < ns.length() && ns.charAt(i) == currentChar) {
                sb.append(currentChar);
                count++;
                i++;
            }
            pq.add(new pair(currentChar, count, sb.toString()));
        }
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            pair p = pq.remove();
            ans.append(p.str);
        }
        return ans.toString();
    }
}
}
