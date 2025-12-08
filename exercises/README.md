# HashMap Exercises

This repository contains three LeetCode-style exercises designed to help you practice working with HashMaps in Java. Each exercise includes comprehensive test cases to validate your solution.

## Prerequisites

- Java 21
- Maven
- IntelliJ IDEA (recommended) or any Java IDE

## Project Structure

```
exercises/
├── src/
│   ├── main/java/hashmap_exercises/
│   │   ├── GroupAnagrams.java
│   │   ├── MaxSumPairEqualDigitSum.java
│   │   └── MinimumConsecutiveCards.java
│   └── test/java/hashmap_exercises/
│       ├── GroupAnagramsTest.java
│       ├── MaxSumPairEqualDigitSumTest.java
│       └── MinimumConsecutiveCardsTest.java
└── pom.xml
```

## Getting Started

1. Clone the repository
2. Open the `exercises` folder in IntelliJ IDEA
3. Make sure Maven dependencies are downloaded
4. Implement the solutions in the respective Java files
5. Run the tests to validate your solutions

---

## Exercise 1: Group Anagrams

**File**: `src/main/java/hashmap_exercises/GroupAnagrams.java`  
**LeetCode Problem**: [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)

### Problem Description

Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

An **anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

### Examples

**Example 1:**
```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```
(Note: The order of groups and words within groups doesn't matter)

**Example 2:**
```
Input: strs = [""]
Output: [[""]]
```

**Example 3:**
```
Input: strs = ["a"]
Output: [["a"]]
```

### Constraints

- `1 <= strs.length <= 10^4`
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters

### Hints

1. Anagrams have the same characters when sorted (e.g., "eat" → "aet", "tea" → "aet")
2. Use a `HashMap<String, List<String>>` where the key is the sorted version of the word
3. The value is a list of all words that match that sorted form

### Method Signature

```java
public List<List<String>> groupAnagrams(String[] strs)
```

### Running Tests

```bash
mvn test -Dtest=GroupAnagramsTest
```

Or right-click on `GroupAnagramsTest.java` in IntelliJ and select "Run 'GroupAnagramsTest'".

---

## Exercise 2: Max Sum of a Pair With Equal Sum of Digits

**File**: `src/main/java/hashmap_exercises/MaxSumPairEqualDigitSum.java`  
**LeetCode Problem**: [2342. Max Sum of a Pair With Equal Sum of Digits](https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/)

### Problem Description

You are given a 0-indexed integer array `nums`. Find the **maximum sum** of a pair of numbers `(nums[i] + nums[j])` such that:
- The sum of digits of `nums[i]` equals the sum of digits of `nums[j]`
- `i != j`

Return the maximum sum, or `-1` if no such pair exists.

### Example

```
Input: nums = [18, 43, 36, 13, 7]
```

Digit sums:
- 18 → 1 + 8 = 9
- 43 → 4 + 3 = 7
- 36 → 3 + 6 = 9
- 13 → 1 + 3 = 4
- 7 → 7

Pairs with same digit sum:
- (18, 36) both have digit sum 9 → sum = 54
- (43, 7) both have digit sum 7 → sum = 50

```
Output: 54
```

### Constraints

- `2 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`

### Hints

1. First, implement a helper method `digitSum(int x)` to calculate the sum of digits
2. Use a `HashMap<Integer, Integer>` to map digit sum → best (largest) number seen with that digit sum
3. For each number, check if you've seen another number with the same digit sum
4. Keep track of the maximum sum found

### Method Signatures

```java
public int maximumSum(int[] nums)
int digitSum(int x)  // helper method
```

### Running Tests

```bash
mvn test -Dtest=MaxSumPairEqualDigitSumTest
```

Or right-click on `MaxSumPairEqualDigitSumTest.java` in IntelliJ and select "Run".

---

## Exercise 3: Minimum Consecutive Cards to Pick Up

**File**: `src/main/java/hashmap_exercises/MinimumConsecutiveCards.java`  
**LeetCode Problem**: [2260. Minimum Consecutive Cards to Pick Up](https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/)

### Problem Description

You are given an integer array `cards` where `cards[i]` represents the value of the i-th card. You need to pick up a contiguous subarray that contains **at least two cards with the same value**.

Return the **minimum length** of such a subarray, or `-1` if it is impossible.

### Examples

**Example 1:**
```
Input: cards = [3, 4, 2, 3, 4, 7]
Output: 4
Explanation: The subarray [3, 4, 2, 3] (indices 0-3) has length 4 and contains duplicate 3's.
```

**Example 2:**
```
Input: cards = [1, 2, 3, 4, 5]
Output: -1
Explanation: No two cards have the same value.
```

**Example 3:**
```
Input: cards = [5, 5]
Output: 2
Explanation: Adjacent duplicates form the shortest possible subarray.
```

### Constraints

- `1 <= cards.length <= 10^5`
- `0 <= cards[i] <= 10^6`

### Hints

1. Use a `HashMap<Integer, Integer>` to track the last seen index of each card value
2. For each card at index `i`:
   - If you've seen this card before at index `j`, the subarray length is `i - j + 1`
   - Update the minimum length if this is smaller
   - Update the last seen index for this card to `i`
3. Return the minimum length found, or `-1` if no duplicates exist

### Method Signature

```java
public int minimumCardPickup(int[] cards)
```

### Running Tests

```bash
mvn test -Dtest=MinimumConsecutiveCardsTest
```

Or right-click on `MinimumConsecutiveCardsTest.java` in IntelliJ and select "Run".

---

## Running All Tests

To run all tests at once:

```bash
mvn test
```

Or in IntelliJ, right-click on the `hashmap_exercises` test folder and select "Run Tests in 'hashmap_exercises'".

## Tips for Success

1. **Start Simple**: Begin with the basic cases and make sure they work before handling edge cases
2. **Test Frequently**: Run tests after each significant change to catch issues early
3. **Use the Hints**: Each problem includes hints in the source code comments
4. **Think About Complexity**: Aim for O(n) time complexity using HashMaps effectively
5. **Debug with Print Statements**: Add `System.out.println()` to see what your code is doing
6. **Read Test Cases**: The test files show exactly what your code should handle

## Common HashMap Patterns

These exercises demonstrate key HashMap use cases:

1. **Grouping** (Group Anagrams): Use a HashMap to collect items into groups based on a key
2. **Tracking Best Values** (Max Sum Pair): Use a HashMap to remember the best value seen for each category
3. **Last Seen Index** (Minimum Consecutive Cards): Use a HashMap to track positions for calculating distances

## Getting Help

If you're stuck:
1. Review the hints in the source code comments
2. Look at the test cases to understand expected behavior
3. Draw out examples on paper to visualize the algorithm
4. Consider what information you need to "remember" as you iterate through the data

Good luck with your exercises!

