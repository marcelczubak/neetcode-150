# 🔁 Reverse Linked List

## 🎯 Difficulty
Easy

## 🏷️ Pattern
Linked List Pointer Manipulation

---

## ❓ Problem

Given the head of a singly linked list, reverse the list and return the new head.

---

## 💡 Approach

We reverse the linked list iteratively by changing the direction of pointers.

Instead of moving forward normally, we redirect each node’s `next` pointer to its previous node.

---

## 🧠 Key Insight

At any point, we maintain three pointers:

- `prev` → already reversed portion
- `curr` → current node being processed
- `next` → temporarily stores the next node

---

## 🚀 Algorithm

1. Initialize:
   - `prev = null`
   - `curr = head`

2. While `curr` is not null:
   - Store `next = curr.next`
   - Reverse pointer: `curr.next = prev`
   - Move `prev` forward
   - Move `curr` forward

3. Return `prev` (new head)

---

## ⏱️ Time Complexity

```text
O(n)
```

Each node is visited once.

---

## 💾 Space Complexity

```text
O(1)
```

Only a few pointers are used.

---

## 🔑 Why This Works

We iteratively reverse the direction of links without losing access to the rest of the list by storing the next node temporarily.

---

## 📚 What I Learned

- How pointer manipulation works in linked lists
- Importance of preserving `next` before modifying links
- Iterative reversal is more efficient than recursion in space

---

## 🧠 Pattern Recognition

If you see:

- reverse linked list
- pointer reordering
- in-place transformation

Think:

✔ Three-pointer technique  
✔ prev / curr / next pattern  
✔ iterative reversal  