# Valid Parenthesis String

## Problem

You are given a string containing three possible characters:

- `'('`
- `')'`
- `'*'`

The `'*'` character can represent:

- `'('`
- `')'`
- an empty string

Return `true` if the string can be interpreted as a valid parentheses string.

---

## Example

### Input

```text
s = "(*))"
```

### Output

```text
true
```

### Explanation

Interpret `'*'` as `'('`:

```text
(())
```

which is valid.

---

# Approach

## Greedy + Two Stacks

The challenge is that `'*'` can take multiple meanings.

Instead of deciding immediately what each `'*'` represents, store its position and decide later if needed.

Maintain two stacks:

- One for the indices of `'('`
- One for the indices of `'*'`

The indices are important because a `'*'` can only act as a closing parenthesis if it appears **after** the `'('`.

---

# Algorithm

### Step 1

Maintain:

```java
Stack<Integer> leftStack;
Stack<Integer> starStack;
```

Each stack stores **indices**, not characters.

---

### Step 2

Scan the string from left to right.

For each character:

- `'('` → push its index onto `leftStack`
- `'*'` → push its index onto `starStack`

---

### Step 3

When encountering `')'`:

Prefer matching with a real `'('`.

```java
if (!leftStack.isEmpty())
    leftStack.pop();
```

Otherwise, use a `'*'` as `'('`.

```java
else if (!starStack.isEmpty())
    starStack.pop();
```

If neither exists:

```text
return false
```

---

### Step 4

After processing the string:

Some `'('` may still remain.

Attempt to match each remaining `'('` with a later `'*'`.

Because the stacks store indices:

```java
if (leftIndex > starIndex)
    return false;
```

A `'*'` before a `'('` cannot become its closing parenthesis.

---

### Step 5

If every remaining `'('` can be matched, return:

```text
true
```

---

# Example Walkthrough

Input:

```text
(*()
```

Process:

```
(
left = [0]

*
stars = [1]

(
left = [0,2]

)
left = [0]
```

Finished scanning.

Remaining:

```
left = [0]
stars = [1]
```

Since:

```
1 > 0
```

the star occurs after the `'('`.

Treat it as `')'`.

The string is valid.

---

# Why Greedy Works

Whenever a `')'` appears:

A real `'('` is always preferable to using a `'*'`.

Keeping stars unused provides more flexibility later.

After the scan:

Any remaining `'('` must be closed by stars that appear **after** them.

Using indices guarantees this ordering.

---

# Complexity

Let:

```
n = length of string
```

## Time Complexity

Each character is pushed and popped at most once.

```
O(n)
```

---

## Space Complexity

Two stacks may together store every character.

```
O(n)
```

---

# Pattern Recognition

When you see:

- wildcard characters
- multiple interpretations
- matching symbols
- ordering constraints

Think:

```
Greedy + Stack
```

---

# Related Problems

- Valid Parentheses
- Generate Parentheses
- Minimum Remove to Make Valid Parentheses
- Longest Valid Parentheses