# Gas Station

## Problem

There are `n` gas stations arranged in a circle.

Each station provides:

- `gas[i]` units of fuel

Travelling from station `i` to station `i + 1` requires:

- `cost[i]` units of fuel

Return the starting gas station's index if you can travel around the circuit exactly once in the clockwise direction.

If completing the circuit is impossible, return `-1`.

It is guaranteed that if a solution exists, it is unique.

---

## Example

### Input

```text
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
```

### Output

```text
3
```

### Explanation

Starting at station `3`:

```
Tank = 0

Station 3:
+4 -1 = 3

Station 4:
+5 -2 = 6

Station 0:
+1 -3 = 4

Station 1:
+2 -4 = 2

Station 2:
+3 -5 = 0
```

The circuit is completed successfully.

---

## Approach

### Greedy

The key observation is that if we fail to reach station `i` starting from station `start`, then **every station between `start` and `i` is also impossible as a starting point**.

Why?

Because all of those stations would begin the journey with even less accumulated fuel than `start`.

Therefore, once failure occurs, we immediately move the candidate starting station to:

```
i + 1
```

and continue scanning.

---

## Algorithm

1. Compute:
   - Total gas
   - Total travel cost

2. If:

```
totalGas < totalCost
```

return:

```
-1
```

because completing the circuit is impossible.

3. Traverse every station once while maintaining:

- current fuel in tank
- current candidate starting station

4. At each station:

```
tank += gas[i] - cost[i]
```

5. If:

```
tank < 0
```

then:

- current candidate cannot work
- every station between candidate and current station cannot work

Reset:

```
candidate = i + 1
tank = 0
```

6. Return the candidate.

---

## Example Walkthrough

Difference array:

```text
gas - cost

[-2,-2,-2,+3,+3]
```

Start:

```text
candidate = 0
tank = 0
```

Station 0:

```
tank = -2
```

Fail.

Move candidate:

```
candidate = 1
tank = 0
```

---

Station 1:

```
tank = -2
```

Fail.

Move candidate:

```
candidate = 2
```

---

Station 2:

```
tank = -2
```

Fail.

Move candidate:

```
candidate = 3
```

---

Station 3:

```
tank = 3
```

---

Station 4:

```
tank = 6
```

End of traversal.

Answer:

```
3
```

---

## Complexity

### Time Complexity

```
O(n)
```

Each station is processed exactly once.

### Space Complexity

```
O(1)
```

Only a few integer variables are maintained.

---

## Key Insight

Whenever the fuel balance becomes negative:

```
tank < 0
```

every station between the previous candidate and the current station can be discarded immediately.

This greedy observation is what reduces the solution from quadratic to linear time.

---

## Pattern Recognition

When you see:

- circular traversal
- cumulative gains/losses
- eliminate impossible candidates
- unique valid starting position

Think:

```
Greedy
```

---

## Related Problems

- Jump Game
- Jump Game II
- Candy
- Partition Labels