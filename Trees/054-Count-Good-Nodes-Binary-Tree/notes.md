# Count Good Nodes in Binary Tree - Notes

---

# Pattern

```
Tree DFS

Carry information from parent to child
```

---

# Observation

A node is good if:

```
node.val >= largest value seen from the root
```

So while traversing the tree, we only need to remember one value:

```
maximum so far
```

---

# DFS State

Every recursive call stores:

```
Current node

Maximum value seen on this path
```

```
dfs(node, maximum)
```

---

# Order of Operations

Always:

```
Compare

↓

Update maximum

↓

Recurse
```

Never update first.

---

Correct:

```java
if (node.val >= maximum)
    answer++;

maximum = Math.max(maximum, node.val);
```

---

Wrong:

```java
maximum = Math.max(maximum, node.val);

if (node.val >= maximum)
```

Every node would appear good because `maximum` has already been updated.

---

# Example

```
        3
       / \
      1   4
         /
        2
```

Visit:

Root

```
maximum = 3
```

---

Left

```
1 >= 3 ?

No
```

Maximum stays

```
3
```

---

Right

```
4 >= 3

Yes

maximum = 4
```

---

Right-left

```
2 >= 4 ?

No
```

---

# Why Pass Maximum?

Each recursive path is independent.

```
        8
       / \
      3   10
```

Left recursion receives

```
8
```

Right recursion also receives

```
8
```

Updating one path never affects another.

---

# Recursion Tree

```
dfs(3,3)

      3

   /      \

dfs(1,3)  dfs(4,4)
```

Notice the maximum changes independently for each branch.

---

# Base Case

```
if(node == null)
    return;
```

---

# Recursive Step

```
Compare current node

↓

Update maximum

↓

Explore left

↓

Explore right
```

---

# Common Mistakes

### Updating maximum before checking

Wrong:

```java
maximum = Math.max(...)

if(node.val >= maximum)
```

Every node becomes good.

---

### Using one global maximum

Wrong idea:

```
maximum = 8

Entire tree uses 8 forever
```

Each path needs its own maximum.

---

### Forgetting the root

The root is always a good node because there are no previous nodes.

---

# Template

```
DFS(node, maximum)

Base case

Check if node is good

Update maximum

DFS(left)

DFS(right)
```

---

# Complexity

Time

```
O(n)
```

Every node visited once.

Space

Balanced tree

```
O(log n)
```

Worst case

```
O(n)
```

due to recursion depth.

---

# Interview Recognition

When the problem says:

- root-to-node path
- largest/smallest seen so far
- ancestor information

Think:

```
DFS

+

Pass state through recursion
```

instead of using global variables or extra data structures.