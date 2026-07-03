# 📝 Notes

---

# 🏷️ Pattern Breakdown

This problem is NOT a single technique.

It is a combination of 3 patterns:

### 1. Fast & Slow Pointer
Used to find the middle of the list.

### 2. Linked List Reversal
Used to reverse the second half.

### 3. Two Pointer Merge
Used to weave two lists together.

---

# 📌 Step 1 — Find Middle

Use:

```java
slow = head;
fast = head;
```

Move:
- slow → 1 step
- fast → 2 steps

When fast reaches end:

```
slow = middle
```

---

# 📌 Step 2 — Split List

Break the list into two halves:

```
second = slow.next;
slow.next = null;
```

This is crucial to avoid cycles.

---

# 📌 Step 3 — Reverse Second Half

Standard reverse pattern:

```java
prev = null;
curr = second;
```

At each step:

```
next = curr.next;
curr.next = prev;
prev = curr;
curr = next;
```

Result:

```
5 → 4 → 3 → null
```

---

# 📌 Step 4 — Merge Lists

Weave nodes alternately:

```
L1: 1 → 2 → 3
L2: 5 → 4
```

Result:

```
1 → 5 → 2 → 4 → 3
```

---

# ⚠️ Important Edge Case

Always handle:

```
head == null or head.next == null
```

Return immediately.

---

# 🧠 Key Insight

The problem looks complex but reduces to:

```
Split → Reverse → Merge
```

This is a **pattern stacking problem**, not a new algorithm.

---

# 🚀 Complexity

- Time: O(n)
- Space: O(1)

---

# 🔑 Interview Tip

If you recognize:

- "reorder"
- "zig-zag list"
- "interleave ends"

Think immediately:

👉 find middle + reverse second half + merge