# 🔄 Linked List Cycle

## 🎯 Difficulty
Easy

## 🏷️ Pattern
Linked List + Fast & Slow Pointers (Floyd's Cycle Detection)

---

## ❓ Problem

Given the `head` of a linked list, determine whether the list contains a cycle.

A cycle exists if a node's `next` pointer eventually points back to a previously visited node.

Return:

- `true` if a cycle exists
- `false` otherwise

---

## 💡 Approach

Use two pointers:

- **Slow pointer** moves one node at a time.
- **Fast pointer** moves two nodes at a time.

If the linked list contains a cycle, the fast pointer will eventually catch up to the slow pointer.

If the fast pointer reaches `null`, the list has no cycle.

---

## 🧠 Key Insight

Instead of remembering every visited node using a `HashSet`, we exploit the different pointer speeds.

Inside a cycle:

- Slow gains 1 node per iteration.
- Fast gains 2 nodes per iteration.

Eventually, fast "laps" slow and they meet.

---

## 🚀 Algorithm

1. Initialize:
   - `slow = head`
   - `fast = head`
2. While `fast` and `fast.next` exist:
   - Move slow one step
   - Move fast two steps
3. If the pointers meet:
   - Return `true`
4. If fast reaches `null`:
   - Return `false`

---

## ⏱️ Time Complexity

```text
O(n)
```

Each pointer traverses the list at most once.

---

## 💾 Space Complexity

```text
O(1)
```

Only two pointers are used.

---

## 🔑 Why This Works

If there is no cycle:

- Fast eventually reaches the end of the list.

If there is a cycle:

- Fast moves faster than slow.
- Inside the loop, the distance between them decreases until they meet.

---

## 📚 What I Learned

- Floyd's Cycle Detection algorithm
- Two-pointer traversal
- Cycle detection without extra memory
- Why different pointer speeds guarantee a meeting point

---

## 🧠 Pattern Recognition

If you see:

- detect cycle
- linked list loop
- repeated traversal

Think:

✔ Fast & Slow Pointers

✔ Floyd's Cycle Detection

---

## 🔄 Similar Problems

- Linked List Cycle II
- Find the Duplicate Number
- Happy Number