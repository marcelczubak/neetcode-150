# 🧮 Evaluate Reverse Polish Notation

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Stack, Expression Evaluation

---

## ❓ Problem

You are given an array of strings `tokens` representing a valid Reverse Polish Notation (RPN) expression.

Evaluate the expression and return the result.

Valid operators:
- +
- -
- *
- /

Division truncates toward zero.

---

## 💡 Approach

Use a stack to evaluate the expression.

### Strategy:

- If token is a number → push to stack
- If token is an operator → pop two values
  - apply operation
  - push result back

---

## 🧠 Key Insight

RPN removes the need for parentheses.

The order of operations is naturally handled by the stack.

---

## 🚀 Algorithm

1. Initialize an empty stack
2. Iterate through tokens
3. If number → push to stack
4. If operator:
   - pop right operand
   - pop left operand
   - compute result
   - push result
5. Final stack element is answer

---

## ⏱️ Time Complexity

O(n)

Each token is processed once.

---

## 💾 Space Complexity

O(n)

Stack holds operands.

---

## 🔑 Why This Works

RPN ensures that every operator appears after its operands.

Stack naturally preserves correct evaluation order.

---

## 📚 What I Learned

- Stack is ideal for expression evaluation
- Operand order matters (left vs right pop order)
- RPN eliminates parentheses complexity
- Every operator reduces stack size by one

---

## 🧠 Pattern Recognition

If you see:

- Expression evaluation
- Postfix notation
- No parentheses
- Operators and operands mixed

Think:

✔ Stack  
✔ Push operands  
✔ Pop on operator  

---

## 🔄 Similar Problems

- Basic Calculator I / II / III
- Infix to Postfix conversion
- Expression Trees