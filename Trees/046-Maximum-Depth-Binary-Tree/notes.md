# 📝 Notes

---

# 🏷️ Pattern

DFS (Bottom-Up Recursion)

---

# 🧠 Core Idea

We compute the height of each subtree and combine results upward.

---

# 🌳 Recursive Structure

```text
maxDepth(node)

        │
        ▼
Compute left depth
        │
        ▼
Compute right depth
        │
        ▼
Return max(left, right) + 1
```

---

# 📌 Base Case

```java
if (root == null)
    return 0;
```

---

# 📌 Recurrence Relation

```text
depth(node) = 1 + max(depth(left), depth(right))
```

---

## ✨ Learning Block

::contentReference[oaicite:0]{index=0}


(This represents the idea that each node combines results from children — structured aggregation.)

---

# 🧪 Example

```
        3
       / \
      9  20
         / \
        15  7
```

Step-by-step:

- depth(15) = 1
- depth(7) = 1
- depth(20) = 1 + max(1,1) = 2
- depth(9) = 1
- depth(3) = 1 + max(1,2) = 3

---

# ⚠️ Common Mistakes

## ❌ Returning 1 for null

Wrong:

```java
if (root == null) return 1;
```

Correct:

```java
if (root == null) return 0;
```

---

## ❌ Forgetting +1

You must include the current node:

```java
1 + max(left, right)
```

---

## ❌ Using BFS incorrectly for no reason

DFS recursion is simpler and optimal.

---

# 🎯 Pattern Recognition

If you see:

- height
- depth
- longest path from root
- tree levels

Think:

✔ DFS bottom-up recursion  
✔ max(left, right) + 1  

---

# 💭 Mental Model

Think:

> “Each node asks its children how tall they are, then adds 1 for itself.”