# Generate Parentheses - Notes

## Pattern

Backtracking

Generate every valid parenthesis string.

Instead of generating all possibilities and checking validity afterwards, only build valid strings.

---

# Recursive State

Need:

StringBuilder current

int open

int close

open

Number of '(' already used.

close

Number of ')' already used.

---

# Rules

Can add '(' if:

open < n

Can add ')' if:

close < open

These two rules guarantee every partial string is valid.

---

# Base Case

When:

current.length() == 2 * n

A complete valid string has been built.

Store:

result.add(current.toString())

---

# Choose → Recurse → Undo

Opening parenthesis:

current.append('(')

backtrack(...)

current.deleteCharAt(current.length() - 1)

Closing parenthesis:

current.append(')')

backtrack(...)

current.deleteCharAt(current.length() - 1)

Always undo after recursion.

---

# Example

n = 2

Start:

""

↓

Add '('

"("

↓

Add '('

"(("

↓

Add ')'

"(()"

↓

Add ')'

"(())"

Save.

Backtrack.

Explore:

"()"

↓

"()("

↓

"()()"

Save.

---

# Why close < open?

Suppose:

current = "()("

open = 2

close = 1

We may add ')'.

Suppose:

current = "()()"

open = 2

close = 2

Cannot add ')'.

There is no unmatched '(' remaining.

---

# Why StringBuilder?

Efficient.

Modify:

append()

Undo:

deleteCharAt()

No new String objects are created during recursion.

---

# Common Bugs

## Incrementing open when adding ')'

Wrong:

backtrack(open + 1, close)

Correct:

backtrack(open, close + 1)

---

## Forgetting undo

Every append must have:

deleteCharAt()

---

## Allowing too many closing brackets

Wrong:

close <= open

Correct:

close < open

---

# Complexity

Valid answers:

Catalan(n)

Time:

O((4^n) / √n)

Space:

O(n)

Recursion depth:

2n

(Output not included.)

---

# Mental Model

Imagine building the string from left to right.

At every position ask:

Can I place '('?

If yes:

branch left.

Can I place ')'?

If yes:

branch right.

The recursion tree never contains invalid strings because impossible choices are never explored.

---

# Recognition

If the problem asks:

- Generate all valid combinations
- Maintain validity during construction
- Every partial solution must satisfy constraints

Think:

Backtracking + Constraints

State:

current string

↓

open count

↓

close count

Decision:

Add '('

or

Add ')'

only if the constraints allow it.