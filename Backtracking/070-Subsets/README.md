# Subsets

## Problem

Given an integer array `nums` of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets, and the order of the subsets does not matter.

---

# Approach

## Backtracking

Each element has exactly **two choices**:

- Include it in the current subset.
- Exclude it from the current subset.

This creates a decision tree where every path represents one unique subset.

Example:

nums = [1,2,3]

                           []
                         /    \
                    take1     skip1
                    /   \      /   \
               take2 skip2 take2 skip2
                  ...             ...

Whenever we reach the end of the array, we have built one complete subset.

---

# Algorithm

Maintain:

- An index representing which number we're currently deciding on.
- A list representing the current subset being built.

At each recursive call:

1. Include nums[index].
2. Recurse.
3. Backtrack by removing the element.
4. Exclude nums[index].
5. Recurse again.

---

# Backtracking

Backtracking means undoing the previous decision before exploring another branch.

Example:

Current subset:

[1]

Include 2:

[1,2]

Recurse...

Return...

Remove 2:

[1]

Now explore the branch where 2 is excluded.

Without removing the element, every future subset would incorrectly contain it.

---

# Base Case

When:

index == nums.length

all decisions have been made.

Store a copy of the current subset.

Important:

Use

new ArrayList<>(subset)

instead of

subset

otherwise every answer would reference the same list.

---

# Complexity Analysis

Let:

n = nums.length

There are:

2^n

possible subsets.

Each subset may contain up to:

n

elements.

Time Complexity:

O(n × 2^n)

Space Complexity:

O(n)

(recursion stack and current subset)

The output itself requires O(n × 2^n) space.

---

# Pattern Recognition

Whenever you see:

- Generate every possible combination
- Include / Exclude decisions
- Need every subset

Think:

Backtracking

The recursion template is:

Choose

↓

Recurse

↓

Undo choice

↓

Explore next choice