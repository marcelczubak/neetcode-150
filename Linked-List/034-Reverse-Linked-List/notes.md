# 📝 Notes

---

## 🏷️ Pattern

Linked List Reversal (Two/Three Pointer Technique)

---

## 🧠 Core Idea

We reverse the direction of each node’s pointer:

```text
A → B → C → D

becomes

A ← B ← C ← D
```

---

## 🚀 Algorithm Steps

### Step 1: Initialize pointers

```java
ListNode prev = null;
ListNode curr = head;
ListNode next;
```

---

### Step 2: Iterate through list

While current node exists:

```java
while (curr != null)
```

---

### Step 3: Store next node

```java
next = curr.next;
```

We must store this before breaking the link.

---

### Step 4: Reverse pointer

```java
curr.next = prev;
```

---

### Step 5: Move pointers forward

```java
prev = curr;
curr = next;
```

---

### Step 6: Return new head

```java
return prev;
```

---

## 🧪 Example

Input:

```text
1 → 2 → 3 → 4 → null
```

Step-by-step:

```text
prev = null
curr = 1

1 → null

prev = 1
curr = 2

2 → 1 → null

prev = 2
curr = 3

3 → 2 → 1 → null

prev = 4
```

Output:

```text
4 → 3 → 2 → 1 → null
```

---

## ⚠️ Common Mistakes

- Losing reference to `next`
- Reversing pointer before storing next node
- Forgetting to update `curr`
- Returning `head` instead of `prev`

---

## 🔄 Alternative Approaches

### ❌ Recursive reversal
- Cleaner but uses O(n) stack space

### ✅ Iterative reversal
- O(1) space
- Preferred in interviews

---

## 🎯 Pattern Recognition

If you see:

- reverse linked list
- in-place pointer changes
- chain re-linking

Think:

✔ prev / curr / next pointers  
✔ iterative reversal  
✔ O(1) space transformation  

---

## 🧩 Key Insight

You are not moving nodes.

You are only changing:

```text
.next pointers
```

to reverse the direction of the chain.