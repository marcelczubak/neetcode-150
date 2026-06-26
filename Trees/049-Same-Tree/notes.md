# 📝 Notes

---

# 🏷️ Pattern

DFS + Tree Comparison

---

# 🧠 Core Idea

We compare two trees at the same time.

At each step:

We compare:

- current node value
- left subtree
- right subtree

---

# 🌳 Recursive Structure

```text
isSameTree(p, q)

        │
        ▼
Compare current nodes
        │
        ├── mismatch → false
        │
        ▼
Compare left subtree
        │
        ▼
Compare right subtree
```

---

# 📌 Base Cases

## Case 1: Both null

```java
if (p == null && q == null)
    return true;
```

---

## Case 2: One null

```java
if (p == null || q == null)
    return false;
```

---

## Case 3: Value mismatch

```java
if (p.val != q.val)
    return false;
```

---

## Case 4: Recurse

```java
return isSameTree(p.left, q.left)
    && isSameTree(p.right, q.right);
```

---

# 🧪 Example

```
Tree 1:        Tree 2:

    1              1
   / \            / \
  2   3          2   3
```

Step-by-step:

- Compare root → 1 == 1 ✔
- Compare left → 2 == 2 ✔
- Compare right → 3 == 3 ✔
- All match → return true

---

# ⚠️ Common Mistakes

## ❌ Accessing `.val` before null check

Wrong:

```java
if (p.val != q.val)
```

Fix:

```java
if (p == null || q == null) return false;
```

---

## ❌ Not checking structure

Two trees can have same values but different shapes.

Example:

```
1        1
 \        \
  2        2
```

These are NOT the same tree.

---

# 🎯 Pattern Recognition

If you see:

- compare trees
- check identical structure
- mirror recursion

Think:

✔ DFS traversal  
✔ Parallel recursion  
✔ Null-safe comparisons  

---

# 💭 Mental Model

Think of recursion as:

> “Walk both trees at the same time and compare every step.”

Each recursive call compares:

- current node
- left child
- right child