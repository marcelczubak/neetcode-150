# Subsets II - Notes

## Pattern

Backtracking

This problem is almost identical to Subsets.

The only addition is handling duplicate values.

---

# Core Idea

Each element has two choices:

Take it.

Skip it.

The recursion tree is the same as the original Subsets problem.

The only change:

When skipping a value, skip every duplicate immediately after it.

---

# Why Sort?

Sort first:

Arrays.sort(nums)

Example:

Before:

[2,1,2]

After:

[1,2,2]

Duplicates become adjacent.

Now they can be skipped together.

---

# Recursive State

Need:

index

Current position in nums.

subset

Current subset being built.

---

# Include Branch

Choose:

subset.add(nums[index])

Recurse:

index + 1

This explores subsets containing the current value.

---

# Undo

After recursion:

subset.remove(subset.size() - 1)

Always undo before exploring another branch.

---

# Skip Branch

Before skipping:

Move past every duplicate.

while (index + 1 < nums.length &&
       nums[index] == nums[index + 1])

    index++;

Then recurse:

index + 1

This removes duplicate recursion paths.

---

# Example

nums:

[1,2,2]

Take first 2:

[2]

↓

Take second 2:

[2,2]

Valid.

Skip first 2:

Skip second 2 also.

Do NOT create another:

[2]

subset.

---

# Why Skip Only On Exclude?

Example:

nums = [2,2]

Take first:

[2]

↓

Take second:

[2,2]

Valid.

Problem occurs only when excluding:

Skip first.

↓

Take second.

Produces another:

[2]

Therefore duplicate pruning belongs only on the exclude branch.

---

# Base Case

If:

index == nums.length

Save:

new ArrayList<>(subset)

Return.

---

# Common Bugs

## Forgetting Arrays.sort()

Duplicate detection fails.

---

## Removing duplicates completely

Wrong.

Duplicate values can both appear.

Example:

[2,2]

is valid.

---

## Skipping duplicates before including

Wrong.

Removes valid subsets.

---

## Forgetting backtracking

Always:

add()

↓

recurse()

↓

remove()

---

## Forgetting copy

Wrong:

result.add(subset)

Correct:

result.add(new ArrayList<>(subset))

---

# Complexity

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

Recursion depth + subset.

---

# Mental Model

Think exactly like Subsets.

For every value:

Take it.

or

Skip it.

The only difference:

If you skip a value, skip every duplicate immediately after it as well.

This removes duplicate recursion branches while keeping valid subsets containing duplicates.

---

# Pattern Recognition

When you see:

- Generate all subsets.
- Duplicate values exist.
- Duplicate subsets are not allowed.

Think:

Backtracking

↓

Sort

↓

Take

↓

Undo

↓

Skip duplicates

↓

Skip