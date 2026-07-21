# Partition Equal Subset Sum Notes

## Pattern

Dynamic Programming

Category:

```
Decision DP
```

Similar patterns:

- Include / Exclude
- Take / Skip
- Subset problems

---

# Mental Model

The question:

> Can I pick some numbers to reach a target?

Immediately think:

```
Take or skip each number
```

---

# Step 1: Convert Problem

Need:

```
subset1 = subset2
```

Therefore:

```
totalSum = subset1 + subset2
```

Each side:

```
target = totalSum / 2
```

Now solve:

```
Can I create a subset with sum = target?
```

---

# Recursive Function

```java
partition(nums, index, currentSum, target)
```

Meaning:

```
Can I reach target using numbers from index onwards?
```

---

# Choices

For nums[index]:

## Take

Include number:

```java
currentSum + nums[index]
```

Move forward:

```java
index + 1
```

---

## Skip

Ignore number:

```java
currentSum
```

Move forward:

```java
index + 1
```

---

# Base Cases

Success:

```java
currentSum == target
```

Failure:

```java
index >= nums.length
```

or:

```java
currentSum > target
```

---

# Memoization

State:

```
(index, currentSum)
```

Why?

The answer does not depend on the path taken.

Example:

```
[1,5,10]
```

Different choices may reach:

```
index = 2
currentSum = 6
```

The remaining possibilities are identical.

---

# Memo Key

Current implementation:

```java
String key = i + "." + curSum;
```

Stores:

```
Can this state reach the target?
```

---

# Possible Optimization

Replace:

```java
Map<String, Boolean>
```

with:

```java
Boolean[][] memo
```

because the state range is known:

```
index: 0 -> n
sum: 0 -> target
```

---

# Complexity

Without memo:

```
O(2^n)
```

Every number creates two branches.

---

With memo:

States:

```
n * target
```

Time:

```
O(n * target)
```

Space:

```
O(n * target)
```

---

# Interview Explanation

"I reduce the problem to subset sum by finding whether a subset can equal half of the total sum. I recursively explore taking or skipping each number. Since many `(index, sum)` states overlap, I memoize those results to avoid recomputation."

---

# Common Mistakes

## Forgetting odd sum check

Example:

```
[1,2,4]
```

Sum:

```
7
```

Cannot divide equally.

---

## Forgetting this is 0/1 choice

Each number can only be used once.

Incorrect:

```
reuse same number multiple times
```

Correct:

```
move index forward after choosing
```

---

## Wrong state

Bad:

```
memo[path]
```

The path does not matter.

Good:

```
memo[index][currentSum]
```

---

# Pattern Recognition

When you see:

- Split array
- Equal groups
- Reach target sum
- Choose elements once

Think:

```
Subset Sum
```

and:

```
Take / Skip recursion
```