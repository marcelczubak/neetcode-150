# 📝 Notes

---

## 🏷️ Pattern

Stack (Expression Evaluation)

---

## 🧠 Core Idea

Reverse Polish Notation ensures:

> Operators always come after their operands

So we can evaluate left-to-right using a stack.

---

## 🚀 Strategy

### Step 1: Iterate tokens

For each token:

---

### Step 2: If number

Push to stack:

```java
stack.push(num);
```

---

### Step 3: If operator

Pop two values:

```text
right = stack.pop()
left = stack.pop()
```

Apply operation:

- left op right

Push result back.

---

## ⚠️ Common Mistakes

- Reversing operand order:
  - wrong: right - left
  - correct: left - right
- Forgetting integer conversion
- Not handling division truncation toward zero
- Assuming operator comes first (it comes after operands)
- Popping only one operand instead of two

---

## 🔄 Alternative Approaches

### 1️⃣ Stack (Optimal)

O(n) time, O(n) space

---

### 2️⃣ Expression Tree

Build tree then evaluate

More complex, unnecessary for this problem.

---

## 🎯 Pattern Recognition

If you see:

- Postfix expression
- No parentheses
- Operators mixed with numbers
- Evaluation problem

Think:

✔ Stack  
✔ Push numbers  
✔ Pop for operators  

---

## 🧩 Key Insight

The stack represents:

> “waiting operands for the next operation”

Each operator collapses the most recent two values into one.