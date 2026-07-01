# ➕ Add Two Numbers

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Linked List + Simulation

---

## ❓ Problem

You are given two non-empty linked lists representing two non-negative integers.

- The digits are stored in **reverse order**.
- Each node contains a single digit.
- Return the sum as a linked list in the same reverse order.

Example:

```
2 → 4 → 3
5 → 6 → 4
---------
7 → 0 → 8
```

because

```
342 + 465 = 807
```

---

## 💡 Approach

Simulate the addition exactly like adding numbers by hand.

For each pair of digits:

1. Add the current digits.
2. Include any carry from the previous addition.
3. Create a node containing the current digit.
4. Carry the overflow to the next iteration.

A **dummy node** is used to simplify construction of the answer list.

---

## 🧠 Key Insight

Treat each node as one digit.

Each iteration computes:

```
digit1 + digit2 + carry
```

Then separates the result into:

- current digit
- carry for the next digit

---

## 🚀 Algorithm

1. Create a dummy node.
2. Maintain a pointer (`curr`) to build the answer.
3. While either list still has nodes:
   - Read both digits (use 0 if one list has ended).
   - Compute the sum.
   - Store `sum % 10` in a new node.
   - Update the carry.
4. After the loop, append a final carry if needed.
5. Return `dummy.next`.

---

## ⏱️ Time Complexity

```text
O(max(m, n))
```

where:

- `m` = length of first list
- `n` = length of second list

---

## 💾 Space Complexity

```text
O(max(m, n))
```

The output list stores one node per digit.

---

## 🔑 Why This Works

Each pair of digits is processed exactly once.

The carry is propagated naturally through the linked list.

Using a dummy node avoids special handling for the first node.

---

## 📚 What I Learned

- How to build linked lists using a dummy node
- Simulating arithmetic digit by digit
- Carry propagation
- Handling lists of different lengths

---

## 🧠 Pattern Recognition

If you see:

- linked list arithmetic
- digit-by-digit processing
- carry between iterations

Think:

✔ Simulation

✔ Dummy Node

✔ Linked List Traversal

---

## 🔄 Similar Problems

- Merge Two Sorted Lists
- Reverse Linked List
- Plus One Linked List
- Multiply Strings