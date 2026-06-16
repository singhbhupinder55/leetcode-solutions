package array_and_hashing.TwoSum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


public class TwoSum {

    // Approach 1: Brute Force : Nested Loop
    // Time: O (n^2)
    // Space:  O (1)
    public int[] twoSumBF(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }



    // Approach 2: Sorting
    // Time: O(nlogn)
    // Space: O(n)

    public int[] twosumSorting(int[] nums, int target) {

        // 2D sorting
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i]; //value 
            arr[i][1] = i;      // original index
        }

        // sorted the Array
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));


        // two pointers
        int j = 0;
        int k = nums.length-1;

        while (j < k ) {
            int cur = arr[j][0] + arr[k][0];
            if (cur == target) {
                return new int[]{Math.min(arr[j][1], arr[k][1]),
                                 Math.max(arr[j][1], arr[k][1])};
            } 
            else if ( cur < target) { 
                j++; // sum too small → move left pointer right to get bigger values
            }
            else {
                k--;  // sum too big → move right pointer left to get smaller values
            }

        }

        return new int[0];
    }


    // Approach 3: HashMap
    // Time: 0(n)
    // Space: 0 (n)

    public int[] twoSumHashMap(int[] nums, int target) {

        HashMap<Integer, Integer> newNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (newNums.containsKey(diff)) {
                return new int[]{newNums.get(diff), i};
            }
            newNums.put(num, i);
        }


        return new int[] {};
    }


    
}
