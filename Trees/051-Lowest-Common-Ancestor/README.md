# Lowest Common Ancestor of a Binary Search Tree

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Binary Search Tree (BST) + Recursion

---

## ❓ Problem

Given the root of a Binary Search Tree (BST) and two nodes `p` and `q`, return their **Lowest Common Ancestor (LCA)**.

The **Lowest Common Ancestor** is defined as the lowest node in the tree that has both `p` and `q` as descendants. A node can be a descendant of itself.

---

## Example

```
           6
         /   \
        2     8
       / \   / \
      0   4 7   9
         / \
        3   5
```

```
p = 2
q = 8
```

Output:

```
6
```

---

Another example:

```
           6
         /   \
        2     8
       / \
      0   4
```

```
p = 2
q = 4
```

Output:

```
2
```

Since a node can be its own ancestor, the answer is `2`.

---

# 💡 Approach

Unlike a normal binary tree, a BST has an ordering property:

- Left subtree contains smaller values.
- Right subtree contains larger values.

This allows us to decide **which direction to search** without exploring both subtrees.

For every node:

- If both `p` and `q` are smaller, the LCA must be in the left subtree.
- If both are larger, the LCA must be in the right subtree.
- Otherwise, the current node is where the paths split, making it the Lowest Common Ancestor.

---

# 🧠 Algorithm

### Step 1

Start at the root.

---

### Step 2

Compare `p.val` and `q.val` with the current node.

If both are smaller:

```
Go left.
```

---

### Step 3

If both are larger:

```
Go right.
```

---

### Step 4

Otherwise:

```
Current node is the Lowest Common Ancestor.
```

This includes two situations:

- One node is on each side.
- One of the nodes is the current node.

---

# Example Walkthrough

Tree:

```
           6
         /   \
        2     8
       / \
      0   4
         / \
        3   5
```

Find:

```
p = 3
q = 5
```

---

Start at:

```
6
```

Both values are less than 6.

Move left.

---

Current node:

```
2
```

Both values are greater than 2.

Move right.

---

Current node:

```
4
```

```
3 < 4
5 > 4
```

The paths split here.

Answer:

```
4
```

---

# Why This Works

Every BST node divides the tree into two regions:

```
        root
       /    \
 smaller   larger
```

If both target nodes lie in the same region, the ancestor must also lie in that region.

The first node where they no longer lie in the same region is exactly where their paths diverge, making it the Lowest Common Ancestor.

---

# Complexity Analysis

Let:

```
h = height of the tree
```

### Time Complexity

One path is followed from the root.

Balanced BST:

```
O(log n)
```

Worst-case (skewed tree):

```
O(n)
```

---

### Space Complexity

Recursive call stack:

Balanced:

```
O(log n)
```

Worst case:

```
O(n)
```

An iterative implementation reduces extra space to:

```
O(1)
```

---

# Key Takeaways

- BST ordering eliminates the need to search both subtrees.
- Only one recursive path is explored.
- The first node where `p` and `q` diverge is the LCA.
- If one node equals the current node, the current node is the answer.

---

# Related Problems

- Lowest Common Ancestor of a Binary Tree
- Validate Binary Search Tree
- Kth Smallest Element in a BST
- Search in a Binary Search Tree