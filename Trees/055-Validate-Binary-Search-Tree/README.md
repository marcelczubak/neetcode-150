# Validate Binary Search Tree

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Binary Tree + DFS + Recursive Bounds

---

## ❓ Problem

Given the root of a binary tree, determine whether it is a valid Binary Search Tree (BST).

A valid BST must satisfy:

- Every node in the left subtree has a value **less than** the node's value.
- Every node in the right subtree has a value **greater than** the node's value.
- Both left and right subtrees must also be valid BSTs.

---

## Example

Valid BST:

```
        5
       / \
      3   8
     / \
    1   4
```

Invalid BST:

```
        5
       / \
      3   8
         /
        4
```

Although `4 < 8`, it is in the right subtree of `5`.

Because:

```
4 must be greater than 5
```

the tree is invalid.

---

# 💡 Approach

A common mistake is only checking the immediate children:

```java
left.val < root.val
right.val > root.val
```

However, BST rules apply to the **entire subtree**.

Each node inherits restrictions from all of its ancestors.

Therefore, while traversing, maintain:

```
minimum allowed value
maximum allowed value
```

for each subtree.

---

# 🧠 Algorithm

## Step 1: Start DFS

The root initially has no restrictions:

```
(-∞, +∞)
```

---

## Step 2: Validate Current Node

For a node to be valid:

```
lowerBound < node.val < upperBound
```

If the value falls outside this range:

```
return false
```

---

## Step 3: Update Bounds

For the left subtree:

The values must be smaller than the current node.

New range:

```
(lowerBound, node.val)
```

For the right subtree:

The values must be larger than the current node.

New range:

```
(node.val, upperBound)
```

---

## Step 4: Continue Recursively

Both subtrees must be valid:

```java
dfs(left) && dfs(right)
```

---

# Example Walkthrough

Tree:

```
        10
       /  \
      5    15
          /
         6
```

Start:

```
10 has range (-∞, +∞)
```

---

Left subtree:

```
5
```

Allowed range:

```
(-∞, 10)
```

Valid.

---

Right subtree:

```
15
```

Allowed range:

```
(10, +∞)
```

Valid.

---

Node:

```
6
```

This is the left child of 15.

Its allowed range:

```
(10, 15)
```

But:

```
6 < 10
```

Therefore:

```
false
```

---

# Complexity Analysis

Let:

```
n = number of nodes
```

## Time Complexity

Every node is visited once.

```
O(n)
```

---

## Space Complexity

The recursion stack stores the current path.

Balanced tree:

```
O(log n)
```

Worst case:

```
O(n)
```

---

# Key Takeaways

- A BST is defined by ancestor constraints, not just parent-child comparisons.
- DFS allows constraints to be passed down the tree.
- Every recursive call represents a smaller valid range.
- Use bounds rather than comparing only immediate children.

---

# Related Problems

- Lowest Common Ancestor of a Binary Tree
- Kth Smallest Element in a BST
- Binary Tree Level Order Traversal
- Construct Binary Tree from Preorder and Inorder Traversal