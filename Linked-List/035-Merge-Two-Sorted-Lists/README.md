# 🔗 Merge Two Sorted Lists

## 🎯 Difficulty
Easy

## 🏷️ Pattern
Linked List + Two Pointers + Dummy Node

---

## ❓ Problem

You are given two sorted linked lists `list1` and `list2`.

Merge them into one sorted linked list and return the head of the merged list.

---

## 💡 Approach

We use two pointers to traverse both lists and always attach the smaller node to the result list.

A dummy node is used to simplify edge cases and avoid handling the head separately.

---

## 🧠 Key Insight

Instead of building a new list, we **reuse existing nodes** and rearrange pointers.

A dummy node allows us to always attach nodes safely.

---

## 🚀 Algorithm

1. Create a dummy node
2. Use a `curr` pointer to build the new list
3. While both lists are non-empty:
   - Compare values
   - Attach smaller node to `curr.next`
   - Move pointer forward
4. Attach remaining nodes (if any)
5. Return `dummy.next`

---

## ⏱️ Time Complexity

```text
O(m + n)
```

Each node is visited once.

---

## 💾 Space Complexity

```text
O(1)
```

No extra data structures used (in-place merging).

---

## 🔑 Why This Works

We always pick the smallest available node from either list, preserving sorted order.

---

## 📚 What I Learned

- Dummy node simplifies linked list problems
- Two-pointer merging technique
- Reusing nodes instead of creating new ones
- Handling edge cases cleanly

---

## 🧠 Pattern Recognition

If you see:

- two sorted linked lists
- merging or combining structures
- maintaining sorted order

Think:

✔ Two pointers  
✔ Dummy node  
✔ Greedy selection of smallest node  