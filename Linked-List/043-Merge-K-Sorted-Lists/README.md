# Merge K Sorted Linked Lists

## 🎯 Difficulty
Hard

## 🏷️ Pattern
Divide and Conquer + Linked List Merge

---

## ❓ Problem

Given an array of `k` sorted linked lists, merge all the linked lists into one sorted linked list.

Example:

Input:

```
[
1 -> 4 -> 5,
1 -> 3 -> 4,
2 -> 6
]
```

Output:

```
1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
```

---

# 💡 Approach

This problem builds on the **Merge Two Sorted Lists** problem.

Instead of merging every list one-by-one:

```
(((L1 + L2) + L3) + L4)
```

which becomes inefficient, we merge lists in pairs using a divide-and-conquer approach.

Similar to merge sort:

```
L1 L2 L3 L4 L5 L6

↓

L1+L2   L3+L4   L5+L6

↓

L1+L2+L3+L4   L5+L6

↓

All merged
```

---

# 🧠 Algorithm

## Step 1: Convert Array to List

The input is:

```java
ListNode[] lists
```

Convert it to:

```java
List<ListNode>
```

This allows us to dynamically remove the number of lists after every merging round.

---

## Step 2: Merge Lists in Pairs

While more than one list remains:

```java
while(current.size() > 1)
```

Merge adjacent pairs:

```
0 with 1

2 with 3

4 with 5
```

Each merged list is stored in a new list.

---

## Step 3: Repeat

After each round:

```
current = merged
```

The number of linked lists decreases by half each round.

Eventually:

```
current.size() == 1
```

The remaining list is the final answer.

---

# 🔄 Example Walkthrough

Input:

```
A = 1->4
B = 2->5
C = 3->6
D = 7->8
```

Round 1:

```
merge(A,B)

1->2->4->5


merge(C,D)

3->6->7->8
```

Current:

```
[
1->2->4->5,
3->6->7->8
]
```

---

Round 2:

```
merge(
1->2->4->5,
3->6->7->8
)
```

Result:

```
1->2->3->4->5->6->7->8
```

---

# Merge Helper Function

The `merge()` method is the same as the Merge Two Sorted Lists problem.

A dummy node is used:

```
dummy -> result
```

At every step:

- Compare the two current nodes.
- Attach the smaller one.
- Advance that pointer.

---

# Complexity Analysis

Let:

- `N` = total number of nodes
- `k` = number of linked lists

## Time Complexity

Each node is processed once per merge round.

There are:

```
log(k)
```

rounds.

Therefore:

```
O(N log k)
```

---

## Space Complexity

The algorithm creates temporary lists containing references to the linked lists.

Extra space:

```
O(k)
```

The nodes themselves are reused; no new linked list nodes are created.

---

# Key Takeaways

- Merge K Sorted Lists is an extension of Merge Two Sorted Lists.
- Avoid sequential merging because the merged list keeps growing.
- Divide and conquer keeps merge sizes balanced.
- The structure is identical to merge sort.

---

# Related Problems

- Merge Two Sorted Lists
- Sort List
- Kth Smallest Element in a Sorted Matrix
- Find Median from Data Stream