# 📝 Notes

---

# 🏷️ Pattern

DFS Tree Transformation

---

# 🧠 Core Idea

At each node:

We perform a simple operation:

> Swap left and right children

Then recurse on both subtrees.

---

# 🌳 Recursive Structure

```text
invertTree(node)

        │
        ▼
Swap left and right
        │
        ├── invert left subtree
        │
        ├── invert right subtree
        │
        ▼
Return node
```

---

# 📌 Base Case

```java
if (root == null)
    return null;
```

---

# 🔄 Core Operation

```java
TreeNode temp = root.left;
root.left = root.right;
root.right = temp;
```

---

# 📌 Recursive Step

```java
root.left = invertTree(root.left);
root.right = invertTree(root.right);
```

---

# 🧪 Example

Before:

```
        4
       / \
      2   7
     / \ / \
    1  3 6  9
```

Step 1 (swap at root):

```
        4
       / \
      7   2
```

Step 2 (recurse left subtree):

```
        7
       / \
      9   6
```

Step 3 (recurse right subtree):

```
        2
       / \
      3   1
```

Final:

```
        4
       / \
      7   2
     / \ / \
    9  6 3  1
```

---

# ⚠️ Common Mistakes

## ❌ Forgetting base case

Without:

```java
if (root == null) return null;
```

you get NullPointerException.

---

## ❌ Not swapping before recursion

Order matters:

Swap first → then recurse.

---

# 🎯 Pattern Recognition

If you see:

- mirror tree
- invert structure
- swap nodes

Think:

✔ DFS traversal  
✔ Modify current node  
✔ Recurse left and right  

---

# 💭 Mental Model

Think:

> “Each node independently swaps its children, and recursion spreads it across the tree.”
```