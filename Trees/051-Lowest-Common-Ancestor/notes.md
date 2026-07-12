# Lowest Common Ancestor of a BST - Notes

---

# Pattern

```
Binary Search Tree

+

Recursion
```

---

# Main Insight

The BST property allows us to eliminate half of the tree.

```
Left subtree

< root

Right subtree

> root
```

We never need to search both sides.

---

# Three Cases

## Case 1

Both nodes are smaller.

```
        10
       /
      ?
```

```
p < 10

q < 10
```

Go:

```
left
```

---

## Case 2

Both nodes are larger.

```
        10
           \
            ?
```

```
p > 10

q > 10
```

Go:

```
right
```

---

## Case 3

Nodes split.

```
        10
       /  \
      p    q
```

or

```
        10
       /
      p
```

where:

```
q == 10
```

Current node is the answer.

---

# Decision Tree

```
Both left?

↓

Go left


Both right?

↓

Go right


Otherwise

↓

Return current node
```

---

# Why It Works

Imagine standing at the root.

If both nodes are on the same side:

```
LCA cannot be here.
```

Keep moving.

Eventually you reach the first node where one target is left and the other is right.

That is exactly where their paths separate.

---

# Example

```
          20
         /  \
       10    30
      / \
     5  15
```

Find:

```
5

15
```

At:

```
20
```

Both smaller.

↓

Go left.

---

At:

```
10
```

```
5 < 10

15 > 10
```

Split.

Answer:

```
10
```

---

# Base Case

No explicit base case is required if the inputs are guaranteed to exist in the BST.

Eventually one of the three comparisons returns the answer.

---

# Recursive Template

```
If both targets are left

    recurse left

Else if both targets are right

    recurse right

Else

    current node is LCA
```

---

# Common Mistakes

## Treating it like a normal binary tree

Wrong:

```
Search left

AND

Search right
```

The BST property already tells you which direction to go.

---

## Forgetting equality

If:

```
root == p
```

then:

```
root
```

is already the Lowest Common Ancestor.

---

## Overcomplicating the split condition

Many implementations simply do:

```java
if (p.val < root.val && q.val < root.val)
    ...

if (p.val > root.val && q.val > root.val)
    ...

return root;
```

Anything that isn't "both left" or "both right" must be the split.

---

# Complexity

Time:

Balanced BST

```
O(log n)
```

Worst case

```
O(n)
```

---

Space:

Recursive version

Balanced

```
O(log n)
```

Worst case

```
O(n)
```

Iterative version

```
O(1)
```

---

# Interview Recognition

When the problem mentions:

- Binary Search Tree
- Lowest Common Ancestor
- Searching for values

Think:

```
Use BST ordering.

Only recurse into one subtree.

The first split is the answer.
```
```