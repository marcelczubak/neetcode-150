# Serialize and Deserialize Binary Tree - Notes

## Core Idea

The solution performs two opposite operations:

* **Serialize:** Tree → String
* **Deserialize:** String → Tree

Both use the same traversal:

```text
Preorder DFS
```

---

## Why Preorder?

Preorder visits:

```text
Root → Left → Right
```

The first value encountered is always the root of the current subtree.

This makes reconstruction straightforward because every recursive call knows exactly which node to create next.

---

## Why Include Null Markers?

Without null markers, different trees can produce the same traversal.

Example:

Tree A

```text
    1
   /
  2
```

Tree B

```text
    1
     \
      2
```

Without null markers both serialize to:

```text
1,2
```

Including `"N"` preserves the structure.

Tree A:

```text
1,2,N,N,N
```

Tree B:

```text
1,N,2,N,N
```

Now the trees are distinguishable.

---

## Serialization Process

For every node:

1. If the node is `null`

   * Append `"N,"`
   * Return

2. Otherwise

   * Append the node value.
   * Serialize the left subtree.
   * Serialize the right subtree.

A `StringBuilder` is used to avoid repeated string concatenation.

---

## Deserialization Process

The serialized string is first converted into:

```text
Queue<String>
```

Each recursive call removes exactly one value from the front.

Algorithm:

1. Remove the next value.
2. If it is `"N"`

   * Return `null`.
3. Otherwise

   * Create a TreeNode.
   * Build the left subtree.
   * Build the right subtree.
4. Return the completed node.

Because preorder is used, recursion naturally rebuilds the tree in the correct order.

---

## Why Use a Queue?

A queue processes values in the exact order they were serialized.

Each recursive call simply consumes the next value.

No indexes or pointers are required.

---

## Common Mistakes

### Forgetting null markers

Without `"N"` values, the tree structure cannot always be reconstructed.

---

### Using String concatenation

Repeatedly doing:

```java
serial += value;
```

creates many unnecessary String objects.

Use:

```java
StringBuilder
```

instead.

---

### Processing right before left

Serialization and deserialization must follow the exact same traversal.

If serialization is:

```text
Root → Left → Right
```

then deserialization must also construct:

```text
Root → Left → Right
```

Changing the order produces an incorrect tree.

---

## Interview Explanation

> "I serialize the tree using preorder DFS while recording null children with a sentinel value. During deserialization, I read the values back in preorder using a queue. Each recursive call consumes one value, creates the current node, and recursively rebuilds its left and right subtrees. Because the traversal order and null markers are preserved, the original tree can be reconstructed exactly in O(n) time."
