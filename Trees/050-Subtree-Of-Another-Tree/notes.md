# 📝 Notes

---

# 🏷️ Pattern

DFS + Tree Recursion + Helper Function

---

# 🧠 Core Idea

This problem has **two separate recursive jobs**.

## 1. Search the tree

```java
isSubtree(root, subRoot)
```

Its job:

> Search every node of the main tree.

---

## 2. Compare two trees

```java
sameTree(root1, root2)
```

Its job:

> Determine whether two trees are identical.

---

# 🌳 Overall Algorithm

```text
For every node in root:

        │
        ▼
Compare with subRoot

        │
        ├── Same?
        │      │
        │      ▼
        │    return true
        │
        ▼
Search left subtree

        ▼
Search right subtree
```

---

# 📌 `sameTree()` Base Cases

## Case 1

Both nodes are null.

```java
if (root1 == null && root2 == null)
    return true;
```

---

## Case 2

Only one node is null.

```java
if (root1 == null || root2 == null)
    return false;
```

---

## Case 3

Values differ.

```java
if (root1.val != root2.val)
    return false;
```

---

## Case 4

Compare children.

```java
return sameTree(root1.left, root2.left)
    && sameTree(root1.right, root2.right);
```

---

# 📌 `isSubtree()` Flow

```java
if (root == null)
    return false;

if (sameTree(root, subRoot))
    return true;

return isSubtree(root.left, subRoot)
    || isSubtree(root.right, subRoot);
```

Notice:

We search **every node**.

We do **not** recurse through `subRoot`.

---

# 🧪 Example

```
root:

        3
       / \
      4   5
     / \
    1   2

subRoot:

      4
     / \
    1   2
```

Traversal:

```
Check node 3
↓

Not same

↓

Search left

↓

Check node 4

↓

sameTree()

↓

Trees match

↓

Return true
```

---

# ⚠️ Common Mistakes

## ❌ Comparing only children

Incorrect:

```java
sameTree(root.left, subRoot.left)
```

This skips potential subtree roots.

Instead:

```java
isSubtree(root.left, subRoot)
```

---

## ❌ Forgetting null checks

Always handle:

```java
null
```

before accessing:

```java
node.val
```

---

## ❌ Returning true too early

Never return true just because:

```java
left == null
```

The entire tree must match.

---

# 🎯 Pattern Recognition

If a tree problem asks:

- "Is this tree contained inside another?"
- "Does this subtree exist?"
- "Compare trees"

Think:

✔ DFS search

combined with

✔ Recursive tree comparison

---

# 💭 Mental Model

Think of the two methods as two different employees.

### `isSubtree()`

"I'm going to search every possible starting node."

---

### `sameTree()`

"Given two roots, I'll tell you if they're identical."

Keeping these responsibilities separate makes the recursive solution much easier to design and debug.