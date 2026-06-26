# 🌳 Same Tree

## 🎯 Difficulty
Easy

## 🏷️ Pattern
Binary Tree + DFS Recursion

---

## ❓ Problem

Given the roots of two binary trees `p` and `q`, return `true` if they are structurally identical and have the same node values.

Two trees are the same if:

- They have the same structure
- Every corresponding node has the same value

---

## 💡 Approach

We recursively compare both trees:

At each step:
- If both nodes are null → return true
- If one is null → return false
- If values differ → return false
- Otherwise → compare left and right subtrees

---

## 🧠 Key Insight

Two trees are identical if:

> Every corresponding pair of nodes matches in both structure and value.

So we check:
- Current node
- Left subtree
- Right subtree

---

## 🚀 Algorithm

1. If both nodes are null → true
2. If one is null → false
3. If values differ → false
4. Recursively compare:
   - left subtree
   - right subtree

---

## ⏱️ Time Complexity

```text
O(n)
```

We visit every node once.

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

We traverse both trees simultaneously and ensure every node matches.

If any mismatch occurs, we stop early.

---

## 📚 What I Learned

- Tree recursion is naturally a divide-and-conquer process
- Always handle null cases first
- Compare current node before children
- Recursive structure mirrors tree structure

---

## 🧠 Pattern Recognition

If you see:

- compare two trees
- check identical structure
- mirror traversal

Think:

✔ DFS recursion  
✔ Base case null handling  
✔ Parallel traversal of two trees

---

## 🔄 Similar Problems

- Subtree of Another Tree
- Invert Binary Tree
- Symmetric Tree
- Balanced Binary Tree