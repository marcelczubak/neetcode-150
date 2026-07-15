# Combination Sum II - Notes

## Pattern

Backtracking + Sorting + Duplicate Pruning

This is an extension of Combination Sum.

The key differences:

Combination Sum:
- Unlimited reuse of numbers.
- Stay on the same index after choosing.

Combination Sum II:
- Each number can only be used once.
- Move forward after choosing.

---

# Why Sort First?

Before:

[10,1,2,7,6,1,5]

After:

[1,1,2,5,6,7,10]

Sorting allows duplicate values to become neighbours.

Example:

[1,1,2]

Now we can detect:

candidate == previous candidate

---

# Recursive State

The helper tracks:

index

Where we start searching.

currentNums

The current combination.

currentSum

The total sum so far.

Template:

backtrack(index, currentNums, currentSum)

---

# Recursive Choice

Use a loop instead of binary take/skip recursion.

For each candidate:

Choose it.

Recurse.

Undo.

Move to next candidate.

Example:

candidates:

[1,2,5]


Start:

[]

Choose 1:

[1]

Choose 2:

[1,2]

Choose 5:

[1,2,5]

---

# Duplicate Pruning

The important condition:

if (i > index && candidates[i] == candidates[i-1])

skip.

Meaning:

"At this recursion level, I have already tried this value."

Example:

Sorted:

[1,1,2]


Level 0:

Choose first 1.

Skip second 1.

Otherwise:

[]

     /       \

    1         1

would create duplicate branches.

---

# Important Detail

Duplicates are only skipped at the SAME recursion depth.

Valid:

[1,1,6]

Why?

The second 1 is chosen after the first 1.

Different recursion levels.

Invalid:

Choosing the second 1 as a separate branch at the same level.

---

# Backtracking Steps

Choose:

currentNums.add(candidates[i])

Recurse:

backtrack(i + 1)

Undo:

currentNums.remove(currentNums.size()-1)

---

# Why i + 1?

Each candidate can only be used once.

Example:

[2,2,3]

After choosing first 2:

Move past it.

Do not allow selecting it again.

---

# Base Cases

If:

currentSum == target

Save:

new ArrayList<>(currentNums)

Return.

---

If:

currentSum > target

Stop.

The combination is already too large.

---

# Combination Sum Comparison

## Combination Sum

Take:

same index

Example:

2 can become:

2,2,2

---

## Combination Sum II

Take:

next index

Example:

2 can only appear once.

---

# Common Bugs

## Removing incorrectly

Wrong:

currentNums.remove(candidates.size()-1)

The candidate array size is unrelated to the current path.

Correct:

currentNums.remove(currentNums.size()-1)

---

## Forgetting to copy

Wrong:

result.add(currentNums)

Correct:

result.add(new ArrayList<>(currentNums))

---

## Duplicate condition wrong

Wrong:

if (candidates[i] == candidates[i-1])

This removes valid duplicates from deeper levels.

Correct:

if (i > index && candidates[i] == candidates[i-1])

---

# Complexity

Sorting:

O(n log n)

Backtracking:

O(2^n)

Space:

O(n)

Recursion depth + current combination.

---

# Mental Template

Sort array.

Start backtracking.

For each candidate:

    If duplicate at same level:
        skip

    Add candidate

    Recurse forward

    Remove candidate

---

# Pattern Recognition

When you see:

- Find all combinations.
- Cannot reuse elements.
- Input contains duplicates.

Think:

Backtracking + Sorting + Pruning