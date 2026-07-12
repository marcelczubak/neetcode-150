# Binary Tree Right Side View

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Binary Tree + Breadth-First Search (BFS)

---

## ❓ Problem

Given the root of a binary tree, imagine standing on the **right side** of the tree.

Return the values of the nodes that are visible when looking at the tree from the right.

### Example

```
        1
       / \
      2   3
       \   \
        5   4
```

Output:

```
[1, 3, 4]
```

Only the rightmost node at each level is visible.

---

# 💡 Approach

The problem is naturally solved using **Breadth-First Search (Level Order Traversal)**.

BFS processes the tree **one level at a time**, allowing us to identify the **last node visited** on every level.

Since children are added to the queue **left first, then right**, the final node processed for each level is the node visible from the right side.

---

# 🧠 Algorithm

## Step 1

Handle the empty tree.

If the root is null:

```
return []
```

---

## Step 2

Initialize:

- Queue for BFS
- Result list

Add the root to the queue.

---

## Step 3

While the queue is not empty:

Store:

```java
int levelSize = queue.size();
```

This tells us exactly how many nodes belong to the current level.

---

## Step 4

Process every node on the current level.

For each node:

- Remove it from the queue.
- Add its left child (if it exists).
- Add its right child (if it exists).

---

## Step 5

When processing the **last node** on that level:

```java
i == levelSize - 1
```

record its value.

This node is the rightmost node visible from that level.

---

# Example Walkthrough

Tree:

```
        1
       / \
      2   3
     / \   \
    4   5   6
```

Queue:

```
[1]
```

---

Level 1

Process:

```
1
```

Queue becomes:

```
[2,3]
```

Last node:

```
1
```

Answer:

```
[1]
```

---

Level 2

Queue:

```
[2,3]
```

Process:

```
2
3
```

Queue becomes:

```
[4,5,6]
```

Last processed node:

```
3
```

Answer:

```
[1,3]
```

---

Level 3

Queue:

```
[4,5,6]
```

Process:

```
4
5
6
```

Last node:

```
6
```

Answer:

```
[1,3,6]
```

---

# Why BFS?

DFS explores one branch completely before another.

This makes it difficult to know which node is the rightmost node of a level.

BFS naturally groups nodes by depth.

Each iteration processes exactly one level.

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

The queue stores at most one tree level.

Worst case:

```
O(w)
```

where:

```
w = maximum width of the tree
```

---

# Key Takeaways

- BFS is ideal for problems involving tree levels.
- `queue.size()` is captured before processing a level.
- The last node processed at each level is the right-side view.
- Queue order matters: enqueue left first, then right.

---

# Related Problems

- Binary Tree Level Order Traversal
- Binary Tree Zigzag Level Order Traversal
- Average of Levels in Binary Tree
- Maximum Depth of Binary Tree