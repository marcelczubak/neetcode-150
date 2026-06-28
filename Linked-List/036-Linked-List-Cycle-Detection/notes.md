# 📝 Notes

---

# 🏷️ Pattern

Fast & Slow Pointers (Tortoise and Hare)

---

# 🧠 Core Idea

Two pointers move through the linked list at different speeds.

```
slow → 1 step

fast → 2 steps
```

If a cycle exists:

```
fast eventually catches slow.
```

If not:

```
fast reaches null.
```

---

# 🌊 Visualization

```
1 → 2 → 3 → 4 → 5
          ↑     ↓
          ← ← ←
```

Traversal:

```
Iteration 1

S → 2
F → 3

Iteration 2

S → 3
F → 5

Iteration 3

S → 4
F → 4

Pointers meet

Cycle detected
```

---

# 📌 Initialization

```java
ListNode slow = head;
ListNode fast = head;
```

Both pointers start at the head.

---

# 📌 Loop Condition

```java
while (fast != null && fast.next != null)
```

This guarantees:

```java
fast.next.next
```

is safe to access.

---

# 📌 Move Pointers

```java
slow = slow.next;
fast = fast.next.next;
```

---

# 📌 Check for Meeting

```java
if (slow == fast)
    return true;
```

Meeting means a cycle exists.

---

# 📌 No Cycle

If the loop exits:

```java
return false;
```

Fast reached the end.

---

# 🧪 Example

```
1 → 2 → 3 → 4 → 5
          ↑     ↓
          ← ← ←
```

Steps:

```
slow: 1 → 2 → 3 → 4

fast: 1 → 3 → 5 → 4
```

They eventually meet.

---

# ⚠️ Common Mistakes

## ❌ Starting `fast = head.next`

It works in some implementations but complicates the logic.

Starting both at `head` is simpler and more common.

---

## ❌ Looping only on `fast != null`

Always check:

```java
fast != null && fast.next != null
```

Otherwise:

```java
fast.next.next
```

may throw a `NullPointerException`.

---

## ❌ Moving fast manually

Avoid:

```java
fast = fast.next;
fast = fast.next;
```

Simply write:

```java
fast = fast.next.next;
```

after checking the loop condition.

---

# 🎯 Pattern Recognition

If a linked list problem asks:

- detect a loop
- repeated nodes
- cycle

Think:

✔ Floyd's Cycle Detection

✔ Fast & Slow Pointers

✔ O(1) extra space

---

# 💭 Mental Model

Imagine two runners on a circular track.

- Slow runs one step at a time.
- Fast runs two steps at a time.

If the track is circular, the faster runner must eventually lap the slower runner.

If the track has an end, the faster runner eventually runs off the track.

This intuition explains why Floyd's algorithm correctly detects cycles while using only two pointers.
```