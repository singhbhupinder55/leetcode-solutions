# 1. Two Sum

**Difficulty:** Easy
**Pattern:** Arrays & Hashing
**Link:** https://leetcode.com/problems/two-sum/

## Problem
Given an integer array `nums` and an integer `target`, return the indices of the two numbers that add up to `target`. Each input has exactly one solution, and you may not use the same element twice. Return the smaller index first.

## Approaches

### 1. Brute Force — O(n²) time, O(1) space
Check every pair with nested loops. Simple but too slow for large inputs.

### 2. Sort + Two Pointers — O(n log n) time, O(n) space
Bundle each value with its original index in a 2D array, sort by value, then use two pointers from both ends.
- If `sum < target` → move left pointer right (need bigger sum)
- If `sum > target` → move right pointer left (need smaller sum)

> The 2D array trick is needed because sorting destroys the original indices, but the problem requires returning indices.

### 3. HashMap One-Pass — O(n) time, O(n) space ✅ Optimal
For each number, compute `complement = target - num`. Check if complement is already in the map. If yes, return both indices. If no, add current number to the map.

**Why it works in one pass:** the map only contains numbers we've already passed. So when we find a match, it must be at an earlier index — we can never accidentally match an element with itself.

## Key Insights
- **"Find a pair with a known relationship" → HashMap.** Burn this pattern in.
- **complement = target - current.** Standard trick for sum-based problems.
- **Check map BEFORE adding current element** — prevents self-matching without needing an explicit `i != j` check.
- **Two Pointers requires sorted input.** That's why approach 2 needed the 2D array workaround.

## Pattern Family
This is the foundation pattern for: Two Sum II, 3Sum, 4Sum, Subarray Sum Equals K, Contains Duplicate II.
