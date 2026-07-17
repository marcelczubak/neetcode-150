# Clone Graph

## Problem

Given a reference to a node in a connected undirected graph, return a deep copy of the graph.

Each node contains:

- An integer value
- A list of neighbouring nodes

The cloned graph must contain completely new nodes with the same connections as the original graph.

---

# Example

Input:

```
1 -- 2
|    |
4 -- 3
```

Output:

```
1 -- 2
|    |
4 -- 3
```

The output looks identical, but every node is a new object.

---

# Approach

## DFS + HashMap

This problem is solved using Depth First Search.

The main challenge is that graphs can contain cycles.

Example:

```
1 -> 2
2 -> 1
```

Without tracking visited nodes, DFS would continue forever:

```
clone 1
    clone 2
        clone 1
            clone 2
                ...
```

To prevent this, use a HashMap:

```java
Map<Node, Node> map;
```

This stores:

```
original node -> cloned node
```

---

# Algorithm

For each node:

1. Check if it has already been cloned.
2. If yes, return the existing clone.
3. Create a new clone node.
4. Store the clone in the HashMap.
5. Recursively clone all neighbours.
6. Add cloned neighbours to the clone.
7. Return the clone.

---

# Backtracking / DFS Flow

Example:

```
dfs(1)
```

Create:

```
1 -> clone1
```

Store immediately:

```
map:
1 : clone1
```

Visit neighbour:

```
dfs(2)
```

Create:

```
2 -> clone2
```

Store:

```
map:
1 : clone1
2 : clone2
```

If node 2 points back to node 1:

```
dfs(1)
```

The map already contains:

```
1 : clone1
```

Return the existing clone.

---

# Why Store The Clone Before Visiting Neighbours?

This is the most important part of the solution:

```java
map.put(node, copy);
```

must happen before:

```java
for(Node neighbor : node.neighbors)
```

If we wait until after exploring neighbours, cycles will cause infinite recursion.

---

# Code Structure

```java
private Node dfs(Node node, Map<Node, Node> map)
```

The function means:

> Clone this node and return its copy.

---

## Base Cases

### Null node

```java
if(node == null)
    return null;
```

### Already cloned

```java
if(map.containsKey(node))
    return map.get(node);
```

---

# Complexity Analysis

Let:

- `V` = number of nodes
- `E` = number of edges

## Time Complexity

```
O(V + E)
```

Every node is visited once.

Every edge is processed once.

---

## Space Complexity

```
O(V)
```

The HashMap stores every cloned node.

The recursion stack can also reach `V` nodes.

---

# Common Mistakes

## 1. Not using a HashMap

Incorrect:

```java
dfs(neighbor)
```

without tracking visited nodes.

Graphs can contain cycles.

---

## 2. Adding to the map too late

Incorrect:

```java
Node copy = new Node(node.val);

for(Node neighbor : node.neighbors) {
    copy.neighbors.add(dfs(neighbor,map));
}

map.put(node,copy);
```

This causes infinite recursion on cycles.

---

Correct:

```java
Node copy = new Node(node.val);

map.put(node,copy);

for(Node neighbor : node.neighbors) {
    copy.neighbors.add(dfs(neighbor,map));
}
```

---

# Pattern Recognition

Use this pattern for:

- Graph cloning
- Graph traversal
- Cycle detection
- Connected components

General DFS graph template:

```java
if(visited)
    return existing result;

mark visited;

for(neighbour)
    dfs(neighbour);
```

---

# Related Problems

- Number of Islands
- Max Area of Island
- Course Schedule
- Pacific Atlantic Water Flow
- Graph Valid Tree