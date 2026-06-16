package array_and_hashing.ValidAnagrams;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Arrays;

public class ValidAnagrams { 

    //Aproach 1: Sorting
    // Time complexity: O(n logn + m lognm)
    // Space Complexity: O(1) or O(n+m) depending on sorting impl
    
    public boolean ValidAnagramSorting(String s, String t) {

        if (s.length() != t.length()) { return false;}

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.equals(ss, tt);

    }


    // Approach 2: HashMap (two maps)
    // Time complexity : O (n + m)
    // Space Complexity : O (1) - at most 26 keys for lowercase English letters
    public boolean ValidAnagramsHashMap(String s, String t) {
        if (s.length() != t. length()) {return false;}

        HashMap<Character, Integer> ss = new HashMap<>();
        HashMap<Character, Integer> tt = new HashMap<>();

        for (int i = 0; i < s.length(); i ++) {
            ss.put(s.charAt(i), ss.getOrDefault(s.charAt(i), 0)+1);
            tt.put(t.charAt(i), tt.getOrDefault(s.charAt(i), 0)+1);
        }
        return ss.equals(tt);  
    }

    // Approach 3: HashTable aka Array of size 26 
    // Time complexity: O (n + m)
    // Space Complexity : O (1)
    // Increment for s, decrement for t - if anagram, all slots end at 0

    public boolean ValidAnagramHashTable(String s, String t) {

        if (s.length() != t.length()) {return false;}

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {

            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;

        }

        for (int j = 0; j < count.length; j++) {
            if (count[j] != 0) return false;
        }

        return true;

    }


    
}
