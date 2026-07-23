# Jump Game II Notes

## Pattern

- Greedy
- BFS Window
- Range Expansion

---

## Core Idea

Treat every jump as exploring an entire range of reachable positions.

Current window:

```text
[left ... right]
```

represents:

> Every index reachable using the current number of jumps.

---

## Variables

### left

Beginning of the current reachable window.

---

### right

End of the current reachable window.

Every position between:

```text
left <= i <= right
```

is reachable using the current number of jumps.

---

### numJumps

Number of windows (levels) processed.

Equivalent to the number of jumps taken.

---

## Transition

For every index inside the current window:

```java
right = Math.max(right, i + nums[i]);
```

This computes the furthest position reachable using one more jump.

After finishing the window:

```java
left = previousWindowEnd + 1;
```

Move to the next BFS level.

Increment:

```java
numJumps++;
```

---

## Example

Input:

```text
[2,3,1,1,4]
```

Start:

```text
left = 0

right = 2

jumps = 1
```

Current window:

```text
Indices:

0 1 2
```

Reach:

```text
0 -> 2

1 -> 4

2 -> 3
```

New window:

```text
[3...4]
```

Destination reached.

Answer:

```text
2
```

---

## Why It Is O(n)

The code contains:

```java
while (...)

    for (...)
```

but every index is processed exactly once.

The window only moves forwards:

```text
left →

right →
```

No index ever re-enters another window.

Therefore:

```text
Total work = O(n)
```

---

## Why Greedy Works

Suppose one jump can reach:

```text
indices 4...8
```

Instead of committing to one index immediately, evaluate every possible landing position first.

Choose the furthest reachable point from the entire window.

This guarantees the largest possible window for the next jump.

---

## Common Mistakes

### Greedy Jumping Immediately

Example:

```text
Always jump to the largest number.
```

This is incorrect.

The largest jump value does not necessarily produce the furthest future reach.

Always evaluate the entire current window first.

---

### Using BFS with a Queue

A queue works, but requires:

```text
O(n)
```

extra memory.

The window method performs the same BFS concept using only two pointers.

---

### Dynamic Programming

DP computes the minimum jumps to every index:

```text
O(n²)
```

The greedy window solution achieves:

```text
O(n)
```

---

## Interview Explanation

"I treat each jump as a BFS level. The current window contains every index reachable with the current number of jumps. While scanning that window, I compute the furthest position reachable in one more jump. That furthest position becomes the next window. Since every index is processed only once, the algorithm runs in linear time."

---

## Complexity

Time:

```
O(n)
```

Space:

```
O(1)
```

---

## Relationship to Jump Game I

Jump Game I asks:

```text
Can I reach the end?
```

Maintain:

```text
one greedy goal
```

Jump Game II asks:

```text
What is the minimum number of jumps?
```

Maintain:

```text
a greedy BFS window
```

Both are greedy problems, but Jump Game II expands **levels** rather than simply checking reachability.