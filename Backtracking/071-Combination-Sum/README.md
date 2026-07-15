# Combination Sum

## Problem

Given an array of distinct integers `nums` and a target integer `target`, return all unique combinations of numbers where:

- The chosen numbers add up to `target`.
- The same number may be chosen unlimited times.
- The order of combinations does not matter.

Example:

nums = [2,3,6,7]

target = 7

Output:

[2,2,3]
[7]

---

# Approach

## Backtracking

This problem uses backtracking to explore all possible combinations.

At every number, we have two choices:

1. Take the current number.
2. Skip the current number.

The key difference from Subsets:

- Taking a number keeps us on the same index because numbers can be reused.
- Skipping a number moves us to the next index.

Decision tree:

                []

              /    \

          take 2   skip 2

            /         \

       take 2       take 3

        ...

---

# Recursive State

The helper function keeps track of:

- Current index:
    - Which number we are considering.

- Current combination:
    - The numbers chosen so far.

- Current sum:
    - The total value of the current combination.

Function:

backtrack(index, currentNums, currentSum)

---

# Base Cases

## Target Reached

If:

currentSum == target

we found a valid combination.

Add a copy:

new ArrayList<>(currentNums)

Then return.

---

## Invalid Path

Stop exploring when:

- We run out of numbers.
- The current sum exceeds the target.

---

# Backtracking Logic

## Choice 1: Take Current Number

Add the number:

currentNums.add(nums[index])

Recurse:

backtrack(index, currentSum + nums[index])

Notice:

The index stays the same.

This allows reuse of the same number.

Example:

[2]

can become:

[2,2]

---

## Undo Choice

After recursion:

currentNums.remove(currentNums.size() - 1)

This restores the list before exploring another path.

---

## Choice 2: Skip Current Number

Move to the next number:

backtrack(index + 1, currentSum)

This prevents using the current number anymore.

---

# Complexity Analysis

Let:

n = number of candidates

The recursion explores many possible combinations.

Time Complexity:

O(n^target)

This represents the exponential search space.

Space Complexity:

O(target)

The maximum recursion depth is limited by how many numbers can fit into the target.

(Output space not included.)

---

# Difference From Subsets

Subsets:

Choice:
- Include
- Exclude

After including:

move forward

Combination Sum:

Choice:
- Take
- Skip

After taking:

stay at the same index

because numbers can repeat.

Example:

Combination Sum:

take 2:

[2]

take 2 again:

[2,2]

---

# Common Mistakes

## 1. Moving index after taking a number

Wrong:

backtrack(index + 1)

after choosing nums[index].

This prevents reuse.

Correct:

backtrack(index)

---

## 2. Forgetting to undo choices

Wrong:

currentNums.add(nums[index])

without:

currentNums.remove(...)

This causes later combinations to contain incorrect values.

---

## 3. Mutating currentSum incorrectly

Avoid:

currentSum += nums[index]

unless you undo it later.

Cleaner:

Pass:

currentSum + nums[index]

into the recursive call.

---

# Pattern Recognition

When you see:

- Generate all combinations.
- Numbers can be reused.
- Need all valid combinations.

Think:

Backtracking.

Template:

Choose

↓

Recurse

↓

Undo choice

↓

Choose another path