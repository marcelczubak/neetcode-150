# Merge Triplets Notes

## Pattern

- Greedy
- Filtering
- Independent State Tracking

---

# Core Insight

The merge operation:

```
[a,b,c] + [x,y,z]

= [
max(a,x),
max(b,y),
max(c,z)
]
```

Only increases values.

Therefore:

```
Values can never decrease.
```

---

# Invalid Triplets

Any triplet exceeding the target is useless.

Example:

Target:

```
[5,5,5]
```

Triplet:

```
[5,6,5]
```

The second value is too large.

After merging:

```
max(5,6)=6
```

The result can never become:

```
5
```

Therefore ignore it.

---

# Valid Triplets

A valid triplet satisfies:

```
triplet[i] <= target[i]
```

for every index.

These triplets can safely contribute.

---

# Tracking Progress

We only care whether each target position can be achieved.

Maintain:

```java
boolean foundX;
boolean foundY;
boolean foundZ;
```

---

When processing:

```text
[x,y,z]
```

update:

```java
if (x == target[0])
    foundX = true;

if (y == target[1])
    foundY = true;

if (z == target[2])
    foundZ = true;
```

---

# Important Observation

The triplets providing each coordinate do NOT need to be the same.

Example:

Target:

```
[5,8,10]
```

Triplets:

```
[5,1,2]
[1,8,3]
[2,3,10]
```

Together they create:

```
[5,8,10]
```

because:

```
max(5,1,2)=5

max(1,8,3)=8

max(2,3,10)=10
```

---

# Algorithm

1. Loop through all triplets.

2. Skip invalid triplets:

```java
if(any value > target)
    continue;
```

3. Record whether this triplet provides any missing target value.

4. Return:

```java
foundX && foundY && foundZ
```

---

# Common Mistakes

## Mistake 1: Requiring one triplet to equal target

Wrong:

```
Need:
[5,8,10]
```

as a single triplet.

Correct:

Different triplets can provide different coordinates.

---

## Mistake 2: Keeping triplets that exceed target

Wrong:

```
[6,8,10]
```

for target:

```
[5,8,10]
```

Because:

```
max(6,...) = 6
```

and we cannot reduce it.

---

## Mistake 3: Overcomplicating with simulation

You do not need to actually perform merges.

The question is asking:

"Can every target coordinate be supplied?"

---

# Optimisation

Original approach:

```
HashSet of invalid indices
```

Works, but unnecessary.

Better:

Process and skip invalid triplets immediately.

This gives:

```
Space: O(1)
```

---

# Interview Explanation

"The merge operation takes the maximum value at each coordinate, meaning values can only increase. Therefore any triplet with a coordinate greater than the target can be discarded because it would make the final result exceed the target. For the remaining triplets, I track whether each coordinate of the target can be supplied by at least one triplet. If all three coordinates are found, the target can be formed."

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

# Key Takeaway

The trick is recognising that:

```
Each coordinate can be satisfied independently.
```

You are not searching for a combination of whole triplets.

You are only checking whether the maximum operation can obtain each target value.