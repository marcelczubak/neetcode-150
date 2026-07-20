# House Robber II Notes

## Pattern

```
Circular Dynamic Programming
```

Reduce to:

```
Two House Robber I problems
```

---

# Main Insight

The only difference from House Robber I:

```
First and last houses are adjacent.
```

So you cannot rob both.

---

# Break into Two Cases

Case 1

```
Use houses:

0 ... n-2
```

Ignore the last house.

---

Case 2

```
Use houses:

1 ... n-1
```

Ignore the first house.

---

Answer:

```
max(case1, case2)
```

---

# Why Only Two Cases?

Every valid solution must satisfy one of:

```
Exclude first

OR

Exclude last
```

No solution can include both.

---

# Reusing House Robber I

For each case:

```java
rob1 = 0;
rob2 = 0;

for (...) {

    current = Math.max(nums[i] + rob1, rob2);

    rob1 = rob2;
    rob2 = current;
}
```

Exactly the same DP as the original problem.

---

# Edge Case

If:

```
nums.length == 1
```

Return:

```java
nums[0]
```

Otherwise both ranges become empty.

---

# Complexity

Time:

```
O(n)
```

Two linear passes.

Space:

```
O(1)
```

when using start/end indices.

---

# Interview Explanation

"I recognised that the circular constraint only prevents taking both the first and last house together. Every valid solution must therefore exclude one of them. I reduced the problem into two House Robber I instances—one excluding the first house and one excluding the last—and returned the larger result. This keeps the solution linear while reusing the existing DP logic."

---

# Common Mistake

Creating new arrays using:

```java
Arrays.copyOfRange(...)
```

works, but costs:

```
O(n)
```

extra space.

Better:

Pass:

```java
start

end
```

indices into the helper.

---

# Recognition Pattern

If you already know the linear version of a DP problem and it suddenly becomes:

- Circular
- Ring
- Wrap-around

Think:

```
Split into a small number of linear cases.
```

---

# Similar Problems

- House Robber
- Delete and Earn
- Maximum Sum Circular Subarray (different technique)
- Gas Station