# Combination Sum II

## Problem

Given a collection of candidate numbers and a target integer, return all unique combinations where the chosen numbers add up to the target.

Rules:

- Each number may only be used once.
- The solution set must not contain duplicate combinations.
- The order of combinations does not matter.

Example:

candidates = [10,1,2,7,6,1,5]

target = 8

Output:

[1,1,6]
[1,2,5]
[1,7]
[2,6]

---

# Approach

## Backtracking

This problem uses backtracking to explore possible combinations.

Unlike Combination Sum:

- Numbers cannot be reused.
- Duplicate combinations must be prevented.

The recursive process:

1. Choose a candidate.
2. Add it to the current combination.
3. Recurse using the remaining candidates.
4. Undo the choice.
5. Try another candidate.

---

# Sorting

Before backtracking:

Arrays.sort(candidates)

Sorting is required because it allows duplicate detection.

Example:

Before:

[10,1,2,7,6,1,5]

After:

[1,1,2,5,6,7,10]

Now duplicates are adjacent.

---

# Duplicate Handling

Even though duplicate values exist, we only want unique combinations.

Example:

[1,1,2]

At the same recursion level:

        []

       /  \
      1    1

The second branch creates the same combinations.

Skip duplicate candidates:

if:

i > index

and:

candidates[i] == candidates[i-1]

continue

Important:

The duplicate check only applies to the same recursion depth.

Duplicates can still be used if they come from different levels.

Example:

[1,1,6]

is valid.

---

# Recursive State

The helper tracks:

## index

The position to start searching from.

Because numbers cannot be reused:

After choosing a number:

move to:

index + 1

---

## currentNums

The current combination being built.

Example:

[1,2]

---

## currentSum

The sum of the current combination.

Example:

1 + 2 = 3

---

# Backtracking Logic

For each candidate:

## Choose

Add the candidate:

currentNums.add(candidates[i])

Recurse:

backtrack(i + 1)

Because each number can only be used once.

---

## Undo

Remove the chosen number:

currentNums.remove(currentNums.size() - 1)

This restores the previous state.

---

# Base Cases

## Target Reached

If:

currentSum == target

Store:

new ArrayList<>(currentNums)

Then return.

---

## Invalid Path

Stop if:

- Current sum exceeds target.
- No candidates remain.

---

# Combination Sum vs Combination Sum II

## Combination Sum

Numbers can repeat.

Example:

[2,2,2]

Decision:

Take:

stay on same index

Skip:

move forward

---

## Combination Sum II

Numbers can only be used once.

Decision:

Take:

move to next index

Skip:

move to next index

---

# Complexity Analysis

Let:

n = number of candidates

Sorting:

O(n log n)

Backtracking:

O(2^n)

because every candidate can be included or excluded.

Overall:

O(n log n + 2^n)

Space:

O(n)

for recursion depth and current combination.

(Output space not included.)

---

# Common Mistakes

## 1. Forgetting to sort

Without sorting, duplicate detection becomes difficult.

---

## 2. Skipping all duplicates

Wrong:

Remove every duplicate value.

Example:

[1,1,6]

is valid.

Only skip duplicates at the same recursion depth.

---

## 3. Forgetting index + 1

Numbers cannot be reused.

Wrong:

backtrack(i)

Correct:

backtrack(i + 1)

---

## 4. Not copying the list

Wrong:

result.add(currentNums)

Correct:

result.add(new ArrayList<>(currentNums))

---

# Pattern Recognition

When you see:

- Generate combinations.
- Numbers cannot repeat.
- Duplicate values exist.

Think:

Backtracking + Sorting + Duplicate Pruning

Template:

Sort

↓

Choose candidate

↓

Recurse forward

↓

Undo choice

↓

Skip duplicates