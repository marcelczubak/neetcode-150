# 🔄 Invert Binary Tree

## 🎯 Difficulty
Easy

## 🏷️ Pattern
Binary Tree + DFS Recursion (Tree Transformation)

---

## ❓ Problem

Given the root of a binary tree, invert the tree and return its root.

Inversion means swapping the left and right children of every node in the tree.

---

## 💡 Approach

We recursively traverse the tree and at each node:

1. Swap the left and right children
2. Recursively invert the left subtree
3. Recursively invert the right subtree

---

## 🧠 Key Insight

Inverting a tree is not about building a new structure.

It is simply:

> Swapping children at every node, then repeating recursively.

Each node independently performs the same operation.

---

## 🚀 Algorithm

1. If node is null → return null
2. Swap left and right children
3. Recursively invert left subtree
4. Recursively invert right subtree
5. Return node

---

## ⏱️ Time Complexity

```text
O(n)
```

Each node is visited once.

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

Each node transformation is independent:

- Swap children
- Delegate work to subtrees

The recursion ensures the swap propagates throughout the entire tree.

---

## 📚 What I Learned

- Tree transformations follow a simple recursive pattern
- Always define what happens at a single node first
- Recursion handles the rest
- Swapping is local, recursion is global

---

## 🧠 Pattern Recognition

If you see:

- “invert”
- “mirror tree”
- “swap structure”

Think:

✔ DFS recursion  
✔ Local transformation at node  
✔ Propagate to children  

---

## 🔄 Similar Problems

- Same Tree
- Symmetric Tree
- Subtree of Another Tree
- Flatten Binary Tree to Linked List