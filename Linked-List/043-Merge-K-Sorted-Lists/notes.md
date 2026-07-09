# Merge K Sorted Linked Lists - Notes

---

## Pattern

```
Divide and Conquer
+
Linked List Manipulation
```

---

## Main Insight

The important observation:

Each linked list is already sorted.

Therefore, do not combine all nodes and sort again.

Instead:

```
Merge sorted lists together.
```

---

## Naive Approach

Merge one list at a time:

```
L1 + L2

↓

(L1 + L2) + L3

↓

((L1 + L2) + L3) + L4
```

Problem:

The merged list gets larger every time.

This causes unnecessary work.

---

## Optimal Approach

Use pairwise merging:

```
A B C D E F

↓

AB CD EF

↓

ABCD EF

↓

ABCDEF
```

This reduces the number of lists by half every round.

---

# Why use List<ListNode>?

Input:

```java
ListNode[] lists
```

The size cannot change.

After merging:

```
6 lists

↓

3 lists

↓

2 lists

↓

1 list
```

A dynamic list makes this easier:

```java
List<ListNode> current
```

---

# Merge Function

Same logic as:

```
Merge Two Sorted Lists
```

Example:

```
A:
1 -> 4

B:
2 -> 3
```

Compare:

```
1 vs 2

take 1

4 vs 2

take 2

4 vs 3

take 3

take remaining 4
```

Result:

```
1 -> 2 -> 3 -> 4
```

---

# Dummy Node Technique

Instead of:

```
head = null
```

Use:

```
dummy -> result
```

Example:

```
dummy

curr
 |
 v

dummy -> 1 -> 2 -> 3
```

At the end:

```java
return dummy.next;
```

Advantages:

- avoids special cases
- easier pointer management

---

# Divide and Conquer Structure

Outer loop:

```java
while(current.size() > 1)
```

means:

"Keep merging until one list remains."

---

Pair merging:

```java
for(int i = 0; i < current.size(); i += 2)
```

means:

```
0 + 1

2 + 3

4 + 5
```

---

# Complexity

Let:

```
N = total nodes
k = number of lists
```

Each merge round processes all nodes:

```
O(N)
```

Number of rounds:

```
log(k)
```

Therefore:

```
O(N log k)
```

Space:

```
O(k)
```

---

# Interview Recognition

If you see:

- multiple sorted lists
- merge everything
- linked lists

Think:

```
Merge Two Sorted Lists
+
Divide and Conquer
```

Alternative:

```
Priority Queue / Min Heap
```

also works:

```
O(N log k)
```

but divide-and-conquer avoids extra heap operations.