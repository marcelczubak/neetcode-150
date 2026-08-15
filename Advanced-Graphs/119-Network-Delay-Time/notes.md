# Network Delay Time Notes

## Pattern

- Graph
- Weighted Graph
- Single-Source Shortest Path
- Dijkstra
- Priority Queue
- Greedy

---

# Core Idea

Send a signal from:

```text
k
```

and determine the shortest time required to reach every node.

This means:

```text
Find shortest path from k → every node
```

Then take:

```text
maximum shortest distance
```

---

# Graph Representation

Input:

```text
times[i] = [u, v, w]
```

means:

```text
u → v
```

with weight:

```text
w
```

Use:

```java
Map<Integer, List<int[]>> graph
```

where:

```text
int[]{neighbour, weight}
```

represents an outgoing edge.

---

# Distance Array

```java
int[] dist = new int[n+1];
```

Meaning:

```text
dist[node] =
shortest known distance from k to node
```

Initialize:

```text
∞
```

for every node.

Then:

```java
dist[k] = 0;
```

---

# Priority Queue

Store:

```text
{distance, node}
```

Use a min-heap ordered by distance.

```java
PriorityQueue<int[]> minHeap =
    new PriorityQueue<>(
        (a,b) -> Integer.compare(a[0], b[0])
    );
```

Start with:

```java
minHeap.offer(new int[]{0, k});
```

---

# Dijkstra

Repeatedly:

```text
1. Take closest node
2. Explore neighbours
3. Calculate new distances
4. Relax improved distances
```

---

# Relaxation

For:

```text
u → v
```

with weight:

```text
w
```

calculate:

```text
newDist = dist[u] + w
```

If:

```text
newDist < dist[v]
```

update:

```java
dist[v] = newDist;
```

and push:

```java
new int[]{newDist, v}
```

---

# Stale Entries

The priority queue may contain multiple entries for the same node.

Example:

```text
[10, 3]
[5, 3]
```

After finding distance `5`, the `[10,3]` entry is outdated.

Use:

```java
if (minNode[0] > dist[minNode[1]])
    continue;
```

This is an important Dijkstra implementation detail.

---

# Why the Maximum?

Suppose:

```text
dist = [0, 1, 4, 2]
```

The signal reaches:

```text
node 1 → 0
node 2 → 1
node 3 → 4
node 4 → 2
```

The entire network receives the signal after:

```text
4
```

because node `3` takes the longest.

Therefore:

```text
answer = max(dist)
```

---

# Unreachable Nodes

If:

```java
dist[i] == Integer.MAX_VALUE
```

then no path exists from `k` to `i`.

Return:

```text
-1
```

---

# Important Dijkstra Rules

### Rule 1

Only use Dijkstra when edge weights are non-negative.

---

### Rule 2

Always relax:

```text
if newDist < dist[neighbour]
```

---

### Rule 3

Only push a node into the priority queue when its distance improves.

---

### Rule 4

Handle stale priority queue entries:

```java
if (distance > dist[node])
    continue;
```

---

### Rule 5

For Network Delay Time, don't return the shortest distance to a particular node.

You need:

```text
maximum shortest distance
```

---

# Common Mistakes

## Adding Every Candidate to the Heap

Wrong:

```java
if (newDist < dist[v])
    dist[v] = newDist;

heap.offer(new int[]{newDist, v});
```

Correct:

```java
if (newDist < dist[v]) {
    dist[v] = newDist;
    heap.offer(new int[]{newDist, v});
}
```

---

## Forgetting Stale Entries

Without:

```java
if (distance > dist[node])
    continue;
```

you may unnecessarily process outdated paths.

The algorithm can still sometimes work, but you lose the clean Dijkstra implementation and may do unnecessary work.

---

## Including Node 0

Nodes are numbered:

```text
1 ... n
```

so:

```java
int[] dist = new int[n+1];
```

has an unused:

```text
dist[0]
```

When checking the answer, iterate:

```java
for (int i = 1; i <= n; i++)
```

not over the entire array.

---

## Returning the Minimum Distance

The answer isn't:

```text
min(dist)
```

The signal needs to reach everyone.

Therefore:

```text
answer = max(dist)
```

---

# Interview Explanation

"I model the network as a weighted directed graph and use Dijkstra's algorithm from node `k` to calculate the shortest time to every node. I store outgoing edges in an adjacency list and use a min-priority queue to always process the node with the smallest known distance. Whenever a shorter route is found, I relax the edge and add the updated distance to the queue. Finally, if any node is unreachable I return `-1`; otherwise the network delay is the maximum of all shortest distances."

---

# Complexity

```text
Time:  O((V + E) log V)

Space: O(V + E)
```

---

# Key Takeaway

Think:

```text
Network Delay Time
        ↓
Shortest path from k
        ↓
Dijkstra
        ↓
dist[every node]
        ↓
maximum distance
```

The core Dijkstra relaxation is:

```java
if (newDist < dist[neighbour]) {
    dist[neighbour] = newDist;
    minHeap.offer(new int[]{newDist, neighbour});
}
```