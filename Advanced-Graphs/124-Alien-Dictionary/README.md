# Alien Dictionary

## Problem

Given a list of words sorted according to an unknown alien alphabet, determine a valid ordering of the characters.

If no valid ordering exists, return an empty string.

The ordering must satisfy all constraints implied by the dictionary.

---

# Pattern

- Graph
- Directed Graph
- DFS
- Topological Sort
- Cycle Detection
- Postorder Traversal

---

# Core Idea

Treat every character as a graph node.

If the dictionary tells us:

```text
a comes before b
```

create a directed edge:

```text
a → b
```

The resulting graph represents the ordering constraints between characters.

Finding the alien alphabet is therefore a **topological sorting** problem.

---

# Step 1 — Create the Graph

Use:

```java
Map<Character, List<Character>> graph
```

Each character is a node.

For example:

```text
a → [b, c]
b → [d]
c → []
d → []
```

means:

```text
a before b
a before c
b before d
```

---

# Step 2 — Add Every Character

Before creating edges, iterate through every word and add every character to the graph.

This is important because a character may have no outgoing edges.

For example:

```text
["abc", "abd"]
```

produces:

```text
c → d
```

but `a` and `b` still need to appear in the final alphabet.

---

# Step 3 — Compare Adjacent Words

Only compare adjacent words:

```text
words[i - 1]
words[i]
```

The dictionary is already sorted, so adjacent words provide the ordering constraints.

For example:

```text
["wrt", "wrf", "er", "ett", "rftt"]
```

compare:

```text
wrt vs wrf
wrf vs er
er vs ett
ett vs rftt
```

---

# Step 4 — Find the First Difference

Compare two words character by character.

Example:

```text
"wrt"
"wrf"
```

Comparison:

```text
w == w
r == r
t != f
```

The first difference tells us:

```text
t → f
```

Add:

```java
graph.get('t').add('f');
```

---

# Why Only the First Difference?

Once the first differing characters are found, their relative ordering is determined.

Characters after that point don't provide additional information about the ordering of these two words.

Therefore:

```java
break;
```

after adding the edge.

---

# Step 5 — Handle the Invalid Prefix Case

Consider:

```text
["abc", "ab"]
```

The words have no differing character.

But:

```text
"abc"
```

cannot come before:

```text
"ab"
```

because `"ab"` is a prefix of `"abc"`.

Therefore this is invalid.

Track whether a difference was found:

```java
boolean foundDifference = false;
```

If no difference was found:

```java
if (!foundDifference && a.length() > b.length()) {
    return "";
}
```

---

# Step 6 — Topological Sort

After constructing the graph, we need an ordering satisfying all edges.

For:

```text
a → b
b → c
```

the answer must contain:

```text
a
```

before:

```text
b
```

and:

```text
b
```

before:

```text
c
```

This is exactly what **topological sorting** solves.

---

# DFS Topological Sort

The solution uses DFS to perform the topological sort.

Each character has three possible states:

```text
0 = unvisited
1 = currently visiting
2 = completely processed
```

The implementation stores these states using:

```java
Map<Character, Integer> state
```

---

# State 1 — Currently Visiting

When DFS enters a character:

```java
state.put(c, 1);
```

This means:

> This character is currently in the recursion path.

---

# State 2 — Completely Processed

After all neighbours have been successfully explored:

```java
state.put(c, 2);
```

This means:

> This character and all of its dependencies have been completely processed.

---

# Cycle Detection

Suppose:

```text
a → b
b → c
c → a
```

DFS:

```text
a
 ↓
b
 ↓
c
 ↓
a
```

When DFS reaches `a` again:

```text
state[a] == 1
```

meaning `a` is already in the current recursion path.

Therefore:

```text
cycle detected
```

and there is no valid alien alphabet.

Return:

```text
""
```

---

# Already Processed Nodes

If:

```java
state.get(c) == 2
```

then the character has already been completely explored.

There is no need to process it again.

Return:

```text
false
```

because no cycle was found.

---

# Postorder Traversal

The character is added to the result **after all of its neighbours** have been processed:

```java
state.put(c, 2);
result.append(c);
```

This is postorder DFS.

For:

```text
a → b
```

DFS does:

```text
dfs(a)
    ↓
dfs(b)
    ↓
add b
↓
add a
```

giving:

```text
[b, a]
```

This is backwards.

Therefore the final result must be reversed.

---

# Step 7 — Reverse the Result

The DFS builds:

```text
reverse topological order
```

so:

```java
return result.reverse().toString();
```

produces the actual alien alphabet.

---

# Example

Suppose the constraints are:

```text
w → e
e → r
r → t
t → f
```

DFS might produce:

```text
f t r e w
```

because nodes are added in postorder.

Reverse:

```text
w e r t f
```

This satisfies all dependencies.

---

# Complete Algorithm

```text
1. Create adjacency list.

2. Add every character from every word
   to the graph.

3. Compare every pair of adjacent words.

4. Find the first differing character.

5. Add an edge:
       character1 → character2

6. Stop comparing that pair.

7. If no difference exists and the first
   word is longer than the second:
       return ""

8. Create DFS state map.

9. For every character:
       run DFS if necessary.

10. During DFS:
       state 1 → currently visiting
       state 2 → completely processed

11. If DFS reaches a node with state 1:
       cycle → return ""

12. After processing all neighbours:
       mark node as complete
       append node to result.

13. Reverse result.

14. Return result.
```

---

# Complexity

Let:

```text
V = number of unique characters
E = number of ordering relationships
```

Graph construction:

```text
O(total characters in all words)
```

DFS topological sort:

```text
O(V + E)
```

Space:

```text
O(V + E)
```

The alphabet contains at most 26 characters in the standard version of the problem, but the graph-based complexity is still useful to understand.

---

# Important Edge Cases

### Single word

```text
["abc"]
```

There may be no ordering constraints.

The answer can be any ordering containing:

```text
a, b, c
```

---

### Character with no edges

```text
["abc", "abd"]
```

`a` and `b` have no outgoing edges but must still appear.

---

### Invalid prefix

```text
["abc", "ab"]
```

Return:

```text
""
```

---

### Cycle

Constraints:

```text
a → b
b → c
c → a
```

Return:

```text
""
```

---

# Interview Explanation

"I model each unique character as a node in a directed graph. I compare adjacent words and find their first differing character. If the first differing characters are `a` and `b`, I add an edge `a → b`, meaning `a` must appear before `b`. I then perform a DFS-based topological sort. I use three states to detect cycles: unvisited, currently visiting, and completely processed. If I encounter a node that is currently in the recursion path, there is a cycle and no valid ordering exists. After processing all neighbours, I add the character to the result in postorder, then reverse the result to obtain the topological ordering."

---

# Key Takeaway

The problem reduces to:

```text
Alien Dictionary
       ↓
Ordering constraints
       ↓
Directed Graph
       ↓
Topological Sort
       ↓
DFS + Cycle Detection
```

The most important insights are:

```text
First differing characters → edge

Currently visiting node → cycle

Add node after neighbours → postorder

Reverse postorder → topological ordering
```