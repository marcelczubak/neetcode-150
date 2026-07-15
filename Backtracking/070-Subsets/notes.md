# Subsets - Notes

## Pattern

Backtracking

Each element has exactly two choices:

Take it

OR

Skip it

This creates a binary decision tree.

Example:

nums = [1,2,3]

                     []
                  /      \
               Take1    Skip1
               /   \     /   \
           Take2 Skip2 ...

Every root-to-leaf path represents one subset.

---

# Recursive State

The recursive function only needs two pieces of information:

1. Current index.
2. Current subset.

Template:

backtrack(index, subset)

The subset is modified throughout recursion.

---

# Base Case

When:

index == nums.length

the subset is complete.

Store:

new ArrayList<>(subset)

Never store:

subset

because every recursive call shares the same list.

---

# Recursive Choices

For every number:

Choice 1:

Include it.

subset.add(nums[index])

↓

Recurse

↓

Backtrack

subset.remove(subset.size() - 1)

Choice 2:

Skip it.

Recurse without adding anything.

---

# Why Backtracking?

Suppose:

subset = [1]

Take 2:

subset = [1,2]

After recursion returns:

Remove 2

subset = [1]

Now the "skip 2" branch starts with the correct subset.

Without removing it, every later subset would incorrectly contain 2.

---

# Mental Model

The subset grows and shrinks during recursion.

[]

↓

[1]

↓

[1,2]

↓

[1,2,3]

↓

Backtrack

↓

[1,2]

↓

[1]

↓

[]

The same list is reused throughout the search.

---

# Common Mistakes

1. Forgetting to backtrack.

Always remove the last element after returning from recursion.

2. Forgetting to copy the subset.

Wrong:

result.add(subset)

Correct:

result.add(new ArrayList<>(subset))

3. Incorrect base case.

Stop when:

index == nums.length

not before.

---

# Complexity

Number of subsets:

2^n

Each subset copy takes:

O(n)

Overall Time:

O(n × 2^n)

Recursion depth:

O(n)

Extra Space:

O(n)

(Output excluded)

---

# Key Insight

This problem is entirely about making decisions.

For every element:

Take it

OR

Skip it

Every complete sequence of decisions forms one subset.

---

# Backtracking Template

backtrack(index, subset)

Base case:
    Save copy of subset

Choose current element
Recurse
Undo choice

Skip current element
Recurse

---

# Pattern Recognition

When you see:

- All subsets
- All combinations
- Include / Exclude choices

Think:

Backtracking

This same template appears in:

- Subsets
- Combination Sum
- Combination Sum II
- Palindrome Partitioning
- N Queens
- Letter Combinations of a Phone Number
- Restore IP Addresses