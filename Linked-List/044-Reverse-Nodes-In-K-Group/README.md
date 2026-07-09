# Reverse Nodes in k-Group

## 🎯 Difficulty
Hard

## 🏷️ Pattern
Linked List Manipulation + Reversal

---

## ❓ Problem

Given the head of a linked list, reverse the nodes of the list `k` at a time and return the modified list.

If the number of nodes remaining is less than `k`, leave them unchanged.

Example:

Input:

```
head = 1 -> 2 -> 3 -> 4 -> 5
k = 3
```

Output:

```
3 -> 2 -> 1 -> 4 -> 5
```

The first group of 3 nodes is reversed, but the remaining 2 nodes stay unchanged.

---

# 💡 Approach

The problem can be broken into three smaller tasks:

1. Find whether a complete group of `k` nodes exists.
2. Reverse exactly those `k` nodes.
3. Reconnect the reversed group back into the list.

The solution uses:

- A dummy node to handle head changes.
- A helper function to find the kth node.
- A helper function to reverse a section of the linked list.

---

# 🧠 Algorithm

## Step 1: Create Dummy Node

A dummy node is placed before the head:

```
dummy -> 1 -> 2 -> 3 -> 4 -> 5
```

This simplifies reconnecting the first reversed group.

Maintain:

```java
groupPrev
```

which always points to the node before the current group.

---

## Step 2: Find kth Node

Use:

```java
getKth(groupPrev, k)
```

This checks if there are at least `k` nodes remaining.

Example:

```
1 -> 2 -> 3 -> 4

k = 3

kth = 3
```

If fewer than `k` nodes exist:

```
return dummy.next
```

because the remaining nodes should not be reversed.

---

## Step 3: Store Group Boundaries

Before reversing:

```
groupPrev
    |
    v
    1 -> 2 -> 3 -> 4
              ^
              kth
```

Store:

```java
groupNext = kth.next;
groupStart = groupPrev.next;
```

`groupNext` marks where the reversal stops.

---

## Step 4: Reverse the Group

The reversal helper uses the standard linked list reversal technique.

The key difference:

Normal reverse:

```java
prev = null;
```

Reverse k-group:

```java
prev = groupNext;
```

This automatically reconnects the reversed section with the next group.

Example:

Before:

```
1 -> 2 -> 3 -> 4
```

After:

```
3 -> 2 -> 1 -> 4
```

---

## Step 5: Reconnect

After reversing:

Connect the previous part of the list to the new group head:

```java
groupPrev.next = kth;
```

Then move:

```java
groupPrev = groupStart;
```

because the original first node is now the end of the reversed group.

---

# Helper Functions

## getKth()

Purpose:

- Finds the kth node from the current position.
- Returns null if fewer than k nodes remain.

---

## reverse()

Purpose:

Reverse nodes from:

```
start
```

until:

```
end (exclusive)
```

The reversal stops when:

```java
curr == end
```

---

# Complexity Analysis

Let:

```
n = number of nodes
```

## Time Complexity

Each node is visited once:

```
O(n)
```

---

## Space Complexity

Only pointers are used:

```
O(1)
```

---

# Key Takeaways

- Use a dummy node when the head may change.
- Always save the next section before modifying pointers.
- Reversing a sub-list is the same as reversing a full list, except:
  - Start `prev` at the node after the group.
  - Stop at the boundary node.
- Linked list problems are mostly about maintaining connections between sections.

---

# Related Problems

- Reverse Linked List
- Reorder List
- Remove Nth Node From End of List
- Merge K Sorted Lists