import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

public class ContainsDuplicates {


    // Approach 1: Brute Force (nested loop)
    // Time: O(n^2) Space : O(1)

    public boolean hasDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    // Approach 2: Sorting 
    // Time: O(nlogn) because sorting takes extratime (logn)
    // Space complexity: O(1) or O(n) depends on the algorithm we use

    public boolean hasDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }


    // Approach 3: HashSet
    // Time complexity: O(n)
    // Space complexiy: O(n) because we have to build a HashSet which will take some memory
    // Trade memory for speed.

    public boolean hasDuplicateHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true; 
            set.add(nums[i]);
        }
        return false;
    }
}