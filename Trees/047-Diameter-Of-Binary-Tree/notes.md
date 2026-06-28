# 📝 Notes

---

# 🏷️ Pattern

Postorder DFS

---

# 🧠 Core Idea

Each recursive call returns:

> The height of its subtree.

Meanwhile, every node computes:

```
leftHeight + rightHeight
```

which is the diameter passing through that node.

---

# 🌳 Recursive Structure

```
dfs(node)

        │
        ▼
Compute left height

        │
        ▼
Compute right height

        │
        ▼
Update diameter

        │
        ▼
Return subtree height
```

---

# 📌 Base Case

```java
if (root == null)
    return 0;
```

A null node has height 0.

---

# 📌 Compute Heights

```java
int left = dfs(root.left);
int right = dfs(root.right);
```

These represent the heights of both subtrees.

---

# 📌 Update Diameter

```java
diameter = Math.max(diameter, left + right);
```

Why?

The longest path through this node is:

```
left subtree
    ↑
 current node
    ↓
right subtree
```

Number of edges:

```
leftHeight + rightHeight
```

---

# 📌 Return Height

```java
return 1 + Math.max(left, right);
```

The parent only cares about the tallest subtree.

---

# 🧪 Example

```
        1
       / \
      2   3
     / \
    4   5
```

Heights:

```
4 → 1
5 → 1

2 → 2

3 → 1

1 → 3
```

Diameters:

At node 2:

```
1 + 1 = 2
```

At node 1:

```
2 + 1 = 3
```

Answer:

```
3
```

(Path: 4 → 2 → 1 → 3)

---

# ⚠️ Common Mistakes

## ❌ Returning the diameter

The recursive function should return:

```
height
```

not diameter.

---

## ❌ Forgetting global variable

The diameter must be tracked across all nodes.

```java
int diameter = 0;
```

---

## ❌ Confusing nodes vs edges

Height:

```
null = 0
leaf = 1
```

Diameter counts:

```
edges
```

not nodes.

---

# 🎯 Pattern Recognition

If a tree problem asks for:

- longest path
- combine left and right subtree information
- calculate something using both children

Think:

✔ Postorder DFS

✔ Return height

✔ Update answer while returning

---

# 💭 Mental Model

Every node asks:

> "How tall are my left and right subtrees?"

It then computes:

```
leftHeight + rightHeight
```

to see if the longest path passes through itself.

Finally, it tells its parent:

> "My subtree height is 1 + max(left, right)."

This separation of responsibilities is the key to solving many tree DP problems.