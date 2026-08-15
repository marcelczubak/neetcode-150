# Cheapest Flights Within K Stops — Notes

## Pattern

- Dynamic Programming
- Graph
- Shortest Path
- Bounded Shortest Path
- Bellman-Ford
- Edge Relaxation

---

# Core Insight

The restriction:

```text
At most k stops
```

means:

```text
At most k + 1 flights
```

Therefore we can process the graph in:

```text
k + 1
```

layers.

---

# State

```java
dp[i]
```

means:

> Cheapest known cost to reach city `i` using at most the number of flights processed so far.

Initial state:

```text
dp[src] = 0
dp[everything else] = ∞
```

---

# Why Layering?

Each layer allows exactly **one additional flight** to be considered.

Think:

```text
0 flights
    ↓
1 flight
    ↓
2 flights
    ↓
3 flights
    ↓
...
    ↓
k + 1 flights
```

---

# Relaxation

For a flight:

```text
u → v
price
```

If `u` is reachable:

```text
newCost = dp[u] + price
```

Then:

```text
next[v] = min(next[v], newCost)
```

---

# Why `next`?

Never update `dp` directly.

Use:

```text
dp → read
next → write
```

because otherwise updates made earlier in the same iteration could be used again immediately.

That could accidentally allow multiple flights during a single layer.

---

# `next` Must Start as a Copy

Use:

```java
next = copy(dp)
```

rather than:

```text
next = [∞, ∞, ∞, ...]
```

because we're interested in:

```text
at most X flights
```

not:

```text
exactly X flights
```

Copying preserves the best routes already found.

---

# Example

Suppose:

```text
0 → 1 = 100
1 → 2 = 50
0 → 2 = 300
```

Initially:

```text
dp = [0, ∞, ∞]
```

After one flight:

```text
dp = [0, 100, 300]
```

After two flights:

```text
dp = [0, 100, 150]
```

The route:

```text
0 → 1 → 2
```

costs:

```text
150
```

which is cheaper than the direct flight:

```text
0 → 2 = 300
```

---

# Stops vs Flights

Always remember:

```text
stops = intermediate cities
```

For:

```text
A → B → C
```

there is:

```text
1 stop
2 flights
```

Therefore:

```text
k stops
=
k + 1 flights
```

---

# Loop Count

Correct:

```text
k + 1 iterations
```

Examples:

```text
k = 0 → 1 flight
k = 1 → 2 flights
k = 2 → 3 flights
```

---

# Why Not Dijkstra?

Dijkstra keeps one best distance per node.

That doesn't capture the stop constraint.

A route can be:

```text
cheaper
```

but:

```text
use too many stops
```

Another route can be:

```text
more expensive
```

but:

```text
valid within k stops
```

Therefore we need to track the number of allowed flights through the DP layers.

---

# Bellman-Ford Connection

The algorithm is essentially a **bounded version of Bellman-Ford**.

Bellman-Ford:

```text
relax every edge repeatedly
```

Here:

```text
relax every flight
```

for only:

```text
k + 1
```

rounds.

---

# No Adjacency List Required

Unlike Dijkstra, we don't need:

```text
node → neighbours
```

because every layer deliberately processes:

```text
every flight
```

So the input:

```java
int[][] flights
```

can be used directly.

---

# Important Implementation Details

### Check reachability

Before:

```text
dp[u] + price
```

make sure:

```text
dp[u] != Integer.MAX_VALUE
```

Otherwise you're trying to extend an unreachable city.

---

### Use `long` if constraints could cause integer overflow

For this LeetCode problem, `int` is sufficient under the given constraints, but conceptually:

```text
distance + price
```

should be checked for overflow in more general implementations.

---

# Common Mistakes

## Mistake 1 — Using `k` iterations

Wrong:

```text
k
```

Correct:

```text
k + 1
```

because stops and flights differ by one.

---

## Mistake 2 — Updating `dp` directly

Wrong conceptually:

```text
dp[v] = min(dp[v], dp[u] + price)
```

during the same layer.

This can allow multiple edges in one iteration.

Use:

```text
next[v]
```

instead.

---

## Mistake 3 — Starting `next` from infinity

If:

```text
next = [∞, ∞, ...]
```

you lose routes found in previous layers.

Instead:

```text
next = copy(dp)
```

---

## Mistake 4 — Iterating `n` times over flights

```text
n = number of cities
```

but:

```text
flights.length = number of flights
```

Always iterate over:

```text
flights.length
```

when processing the edges.

---

# Interview Explanation

"I treat the stop limit as a bound on the number of edges in the path. Since at most `k` stops means at most `k+1` flights, I perform `k+1` rounds of edge relaxation. `dp[i]` stores the cheapest cost to reach city `i` using the number of flights processed so far. For each round I copy `dp` into `next`, then relax every flight from `dp` into `next`. Using a separate array prevents an update in the current round from being reused immediately. After `k+1` rounds, `dp[dst]` is the cheapest valid price."

---

# Complexity

```text
Time:  O(kE)
Space: O(n)
```

where:

```text
E = number of flights
```

---

# Key Takeaway

Remember:

```text
k stops
    ↓
k + 1 flights
    ↓
k + 1 relaxation rounds
    ↓
dp → next
    ↓
dp[dst]
```

The critical implementation pattern is:

```text
for each layer:

    next = copy(dp)

    for each flight:
        relax from dp → next

    dp = next
```
```