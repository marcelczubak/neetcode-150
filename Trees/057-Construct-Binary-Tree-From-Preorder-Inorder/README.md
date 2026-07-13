# Construct Binary Tree from Preorder and Inorder Traversal

## Problem

Given two integer arrays `preorder` and `inorder` representing the preorder and inorder traversals of a binary tree, reconstruct and return the original binary tree.

---

## Example

### Input

```text
preorder = [3,9,20,15,7]
inorder  = [9,3,15,20,7]
```

### Output

```text
        3
       / \
      9   20
         /  \
       15    7
```

---

## Approach

### Key Observations

* The **first unused value** in the preorder traversal is always the root of the current subtree.
* The root's position in the inorder traversal divides the subtree into:

  * Left subtree
  * Right subtree

To avoid repeatedly searching the inorder array, preprocess it into a `HashMap` that stores each value's index.

A global `preorderIndex` keeps track of the next root to construct as the recursion progresses.

---

## Algorithm

1. Store every value from the inorder traversal in a `HashMap`.
2. Initialize `preorderIndex = 0`.
3. Recursively build the tree:

   * If the current inorder range is invalid, return `null`.
   * Read the next root value from `preorder`.
   * Find its position in the inorder traversal using the `HashMap`.
   * Create the root node.
   * Recursively build the left subtree.
   * Recursively build the right subtree.
4. Return the constructed root.

---

## Complexity Analysis

### Time Complexity

```
O(n)
```

* Building the HashMap takes **O(n)**.
* Each node is visited exactly once.
* Every inorder lookup is **O(1)**.

---

### Space Complexity

```
O(n)
```

* **O(n)** for the HashMap.
* Up to **O(h)** recursive call stack, where **h** is the height of the tree (worst case **O(n)**).
