# Kth Smallest Element in a BST

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Binary Search Tree + In-Order Traversal + Recursion

---

## ❓ Problem

Given the root of a Binary Search Tree and an integer `k`, return the `k`th smallest value in the tree.

The kth smallest value is the value that would appear at position `k` if the BST was converted into a sorted list.

---

## Example

Input:

```
        5
       / \
      3   8
     / \   \
    2   4   9

k = 3
```

Perform in-order traversal:

```
2 → 3 → 4 → 5 → 8 → 9
```

The 3rd smallest value is:

```
4
```

Output:

```
4
```

---

# 💡 Key Insight

A Binary Search Tree has a special property:

```
Left subtree < Node < Right subtree
```

Therefore:

**In-order traversal of a BST always visits values in ascending order.**

Traversal order:

```
Left
↓
Node
↓
Right
```

Example:

```
        5
       / \
      3   8
```

In-order:

```
3, 5, 8
```

which is sorted.

---

# Approach

Instead of creating a sorted array:

1. Perform an in-order traversal.
2. Keep a counter of how many nodes have been visited.
3. When the counter reaches `k`, the current node is the answer.

---

# Algorithm

## Step 1

Start recursive in-order traversal.

```
left subtree
```

---

## Step 2

When visiting a node:

Increment the counter:

```
count++
```

This represents the next smallest value.

---

## Step 3

If:

```
count == k
```

store the current node as the answer.

---

## Step 4

Continue traversal only if the answer has not been found.

---

# Code Flow

Example:

```
        5
       /
      3
     /
    2
```

Traversal:

```
visit 2

count = 1

visit 3

count = 2

visit 5

count = 3
```

If:

```
k = 3
```

answer:

```
5
```

---

# Complexity Analysis

Let:

```
H = height of BST
```

## Time Complexity

Worst case:

```
O(n)
```

because the tree may need to be fully traversed.

With early stopping:

```
O(H + k)
```

because we only visit nodes until reaching the kth smallest.

---

## Space Complexity

Recursive call stack:

```
O(H)
```

where:

- Balanced tree → `O(log n)`
- Skewed tree → `O(n)`

---

# Key Takeaways

- BST in-order traversal produces sorted values.
- kth smallest = kth node visited during in-order traversal.
- Counter should increment when processing the current node.
- Recursive return only exits one stack frame.
- Use shared state to stop traversal early.

---

# Related Problems

- Validate Binary Search Tree
- Lowest Common Ancestor of a BST
- Binary Tree Level Order Traversal
- Kth Largest Element in a Stream