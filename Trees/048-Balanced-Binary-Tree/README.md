# ⚖️ Balanced Binary Tree

## 🎯 Difficulty
Easy

## 🏷️ Pattern
Binary Tree + DFS + Postorder Traversal

---

## ❓ Problem

Given the root of a binary tree, determine whether it is **height-balanced**.

A binary tree is height-balanced if, for every node:

- The heights of the left and right subtrees differ by **at most 1**.

---

## 💡 Approach

This solution performs a **postorder DFS**.

For every node:

1. Recursively compute the height of the left subtree.
2. Recursively compute the height of the right subtree.
3. Compare the two heights.
4. If the difference is greater than 1, mark the tree as unbalanced.
5. Return the height of the current subtree.

A global boolean (`isBalanced`) keeps track of whether any imbalance has been found.

> **Important:** Once `isBalanced` becomes `false`, it should never be set back to `true`.

---

## 🧠 Key Insight

The recursive function returns the **height** of each subtree.

While computing heights, we also verify whether each node satisfies the balance condition.

This allows us to solve the problem in a single DFS traversal.

---

## 🚀 Algorithm

1. If the node is null, return height `0`.
2. Compute:
   - left subtree height
   - right subtree height
3. If:

   ```
   |left - right| > 1
   ```

   mark the tree as unbalanced.

4. Return:

   ```
   1 + max(left, right)
   ```

---

## ⏱️ Time Complexity

```text
O(n)
```

Every node is visited exactly once.

---

## 💾 Space Complexity

```text
O(h)
```

where `h` is the height of the tree.

Worst case:

```text
O(n)
```

for a completely skewed tree.

---

## 🔑 Why This Works

Every recursive call computes one subtree's height.

While those heights are available, we immediately verify the balance condition.

This avoids recalculating subtree heights multiple times.

---

## 📚 What I Learned

- DFS can return one value while updating another.
- Postorder traversal is useful when parents depend on children.
- Global variables can simplify recursive solutions.
- Be careful not to overwrite important global state.

---

## 🧠 Pattern Recognition

If you see:

- balanced tree
- subtree heights
- compare left and right

Think:

✔ DFS

✔ Postorder Traversal

✔ Return height

✔ Update a global answer

---

## 🔄 Similar Problems

- Maximum Depth of Binary Tree
- Diameter of Binary Tree
- Binary Tree Maximum Path Sum