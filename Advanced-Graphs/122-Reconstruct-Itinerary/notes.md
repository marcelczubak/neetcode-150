# Reconstruct Itinerary — Notes

## Pattern

- Graph
- DFS
- Eulerian Path
- Hierholzer's Algorithm
- Postorder Traversal
- Lexicographical Ordering

---

# Graph

Each airport:

```text
vertex
```

Each ticket:

```text
directed edge
```

Example:

```text
JFK → SFO
```

---

# Adjacency List

Use:

```java
Map<String, List<String>> graph
```

Example:

```text
JFK → [ATL, SFO]
ATL → [JFK]
```

---

# Sort Destinations

For each airport:

```java
Collections.sort(neighbors);
```

This gives:

```text
ATL < SFO
```

so ATL is considered first.

---

# Don't Track Visited Airports

This is a key distinction.

Wrong mental model:

```text
visited airports
```

because an airport can appear multiple times.

Instead:

```text
consume tickets
```

Each edge must be used exactly once.

---

# DFS State

Think of:

```text
dfs(airport)
```

as:

> Consume all remaining tickets starting from this airport and add the airport to the answer once all its outgoing tickets have been handled.

---

# Core DFS

Conceptually:

```text
dfs(airport):

    while there are unused tickets:

        choose smallest destination

        remove ticket

        dfs(destination)

    add airport to result
```

---

# The Crucial Part

The airport is added:

```text
AFTER
```

the recursive calls.

Not:

```text
BEFORE
```

This means the itinerary is constructed in reverse.

---

# Example

```text
JFK → A
A → B
```

Traversal:

```text
JFK
 ↓
A
 ↓
B
```

Backtracking:

```text
add B
add A
add JFK
```

Result:

```text
[B, A, JFK]
```

Reverse:

```text
[JFK, A, B]
```

---

# Why This Works

The algorithm is based on **Hierholzer's algorithm** for Eulerian paths.

The goal is to use:

```text
every edge exactly once
```

rather than:

```text
visit every vertex once
```

DFS consumes edges until it reaches a dead end.

The dead-end airport gets placed into the result first.

Earlier airports are added as recursion unwinds.

---

# Dead End

If:

```java
graph.get(airport) == null
```

or there are no remaining neighbours:

```text
add airport
return
```

The airport can still be part of the final itinerary even though it has no outgoing tickets.

---

# Why the Result Is Reversed

The DFS adds airports in:

```text
postorder
```

rather than preorder.

Therefore:

```text
DFS traversal:
JFK → ATL → SFO

Result construction:
SFO → ATL → JFK
```

So:

```java
Collections.reverse(itinerary);
```

is required at the end.

---

# Important Java Details

The intended recursive call must pass all required arguments:

```text
dfs(graph, itinerary, neighbor)
```

not simply:

```text
dfs(neighbor)
```

Also:

```java
Collections.reverse(itinerary);
```

modifies the list in-place and returns `void`.

Therefore:

```text
Collections.reverse(itinerary);
return itinerary;
```

not:

```text
return Collections.reverse(itinerary);
```

---

# `ArrayList.remove(0)`

Current approach:

```java
neighbors.remove(0);
```

gets the lexicographically smallest destination because the list was sorted.

However, removing index `0` from an `ArrayList` is:

```text
O(n)
```

because all remaining elements shift left.

So the implementation is correct conceptually, but the data structure can be optimized.

---

# Common Mistakes

## 1. Adding airport before recursion

Wrong:

```text
add airport
dfs(neighbor)
```

This doesn't produce the required Eulerian-path construction.

Correct:

```text
dfs(neighbor)
add airport
```

---

## 2. Marking airports visited

Wrong:

```text
visited[airport]
```

Airports may be visited multiple times.

Tickets are what must be used once.

---

## 3. Forgetting to remove tickets

If you don't remove an edge after using it, you may reuse the same ticket.

Correct concept:

```text
choose edge
↓
consume edge
↓
DFS
```

---

## 4. Not reversing the result

Because airports are added in postorder:

```text
result = reversed itinerary
```

so reverse before returning.

---

# Interview Explanation

"I model each airport as a vertex and each ticket as a directed edge. Since every ticket must be used exactly once, this is an Eulerian path problem, so I use Hierholzer's algorithm. I sort each airport's destinations lexicographically so that the smallest available destination is considered first. During DFS I consume each ticket exactly once. Importantly, I add an airport to the itinerary only after all of its outgoing tickets have been consumed, which constructs the itinerary in reverse. I then reverse the result."

---

# Complexity

Sorting:

```text
O(E log E)
```

where:

```text
E = number of tickets
```

Traversal:

```text
O(E)
```

conceptually, once destinations are efficiently ordered.

With the current `ArrayList.remove(0)` implementation, removing from the front can introduce additional shifting cost.

---

# Key Takeaway

Remember:

```text
Graph
 ↓
Sort destinations
 ↓
DFS
 ↓
Consume edges
 ↓
Add airport AFTER recursion
 ↓
Reverse result
```

The key insight:

> **This is an Eulerian path problem, not a normal "visit every node once" DFS.**