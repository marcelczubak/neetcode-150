# Cheapest Flights Within K Stops

## Problem

Given:

- `n` cities
- directed flights
- a source city `src`
- a destination city `dst`
- a maximum of `k` stops

Find the cheapest possible price from `src` to `dst` using **at most `k` stops**.

If no valid route exists, return `-1`.

Each flight is represented as:

```text
[from, to, price]
```

---

# Key Insight

The important constraint is:

```text
At most k stops
```

A route with:

```text
k stops
```

contains:

```text
k + 1 flights
```

Therefore, we only need to consider paths containing at most:

```text
k + 1 edges
```

This makes the problem a **bounded shortest-path / dynamic programming** problem.

---

# Why Not Standard Dijkstra?

Standard Dijkstra tracks:

```text
dist[city]
```

meaning:

```text
cheapest cost to reach city
```

However, here the number of stops matters.

A more expensive route to a city may still be useful if it uses fewer flights.

Therefore, simply storing one unrestricted shortest distance per city is not enough.

Instead, we process the graph **layer by layer**, where each layer represents allowing one additional flight.

---

# DP State

```java
int[] dp
```

represents:

```text
dp[i] =
cheapest known cost to reach city i
using at most the number of flights
processed so far
```

Initially:

```text
dp[src] = 0
```

and:

```text
dp[all other cities] = ∞
```

because only the source is reachable before taking any flights.

---

# Layer-by-Layer Processing

Since:

```text
k stops = k + 1 flights
```

process:

```text
k + 1
```

layers.

For every layer:

1. Copy `dp` into `next`.
2. Examine every flight.
3. Relax each flight using `dp`.
4. Store improvements in `next`.
5. Set `dp = next`.

---

# Why Use `next`?

This is the most important implementation detail.

We must **not modify `dp` while processing flights**.

Suppose:

```text
A → B → C
```

If `dp[B]` is updated while processing:

```text
A → B
```

then the same iteration could immediately use the new `dp[B]` to process:

```text
B → C
```

This would allow two flights in one layer.

Instead:

```text
dp
 ↓
read
 ↓
next
 ↓
write
```

Every update in the current layer is based on the **previous layer's `dp`**.

---

# Copying the DP Array

At the beginning of every layer:

```java
int[] next = Arrays.copyOf(dp, n);
```

This is important because we are calculating:

```text
at most X flights
```

rather than:

```text
exactly X flights
```

Copying `dp` preserves all previously discovered cheaper routes.

---

# Relaxing a Flight

For every flight:

```text
[u, v, price]
```

If:

```text
dp[u] != Integer.MAX_VALUE
```

then `u` is reachable.

Calculate:

```text
newCost = dp[u] + price
```

Then update:

```text
next[v] = min(next[v], newCost)
```

This is the standard **edge relaxation** operation.

---

# Example

Suppose:

```text
0 → 1 = 100
1 → 2 = 100
```

Initially:

```text
dp = [0, ∞, ∞]
```

### Layer 1

Process:

```text
0 → 1
```

giving:

```text
next = [0, 100, ∞]
```

After:

```text
dp = next
```

we have:

```text
dp = [0, 100, ∞]
```

### Layer 2

Now:

```text
1 → 2
```

can be used:

```text
100 + 100 = 200
```

giving:

```text
dp = [0, 100, 200]
```

So city `2` can be reached for `200` using two flights.

---

# Number of Layers

If:

```text
k = 0
```

then:

```text
at most 0 stops
```

means only:

```text
src → dst
```

is allowed.

Therefore:

```text
1 flight
```

must be processed.

If:

```text
k = 2
```

then:

```text
at most 2 stops
```

allows:

```text
3 flights
```

Therefore process:

```text
k + 1 = 3
```

layers.

---

# Final Answer

After processing `k + 1` layers:

```java
dp[dst]
```

contains the cheapest valid price.

If:

```text
dp[dst] == Integer.MAX_VALUE
```

then the destination cannot be reached within the stop limit.

Return:

```text
-1
```

Otherwise:

```text
dp[dst]
```

is the answer.

---

# Algorithm

```text
Initialize dp[src] = 0
Initialize all other dp values to infinity

Repeat k + 1 times:

    next = copy of dp

    For every flight [u, v, price]:

        If u is reachable:

            newCost = dp[u] + price

            next[v] = min(next[v], newCost)

    dp = next

If dst is unreachable:
    return -1

Otherwise:
    return dp[dst]
```

---

# Complexity

Let:

```text
n = number of cities
E = number of flights
```

We process every flight for each of the `k + 1` layers.

### Time

```text
O(kE)
```

More precisely:

```text
O((k + 1)E)
```

which simplifies to:

```text
O(kE)
```

### Space

We maintain two arrays of size `n`:

```text
dp
next
```

Therefore:

```text
O(n)
```

---

# Pattern Recognition

When you see:

- Directed weighted graph
- Cheapest path
- Maximum number of stops / edges
- A bounded number of transitions

Think:

```text
Bounded Dynamic Programming
```

or:

```text
Bellman-Ford-style relaxation
```

---

# Important Distinction

### Network Delay Time

Uses:

```text
Dijkstra
```

because we want unrestricted shortest paths from one source.

### Cheapest Flights Within K Stops

Uses:

```text
Layered DP / Bellman-Ford
```

because paths are restricted by the number of flights.

The constraint:

```text
k + 1 flights
```

naturally gives us the number of relaxation rounds.

---

# Key Takeaway

The main idea is:

```text
dp = cheapest prices using previous number of flights

        ↓

process every flight

        ↓

next = cheapest prices using one more flight

        ↓

dp = next
```

Repeat this:

```text
k + 1 times
```

Then:

```text
answer = dp[dst]
```