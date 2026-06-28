# 📝 Notes

---

# 🏷️ Pattern

Postorder DFS

---

# 🧠 Core Idea

Each recursive call returns:

> The height of the current subtree.

While computing that height, we also verify whether the subtree is balanced.

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
Check balance

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

A null subtree has height `0`.

---

# 📌 Compute Heights

```java
int left = dfs(root.left);
int right = dfs(root.right);
```

---

# 📌 Check Balance

```java
if (Math.abs(left - right) > 1) {
    isBalanced = false;
}
```

Once an imbalance is found, the tree cannot become balanced again.

> **Important:** Do **not** set `isBalanced = true` when a node is balanced. A later balanced node should not overwrite an earlier imbalance.

---

# 📌 Return Height

```java
return 1 + Math.max(left, right);
```

Each node reports its height to its parent.

---

# 🧪 Example

```
        3
       / \
      9  20
         / \
        15  7
```

Heights:

```
9  → 1
15 → 1
7  → 1

20 → 2

3 → 3
```

Balance checks:

```
Node 20:

|1 - 1| = 0 ✔

Node 3:

|1 - 2| = 1 ✔
```

Tree is balanced.

---

Unbalanced example:

```
      1
     /
    2
   /
  3
```

Heights:

```
3 → 1
2 → 2
1 → 3
```

At node 1:

```
|2 - 0| = 2 ❌
```

Set:

```java
isBalanced = false;
```

---

# ⚠️ Common Mistakes

## ❌ Resetting the global boolean

Wrong:

```java
if (balanced)
    isBalanced = true;
else
    isBalanced = false;
```

This can overwrite a previous `false`.

Correct:

```java
if (Math.abs(left - right) > 1)
    isBalanced = false;
```

---

## ❌ Forgetting the base case

```java
if (root == null)
    return 0;
```

---

## ❌ Returning the wrong value

The DFS should return:

```
height
```

—not whether the tree is balanced.

---

# 🎯 Pattern Recognition

If a tree problem asks you to compare information from both subtrees before computing the parent's answer, think:

✔ Postorder DFS

✔ Compute child information first

✔ Return a value upward

✔ Optionally update a global result

---

# 💭 Mental Model

Every node asks:

> "How tall are my left and right subtrees?"

It then checks:

```
|leftHeight - rightHeight|
```

If the difference is greater than `1`, the tree is unbalanced.

Finally, it tells its parent:

> "My subtree height is `1 + max(left, right)`."

This separation—**returning height while checking balance**—is the key idea behind the solution.