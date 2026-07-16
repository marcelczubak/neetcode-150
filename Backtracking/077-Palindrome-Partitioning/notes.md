# Palindrome Partitioning - Notes

## Pattern

Backtracking

Generate every possible partition of a string where every piece satisfies a condition.

Condition:

Each substring must be a palindrome.

---

# Core Idea

Instead of choosing individual characters:

Choose substrings.

Example:

s = "aab"


Possible first choices:

"a"

"aa"

"aab"


Only continue with palindrome choices.

---

# Recursive State

Need:

## start

Current index being partitioned.

Example:

"aab"

start = 1

Remaining:

"ab"


## currentPartition

Stores chosen palindrome pieces.

Example:

["aa"]

---

# Backtracking Template

Choose

↓

Explore

↓

Undo


For this problem:

Choose:

substring

Explore:

remaining string

Undo:

remove substring

---

# Algorithm

1. Start at index 0.

2. Try every possible substring:

s[start...end]

3. Check if palindrome.

4. If valid:

add substring

recurse from end + 1

5. Remove substring after recursion.

---

# Example

s:

"aab"


Start:

[]


Choose:

"a"

↓

["a"]


Choose:

"a"

↓

["a","a"]


Choose:

"b"

↓

["a","a","b"]


Save.


Backtrack:

Remove "b"


Try:

"aa"

↓

["aa","b"]


---

# Palindrome Checking

Two pointer approach:

left = start

right = end


Compare:

s[left]

s[right]


Move inward.

If mismatch:

not palindrome.

---

# Important Index Rule

After selecting:

s[start...end]


Next recursion:

end + 1


Example:

"aa" selected:

a a | b
    ^
    next start

---

# Undo Step

After recursion:

remove last substring.


Example:

Before:

["aa","b"]


Undo:

["aa"]


Allows trying another partition.

---

# Common Bugs

## Forgetting backtracking

Need:

add()

recurse()

remove()


---

## Using start + 1

Wrong:

Move one character.


Correct:

Move past the whole substring:

end + 1


---

## Not copying result

Wrong:

result.add(currentPartition)


Correct:

result.add(new ArrayList<>(currentPartition))


---

# Complexity

n = string length


Number of partitions:

2^(n-1)


Palindrome checking:

O(n)


Time:

O(n * 2^n)


Space:

O(n)


---

# Optimisation

Use DP palindrome table.

Precompute:

palindrome[i][j]


Then:

isPalindrome()

becomes:

O(1)


Improved:

O(n * 2^n)

---

# Mental Model

Imagine placing cuts in a string.


Example:

aab


Possible cuts:

a | a | b

aa | b

aab


The recursion tries every possible cut.

Only keep cuts where every piece is a palindrome.


---

# Recognition

If a problem asks:

"Generate every way to split something"

and each piece must satisfy a rule:


Think:

Backtracking + Validation


State:

current partition

start index


Decision:

choose next substring