# Reconstruct Itinerary

## Problem

Given a list of airline tickets, reconstruct the itinerary such that:

1. The trip starts at `"JFK"`.
2. Every ticket is used exactly once.
3. If multiple valid itineraries exist, return the lexicographically smallest one.

Each ticket:

```text
[from, to]
```

represents a directed edge:

```text
from → to
```

---

# Approach

## Graph Representation

Represent the tickets as a directed adjacency list:

```java
Map<String, List<String>> graph
```

For example:

```text
JFK → ATL
JFK → SFO
ATL → SFO
```

becomes:

```text
JFK → [ATL, SFO]
ATL → [SFO]
```

---

# Lexicographical Ordering

Sort every airport's list of destinations:

```java
Collections.sort(neighbors);
```

This ensures destinations are considered in lexicographical order.

For example:

```text
JFK → [ATL, SFO]
```

means:

```text
ATL
```

will be considered before:

```text
SFO
```

---

# Important Insight

A normal DFS approach would be:

```text
visit node
→ recursively visit neighbours
→ add node to result
```

However, this problem is slightly different.

Every **ticket/edge** must be used exactly once.

Therefore, we need to consume edges rather than simply mark airports as visited.

An airport can appear multiple times in the itinerary.

---

# DFS / Hierholzer's Algorithm

The solution uses the idea behind **Hierholzer's algorithm**, which is used for finding Eulerian paths.

The key idea is:

> Continue following unused tickets until there are no tickets left from the current airport.

Only **after** all outgoing tickets have been consumed do we add the airport to the itinerary.

Conceptually:

```text
dfs(airport):

    while airport has unused tickets:

        take next destination

        remove that ticket

        dfs(destination)

    add airport to itinerary
```

---

# Why Add the Airport After DFS?

This is the most important part of the algorithm.

Suppose:

```text
JFK → A → B
```

DFS travels:

```text
JFK
 ↓
A
 ↓
B
```

When `B` has no remaining tickets:

```text
add B
```

Then return to `A`:

```text
add A
```

Then return to `JFK`:

```text
add JFK
```

The result is therefore constructed backwards:

```text
[B, A, JFK]
```

So we reverse it at the end:

```text
[JFK, A, B]
```

This is effectively **postorder DFS**.

---

# Consuming Tickets

When a destination is selected:

```java
String neighbor = neighbors.remove(0);
```

the ticket:

```text
airport → neighbor
```

has been consumed.

This is important because every ticket must be used exactly once.

We do **not** use:

```text
visited[airport]
```

because airports may be visited multiple times.

The edges/tickets are what need to be consumed.

---

# Dead Ends

An airport may have no outgoing tickets.

For example:

```text
SFO → []
```

When DFS reaches `SFO`, there are no more tickets to consume.

Therefore:

```text
add SFO to itinerary
```

and return to the previous recursive call.

This is why adding airports after exploring their edges is so important.

---

# Algorithm

1. Build a directed adjacency list.
2. Sort every airport's destinations lexicographically.
3. Start DFS from `"JFK"`.
4. While the current airport has unused tickets:
   - Take the lexicographically smallest destination.
   - Remove that ticket.
   - Recursively DFS from the destination.
5. Once an airport has no remaining tickets, add it to the itinerary.
6. Reverse the itinerary.
7. Return it.

---

# Example

Tickets:

```text
JFK → SFO
JFK → ATL
ATL → JFK
```

Sorted:

```text
JFK → [ATL, SFO]
ATL → [JFK]
```

DFS initially chooses:

```text
JFK → ATL
```

then:

```text
ATL → JFK
```

then:

```text
JFK → SFO
```

The airports are added during backtracking:

```text
[SFO, JFK, ATL, JFK]
```

Reverse:

```text
[JFK, ATL, JFK, SFO]
```

---

# Why Greedy Lexicographical Choice Works

We always consume the smallest available destination first.

However, we **don't immediately commit that airport to the final itinerary**.

Instead, we continue consuming tickets recursively and add airports during backtracking.

This allows the traversal to handle situations where a lexicographically smaller choice temporarily leads to a dead end.

The postorder construction is what makes the greedy ordering compatible with using every edge exactly once.

---

# Complexity

Let:

```text
E = number of tickets
```

There are `E` edges.

Sorting the adjacency lists takes:

```text
O(E log E)
```

in the worst case.

Each ticket is consumed once, although:

```java
remove(0)
```

from an `ArrayList` costs `O(n)` because elements must be shifted.

Therefore, with the current `ArrayList` implementation, the traversal can have additional shifting cost.

A more efficient implementation can use a data structure that supports removing the smallest destination efficiently.

The conceptual Eulerian traversal itself is:

```text
O(E)
```

after the destinations are ordered appropriately.

---

# Pattern Recognition

When you see:

- Directed graph
- Every edge must be used exactly once
- Construct a path using all edges
- Possible repeated vertices

Think:

```text
Eulerian Path
```

and consider:

```text
Hierholzer's Algorithm
```

---

# Key Takeaway

The unusual part of this problem is:

```text
Don't add the airport when you ENTER it.

Add it when you FINISH exploring it.
```

Think:

```text
DFS
 ↓
consume all outgoing tickets
 ↓
dead end
 ↓
add airport
 ↓
backtrack
 ↓
add previous airport
 ↓
reverse result
```

This is the core idea behind the solution.