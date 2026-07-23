# Gas Station Notes

## Pattern

- Greedy
- Prefix Sum
- Candidate Elimination

---

## Core Idea

Maintain:

- current fuel in tank
- candidate starting station

Instead of testing every possible starting point, eliminate impossible ones as soon as failure occurs.

---

## Observation 1

If:

```
totalGas < totalCost
```

then:

```
No solution exists.
```

There simply isn't enough fuel to travel the entire circuit.

Always check this first.

---

## Observation 2 (Greedy Insight)

Suppose we start at station:

```
start
```

and eventually fail at station:

```
i
```

because:

```
tank < 0
```

Then **every station between**:

```
start ... i
```

must also fail.

Therefore we skip all of them and continue from:

```
i + 1
```

This is the key greedy proof.

---

## Variables

### candidate

Current station being considered as the starting point.

Initially:

```java
candidate = 0;
```

---

### tank

Current amount of fuel accumulated while travelling.

Update each station:

```java
tank += gas[i] - cost[i];
```

---

## Transition

At every station:

```java
tank += gas[i] - cost[i];
```

If:

```java
tank < 0
```

then:

```java
candidate = i + 1;
tank = 0;
```

Start searching from the next station.

---

## Example

```
gas

1 2 3 4 5

cost

3 4 5 1 2
```

Difference:

```
-2
-2
-2
+3
+3
```

Process:

```
candidate = 0

tank = -2

Fail

candidate = 1
```

---

```
candidate = 1

tank = -2

Fail

candidate = 2
```

---

```
candidate = 2

tank = -2

Fail

candidate = 3
```

---

```
candidate = 3

tank = 3

tank = 6
```

Finish.

Return:

```
3
```

---

## Why Greedy Works

Suppose starting from station:

```
A
```

you fail before reaching:

```
B
```

Any station between:

```
A and B
```

starts with less accumulated fuel than A.

If A cannot reach B, neither can any station after A but before B.

Therefore they can all be discarded immediately.

---

## Common Mistakes

### Forgetting Total Gas Check

Without checking:

```
totalGas >= totalCost
```

you may incorrectly return a starting station even when the circuit is impossible.

---

### Brute Force

Trying every station individually leads to:

```
O(n²)
```

The greedy observation eliminates large groups of impossible candidates.

---

### Resetting Incorrectly

When failure occurs:

Wrong:

```java
candidate++;
```

Correct:

```java
candidate = i + 1;
```

All stations up to `i` have already been proven impossible.

---

## Interview Explanation

"I first verify that the total amount of gas is at least the total travel cost; otherwise no solution exists. Then I scan the stations once while maintaining the current fuel balance and a candidate starting station. Whenever the fuel balance becomes negative, I know every station from the current candidate to the current index is impossible as a starting point, so I reset the candidate to the next station and continue. This greedy elimination gives an O(n) solution."

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

The important insight is **not** simulating every starting station.

The important insight is proving that once a starting station fails, **an entire range of stations can be discarded at once**, allowing a single linear pass.