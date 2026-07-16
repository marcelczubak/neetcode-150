# Generate Parentheses

## Problem

Given `n` pairs of parentheses, generate all combinations of well-formed parentheses.

Example:

Input:

n = 3

Output:

[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()"
]

---

# Approach

## Backtracking

Rather than generating every possible string of '(' and ')' and checking if it is valid afterwards, we only build valid strings.

At every step we decide whether to add:

- '('
- ')'

The decision depends on two rules.

---

# State

During recursion we keep track of:

- current string
- number of opening parentheses used
- number of closing parentheses used

Variables:

open

Number of '(' placed.

close

Number of ')' placed.

---

# Decision Rules

## Rule 1

We may add an opening parenthesis if:

open < n

This ensures we never exceed n opening brackets.

---

## Rule 2

We may add a closing parenthesis only if:

close < open

A closing parenthesis must always match a previous opening parenthesis.

This guarantees every partial string remains valid.

---

# Recursive Process

Start with:

current = ""

open = 0

close = 0

At every recursive call:

1. Try adding '(' if possible.
2. Try adding ')' if possible.
3. Undo the choice after recursion.

This follows the classic backtracking pattern:

Choose

↓

Recurse

↓

Undo

---

# Example

For:

n = 2

Start:

""

↓

"("

↓

"(("

↓

"(())"

Save.

Backtrack.

Then explore:

"()"

↓

"()("

↓

"()()"

Save.

Result:

[
"(())",
"()()"
]

---

# Base Case

When:

current.length() == 2 * n

a complete valid string has been constructed.

Store a copy:

result.add(current.toString())

---

# Why StringBuilder?

A StringBuilder is modified in-place.

Choose:

current.append('(')

Undo:

current.deleteCharAt(current.length() - 1)

This avoids creating a new String during every recursive call.

---

# Correctness

The algorithm never creates invalid strings.

Examples like:

")("

or

"(()))("

are impossible because the recursive rules prevent them from ever being built.

Every valid sequence is generated exactly once.

---

# Complexity Analysis

The number of valid parenthesis strings is the nth Catalan number.

Time Complexity:

O((4^n) / √n)

Space Complexity:

O(n)

Recursion depth is at most 2n.

(Output space not included.)

---

# Common Mistakes

## Incrementing the wrong counter

When adding '(':

open++

When adding ')':

close++

---

## Forgetting to undo

After recursion:

current.deleteCharAt(current.length() - 1)

Without undoing, later recursive calls use an incorrect string.

---

## Using close <= open

The correct condition is:

close < open

Otherwise invalid strings may be produced.

---

# Pattern Recognition

When you see:

- Generate every valid string
- Partial solutions must remain valid
- Character-by-character construction

Think:

Backtracking with Constraints

Unlike subsets or permutations, there is no index or used array.

The recursion state consists of:

- current string
- open count
- close count