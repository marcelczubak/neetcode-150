# Reverse Nodes in k-Group - Notes

---

## Pattern

```
Linked List Reversal
+
Pointer Manipulation
```

---

# Main Idea

Reverse the linked list in chunks of size `k`.

Example:

```
1 -> 2 -> 3 -> 4 -> 5 -> 6

k = 2
```

Process:

```
2 -> 1 -> 4 -> 3 -> 6 -> 5
```

---

# Why Use a Dummy Node?

The first group reversal changes the head.

Without dummy:

```
1 -> 2 -> 3
```

After reversing:

```
3 -> 2 -> 1
```

The head changes from `1` to `3`.

A dummy node avoids special cases:

```
dummy -> 1 -> 2 -> 3
```

After:

```
dummy -> 3 -> 2 -> 1
```

---

# Important Pointers

## groupPrev

Node before the current group.

Example:

```
groupPrev
   |
   v
0 -> 1 -> 2 -> 3
```

---

## kth

Last node in the current group.

For:

```
1 -> 2 -> 3 -> 4
```

with:

```
k = 3
```

```
kth = 3
```

---

## groupNext

Node after the current group.

```
1 -> 2 -> 3 -> 4
          ^
          kth

groupNext = 4
```

---

## groupStart

First node of the group.

Important because after reversal it becomes the tail.

Before:

```
1 -> 2 -> 3
^
groupStart
```

After:

```
3 -> 2 -> 1
         ^
         groupStart
```

---

# Reverse Helper Insight

Normal linked list reversal:

```java
prev = null;
```

For k-group reversal:

```java
prev = end;
```

Why?

Because we want:

Before:

```
1 -> 2 -> 3 -> 4
```

After:

```
3 -> 2 -> 1 -> 4
```

The last node should point to the next group.

---

# Reversal Steps

Given:

```
1 -> 2 -> 3 -> 4
```

Reverse until node 4.

Initial:

```
prev = 4
curr = 1
```

---

Iteration 1:

```
1.next = 4

prev = 1
curr = 2
```

Result:

```
1 -> 4
```

---

Iteration 2:

```
2.next = 1

prev = 2
curr = 3
```

Result:

```
2 -> 1 -> 4
```

---

Iteration 3:

```
3.next = 2

prev = 3
curr = 4
```

Stop.

Result:

```
3 -> 2 -> 1 -> 4
```

---

# Common Mistakes

## 1. Forgetting to save next

Wrong:

```java
curr.next = prev;
curr = curr.next;
```

The original next node is lost.

Correct:

```java
ListNode next = curr.next;

curr.next = prev;

curr = next;
```

---

## 2. Forgetting reconnection

After reversal:

Wrong:

```
dummy -> 1 -> 4
```

Correct:

```java
groupPrev.next = kth;
```

Result:

```
dummy -> 3 -> 2 -> 1 -> 4
```

---

## 3. Not moving groupPrev

After each reversal:

```java
groupPrev = groupStart;
```

because the original start becomes the tail.

---

# Algorithm Template

```
create dummy

groupPrev = dummy

while:

    find kth node

    if no kth:
        return answer

    save groupNext

    reverse group

    connect previous group

    move groupPrev
```

---

# Interview Recognition

When you see:

- Reverse every k nodes
- Linked list
- In-place modification

Think:

```
Dummy Node
+
Find Boundary
+
Reverse Segment
+
Reconnect
```

---

# Complexity

Time:

```
O(n)
```

Space:

```
O(1)
```