# Burst Balloons Notes

## Pattern

- Dynamic Programming
- DFS
- Memoization
- Interval DP

---

# Core Idea

The difficult part is that bursting a balloon changes its neighbours.

Instead of asking:

```text
Which balloon should I burst first?
```

ask:

```text
Which balloon should I burst LAST?
```

This makes the surrounding balloons predictable.

---

# Padding

Original:

```text
[3, 1, 5, 8]
```

Pad with `1`s:

```text
[1, 3, 1, 5, 8, 1]
```

The actual balloons are:

```text
1 ... n
```

The boundary `1`s are never removed.

This allows:

```java
nums[left - 1]
nums[right + 1]
```

to always be valid.

---

# DP State

```java
popBalloons(left, right)
```

means:

```text
Maximum coins obtainable by bursting
every balloon from left through right.
```

Cache:

```java
cache[left][right]
```

---

# Base Case

If:

```java
left > right
```

there are no balloons.

Return:

```text
0
```

---

# Choosing the Last Balloon

For:

```text
[left ........ right]
```

try every:

```text
i
```

as the balloon that gets burst last.

The interval becomes:

```text
[left ... i-1]   i   [i+1 ... right]
```

---

# Final Burst

Because `i` is the last balloon:

```text
all balloons inside the interval
```

except `i` have already disappeared.

Therefore its neighbours are:

```text
nums[left - 1]
```

and:

```text
nums[right + 1]
```

Coins:

```text
nums[left - 1]
*
nums[i]
*
nums[right + 1]
```

---

# Recurrence

For every possible `i`:

```text
coins =
    dfs(left, i-1)
    +
    nums[left-1] * nums[i] * nums[right+1]
    +
    dfs(i+1, right)
```

Take:

```text
max(coins)
```

over all `i`.

---

# Visual

```text
        current interval

    left              right
      ↓                  ↓
[ ... ... ... i ... ... ... ]
              ↑
          burst LAST
```

After everything else has disappeared:

```text
[nums[left-1]] [i] [nums[right+1]]
```

So the final burst is completely determined by the interval boundaries.

---

# Why the Subproblems Add

If `i` is last:

```text
LEFT SIDE
```

must be completely burst first.

And:

```text
RIGHT SIDE
```

must also be completely burst first.

Then:

```text
i
```

is burst.

Therefore:

```text
leftCoins
+
rightCoins
+
finalBurst
```

not:

```text
max(leftCoins, rightCoins, finalBurst)
```

Both sides contribute to the total.

---

# Memoization

Different recursive paths can produce the same interval:

```text
(left, right)
```

The answer for that interval is always identical.

Store:

```java
cache[left][right]
```

and return it if already calculated.

---

# Example

```text
nums = [3,1,5,8]
```

Padded:

```text
[1,3,1,5,8,1]
```

Initial interval:

```text
[1 ... 4]
```

Try:

```text
i = 1
i = 2
i = 3
i = 4
```

For each `i`, assume it is the final balloon.

For example, if:

```text
i = 3
```

then:

```text
left interval  = [1,2]

right interval = [4]

final burst     = nums[0] * nums[3] * nums[5]
```

Calculate all three parts and take the maximum.

---

# Common Mistakes

## Choosing the First Balloon

Trying to model:

```text
which balloon do I burst first?
```

makes the neighbouring values difficult to track.

Use:

```text
last balloon
```

instead.

---

## Using `nums[i-1]` and `nums[i+1]`

This is wrong for the final-burst formulation:

```java
nums[i-1] * nums[i] * nums[i+1]
```

Those balloons may already have been burst.

Use:

```java
nums[left-1] * nums[i] * nums[right+1]
```

because `i` is the last balloon in the interval.

---

## Forgetting the Empty Interval

Recursive calls can produce:

```text
left > right
```

Return:

```text
0
```

---

## Forgetting to Add Both Subproblems

Wrong:

```java
Math.max(left, right)
```

Correct:

```java
left + finalBurst + right
```

---

## Forgetting Padding

Without padding, boundary cases require special handling.

Adding:

```text
1
```

to both ends simplifies the recurrence significantly.

---

# Interview Explanation

"I use interval DP with the key insight of considering the balloon that is burst last rather than first. For an interval `[left, right]`, I try every balloon `i` as the final balloon. Once all other balloons in the interval have been removed, the neighbours of `i` are fixed at `left-1` and `right+1`, so its final contribution is `nums[left-1] * nums[i] * nums[right+1]`. The balloons to the left and right form independent subproblems. I memoize each interval to avoid recomputation."

---

# Complexity

Time:

```text
O(n³)
```

Space:

```text
O(n²)
```

---

# Key Takeaway

The main trick is:

```text
Don't choose what happens FIRST.

Choose what happens LAST.
```

For an interval:

```text
[left ... right]
```

choose:

```text
i = last balloon
```

Then:

```text
answer =
    left subproblem
    +
    final burst
    +
    right subproblem
```

This transforms a difficult simulation problem into a standard interval DP problem.
```