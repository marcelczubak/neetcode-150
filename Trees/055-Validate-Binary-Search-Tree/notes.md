# Validate Binary Search Tree - Notes

---

# Pattern

```
DFS

+

Carry state through recursion
```

---

# Main Insight

A BST is not just:

```
left child < parent < right child
```

It is:

```
EVERY node in left subtree < parent

EVERY node in right subtree > parent
```

---

# Why Child Comparison Fails

Example:

```
        10
       /  \
      5    15
          /
         6
```

Checking only children:

```
6 < 15

true
```

But:

```
6 is in the right subtree of 10
```

so:

```
6 must be > 10
```

The tree is invalid.

---

# Solution Idea

Every node receives a valid interval.

Example:

```
        10
       /  \
```

Root:

```
(-∞, +∞)
```

Left child:

```
(-∞, 10)
```

Right child:

```
(10, +∞)
```

---

# Recursive State

Function:

```java
dfs(node, lower, upper)
```

Means:

"Is this subtree valid if every value must be between lower and upper?"

---

# Updating Bounds

At node:

```
x
```

Left subtree:

```
lower stays the same

upper becomes x
```

because:

```
all left values < x
```

---

Right subtree:

```
lower becomes x

upper stays the same
```

because:

```
all right values > x
```

---

# Important Ordering

Check first:

```java
if (node.val <= lower || node.val >= upper)
    return false;
```

Then recurse.

Do not update bounds before checking.

---

# Duplicate Values

BST usually does not allow duplicates.

Therefore:

Invalid:

```
    5
   /
  5
```

Because:

```
left must be < 5
```

not:

```
<= 5
```

---

# Common Mistakes

## Mistake 1: Checking only children

Wrong:

```java
root.left.val < root.val
root.right.val > root.val
```

Fails because grandchildren may violate ancestor constraints.

---

## Mistake 2: Hardcoding constraints

Example:

```java
[-1000,1000]
```

Works only for the given problem.

Better:

```
(-∞,+∞)
```

using:

```java
long
```

bounds.

---

## Mistake 3: Integer overflow

Using:

```java
Integer.MIN_VALUE
Integer.MAX_VALUE
```

can cause issues if node values equal those values.

Better:

```java
long lower = Long.MIN_VALUE;
long upper = Long.MAX_VALUE;
```

---

# Recursive Template

```
validate(node, lower, upper)

if node is null:
    return true

if node violates bounds:
    return false

return

validate(left, lower, node.val)
AND
validate(right, node.val, upper)
```

---

# Complexity

Time:

```
O(n)
```

Every node visited once.

Space:

```
O(h)
```

where h = tree height.

---

# Interview Recognition

When a tree problem involves:

- ancestor restrictions
- ordering
- valid ranges
- constraints passed down

Think:

```
DFS + State Propagation
```