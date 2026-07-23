# Maximum Subarray Notes

## Pattern

Dynamic Programming

Kadane's Algorithm

---

# Core Idea

Track the best subarray ending at the current position.

At every number:

Ask:

"Should I continue the previous subarray or start fresh?"

---

# Variables

## curSum

Meaning:

```
Best sum of a subarray ending here
```

Example:

```
nums = [-2,1,-3]
```

At `1`:

Option 1:

```
-2 + 1 = -1
```

Option 2:

```
1
```

Choose:

```
1
```

because restarting is better.

---

## maxSum

Tracks:

```
Highest curSum encountered
```

because the best answer may have occurred earlier.

---

# Recurrence

For current element:

```
curSum = max(previous sum + current, current)
```

Meaning:

```
extend existing subarray
        OR
start new subarray
```

---

# Example Walkthrough

Array:

```
[-2,1,-3,4,-1,2,1]
```

Start:

```
curSum = -2
maxSum = -2
```

Process:

```
1:
curSum=max(-1,1)=1
maxSum=1

-3:
curSum=max(-2,-3)=-2

4:
curSum=max(2,4)=4
maxSum=4

-1:
curSum=3

2:
curSum=5

1:
curSum=6
maxSum=6
```

Answer:

```
6
```

---

# Why Reset?

A negative prefix reduces any future sum.

Example:

```
[-5,4]
```

Keeping:

```
-5+4=-1
```

is worse than:

```
4
```

So discard negative running sums.

---

# Common Mistakes

## Mistake 1

Initialising:

```java
curSum = 0;
maxSum = 0;
```

Fails for:

```
[-3,-2]
```

because answer is:

```
-2
```

---

## Mistake 2

Only returning curSum:

```java
return curSum;
```

Wrong because the maximum may have occurred earlier.

Example:

```
[5,-10,2]
```

Final curSum:

```
2
```

Answer:

```
5
```

---

# Interview Explanation

"I maintain the maximum subarray sum ending at the current index. For each element, I either extend the previous subarray or start a new one. I keep track of the best sum seen globally while scanning once through the array."

---

# Complexity

Time:

```
O(n)
```

Space:

```
O(1)
```

---

# Related Pattern

Maximum Product Subarray uses the same idea but needs:

```
current maximum
current minimum
```

because multiplying by a negative number can flip signs.