# Alien Dictionary — Notes

## Pattern

- Graph
- Directed Graph
- Topological Sort
- DFS
- Cycle Detection
- Postorder

---

# Graph Representation

```java
Map<Character, List<Character>> graph
```

Character:

```text
Node
```

Ordering constraint:

```text
Directed edge
```

Example:

```text
a → b
```

means:

```text
a comes before b
```

---

# Building the Graph

## 1. Add Every Character

Go through every word:

```text
word
 ↓
characters
 ↓
graph.putIfAbsent(character, [])
```

This ensures characters with no outgoing edges aren't lost.

---

## 2. Compare Adjacent Words

Compare:

```text
words[i - 1]
words[i]
```

not every pair.

---

## 3. Find First Difference

Example:

```text
abc
abd
```

First difference:

```text
c vs d
```

Therefore:

```text
c → d
```

Then:

```text
break
```

---

# Prefix Edge Case

Example:

```text
abc
ab
```

No difference is found.

But:

```text
abc
```

is longer than:

```text
ab
```

Therefore the dictionary is invalid.

Condition:

```text
!foundDifference && a.length() > b.length()
```

---

# DFS States

Use:

```java
Map<Character, Integer> state
```

States:

```text
0 → unvisited
1 → currently visiting
2 → completely processed
```

---

# DFS

For character `c`:

### Already complete

```text
state[c] == 2
```

Return:

```text
no cycle
```

---

### Currently visiting

```text
state[c] == 1
```

Return:

```text
cycle detected
```

---

### Unvisited

Mark:

```text
state[c] = 1
```

Then DFS all neighbours.

---

# Cycle Detection

Graph:

```text
a → b
b → c
c → a
```

DFS path:

```text
a → b → c → a
```

When `a` is encountered again:

```text
state[a] == 1
```

Therefore:

```text
cycle
```

No valid alphabet exists.

---

# Postorder

After all neighbours have been processed:

```text
state[c] = 2
result.append(c)
```

This means dependencies are added first.

Example:

```text
a → b
```

DFS produces:

```text
b
a
```

Therefore reverse:

```text
a
b
```

---

# Why Reverse?

DFS produces:

```text
reverse topological order
```

because nodes are added after their dependencies.

Therefore:

```java
result.reverse();
```

---

# Full DFS Logic

```text
dfs(c):

    if c is complete:
        return false

    if c is currently visiting:
        return true

    mark c as visiting

    for neighbour of c:

        if dfs(neighbour):
            return true

    mark c as complete

    add c to result

    return false
```

Where:

```text
true  = cycle found
false = no cycle
```

---

# Full Problem Flow

```text
Words
 ↓
Add all characters
 ↓
Compare adjacent words
 ↓
Find first difference
 ↓
Create directed edge
 ↓
Check invalid prefix
 ↓
DFS each character
 ↓
Detect cycles
 ↓
Postorder
 ↓
Reverse
 ↓
Answer
```

---

# Common Mistakes

### Forgetting to break

Once the first difference is found:

```text
add edge
break
```

---

### Comparing non-adjacent words

Only adjacent words are needed.

---

### Forgetting characters without edges

Every character must appear in the graph.

---

### Wrong prefix condition

Invalid:

```text
["abc", "ab"]
```

Valid:

```text
["abc", "abd"]
```

because the latter has a first differing character.

---

### Treating processed nodes as cycles

```text
state == 2
```

is **not** a cycle.

Only:

```text
state == 1
```

indicates a cycle.

---

### Not propagating cycle detection

If:

```text
dfs(neighbor)
```

returns `true`, immediately return `true` from the current DFS.

Otherwise the cycle information is lost.

---

# Complexity

```text
Graph construction:
O(total characters)

DFS:
O(V + E)

Space:
O(V + E)
```

where:

```text
V = unique characters
E = ordering constraints
```

---

# Key Mental Model

Think:

```text
"Character A must come before Character B"
             ↓
        A → B
             ↓
       dependency
             ↓
    topological sort
```

And for DFS:

```text
Enter node
    ↓
Mark VISITING
    ↓
Explore neighbours
    ↓
Cycle?
    ↓
No
    ↓
Mark COMPLETE
    ↓
Add to result
    ↓
Reverse
```

The three things to remember:

```text
FIRST difference → edge

VISITING → cycle

POSTORDER → reverse
```
```