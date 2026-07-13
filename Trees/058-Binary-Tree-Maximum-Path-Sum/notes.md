# Binary Tree Maximum Path Sum - Notes

## Core Idea

At every node, there are **two different questions**:

### Question 1

> What is the best path I can return to my parent?

A parent can only continue along **one** child.

Therefore the returned value is:

```text
root.val + max(leftGain, rightGain)
```

---

### Question 2

> Could the maximum path end at this node?

Unlike the returned value, a complete path may include **both** children.

Candidate path:

```text
leftGain + root.val + rightGain
```

This value updates the global answer.

---

## Why Ignore Negative Paths?

Suppose:

```text
      5
     /
   -10
```

Using the left subtree would reduce the total.

Instead:

```text
max(leftGain, 0)
```

means:

> If a subtree hurts the answer, don't include it.

---

## Why Postorder Traversal?

Postorder processes:

```text
Left → Right → Root
```

A node cannot compute its best path until both children have already computed theirs.

---

## Returned Value

Each recursive call returns:

```text
root.val + max(leftGain, rightGain)
```

Only one branch can continue upward.

Example:

```text
      5
     / \
    4   8
```

Returning both branches would create:

```text
4 → 5 → 8
```

A parent cannot extend that path because it would fork.

Only one side can be returned.

---

## Updating the Global Maximum

The best path ending at the current node is:

```text
leftGain + root.val + rightGain
```

This may become the new answer.

Example:

```text
      20
     /  \
   15    7
```

Candidate:

```text
15 + 20 + 7 = 42
```

The recursion still returns:

```text
20 + max(15,7) = 35
```

because only one branch can extend upward.

---

## Common Mistakes

### Returning both branches

Incorrect:

```text
left + root + right
```

This cannot be extended by the parent.

Always return:

```text
root + max(left, right)
```

---

### Forgetting negative paths

Always compute:

```java
int leftGain = Math.max(dfs(root.left), 0);
int rightGain = Math.max(dfs(root.right), 0);
```

Otherwise a negative subtree may reduce the answer.

---

### Initializing the answer to zero

Incorrect:

```java
maxPathSum = 0;
```

Fails for trees containing only negative values.

Correct:

```java
maxPathSum = root.val;
```

---

## Interview Explanation

> "I perform a postorder DFS so that each node already knows the maximum gain from its left and right subtrees. Each recursive call returns the best single branch that can continue upward, while simultaneously updating a global maximum using both branches. Negative gains are ignored because they can only decrease the total path sum. This visits every node once, giving O(n) time complexity."
