# 🔁 Reorder List

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Linked List
- Fast & Slow Pointer
- Reverse Linked List
- Two Pointers / Merge

---

## ❓ Problem

Given the head of a singly linked list:

```
L0 → L1 → L2 → ... → Ln
```

Reorder it in-place to:

```
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...
```

You must not change node values, only pointers.

---

## 💡 Key Idea

This problem is a combination of 3 classic linked list techniques:

### 1. Find the middle of the list
Use fast & slow pointers.

### 2. Reverse the second half
Reverse nodes from the middle onward.

### 3. Merge two lists alternately
Weave the first half and reversed second half.

---

## 🚀 Algorithm

### Step 1: Find Middle

Use:

```
slow = head
fast = head
```

Move:
- slow → 1 step
- fast → 2 steps

When fast reaches the end, slow is at the middle.

---

### Step 2: Split List

Break the list into two halves:

```
second = slow.next
slow.next = null
```

---

### Step 3: Reverse Second Half

Standard linked list reversal:

```
prev = null
curr = second
```

Iteratively reverse pointers.

---

### Step 4: Merge Alternating

Weave nodes:

```
L0 → Ln → L1 → Ln-1 → ...
```

Use two pointers:
- l1 = first half
- l2 = reversed second half

---

## ⏱️ Complexity

```
Time: O(n)
Space: O(1)
```

---

## 🧠 Key Insight

Instead of trying to reorder in one pass, break it into:

- Find structure
- Reverse part of it
- Merge two lists

This is a **pattern-composition problem**, not a new algorithm.

---

## 🔄 Example

Input:

```
1 → 2 → 3 → 4 → 5
```

Step 1: Split

```
1 → 2 → 3
4 → 5
```

Step 2: Reverse second half

```
5 → 4
```

Step 3: Merge

```
1 → 5 → 2 → 4 → 3
```

---

## 📚 Similar Problems

- Reverse Linked List
- Merge Two Sorted Lists
- Linked List Cycle
- Remove Nth Node From End
- Find Middle of Linked List