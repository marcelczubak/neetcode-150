# Word Ladder Notes

## Core Pattern

This is a:

```
Shortest path problem
```

on an:

```
Unweighted graph
```

Therefore:

```
BFS
```

---

# Graph Representation

Words are nodes.

Example:

```
hit
hot
dot
dog
```

---

Edges exist when:

```
Two words differ by exactly one character
```

Example:

```
hit -> hot
```

because:

```
i -> o
```

is the only change.

---

# Why BFS?

DFS can find a path.

However:

DFS does not guarantee the shortest path.

BFS explores:

```
distance 1
distance 2
distance 3
...
```

The first time we reach the target:

```
shortest transformation found
```

---

# BFS Structure

Use:

```java
Queue<String> queue;
Set<String> visited;
```

---

Initialize:

```java
queue.offer(beginWord);

visited.add(beginWord);
```

Start:

```
steps = 1
```

because the beginning word counts.

---

# Level Traversal

Important pattern:

```java
int size = queue.size();
```

Process exactly this many nodes.

After processing:

```
steps++
```

because we move to the next transformation level.

---

# Visited Set

Necessary because the graph is undirected.

Example:

```
hit <-> hot
```

Without visited:

```
hit
hot
hit
hot
...
```

Infinite loop.

---

# String Comparison

Incorrect:

```java
word == endWord
```

`==` compares references.

Correct:

```java
word.equals(endWord)
```

because it compares contents.

---

# Neighbour Checking

Two words are connected if:

```
number of different characters == 1
```

Implementation:

```java
int diff = 0;

for(int i = 0; i < word.length(); i++){

    if(word.charAt(i) != other.charAt(i)){
        diff++;
    }

}
```

If:

```
diff == 1
```

valid edge.

---

# Current Solution

## Advantages

✅ Easy to understand  
✅ Clear graph representation  
✅ BFS naturally solves shortest path  

---

## Disadvantages

Building the graph requires:

```
Every word compared with every other word
```

Complexity:

```
O(N² * L)
```

---

# Optimal Approach

Do not build the graph.

Instead:

For each current word:

```
change every character
```

Example:

```
hot
```

Generate:

```
aot
bot
cot
...
hoa
hob
```

Check:

```
Does this word exist?
```

If yes:

```
BFS neighbour
```

---

# Complexity Comparison

## Explicit Graph

Time:

```
O(N² * L)
```

Space:

```
O(N²)
```

---

## Dynamic Neighbour Generation

Time:

```
O(N * L * 26)
```

Space:

```
O(N)
```

---

# Interview Recognition

Keywords:

```
minimum
shortest
fewest changes
number of transformations
```

↓

```
BFS
```

---

# General Template

```
Queue stores current states

while queue not empty:

    process current level

    generate neighbours

    add unvisited neighbours

    increase distance
```

---

# Similar Problems

- Open the Lock
- Rotting Oranges
- Shortest Path in Binary Matrix
- Minimum Genetic Mutation