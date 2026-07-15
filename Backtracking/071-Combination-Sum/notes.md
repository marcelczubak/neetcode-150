# Combination Sum - Notes

## Pattern

Backtracking

This problem is similar to Subsets, but the decision tree behaves differently.

At every index:

Choice 1:
Take the number.

Choice 2:
Skip the number.

The important rule:

Take -> stay on the same index

Skip -> move to the next index

---

# Recursive State

The helper needs:

index

The current number we are considering.

currentNums

The combination being built.

currentSum

The total sum of the current combination.

Template:

backtrack(index, currentNums, currentSum)

---

# Example

nums:

[2,3,6,7]

target:

7


Start:

[]

index = 0


Take 2:

[2]

index stays 0


Take 2 again:

[2,2]

index stays 0


Take 3:

[2,2,3]

sum = 7

Valid answer.

---

# Take Decision

When choosing nums[index]:

Add it:

currentNums.add(nums[index])

Recurse:

backtrack(
    index,
    currentSum + nums[index]
)

The index does not change.

Why?

Because numbers can be used unlimited times.

Example:

[2]

can become:

[2,2]

---

# Skip Decision

After undoing the choice:

currentNums.remove(currentNums.size() - 1)

Skip the current number:

backtrack(
    index + 1,
    currentSum
)

Why?

We no longer want to use this number.

---

# Backtracking

Backtracking means:

1. Make a choice.
2. Explore the consequences.
3. Undo the choice.
4. Try another choice.


Example:

Before:

[]

Choose 2:

[2]

Explore...

Undo:

[]

Try another path.

---

# Important State Rule

The list and sum must always match.

Example:

Correct:

currentNums:

[2,3]

currentSum:

5


Incorrect:

currentNums:

[2]

currentSum:

5


The recursive state is broken.

---

# Base Cases

## Found Combination

If:

currentSum == target

Save:

new ArrayList<>(currentNums)

Return.

---

## Invalid Path

Return when:

index >= nums.length

or:

currentSum > target

---

# Common Mistakes

## Moving index after taking

Wrong:

Take number:

backtrack(index + 1)

This prevents reuse.

Correct:

backtrack(index)

---

## Forgetting to remove

Wrong:

add()

then recurse forever without removing.

Correct:

add()

recurse()

remove()

---

## Saving the same list

Wrong:

result.add(currentNums)

Correct:

result.add(new ArrayList<>(currentNums))

The copy preserves the current combination.

---

# Combination Sum vs Subsets

Subsets:

Include:

move forward

Exclude:

move forward


Combination Sum:

Take:

stay

Skip:

move forward


This is the main difference.

---

# Mental Template

backtrack(index, path, sum)

If sum == target:
    save answer

If invalid:
    return


Take:

    add number

    recurse same index

    remove number


Skip:

    recurse next index

---

# Complexity

Time:

O(n^target)

Space:

O(target)

Recursion depth depends on how many numbers can fit into target.

---

# Pattern Recognition

Whenever you see:

- All combinations
- Reusing elements allowed
- Need combinations that satisfy a condition

Think:

Backtracking with Take / Skip decisions.