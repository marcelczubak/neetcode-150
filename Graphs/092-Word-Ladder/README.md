# Word Ladder

## Problem

Given two words:

- `beginWord`
- `endWord`

and a dictionary of words, find the **shortest transformation sequence length** from `beginWord` to `endWord`.

Rules:

- Change only one letter at a time.
- Every transformed word must exist in the word list.
- Return `0` if no valid transformation exists.

---

# Example

Input:

```
beginWord = "hit"

endWord = "cog"

wordList =
[
 "hot",
 "dot",
 "dog",
 "lot",
 "log",
 "cog"
]
```

Transformation:

```
hit
 |
hot
 |
dot
 |
dog
 |
cog
```

Output:

```
5
```

---

# Graph Interpretation

This problem can be modelled as an unweighted graph.

## Nodes

Each word is a node.

Example:

```
hit
hot
dot
dog
cog
```

---

## Edges

Two words have an edge if they differ by exactly one character.

Example:

```
hit ---- hot
```

because:

```
h i t
h o t
```

Only one character differs.

---

# Approach: BFS Shortest Path

## Why BFS?

The problem asks for:

```
minimum number of transformations
```

This is equivalent to:

```
shortest path in an unweighted graph
```

Therefore:

```
Shortest path + unweighted graph = BFS
```

---

# BFS Algorithm

## Step 1: Build Graph

Compare every pair of words.

If two words differ by one letter:

```
Add an edge between them
```

Example:

```
hot -> dot
dot -> hot
```

The graph is undirected.

---

## Step 2: Initialize BFS

Use:

```java
Queue<String> queue;
Set<String> visited;
```

Start with:

```
beginWord
```

Mark it visited.

---

## Step 3: Process Levels

Each BFS level represents one transformation.

Example:

```
Level 1:
hit

Level 2:
hot

Level 3:
dot, lot

Level 4:
dog, log

Level 5:
cog
```

When `endWord` is found:

```
return current level
```

---

# BFS Template

```java
queue.offer(beginWord);
visited.add(beginWord);

int steps = 1;

while (!queue.isEmpty()) {

    int size = queue.size();

    for (int i = 0; i < size; i++) {

        String current = queue.poll();

        if (current.equals(endWord)) {
            return steps;
        }

        for (String neighbor : graph.get(current)) {

            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.offer(neighbor);
            }
        }
    }

    steps++;
}
```

---

# Finding Neighbours

Two words are connected if they differ by one character.

Example:

```
hot
dot
```

Comparison:

```
h != d  -> difference
o == o
t == t
```

Total differences:

```
1
```

Therefore:

```
edge exists
```

---

# Complexity

Let:

- N = number of words
- L = length of each word

## Graph Construction

Compare every pair:

```
O(N²)
```

Each comparison:

```
O(L)
```

Total:

```
O(N² * L)
```

---

## BFS

Each node and edge is visited once:

```
O(V + E)
```

---

## Overall

Time:

```
O(N² * L)
```

Space:

```
O(N²)
```

because of the adjacency list.

---

# Optimisation

The above approach explicitly creates the graph.

However, Word Ladder has an implicit graph.

Instead of storing edges:

For:

```
hot
```

generate:

```
aot
bot
cot
...
hbt
...
hoa
hob
...
```

and check whether they exist in a HashSet.

This avoids building all edges.

Optimised complexity:

```
O(N * L * 26)
```

Space:

```
O(N)
```

---

# Key Interview Insight

Whenever you see:

```
Minimum transformations
Minimum steps
Shortest sequence
```

think:

```
BFS
```

When the graph is not explicitly given:

```
Generate neighbours dynamically
```

---

# Related Problems

- Open the Lock
- Minimum Genetic Mutation
- Shortest Path in Binary Matrix
- Clone Graph
- Network Delay Time