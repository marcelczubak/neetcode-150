# 🗑️ Remove Nth Node From End of List

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Linked List + Two Pass Traversal

---

## ❓ Problem

Given the head of a linked list, remove the **n-th node from the end** of the list and return the head of the modified list.

Example:

```
Input:

1 → 2 → 3 → 4 → 5
n = 2

Output:

1 → 2 → 3 → 5
```

---

## 💡 Approach

This solution uses **two traversals**.

### Pass 1

Traverse the linked list to determine its total length.

### Pass 2

Since we know the length, we can calculate the index of the node immediately **before** the one to remove.

```
preRemove = length - n
```

Traverse to this node and bypass the target node.

---

## 🧠 Key Insight

Instead of trying to count backwards, convert the problem into counting forwards.

If the list length is known,

```
node before removal = length - n
```

This lets us remove the target node using normal forward traversal.

---

## 🚀 Algorithm

1. Traverse the list to calculate its length.
2. Compute:

```
preRemove = length - n
```

3. Handle the special case where the head must be removed.
4. Traverse to the node before the target.
5. Remove the node by changing one pointer.

```
curr.next = curr.next.next;
```

6. Return the head.

---

## ⏱️ Time Complexity

```
O(n)
```

Two traversals of the list.

---

## 💾 Space Complexity

```
O(1)
```

Only a few pointers are used.

---

## 🔑 Why This Works

Knowing the total length converts the "n-th from the end" problem into a simple forward traversal.

Removing a node in a singly linked list only requires access to the node immediately before it.

---

## 📚 What I Learned

- Computing linked list length
- Translating positions from the end into positions from the beginning
- Removing nodes by rewiring pointers
- Handling head removal as a special case

---

## 🧠 Pattern Recognition

If a problem asks for:

- removing a node
- deleting from the end
- only a singly linked list is available

Think:

- Compute the length
- Convert from end index to front index
- Rewire pointers

For the interview follow-up, learn the **Fast & Slow Pointer** one-pass solution.

---

## 🔄 Similar Problems

- Reverse Linked List
- Merge Two Sorted Lists
- Linked List Cycle
- Middle of the Linked List
- Reorder List
- Remove Linked List Elements