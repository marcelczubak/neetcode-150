# Valid Parenthesis String Notes

## Pattern

- Greedy
- Stack
- Deferred Decisions

---

# Core Insight

The `'*'` character has three possible meanings:

```
'('

')'

empty
```

Instead of choosing immediately, postpone the decision until it becomes necessary.

---

# Data Structures

Maintain two stacks:

```java
Stack<Integer> leftStack;
Stack<Integer> starStack;
```

Both store **indices**, not characters.

---

# Why Store Indices?

Order matters.

Example:

```text
*(
```

The star occurs before the `'('`.

It cannot later become:

```text
()
```

because a closing parenthesis cannot appear before its opening parenthesis.

Therefore compare positions:

```java
leftIndex < starIndex
```

Only then can the star close that `'('`.

---

# Processing Rules

### `'('`

Push onto:

```java
leftStack
```

---

### `'*'`

Push onto:

```java
starStack
```

---

### `')'`

Always try to match:

1. Real `'('`
2. Otherwise `'*'`

```java
if (!leftStack.isEmpty())
    leftStack.pop();
else if (!starStack.isEmpty())
    starStack.pop();
else
    return false;
```

Using a real `'('` first preserves the flexibility of stars.

---

# Final Matching

After scanning:

Some `'('` may remain.

Try to match each with a later star.

While both stacks contain elements:

```java
if (leftStack.pop() > starStack.pop())
    return false;
```

If the `'('` appears after the star, no valid interpretation exists.

---

# Example

Input:

```text
(*()
```

Stacks after scanning:

```
left = [0]
stars = [1]
```

Compare:

```
0 < 1
```

The star can become:

```
)
```

Result:

```
true
```

---

# Why Greedy Works

A `'*'` can replace either parenthesis.

Using it too early wastes flexibility.

Matching real `'('` first is always optimal because stars remain available for future unmatched parentheses.

---

# Common Mistakes

## Treating every `'*'` as `'('`

Fails on:

```text
*)
```

---

## Treating every `'*'` as `')'`

Fails on:

```text
(*
```

---

## Ignoring order

Wrong:

```
*(
```

The star cannot close a parenthesis that appears later.

Indices solve this problem.

---

# Interview Explanation

"I maintain two stacks storing the indices of `'('` and `'*'`. When I encounter a closing parenthesis, I greedily match it with a real opening parenthesis if possible; otherwise I use a star. After processing the string, any remaining opening parentheses must be matched with stars that appear later in the string. Comparing indices guarantees the ordering is valid."

---

# Complexity

Time:

```
O(n)
```

Space:

```
O(n)
```

---

# Optimisation

Modern Java prefers:

```java
Deque<Integer> leftStack = new ArrayDeque<>();
Deque<Integer> starStack = new ArrayDeque<>();
```

instead of:

```java
Stack<Integer>
```

because `ArrayDeque` is faster and is the recommended stack implementation.

---

# Key Takeaway

The important insight is not the wildcard itself.

It is that **wildcards should remain undecided until they are actually needed**, and storing their positions lets us verify that any interpretation respects the order of the parentheses.