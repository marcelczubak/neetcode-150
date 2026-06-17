# 📝 Notes

---

## 🏷️ Pattern

Stack

---

## 🧠 Core Idea

Opening brackets create expectations.

Closing brackets must satisfy those expectations in reverse order.

A stack is perfect because:

```text
Last opened
↓
First closed
```

---

## 🚀 Strategy

### Opening bracket

Push onto stack.

```java
stack.push(bracket);
```

---

### Closing bracket

1. Stack must not be empty.
2. Pop most recent opening bracket.
3. Verify pair matches.

```java
char open = stack.pop();
```

---

### End of traversal

Stack must be empty.

```java
return stack.isEmpty();
```

---

## ⚠️ Common Mistakes

- Forgetting to check `stack.isEmpty()` before popping
- Returning true without verifying stack is empty
- Matching wrong bracket types
- Ignoring odd-length strings
- Using counters instead of a stack (fails for nesting)

Example:

```text
([)]
```

Counts match, but nesting is invalid.

---

## 🔄 Alternative Implementation

Use a HashMap:

```java
')' -> '('
']' -> '['
'}' -> '{'
```

Then compare using map lookups instead of multiple conditions.

Both approaches are O(n).

---

## 🎯 Pattern Recognition

If you see:

- Balanced parentheses
- Nested expressions
- Matching tags/brackets
- Most-recently-opened relationships

Think:

✔ Stack  
✔ Push opens  
✔ Pop closes  

---

## 🧩 Key Insight

This problem is not about counting brackets.

It is about preserving order.

Example:

```text
([)]
```

Contains correct counts, but invalid ordering.

A stack captures ordering naturally.