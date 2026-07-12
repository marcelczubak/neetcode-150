# Kth Smallest Element in a BST - Notes

---

# Pattern Recognition

When you see:

```
BST

+

kth smallest / kth largest
```

Think:

```
In-order traversal
```

Because:

```
BST In-order = sorted order
```

---

# In-Order Traversal

The order is:

```
Left

↓

Node

↓

Right
```

Example:

```
        5
       / \
      3   8
     /
    2
```

Traversal:

```
2 → 3 → 5 → 8
```

---

# Core Idea

The kth smallest element is simply:

```
the kth node visited during in-order traversal
```

No sorting required.

---

# Recursive Template

```
function inorder(node):

    if node is null:
        return


    visit left subtree


    process current node


    visit right subtree
```

---

# Where does the counter go?

Incorrect:

```
count++ before going left
```

because the left subtree contains smaller values.

Correct:

```
left

count++

node

right
```

---

# Example

Tree:

```
        6
       / \
      3   8
     /
    1
```

In-order:

```
1, 3, 6, 8
```

For:

```
k = 3
```

Process:

```
1 -> count 1

3 -> count 2

6 -> count 3
```

Return:

```
6
```

---

# Early Termination

Important recursion concept:

A return only exits:

```
current function call
```

It does NOT automatically stop all recursive calls.

Example:

```java
if (count == k) {
    result = root;
    return;
}
```

Only returns from that node.

To fully stop:

```java
if (root == null || result != null)
    return;
```

---

# Common Mistakes

## Mistake 1: Sorting the tree

Wrong approach:

```
Traverse tree

Store values

Sort array
```

Why?

BST already gives sorted order.

---

## Mistake 2: Counting before visiting left

Wrong:

```
Node
Left
Right
```

This gives preorder traversal, not sorted order.

---

## Mistake 3: Forgetting equality

If:

```
k = 1
```

the smallest node is the first visited node.

---

# Alternative Approach

Iterative in-order traversal:

Use a stack:

```
Push left nodes

Pop

Process

Move right
```

This avoids recursion and can stop immediately after k visits.

---

# Interview Explanation

Good explanation:

> "Because a BST's in-order traversal produces values in ascending order, I can traverse the tree in-order and count visited nodes. The kth node visited is the kth smallest value."

---

# Complexity

Time:

```
O(H + k)
```

with early stopping.

Worst case:

```
O(n)
```

Space:

```
O(H)
```

for recursion stack.