# 🌳 Diameter of Binary Tree

## 🎯 Difficulty
Easy

## 🏷️ Pattern
Binary Tree + DFS + Postorder Traversal

---

## ❓ Problem

Given the root of a binary tree, return the **diameter** of the tree.

The diameter is the length (number of edges) of the longest path between any two nodes in the tree.

The path does **not** have to pass through the root.

---

## 💡 Approach

Use a postorder DFS to compute the height of every subtree.

For each node:

- Compute the height of its left subtree.
- Compute the height of its right subtree.
- The longest path passing through this node is:
  ```
  leftHeight + rightHeight
  ```
- Update the global maximum diameter.
- Return the height of the current subtree.

---

## 🧠 Key Insight

Although we're asked for the **diameter**, the easiest thing to compute recursively is the **height**.

While computing heights, we can also calculate the diameter passing through each node.

---

## 🚀 Algorithm

1. Perform DFS.
2. If node is null → return height 0.
3. Compute:
   - left subtree height
   - right subtree height
4. Update:
   ```
   diameter = max(diameter, left + right)
   ```
5. Return:
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

where `h` is the tree height.

Worst case:

```text
O(n)
```

for a completely skewed tree.

---

## 🔑 Why This Works

Each node contributes:

- Its subtree height (returned to its parent)
- A possible diameter (used to update the global answer)

The longest diameter will be discovered while traversing the tree.

---

## 📚 What I Learned

- Diameter is easier to compute while calculating heights.
- DFS can return one piece of information while updating another.
- Postorder traversal is ideal when parent calculations depend on children.

---

## 🧠 Pattern Recognition

If you see:

- longest path
- diameter
- tree height
- information from children

Think:

✔ DFS

✔ Postorder Traversal

✔ Return height

✔ Update global answer

---

## 🔄 Similar Problems

- Maximum Depth of Binary Tree
- Balanced Binary Tree
- Binary Tree Maximum Path Sum
- Lowest Common Ancestor