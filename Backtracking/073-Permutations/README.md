# Permutations

## Problem

Given an array of distinct integers `nums`, return all possible permutations.

A permutation is an arrangement of all elements where the order matters.

Example:

nums = [1,2,3]

Output:

[
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
]

---

# Approach

## Backtracking

Permutations are solved using backtracking.

Unlike subsets, where we decide:

"Take or skip this element"

Permutations ask:

"Which unused element should be placed next?"

At every recursion level:

1. Try every unused number.
2. Add it to the current permutation.
3. Recurse.
4. Undo the choice.

---

# Recursive State

The helper function tracks:

## permutation

The current ordering being built.

Example:

[1,2]

---

## used[]

A boolean array tracking which numbers are already included.

Example:

nums = [1,2,3]

used:

[true, true, false]

means:

1 and 2 are already in the permutation.

---

# Algorithm

Start with:

permutation = []

used = [false, false, false]


At each step:

Loop through every number.

If the number has not been used:

1. Mark it as used.
2. Add it to the permutation.
3. Recurse.
4. Undo the choice.

---

# Backtracking Example

nums:

[1,2,3]


Start:

[]

Choose 1:

[1]

Choose 2:

[1,2]

Choose 3:

[1,2,3]

Permutation complete.

Save answer.

---

Undo:

Remove 3:

[1,2]

Try another choice.

This allows:

[1,3,2]

and all other possibilities to be explored.

---

# Why We Need used[]

Without tracking used elements:

Starting:

[]

Could choose:

[1,1,1]

which is invalid.

The used array prevents choosing the same index twice.

---

# Base Case

When:

permutation.size() == nums.length

all numbers have been chosen.

Store:

new ArrayList<>(permutation)

A copy is required because the same list is reused during backtracking.

---

# Complexity Analysis

For n numbers:

There are:

n!

possible permutations.

Each permutation contains:

n

elements.

Time Complexity:

O(n × n!)

Space Complexity:

O(n)

For:

- recursion depth
- current permutation
- used array

(Output space not included.)

---

# Difference From Subsets

## Subsets

Order does not matter.

Example:

[1,2]

and

[2,1]

are the same subset.

Uses:

Take / Skip

State:

index

---

## Permutations

Order matters.

Example:

[1,2]

and

[2,1]

are different.

Uses:

Choose any unused number.

State:

used[]

---

# Common Mistakes

## 1. Using an index parameter

Wrong idea:

Move from left to right.

Permutations need to revisit all positions.

Correct:

Loop through every number at every level.

---

## 2. Forgetting to undo choices

After:

permutation.add(nums[i])

must do:

permutation.remove(permutation.size()-1)

---

## 3. Resetting state

Wrong:

Create a new list or used array inside recursion.

The same objects must be modified and restored.

---

# Pattern Recognition

When you see:

- Generate all arrangements.
- Order matters.
- Every element must appear once.

Think:

Backtracking + Used Array

Template:

Choose unused element

↓

Recurse

↓

Undo choice