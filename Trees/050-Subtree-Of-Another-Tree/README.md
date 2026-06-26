# 🌳 Subtree of Another Tree

## 🎯 Difficulty
Easy

## 🏷️ Pattern
Binary Tree + DFS + Recursion

---

## ❓ Problem

Given the roots of two binary trees `root` and `subRoot`, determine whether there exists a node in `root` such that the subtree rooted at that node is identical to `subRoot`.

A subtree includes a node and all of its descendants.

---

## 💡 Approach

This problem is solved using **two recursive DFS functions**:

1. **`isSubtree()`**
   - Searches every node in the main tree.
   - At each node, checks if the subtree rooted there matches `subRoot`.

2. **`sameTree()`**
   - Compares two trees for structural and value equality.

For every node in `root`:

- Compare the subtree rooted there with `subRoot`.
- If they match, return `true`.
- Otherwise continue searching the left and right subtrees.

---

## 🧠 Key Insight

This problem is a combination of:

- Tree traversal
- Same Tree comparison

Rather than trying to compare partial trees, we search every possible starting point in the main tree.

---

## 🚀 Algorithm

1. If `root` is `null`, return `false`.
2. Check if `sameTree(root, subRoot)` is true.
3. If so, return `true`.
4. Otherwise recursively search:
   - left subtree
   - right subtree
5. If neither contains the subtree, return `false`.

---

## ⏱️ Time Complexity

Worst case:

```text
O(n × m)
```

Where:

- `n` = number of nodes in `root`
- `m` = number of nodes in `subRoot`

At every node in `root`, we may compare up to the entire `subRoot`.

---

## 💾 Space Complexity

```text
O(h)
```

where `h` is the recursion depth of the tree.

Worst case:

```text
O(n)
```

for a completely skewed tree.

---

## 🔑 Why This Works

Every possible subtree root is examined exactly once.

Whenever a node has the same value as `subRoot`, we verify the entire subtree using `sameTree()`.

---

## 📚 What I Learned

- Separate recursive methods can have different responsibilities.
- One recursion can search.
- Another recursion can compare.
- Reusing helper methods makes recursive tree problems much cleaner.

---

## 🧠 Pattern Recognition

If you see:

- subtree
- identical tree
- compare trees

Think:

✔ DFS  
✔ Recursive search  
✔ Helper method to compare trees

---

## 🔄 Similar Problems

- Same Tree
- Invert Binary Tree
- Balanced Binary Tree
- Symmetric Tree
- Serialize and Deserialize Binary Tree