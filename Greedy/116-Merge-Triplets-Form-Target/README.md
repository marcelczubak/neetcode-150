# Merge Triplets to Form Target Triplet

## Problem

You are given an array of triplets.

Each triplet:

```
[x, y, z]
```

can be merged with another triplet by taking the maximum value at each position:

```
[a,b,c] + [x,y,z]

= [max(a,x), max(b,y), max(c,z)]
```

Return `true` if some combination of triplets can be merged to create the target triplet.

---

## Example

### Input

```text
triplets = [
  [2,5,3],
  [1,8,4],
  [1,7,5]
]

target = [2,8,5]
```

### Output

```text
true
```

### Explanation

Valid triplets:

```
[2,5,3]
[1,8,4]
[1,7,5]
```

Merge:

```
max(2,1,1) = 2
max(5,8,7) = 8
max(3,4,5) = 5
```

Result:

```
[2,8,5]
```

---

# Approach

## Greedy

The merge operation only uses:

```
maximum values
```

Therefore:

- A value larger than the target can never be useful.
- A value smaller than the target can still contribute.

Example:

Target:

```
[5,5,5]
```

Triplet:

```
[6,4,5]
```

The `6` is already too large.

Since merging uses:

```
max()
```

there is no way to reduce it back to `5`.

Therefore this triplet must be ignored.

---

## Algorithm

1. Iterate through every triplet.

2. Ignore any triplet where:

```
triplet[i] > target[i]
```

for any position.

These triplets can never contribute.

---

3. For valid triplets:

Check whether they can provide each target coordinate.

Example:

```
target = [5,8,10]
```

Need to find:

```
some triplet with x = 5

some triplet with y = 8

some triplet with z = 10
```

Track this using boolean variables:

```
foundX
foundY
foundZ
```

---

4. Return:

```
foundX && foundY && foundZ
```

---

# Example Walkthrough

Target:

```
[3,4,5]
```

Triplets:

```
[3,2,5]
[1,4,2]
[2,3,4]
```

All are valid.

Process:

First:

```
[3,2,5]
```

Provides:

```
x = 3
z = 5
```

So:

```
foundX = true
foundZ = true
```

---

Second:

```
[1,4,2]
```

Provides:

```
y = 4
```

Now:

```
foundX = true
foundY = true
foundZ = true
```

Return:

```
true
```

---

# Why Greedy Works

The final triplet is formed by:

```
maximum value at each position
```

Each coordinate can be supplied independently.

We only need:

```
one valid triplet providing target[0]

one valid triplet providing target[1]

one valid triplet providing target[2]
```

They do not need to be the same triplet.

---

# Complexity

Let:

```
n = number of triplets
```

## Time Complexity

We check every triplet once:

```
O(n)
```

---

## Space Complexity

Only three boolean variables are needed:

```
O(1)
```

---

# Pattern Recognition

When you see:

- combine arrays using maximum/minimum
- target values
- invalid values cannot be reduced
- independent coordinates

Think:

```
Greedy filtering
```

---

# Related Problems

- Gas Station
- Jump Game
- Hand of Straights
- Partition Labels
- Assign Cookies