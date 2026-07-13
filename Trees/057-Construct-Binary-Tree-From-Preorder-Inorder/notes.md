# Construct Binary Tree from Preorder and Inorder Traversal - Notes

## Core Idea

The solution combines the properties of preorder and inorder traversals.

* **Preorder** tells us **which node to create next**.
* **Inorder** tells us **where that node splits the current subtree**.

Together, these uniquely determine the tree.

---

## Traversal Properties

### Preorder

```
Root → Left → Right
```

The next unused value in preorder is always the root of the current subtree.

A global `preorderIndex` advances every time a new node is created.

---

### Inorder

```
Left → Root → Right
```

The root divides the inorder array into:

```
[left subtree] root [right subtree]
```

Only the current inorder boundaries (`left` and `right`) should be searched.

---

## Why Use a HashMap?

Without a HashMap:

* Every recursive call must search the inorder array.
* Searching is **O(n)**.
* Overall complexity becomes **O(n²)**.

With a HashMap:

```text
value → inorder index
```

Example:

```text
9  -> 0
3  -> 1
15 -> 2
20 -> 3
7  -> 4
```

Each lookup becomes **O(1)**, reducing the overall complexity to **O(n)**.

---

## Recursive Helper

The helper receives:

* `preorder`
* `left`
* `right`
* `HashMap`

The `left` and `right` values represent the current inorder boundaries.

For each recursive call:

1. If `left > right`, return `null`.
2. Read the next preorder value.
3. Create the current node.
4. Find the node's index in inorder.
5. Recursively construct the left subtree.
6. Recursively construct the right subtree.
7. Return the completed node.

---

## Why Build the Left Subtree First?

Because preorder visits nodes in this order:

```
Root → Left → Right
```

After creating the root, the next preorder value always belongs to the left subtree.

Only after the entire left subtree has been built should the recursion move to the right subtree.

---

## Common Mistakes

### Forgetting to increment `preorderIndex`

```java
int root = preorder[preorderIndex];
preorderIndex++;
```

Without incrementing, every recursive call attempts to build the same node.

---

### Searching the inorder array every recursion

Using a loop to locate each root results in **O(n²)** time.

Always preprocess the inorder array into a HashMap.

---

### Incorrect subtree boundaries

Incorrect:

```text
Left:  left → rootIndex
Right: rootIndex → right
```

Correct:

```text
Left:  left → rootIndex - 1
Right: rootIndex + 1 → right
```

The root itself does not belong to either subtree.

---

## Interview Explanation

> "I use preorder to determine the next node to create because preorder always visits the root first. I use the inorder traversal to determine where that root splits the current subtree into left and right sections. A HashMap allows constant-time lookups of the root's position, giving an overall time complexity of O(n)."
