# Jump Game Notes

## Pattern

- Greedy
- Reachability
- Reverse traversal

---

## Core Idea

Instead of asking:

> "How far can I jump from here?"

Ask:

> "Can this position reach my current goal?"

If it can, move the goal backwards.

---

## Greedy Invariant

At every iteration:

```
goalIndex
```

represents:

> The leftmost index currently known to reach the last index.

Initially:

```java
goalIndex = nums.length - 1;
```

because the final index always reaches itself.

---

## Transition

For each index moving backwards:

```java
if (i + nums[i] >= goalIndex)
```

If true:

```java
goalIndex = i;
```

The current index can reach the goal, so it becomes the new goal.

---

## Why This Works

Suppose:

```text
goal = 7
```

If index `4` can jump to `7`, then:

- reaching index `4`
- automatically means reaching the end

Therefore:

```text
goal = 4
```

Repeat until either:

- the goal reaches index `0`
- or no earlier position can reach it.

---

## Example

```text
nums = [2,3,1,1,4]
```

Start:

```text
goal = 4
```

Process:

```text
i = 3

3 + 1 >= 4

goal = 3
```

```text
i = 2

2 + 1 >= 3

goal = 2
```

```text
i = 1

1 + 3 >= 2

goal = 1
```

```text
i = 0

0 + 2 >= 1

goal = 0
```

Goal reached index `0`.

Answer:

```text
true
```

---

## Common Mistakes

### Starting from the front

Many people attempt DFS or recursion.

This creates many overlapping paths and becomes exponential.

---

### Forgetting the Greedy Invariant

The important idea isn't:

> "maximum jump"

It's:

> "leftmost reachable goal"

That is what makes the proof work.

---

### Confusing with Jump Game II

Jump Game I:

```
Can we reach the end?
```

Answer:

```
boolean
```

Jump Game II:

```
Minimum number of jumps?
```

Uses a different greedy strategy.

---

## Interview Explanation

"I solve the problem greedily from right to left. I maintain the leftmost position that can reach the end. Whenever I find an earlier index that can jump to this goal, I move the goal to that index. If the goal eventually becomes index 0, then the start can reach the end."

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

## Key Takeaway

Greedy works because once an index can reach the current goal, everything after that goal is already guaranteed to be reachable.

Rather than exploring all paths, simply keep moving the goal backwards.