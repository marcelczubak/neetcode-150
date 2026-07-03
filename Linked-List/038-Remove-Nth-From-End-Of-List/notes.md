# 📝 Notes

---

# 🏷️ Pattern

Linked List

Two-Pass Traversal

---

# 🧠 Core Idea

The problem asks for the **n-th node from the end**, but linked lists can only be traversed forwards.

Instead:

1. Find the total length.
2. Convert the position from the end into a position from the beginning.

---

# 📌 Step 1 — Compute Length

Traverse the list once.

```
1 → 2 → 3 → 4 → 5
```

Length

```
5
```

---

# 📌 Step 2 — Find the Node Before Removal

Suppose

```
n = 2
```

Then

```
preRemove = length - n
```

```
5 - 2 = 3
```

The third node is

```
1 → 2 → 3 → 4 → 5
          ↑
```

The node after it should be removed.

---

# 📌 Step 3 — Remove the Node

Simply skip over it.

Before

```
3 → 4 → 5
```

After

```
3 ─────→ 5
```

Code

```java
curr.next = curr.next.next;
```

---

# 📌 Special Case

If

```
preRemove == 0
```

the node being removed is the head.

Example

```
1 → 2 → 3

n = 3
```

Answer

```
2 → 3
```

Simply return

```java
head.next;
```

---

# 🌊 Example Walkthrough

Input

```
1 → 2 → 3 → 4 → 5

n = 2
```

Length

```
5
```

Compute

```
preRemove = 5 - 2 = 3
```

Traverse to

```
1 → 2 → 3
```

Remove next node

```
1 → 2 → 3 → 5
```

---

# ⚠️ Common Mistakes

## ❌ Forgetting to remove the head

When

```
length == n
```

there is no previous node.

Handle separately.

---

## ❌ Off-by-one Errors

Remember:

```
preRemove = length - n
```

is the number of nodes before the node to remove.

Carefully verify loop boundaries when traversing.

---

## ❌ Accessing `curr.next.next`

Only do this after confirming the target node exists.

---

# 🎯 Pattern Recognition

Whenever you need to remove a node from a singly linked list:

- Find the node before it.
- Change one pointer.

```
curr.next = curr.next.next;
```

Many linked list deletion problems use this exact operation.

---

# 🚀 Interview Follow-up

This solution uses **two passes**.

A more advanced solution uses **Fast and Slow Pointers**:

- Move `fast` ahead by `n` nodes.
- Move both pointers together.
- When `fast` reaches the end, `slow` is immediately before the node to remove.

This solves the problem in **one traversal** while still using **O(1)** extra space.

Both approaches have **O(n)** time complexity, but the fast/slow pointer solution satisfies the follow-up requirement.