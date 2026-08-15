# Network Delay Time

## Problem

Given a directed weighted graph representing a network, determine how long it takes for a signal sent from node `k` to reach **every node**.

Each connection is represented as:

```text
times[i] = [u, v, w]
```

meaning:

```text
u → v
```

with travel time:

```text
w
```

If it is impossible to reach every node, return:

```text
-1
```

---

## Example

### Input

```text
times = [[2,1,1],[2,3,1],[3,4,1]]

n = 4

k = 2
```

The signal travels:

```text
2 → 1 = 1

2 → 3 = 1

2 → 3 → 4 = 2
```

Therefore the total network delay is:

```text
2
```

### Output

```text
2
```

---

# Approach

## Dijkstra's Algorithm

This is a **single-source shortest path** problem.

We need to find:

```text
Shortest distance from k → every other node
```

Since all edge weights are positive, Dijkstra's algorithm is appropriate.

After finding the shortest distance to every node, the answer is the **maximum shortest distance**.

Why?

The signal must reach every node, so the node that takes the longest to reach determines the total delay.

---

# Graph Representation

Use an adjacency list:

```java
Map<Integer, List<int[]>> graph
```

Each entry represents:

```text
node → list of {neighbor, weight}
```

For example:

```text
times = [[1,2,5],[1,3,2]]
```

becomes conceptually:

```text
1 → [2,5]
    [3,2]
```

---

# Distance Array

Maintain:

```java
int[] dist
```

where:

```text
dist[i] = shortest known distance from k to node i
```

Initially:

```text
∞ ∞ ∞ ∞
```

except:

```text
dist[k] = 0
```

because the signal starts at `k`.

---

# Priority Queue

Use a min-heap containing:

```java
{distance, node}
```

The smallest distance is processed first.

```java
PriorityQueue<int[]> minHeap =
    new PriorityQueue<>(
        (a, b) -> Integer.compare(a[0], b[0])
    );
```

Initially:

```text
{0, k}
```

is added.

---

# Dijkstra Process

Repeatedly remove the node with the smallest known distance.

Suppose:

```text
{distance, node}
```

is removed.

For every outgoing edge:

```text
node → neighbour
```

with weight:

```text
weight
```

calculate:

```text
newDist = distance + weight
```

---

# Relaxation

If:

```text
newDist < dist[neighbour]
```

we have discovered a shorter route.

Update:

```java
dist[neighbour] = newDist;
```

and add the improved distance to the priority queue:

```java
minHeap.offer(new int[]{newDist, neighbour});
```

This operation is called **relaxation**.

---

# Stale Priority Queue Entries

Java's `PriorityQueue` does not automatically remove an older entry when a shorter path is discovered.

For example, the queue could contain:

```text
[10, 3]
```

and later:

```text
[5, 3]
```

The distance to node `3` is now:

```text
5
```

When `[10,3]` is eventually removed, it is stale.

Check:

```java
if (minNode[0] > dist[minNode[1]])
    continue;
```

This prevents processing outdated paths.

---

# Finding the Answer

After Dijkstra finishes, inspect:

```text
dist[1...n]
```

If any node still has:

```text
Integer.MAX_VALUE
```

then that node is unreachable.

Return:

```text
-1
```

Otherwise, return:

```text
max(dist[1...n])
```

because the slowest-to-reach node determines the network delay.

---

# Algorithm

1. Build an adjacency list.
2. Initialize every distance to `Integer.MAX_VALUE`.
3. Set `dist[k] = 0`.
4. Add `{0, k}` to the min-heap.
5. While the heap is not empty:
   - Remove the smallest-distance node.
   - Ignore it if the entry is stale.
   - Explore all outgoing edges.
   - Relax any improved distances.
6. Iterate through nodes `1...n`.
7. If any node is unreachable, return `-1`.
8. Otherwise return the maximum shortest distance.

---

# Complexity

Let:

```text
V = number of nodes

E = number of edges
```

Using an adjacency list and binary min-heap:

### Time

```text
O((V + E) log V)
```

Often simplified to:

```text
O(E log V)
```

for a connected graph.

### Space

```text
O(V + E)
```

for:

- adjacency list
- distance array
- priority queue

---

# Pattern Recognition

When you see:

- Weighted graph
- Directed or undirected edges
- Positive edge weights
- Shortest paths from one source

Think:

```text
Dijkstra
```

For Network Delay Time, there is one extra step:

```text
Shortest path to every node
        ↓
Take the maximum
```

---

# Key Insight

Dijkstra finds:

```text
dist[i] = earliest time signal reaches i
```

The answer is:

```text
max(dist[i])
```

because the signal cannot be considered fully delivered until **every** node has received it.

If even one node is unreachable:

```text
return -1
```