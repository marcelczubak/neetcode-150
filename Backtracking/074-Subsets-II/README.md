# Subsets II

## Problem

Given an integer array `nums` that may contain duplicates, return all possible subsets.

The solution set must not contain duplicate subsets.

Example:

Input:

nums = [1,2,2]

Output:

[
[],
[1],
[2],
[1,2],
[2,2],
[1,2,2]
]

---

# Approach

## Backtracking (Take / Skip)

This solution extends the original Subsets problem using the same take/skip recursion.

For every element we have two choices:

1. Include the current number.
2. Exclude the current number.

Unlike the original problem, duplicate values exist, so we must avoid generating duplicate subsets.

---

# Sorting

Before recursion:

Arrays.sort(nums)

Example:

Before:

[2,1,2]

After:

[1,2,2]

Sorting places duplicate values beside each other, allowing us to skip them together.

---

# Recursive State

The helper function keeps track of:

index

The current position in the array.

subset

The subset currently being built.

---

# Decision 1: Include

Choose the current number.

Example:

subset.add(nums[index])

Move to the next index.

This explores every subset containing this value.

---

# Undo Choice

After returning:

subset.remove(subset.size() - 1)

This restores the subset before exploring another path.

---

# Decision 2: Exclude

When excluding the current value, skip every duplicate immediately following it.

Example:

nums:

[1,2,2,2,5]

If we decide not to include the first 2, we also skip the remaining 2's.

Code:

while (index + 1 < nums.length &&
       nums[index] == nums[index + 1]) {
    index++;
}

Then recurse.

This prevents duplicate subsets from being generated.

---

# Example

nums:

[1,2,2]

Decision tree:

[]

├── Include 1
│   ├── Include 2
│   │   ├── Include 2
│   │   └── Skip 2
│   └── Skip duplicate 2
└── Skip 1

Duplicate branches are removed automatically.

---

# Base Case

When:

index == nums.length

every decision has been made.

Store a copy:

result.add(new ArrayList<>(subset))

---

# Why Skip Duplicates Only On The Exclude Branch?

Suppose:

nums = [2,2]

Including both values is valid:

[2,2]

The only duplicate occurs when we skip the first 2 but later include the second 2.

Therefore duplicate pruning only belongs on the exclude branch.

---

# Complexity Analysis

Sorting:

O(n log n)

Backtracking:

O(2^n)

Copying subsets:

O(n)

Overall:

O(n × 2^n)

Space:

O(n)

Recursion depth and current subset.

(Output space not included.)

---

# Common Mistakes

## Forgetting to sort

Duplicate skipping only works when equal values are adjacent.

---

## Skipping duplicates before the include branch

Doing so removes valid subsets like:

[2,2]

---

## Forgetting to undo

Always remove the last element before exploring the exclude branch.

---

## Forgetting to copy the subset

Wrong:

result.add(subset)

Correct:

result.add(new ArrayList<>(subset))

---

# Pattern Recognition

When you see:

- Generate every subset.
- Input contains duplicates.
- Duplicate subsets are not allowed.

Think:

Backtracking + Sorting + Duplicate Skipping

Template:

Take

↓

Undo

↓

Skip duplicate values

↓

Skip