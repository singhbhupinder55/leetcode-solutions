# 242. Valid Anagram

**Difficulty:** Easy
**Pattern:** Arrays & Hashing
**Link:** https://leetcode.com/problems/valid-anagram/

## Problem
Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`.
An anagram is a string with the same characters in any order.

## Approaches

### 1. Sorting — O(n log n + m log m) time, O(1) space
Sort both strings, compare them. Simple but slower than counting.

### 2. HashMap (two maps) — O(n + m) time, O(1) space
Build a frequency map for each string. Compare maps with `.equals()`.
Works for ANY character set (Unicode, mixed case) — most flexible.

### 3. Array of 26 — O(n + m) time, O(1) space ✅ Optimal
Use a single int[26] array. Increment for s, decrement for t.
If anagram, every slot ends at 0.
Works only when character set is small and known (lowercase English).

## Key Insights
- **`char - 'a'` maps a lowercase letter to an index 0–25.** Burn this trick in.
- **Increment/decrement cancellation** — one array instead of two maps. Elegant.
- `HashMap.equals()` compares contents, not references — order doesn't matter.
- Always check lengths first. Different length → can't be anagram. Saves time.

## When to Use Which
| Scenario | Best Approach |
|----------|--------------|
| Lowercase English only | Array of 26 |
| Unicode or unknown character set | HashMap |
| Memory tight, can mutate input | Sort |

## Mistakes I Made
- In case of sorting, i was sorting string straight, instead of coverting it into array first then sort.