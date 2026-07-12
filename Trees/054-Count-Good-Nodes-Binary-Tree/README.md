# Count Good Nodes in Binary Tree

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Binary Tree + Depth-First Search (DFS)

---

## ❓ Problem

Given the root of a binary tree, return the number of **good nodes**.

A node X in the tree is considered **good** if, on the path from the root to X, there are no nodes with a value greater than X.

In other words, a node is good if its value is greater than or equal to every value encountered from the root to that node.

### Example

```
        3
       / \
      1   4
     /   / \
    3   1   5
```

Good nodes:

- 3 (root)
- 3 (left child)
- 4
- 5

Answer:

```
4
```

---

# 💡 Approach

Traverse the tree using **Depth-First Search**.

While traversing, keep track of the **maximum value seen so far** on the current root-to-node path.

For every node:

1. Compare its value against the current maximum.
2. If its value is at least the maximum, it is a good node.
3. Update the maximum.
4. Continue searching both subtrees.

Because each recursive call receives its own copy of the current maximum, every path is evaluated independently.

---

# 🧠 Algorithm

### Step 1

Start DFS from the root.

Initially:

```java
maximum = root.val;
```

---

### Step 2

Visit a node.

If:

```java
root.val >= maximum
```

increment the answer.

---

### Step 3

Update the maximum value seen on this path.

```java
newMax = Math.max(maximum, root.val);
```

---

### Step 4

Continue recursively.

```java
dfs(root.left, newMax);
dfs(root.right, newMax);
```

---

### Step 5

When a null node is reached, simply return.

---

# Example Walkthrough

Tree:

```
        3
       / \
      1   4
     /   / \
    3   1   5
```

Start:

```
maximum = 3
```

Visit root:

```
3 >= 3

goodNodes = 1
maximum = 3
```

---

Visit left child:

```
1 >= 3 ?

No
```

Maximum remains:

```
3
```

---

Visit left-left child:

```
3 >= 3

Yes

goodNodes = 2
```

---

Return.

Visit right child:

```
4 >= 3

Yes

goodNodes = 3

maximum = 4
```

---

Visit right-left:

```
1 >= 4 ?

No
```

---

Visit right-right:

```
5 >= 4

Yes

goodNodes = 4
```

Finished.

---

# Why Pass the Maximum?

Each path in the tree has its own largest value.

Passing the maximum into recursion keeps track of the largest value seen **only along the current path**.

For example:

```
        5
       / \
      2   8
```

The left subtree should compare against:

```
5
```

while the right subtree also starts with:

```
5
```

The recursive parameter naturally maintains this information.

---

# Complexity Analysis

Let:

```
n = number of nodes
```

### Time Complexity

Every node is visited exactly once.

```
O(n)
```

---

### Space Complexity

The only extra space is the recursion stack.

Balanced tree:

```
O(log n)
```

Worst case (skewed tree):

```
O(n)
```

---

# Key Takeaways

- DFS is ideal when information must be carried from parent to child.
- Recursive parameters allow each path to maintain independent state.
- Always compare against the current maximum **before** updating it.
- Every node is processed exactly once, making this the optimal solution.

---

# Related Problems

- Maximum Depth of Binary Tree
- Balanced Binary Tree
- Diameter of Binary Tree
- Binary Tree Right Side View
- Path Sum