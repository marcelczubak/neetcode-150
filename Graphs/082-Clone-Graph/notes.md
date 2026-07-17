# Clone Graph - Notes

## Core Idea

Clone every node in a graph while preserving all connections.

This is a graph traversal problem.

The intended approach is:

```
DFS + HashMap
```

---

# Why We Need a HashMap

Graphs can contain cycles.

Example:

```
1 -> 2
2 -> 1
```

Normal DFS:

```
clone 1
    clone 2
        clone 1
            clone 2
                ...
```

Infinite recursion.

The HashMap prevents this.

---

# HashMap Purpose

Store:

```
Original Node -> Cloned Node
```

Example:

```java
map.put(node, copy);
```

After cloning:

```
1 -> clone1
2 -> clone2
3 -> clone3
```

---

# DFS Function

```java
private Node dfs(Node node, Map<Node, Node> map)
```

Meaning:

> Return the clone of this node.

---

# Algorithm Steps

## 1. Check Null

```java
if(node == null)
    return null;
```

---

## 2. Check Existing Clone

```java
if(map.containsKey(node))
    return map.get(node);
```

If we already cloned this node, reuse it.

---

## 3. Create Clone

```java
Node copy = new Node(node.val);
```

---

## 4. Store Immediately

```java
map.put(node, copy);
```

Important:

This must happen before cloning neighbours.

Why?

Because neighbours may point back to this node.

---

## 5. Clone Neighbours

```java
for(Node neighbor : node.neighbors) {

    copy.neighbors.add(
        dfs(neighbor,map)
    );

}
```

Each neighbour is recursively cloned.

---

# Full Mental Model

For every node:

```
Have I cloned this before?
        |
       yes
        |
 return existing clone


       no

Create clone

Save clone

Clone neighbours

Return clone
```

---

# Example Walkthrough

Graph:

```
1 ---- 2
|      |
--------
```

Call:

```
dfs(1)
```

Create:

```
clone1
```

Map:

```
1 -> clone1
```

Visit node 2.

Create:

```
2 -> clone2
```

Visit node 1 again.

Map contains node 1:

```
return clone1
```

Cycle handled.

---

# Important Ordering

Correct:

```java
Node copy = new Node(node.val);

map.put(node, copy);

for(Node neighbor : node.neighbors)
{
    copy.neighbors.add(
        dfs(neighbor,map)
    );
}
```

Incorrect:

```java
Node copy = new Node(node.val);

for(Node neighbor : node.neighbors)
{
    dfs(neighbor,map);
}

map.put(node,copy);
```

The second version fails with cycles.

---

# Complexity

Let:

```
V = nodes
E = edges
```

## Time

```
O(V + E)
```

Each node and edge is processed once.

---

## Space

```
O(V)
```

For:

- HashMap
- DFS recursion stack

---

# DFS vs BFS

Both work.

DFS:

```
Recursion
```

BFS:

```
Queue
```

However, DFS is usually preferred because the recursive structure naturally handles cloning.

---

# Graph DFS Template

Remember:

```java
if(alreadyVisited)
    return existing;

create result;

mark visited;

for(neighbour)
    process neighbour;

return result;
```

---

# Related Problems

- Number of Islands
- Course Schedule
- Graph Valid Tree
- Pacific Atlantic Water Flow
- Surrounded Regions