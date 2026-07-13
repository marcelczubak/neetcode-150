# Serialize and Deserialize Binary Tree

## Problem

Design an algorithm to serialize and deserialize a binary tree.

* **Serialize** converts a binary tree into a string.
* **Deserialize** reconstructs the original binary tree from that string.

The reconstructed tree must be identical to the original.

---

## Example

### Input

```text
        1
       / \
      2   3
         / \
        4   5
```

### Serialized Output

```text
1,2,N,N,3,4,N,N,5,N,N,
```

### Deserialized Output

```text
        1
       / \
      2   3
         / \
        4   5
```

---

# Approach

## Key Idea

Use a **preorder DFS traversal** and include **null markers** (`N`) for missing children.

Preorder visits nodes in the order:

```text
Root → Left → Right
```

Including null markers preserves the exact structure of the tree, allowing it to be reconstructed uniquely.

---

## Serialization

Perform a preorder DFS.

* If the current node is `null`, append `"N,"`.
* Otherwise:

  * Append the node value.
  * Serialize the left subtree.
  * Serialize the right subtree.

Example:

```text
        1
       / \
      2   3
```

Produces:

```text
1,2,N,N,3,N,N,
```

---

## Deserialization

Split the serialized string by commas and place every value into a queue.

Recursively rebuild the tree:

* Remove the next value.
* If it is `"N"`, return `null`.
* Otherwise:

  * Create the node.
  * Recursively build the left subtree.
  * Recursively build the right subtree.
* Return the completed node.

Because serialization used preorder traversal, deserialization simply follows the same order.

---

# Complexity Analysis

## Time Complexity

```text
O(n)
```

Every node is visited exactly once during serialization and exactly once during deserialization.

---

## Space Complexity

```text
O(n)
```

Used by:

* Serialized string / queue
* Recursive call stack
