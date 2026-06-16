# 217. Contains Duplicate

**Difficulty:** Easy
**Pattern:** Arrays & Hashing
**Link:** https://leetcode.com/problems/contains-duplicate/

## Problem
Given an integer array `nums`, return `true` if any value appears more than once, otherwise `false`.

## Approaches

### 1. Brute Force — O(n²) time, O(1) space
Compare every pair using nested loops. Simple but too slow for large inputs.

### 2. Sorting — O(n log n) time, O(1) space
Sort the array, then check adjacent elements. Good when memory is tight and you can mutate the input.

### 3. HashSet — O(n) time, O(n) space ✅ Optimal
Iterate once. If element already in set → duplicate found. Otherwise add it.
Classic **space-for-time tradeoff**.

> Note: A one-line variant exists — convert the array to a set and compare sizes. Same complexity, but no early exit, so slightly worse in practice.

## Mistakes I Made
- I was checking index of array as a element inside the set in HashSet approach