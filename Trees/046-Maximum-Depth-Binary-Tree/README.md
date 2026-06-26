# 🌳 Maximum Depth of Binary Tree

## 🎯 Difficulty
Easy

## 🏷️ Pattern
Binary Tree + DFS / Recursion

---

## ❓ Problem

Given the root of a binary tree, return its **maximum depth**.

The maximum depth is the number of nodes along the longest path from the root down to the farthest leaf node.

---

## 💡 Approach

We solve this using recursion (DFS):

At each node:
- Compute the depth of the left subtree
- Compute the depth of the right subtree
- Return the larger one + 1 (for current node)

---

## 🧠 Key Insight

The depth of a tree is:

> 1 + max(depth(left), depth(right))

This naturally fits recursion.

---

## 🚀 Algorithm

1. If node is null → return 0
2. Recursively compute:
   - left depth
   - right depth
3. Return `1 + max(left, right)`

---

## ⏱️ Time Complexity

```text
O(n)
```

Every node is visited once.

---

## 💾 Space Complexity

```text
O(h)
```

where `h` is tree height (recursion stack)

Worst case:

```text
O(n)
```

(skewed tree)

---

## 🔑 Why This Works

Each node contributes exactly 1 to the depth, and the deepest path determines the final answer.

---

## 📚 What I Learned

- Tree depth problems are naturally recursive
- Always think: left subtree + right subtree + current node
- Base case is always null → 0
- Return value represents “height of subtree”

---

## 🧠 Pattern Recognition

If you see:

- “height of tree”
- “maximum depth”
- “longest path from root”

Think:

✔ DFS recursion  
✔ Bottom-up computation  
✔ max(left, right) + 1  

---

## 🔄 Similar Problems

- Balanced Binary Tree
- Diameter of Binary Tree
- Minimum Depth of Binary Tree
- Path Sum