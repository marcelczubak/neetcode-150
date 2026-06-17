# 🧱 Valid Parentheses

## 🎯 Difficulty
Easy

## 🏷️ Pattern
Stack

---

## ❓ Problem

Given a string `s` containing only the characters:

```text
( ) { } [ ]
```

Determine if the input string is valid.

A string is valid if:

1. Every opening bracket has a corresponding closing bracket.
2. Brackets close in the correct order.
3. Every closing bracket has a matching opening bracket.

---

## 💡 Approach

Use a stack to keep track of opening brackets.

### Strategy

- Push every opening bracket onto the stack.
- When a closing bracket is encountered:
  - The stack must not be empty.
  - The top of the stack must contain the matching opening bracket.
- After processing the string:
  - The stack should be empty.

---

## 🧠 Key Insight

The most recently opened bracket must be the first one closed.

This is exactly the behavior of a stack:

> Last In, First Out (LIFO)

---

## 🚀 Algorithm

1. Return false if length is odd.
2. Iterate through the string.
3. Push opening brackets.
4. For closing brackets:
   - Check stack is not empty.
   - Pop and verify matching pair.
5. Return true only if stack is empty at the end.

---

## ⏱️ Time Complexity

O(n)

Each bracket is pushed and popped at most once.

---

## 💾 Space Complexity

O(n)

In the worst case, all characters are opening brackets.

---

## 🔑 Why This Works

A stack naturally models nested structures.

The most recently opened bracket must be matched before earlier brackets.

---

## 📚 What I Learned

- Stacks are ideal for matching and nesting problems.
- Early exits simplify validation logic.
- An odd-length string can never form valid bracket pairs.
- LIFO ordering matches nested parentheses behavior.

---

## 🧠 Pattern Recognition

If you see:

- Matching symbols
- Nested structures
- Expression validation
- Balanced parentheses

Think:

✔ Stack  
✔ Push opening symbols  
✔ Pop on closing symbols  

---

## 🔄 Similar Problems

- Min Stack
- Daily Temperatures
- Evaluate Reverse Polish Notation
- Generate Parentheses
- Decode String