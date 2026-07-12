# Binary Tree Right Side View - Notes

---

# Pattern

```
Binary Tree

+

Level Order Traversal (BFS)
```

---

# Main Observation

The answer contains:

```
One node per level
```

Specifically:

```
The rightmost node.
```

---

# Why BFS?

BFS naturally processes:

```
Level 1

↓

Level 2

↓

Level 3
```

This makes it easy to identify the last node on each level.

---

# Queue Example

Tree:

```
        1
       / \
      2   3
     / \   \
    4   5   6
```

Initially:

```
Queue

[1]
```

---

After processing level 1:

```
Queue

[2,3]
```

---

After processing level 2:

```
Queue

[4,5,6]
```

Notice that each level is grouped together.

---

# Processing One Level

Before processing:

```java
int levelSize = queue.size();
```

Suppose:

```
Queue

[4,5,6]
```

```
levelSize = 3
```

Process exactly three nodes.

Even if children are added during processing, they belong to the next level.

---

# Finding the Rightmost Node

Loop:

```java
for(int i = 0; i < levelSize; i++)
```

The rightmost node is simply:

```java
i == levelSize - 1
```

Example:

```
Level

4

5

6
```

Indices:

```
0

1

2
```

Last node:

```
2 == 3-1
```

Answer:

```
6
```

---

# Queue Order Matters

Enqueue:

```java
left

then

right
```

Queue:

```
2

3
```

Processing order:

```
2

3
```

Last processed:

```
3
```

which is exactly what we want.

---

If reversed:

```java
right

then

left
```

Queue:

```
3

2
```

Last processed becomes:

```
2
```

Incorrect.

---

# Base Case

```java
if(root == null)
    return;
```

Avoids:

```
NullPointerException
```

---

# BFS Template

```
Create queue

Add root

while queue not empty

    levelSize = queue.size()

    repeat levelSize times

        remove node

        process node

        add children
```

---

# Common Mistakes

## Forgetting queue.size()

Wrong:

```
Process until queue empty
```

Children from the next level become mixed into the current level.

Always store:

```java
levelSize = queue.size();
```

before processing.

---

## Adding null children

Wrong:

```java
queue.add(node.left);
```

without checking for null.

Only enqueue existing nodes.

---

## Recording every node

Need only:

```
Last node of each level
```

not every node.

---

# Complexity

Time:

```
O(n)
```

Every node visited once.

---

Space:

```
O(w)
```

where:

```
w = maximum tree width.
```

---

# Interview Recognition

When the question asks about:

- tree levels
- left view
- right view
- averages per level
- zigzag traversal

Think:

```
Queue

+

Level Order BFS

+

queue.size()
```

This pattern solves an entire family of binary tree problems efficiently.
