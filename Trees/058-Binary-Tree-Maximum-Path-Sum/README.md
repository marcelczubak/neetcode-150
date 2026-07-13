# Binary Tree Maximum Path Sum

## Problem

Given the root of a binary tree, return the maximum path sum.

A **path** is any sequence of connected nodes where each node appears at most once. The path does **not** have to pass through the root.

---

## Example

### Input

```text
        -10
        /  \
       9    20
           /  \
          15   7
```

### Output

```text
42
```

The maximum path is:

```text
15 → 20 → 7
```

Path sum:

```text
15 + 20 + 7 = 42
```

---

# Approach

## Key Idea

Perform a postorder DFS.

For every node, calculate two different values:

1. **The maximum path that can be extended to the parent.**
2. **The maximum path that ends at the current node** (possibly using both children).

Since a parent cannot continue down both children, only one branch can be returned upward.

However, when updating the global answer, both branches may be included because the path can terminate at the current node.

---

## Algorithm

1. Initialize the global answer using the root value.
2. Perform a DFS.
3. For every node:

   * Recursively compute the maximum gain from the left subtree.
   * Recursively compute the maximum gain from the right subtree.
   * Ignore negative gains by treating them as zero.
   * Update the global maximum using:

     * left gain
     * current node
     * right gain
   * Return the maximum single branch to the parent.
4. Return the global maximum after the DFS completes.

---

## Complexity Analysis

### Time Complexity

```text
O(n)
```

Every node is visited exactly once.

---

### Space Complexity

```text
O(h)
```

Where **h** is the height of the tree.

* Balanced tree: **O(log n)**
* Worst case (skewed tree): **O(n)**
